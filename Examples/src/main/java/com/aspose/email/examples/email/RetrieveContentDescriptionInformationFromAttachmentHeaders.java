package com.aspose.email.examples.email;

import com.aspose.email.MailMessage;
import com.aspose.email.examples.Utils;

public class RetrieveContentDescriptionInformationFromAttachmentHeaders {

	public static void main(String[] args) {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(RetrieveContentDescriptionInformationFromAttachmentHeaders.class) + "email/";
				
		MailMessage msg = MailMessage.load(dataDir + "EmailWithAttachment.eml");
		String description = msg.getAttachments().get_Item(0).getHeaders().get_Item("Content-Description");
		System.out.println("Description: " + description);
	}
}
