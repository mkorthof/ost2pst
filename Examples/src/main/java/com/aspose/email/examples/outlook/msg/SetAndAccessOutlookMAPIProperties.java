package com.aspose.email.examples.outlook.msg;

import com.aspose.email.BodyContentType;
import com.aspose.email.MapiMessage;
import com.aspose.email.MapiProperty;
import com.aspose.email.MapiPropertyCollection;
import com.aspose.email.MapiPropertyTag;
import com.aspose.email.examples.Utils;

public class SetAndAccessOutlookMAPIProperties {

	public static void main(String[] args) {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(SetAndAccessOutlookMAPIProperties.class) + "outlook/";
		
		accessOutlookMAPIProperties(dataDir);
		
		removeProperties(dataDir);
	}

	public static void accessOutlookMAPIProperties(String dataDir) {

		//Instantiate an MSG file to load an MSG file from disk
		MapiMessage outlookMessageFile = MapiMessage.fromFile(dataDir + "messageMapi.msg");

		//Get the MapiProperties collection
		MapiPropertyCollection coll = outlookMessageFile.getProperties();

		//Access the MapiPropertyTag.PR_SUBJECT property
		MapiProperty prop = coll.get_Item(MapiPropertyTag.PR_SUBJECT);

		//If the MapiProperty is not found, check the MapiProperty.PR_SUBJECT_W
		//which is a unicode peer of MapiPropertyTag.PR_SUBJECT
		if (prop == null) {
			prop = coll.get_Item(MapiPropertyTag.PR_SUBJECT_W);
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
		prop = coll.get_Item(MapiPropertyTag.PR_INTERNET_CPID);
		if (prop != null) {
			System.out.println("Code page: " + prop.getLong());
		}
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
