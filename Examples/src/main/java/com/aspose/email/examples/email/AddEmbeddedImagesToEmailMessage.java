package com.aspose.email.examples.email;

import com.aspose.email.LinkedResource;
import com.aspose.email.MailAddress;
import com.aspose.email.MailMessage;
import com.aspose.email.MediaTypeNames;
import com.aspose.email.examples.Utils;

public class AddEmbeddedImagesToEmailMessage {

	public static void main(String[] args) {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(AddEmbeddedImagesToEmailMessage.class) + "email/";
				
		// Create a new instance of MailMessage class
		MailMessage message = new MailMessage();

		// Set sender information
		message.setFrom(new MailAddress("from@domain.com", "Sender Name", false));

		// Add recipients
		message.getTo().addItem(new MailAddress("to1@domain.com", "Recipient 1", false));
		message.getTo().addItem(new MailAddress("to2@domain.com", "Recipient 2", false));

		// Set subject of the message
		message.setSubject("New message created by Aspose.Email for Java");

		// Set Html body. It also contains <img> tag with cid. cid = LinkedResource.ContentID
		message.setHtmlBody("<b>This line is in bold.</b> <br/> <br/>" + "<font color=blue>This line is in blue color</font><br><br>" + "Here is an embedded image.<img src=cid:companylogo>");

		// Add linked resource
		LinkedResource res = new LinkedResource(dataDir + "barcode.png", MediaTypeNames.Image.PNG);
		res.setContentId("companylogo");

		// Add Linked resource to the message’s Linked resource colledction
		message.getLinkedResources().addItem(res);

		// Save message in EML, MSG and MHTML formats
		message.save(dataDir + "EmbeddedImageToEmail_out.eml");
		message.save(dataDir + "EmbeddedImageToEmail_out.msg");
		message.save(dataDir + "EmbeddedImageToEmail_out.mhtml");
	}
}
