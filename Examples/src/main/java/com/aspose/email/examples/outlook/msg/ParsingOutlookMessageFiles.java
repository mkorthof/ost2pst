package com.aspose.email.examples.outlook.msg;

import com.aspose.email.MapiMessage;
import com.aspose.email.MapiRecipient;
import com.aspose.email.examples.Utils;

public class ParsingOutlookMessageFiles {

	public static void main(String[] args) {

		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(ParsingOutlookMessageFiles.class) + "outlook/";

		//Instantiate an MSG file to load an MSG file from disk
		MapiMessage outlookMessageFile = MapiMessage.fromFile(dataDir + "message.msg");
		//Display sender's name
		System.out.println("Sender Name : " + outlookMessageFile.getSenderName());
		//Display Subject
		System.out.println("Subject : " + outlookMessageFile.getSubject());
		//Display Body
		System.out.println("Body : " + outlookMessageFile.getBody());
		//Display Recipient's info
		System.out.println("Recipients : \n");

		//Loop through the recipients collection associated with the MapiMessage object
		for (int i = 0; i < outlookMessageFile.getRecipients().size(); i++) {
			//Set a reference to the MapiRecipient object
			MapiRecipient rcp = (MapiRecipient) outlookMessageFile.getRecipients().get_Item(i);
			//Display recipient email address
			System.out.println("Email : " + rcp.getEmailAddress());
			//Display recipient name
			System.out.println("Name : " + rcp.getDisplayName());
			//Display recipient type
			System.out.println("Recipient Type : " + rcp.getRecipientType());
		}

	}

}
