package com.aspose.email.examples.outlook.msg;

import com.aspose.email.MapiAttachment;
import com.aspose.email.MapiMessage;
import com.aspose.email.examples.Utils;

public class ParseAndSaveAttachment {

	public static void main(String[] args) {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(ParseAndSaveAttachment.class) + "outlook/";
		
		parseAndSaveAttachment(dataDir);
		
		embeddingMessageAsAttachment(dataDir);
		
		readingEmbeddedMessageFromAttachment(dataDir);
	}

	public static void parseAndSaveAttachment(String dataDir) {

		//Instantiate an MSG file to load an MSG file from disk
		MapiMessage outlookMessageFile = MapiMessage.fromFile(dataDir + "WithEmbeddedMsg.msg");

		//Loop through the attachments collection associated with the MapiMessage object
		for (int i = 0; i < outlookMessageFile.getAttachments().size(); i++) {
			//Set a reference to the MapiAttachment object
			MapiAttachment outlookMessageAttachment = (MapiAttachment) outlookMessageFile.getAttachments().get_Item(i);
			//Display attachment type
			System.out.println("Att Type : " + outlookMessageAttachment.getMimeTag());
			//Display attached file name
			System.out.println("File Name : " + outlookMessageAttachment.getLongFileName());
			//Save attachment to the disk
			outlookMessageAttachment.save(dataDir + outlookMessageAttachment.getDisplayName());
		}
	}

	public static void embeddingMessageAsAttachment(String dataDir) {
		MapiMessage msg = new MapiMessage("from@test.com", "to@test.com", "Subj", "This is a message body");
		MapiMessage attachMsg = MapiMessage.fromFile(dataDir + "message.msg");
		msg.getAttachments().add("Weekly report", attachMsg);
		msg.save(dataDir + "EmbededMessageAsAttachment.msg");
	}
	
	public static void readingEmbeddedMessageFromAttachment(String dataDir) {
		MapiMessage mapi = MapiMessage.fromFile(dataDir + "EmbededMessageAsAttachment.msg");
		MapiMessage emb = mapi.getAttachments().get_Item(0).getObjectData().toMapiMessage();
	}
}
