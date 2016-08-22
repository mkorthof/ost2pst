package com.aspose.email.examples.outlook.msg;

import com.aspose.email.MailMessage;
import com.aspose.email.MapiMessage;
import com.aspose.email.MapiNamedProperty;
import com.aspose.email.MapiPropertyCollection;
import com.aspose.email.examples.Utils;

public class ReadNamedMapiProperties {

	public static void main(String[] args) {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(ReadNamedMapiProperties.class) + "outlook/";
		
		//Reading Named MAPI Property
		readingNamedMAPIProperty(dataDir);
		
		//Reading Named Mapi Property from Attachment
		readingNamedMapiPropertyFromAttachment(dataDir);
	}

	@SuppressWarnings("unchecked")
	public static void readingNamedMAPIProperty(String dataDir) {
		// Load MSG file
		MapiMessage message = MapiMessage.fromFile(dataDir + "message.msg");

		// Get all named MAPI properties
		MapiPropertyCollection properties = message.getNamedProperties();

		// Read all properties in for loop
		for (MapiNamedProperty mapiNamedProp : (Iterable<MapiNamedProperty>) properties.getValues()) {
			// Read any specific property
			switch (mapiNamedProp.getNameId()) {
			case "TEST":
				System.out.println(mapiNamedProp.getNameId() + " equals " + mapiNamedProp.getString());
				break;
			case "MYPROP":
				System.out.println(mapiNamedProp.getNameId() + " equals " + mapiNamedProp.getString());
				break;
			default:
				break;
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static void readingNamedMapiPropertyFromAttachment(String dataDir) {
		
		MailMessage mail = MailMessage.load(dataDir + "test.eml");
		MapiMessage mapi = MapiMessage.fromMailMessage(mail);

		for (MapiNamedProperty namedProperty : (Iterable<MapiNamedProperty>) mapi.getAttachments().get_Item(0).getNamedProperties().getValues()) {
			if (namedProperty.getNameId().equalsIgnoreCase("CustomAttGuid")) {
				System.out.println("Equal..");
			}
		}
	}
}
