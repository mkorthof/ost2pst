package com.aspose.email.examples.email;

import com.aspose.email.MailMessage;
import com.aspose.email.examples.Utils;

public class DetermineIfAttachmentIsEmbeddedMessage {

	public static void main(String[] args) {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(DetermineIfAttachmentIsEmbeddedMessage.class) + "email/";
		MailMessage eml = MailMessage.load(dataDir + "EmailWithAttandEmbedded.eml");

		if (eml.getAttachments().get_Item(0).isEmbeddedMessage()) {
			System.out.println("Attachment is an embedded message");
		}
	}
}
