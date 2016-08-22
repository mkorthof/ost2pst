package com.aspose.email.examples.outlook.msg;

import java.util.UUID;

import com.aspose.email.BodyContentType;
import com.aspose.email.MapiMessage;
import com.aspose.email.MapiProperty;
import com.aspose.email.MapiPropertyCollection;
import com.aspose.email.MapiPropertyTag;
import com.aspose.email.MapiPropertyType;
import com.aspose.email.examples.Utils;
import com.aspose.email.system.collections.ArrayList;
import com.aspose.email.system.collections.IList;

public class SetAndAccessOutlookMAPIProperties {

	public static void main(String[] args) {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(SetAndAccessOutlookMAPIProperties.class) + "outlook/";
		
		accessOutlookMAPIProperties(dataDir);
		
		setAdditionalPropertiesOfAnOutlookMapiMessage();
		
		removeProperties(dataDir);
	}

	public static void accessOutlookMAPIProperties(String dataDir) {

		//Instantiate an MSG file to load an MSG file from disk
		MapiMessage outlookMessageFile = MapiMessage.fromFile(dataDir + "messageMapi.msg");

		//Get the MapiProperties collection
		MapiPropertyCollection coll = outlookMessageFile.getProperties();

		//Access the MapiPropertyTag.PR_SUBJECT property
		MapiProperty prop = (MapiProperty) coll.get_Item((Object) MapiPropertyTag.PR_SUBJECT);

		//If the MapiProperty is not found, check the MapiProperty.PR_SUBJECT_W
		//which is a unicode peer of MapiPropertyTag.PR_SUBJECT
		if (prop == null) {
			prop = (MapiProperty) coll.get_Item(MapiPropertyTag.PR_SUBJECT_W);
		}

		//If it cannot be found
		if (prop == null) {
			System.out.println("Mapi property could not be found.");
		} else {
			//Get the property data as string
			String strSubject = prop.getString();
			System.out.println("Subject: " + strSubject);
		}

		//Read internet code page property
		prop = (MapiProperty) coll.get_Item(MapiPropertyTag.PR_INTERNET_CPID);
		if (prop != null) {
			System.out.println("Code page: " + prop.getLong());
		}
	}

	public static void setAdditionalPropertiesOfAnOutlookMapiMessage() {
		// PT_MV_FLOAT, PT_MV_R4, mv.float
		MapiMessage msg = new MapiMessage();
		IList values = (IList) new ArrayList();
		values.addItem((float) 1);
		values.addItem((float) 2);
		msg.setProperty(new MapiProperty(0x23901004, values));

		//PT_MV_DOUBLE, PT_MV_R8
		values = (IList) new ArrayList();
		values.addItem((double) 1);
		values.addItem((double) 2);
		msg.setProperty(new MapiProperty(0x23901005, values));

		//PT_MV_APPTIME
		values = (IList) new ArrayList();
		values.addItem(30456.34);
		values.addItem(40655.45);
		msg.setProperty(new MapiProperty(0x23901007, values));

		//PT_MV_I8, PT_MV_LONGLONG
		values = (IList) new ArrayList();
		values.addItem((long) 30456);
		values.addItem((long) 40655);
		msg.setProperty(new MapiProperty(0x23901014, values));

		//PT_MV_SHORT, PT_MV_I2, mv.i2
		values = (IList) new ArrayList();
		values.addItem((short) 1);
		values.addItem((short) 2);
		msg.setProperty(new MapiProperty(0x23901002, values));

		//PT_MV_BOOLEAN
		values = (IList) new ArrayList();
		values.addItem(true);
		values.addItem(false);
		msg.setProperty(new MapiProperty(0x2390100b, values));

		//PT_NULL
		msg.setProperty(new MapiProperty(0x67400001, new byte[1]));

		//PT_MV_LONG
		values = (IList) new ArrayList();
		values.addItem((int) 4);

		UUID uuid = UUID.randomUUID();
		MapiProperty property = new MapiProperty(msg.getNamedPropertyMapping().getNextAvailablePropertyId(MapiPropertyType.PT_MV_LONG), values);
		msg.getNamedPropertyMapping().addNamedPropertyMapping(property, 0x00008028, uuid);
		msg.setProperty(property);

		//OR you can set the custom property (with the custom name)
		MapiMessage message = new MapiMessage("sender@test.com", "recipient@test.com", "subj", "Body of test msg");

		values = (IList) new ArrayList();
		values.addItem((int) 4);

		property = new MapiProperty(message.getNamedPropertyMapping().getNextAvailablePropertyId(MapiPropertyType.PT_MV_LONG), values);

		message.addCustomProperty(property, "customProperty");
	}

	public static void removeProperties(String dataDir) {
		MapiMessage mapi = new MapiMessage("from@doamin.com", "to@domain.com", "subject", "body");
		mapi.setBodyContent("<html><body><h1>This is the body content</h1></body></html>", BodyContentType.Html);
		MapiMessage attachment = MapiMessage.fromFile(dataDir + "message.msg");
		mapi.getAttachments().add(dataDir + "Outlook2 Test subject.msg", attachment);
		System.out.println("Before removal = " + mapi.getAttachments().get_Item(mapi.getAttachments().size() - 1).getProperties().size());

		mapi.getAttachments().get_Item(mapi.getAttachments().size() - 1).removeProperty(923467779);//Delete anyone property
		System.out.println("After removal = " + mapi.getAttachments().get_Item(mapi.getAttachments().size() - 1).getProperties().size());
		mapi.save(dataDir + "EMAIL_589265.msg");

		MapiMessage mapi2 = MapiMessage.fromFile(dataDir + "EMAIL_589265.msg");
		System.out.println("Reloaded = " + mapi2.getAttachments().get_Item(mapi2.getAttachments().size() - 1).getProperties().size());
	}

}
