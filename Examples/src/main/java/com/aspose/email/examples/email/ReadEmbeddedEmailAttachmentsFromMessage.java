package com.aspose.email.examples.email;

import com.aspose.email.Attachment;
import com.aspose.email.MailMessage;
import com.aspose.email.examples.Utils;

public class ReadEmbeddedEmailAttachmentsFromMessage {

	public static void main(String[] args) {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(ReadEmbeddedEmailAttachmentsFromMessage.class) + "email/";
		try {
			MailMessage message = MailMessage.load(dataDir + "EmailWithAttandEmbedded.eml");
			ParseMessage(message, dataDir);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	private static void ParseMessage(MailMessage message, String dataDir) {
		System.out.println("Subject: " + message.getSubject());
		System.out.println("Extracting attachments....");
		for (int i = 0; i < message.getAttachments().size(); i++) {
			Attachment att = message.getAttachments().get_Item(i);
			System.out.println("Attachment Name: " + att.getName());

			// Get the name of attachment. If msg subject contains characters like :, /, \ etc., replace with space
			// because windows cannot save files with these characters also save first 50 characters as file name to avoid long file names
			String attFileName = att.getName().replace(".eml", "").replace(":", " ").replace("\\", " ").replace("/", " ").replace("?", "");
			if (attFileName.length() > 50) {
				attFileName = attFileName.substring(0, 50);
			}
			String attExt = (att.getName().substring(att.getName().lastIndexOf("."), att.getName().lastIndexOf(".") + 4));

			// Save the attachment to disk
			att.save(dataDir + attFileName + attExt);

			// Check if it is an orphaned text attachment file (ATT00001.txt....) and of type eml
			if ((attExt.equals(".eml")) || (att.getContentType().getMediaType().equals("text/plain") && att.getName().contains(".txt") == true && att.getName().contains("ATT") == true)) {
				// Try to load this text file in MailMessage
				MailMessage attMsg = MailMessage.load(dataDir + attFileName + attExt);
				// Call the function recursively to parse this message and attachments
				ParseMessage(attMsg, dataDir);
			}
		}
	}

}
