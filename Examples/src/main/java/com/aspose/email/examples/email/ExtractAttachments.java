package com.aspose.email.examples.email;

import com.aspose.email.Attachment;
import com.aspose.email.AttachmentCollection;
import com.aspose.email.EmlLoadOptions;
import com.aspose.email.MailMessage;
import com.aspose.email.examples.Utils;

public class ExtractAttachments {

	public static void main(String[] args) {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(CreateNewEmail.class) + "email/";

		//Initialize and Load an existing EML file
		MailMessage msg = MailMessage.load(dataDir + "EmailWithAttachment.eml", new EmlLoadOptions());

		//Initialize AttachmentCollection object with MailMessage Attachments
		AttachmentCollection attachments = msg.getAttachments();

		//Iterate over the AttachmentCollection
		for (int index = 0; index < attachments.size(); index++) {
			//Initialize Attachment object and Get the indexed Attachment reference
			Attachment attachment = (Attachment) attachments.get_Item(index);
			//Display Attachment Name
			System.out.println(attachment.getName());
			//Save Attachment to disk
			attachment.save(dataDir + "attachment_" + attachment.getName());
		}
	}

}
