package com.aspose.email.examples.email;

import com.aspose.email.Attachment;
import com.aspose.email.AttachmentCollection;
import com.aspose.email.MailMessage;
import com.aspose.email.SaveOptions;
import com.aspose.email.examples.Utils;

public class AddOrRemoveAttachmentFromAnExistingMessage {

	public static void main(String[] args) {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(AddOrRemoveAttachmentFromAnExistingMessage.class) + "email/";

		//Initialize and Load an existing EML file by specifying the MessageFormat
		MailMessage message = MailMessage.load(dataDir + "EmailWithAttachment.eml");

		//Initialize AttachmentCollection object with MailMessage Attachments
		AttachmentCollection attachments = message.getAttachments();
		System.out.println("Attachment Count: " + attachments.size());

		//Check if AttachmentCollection size is greater than 0
		if (attachments.size() > 0) {
			//Remove Attachment from index location 0
			attachments.removeAt(0);
			System.out.println("Attachment Count: " + attachments.size());
		}

		//Add a PDF file as attachment to the message
		message.addAttachment(new Attachment(dataDir + "1.pdf"));
		System.out.println("Attachment Count: " + attachments.size());

		//Save the Email message to disk
		message.save(dataDir + "AddRemoveAttachmentFromAnExistingMessage_out.eml", SaveOptions.getDefaultEml());
	}

}
