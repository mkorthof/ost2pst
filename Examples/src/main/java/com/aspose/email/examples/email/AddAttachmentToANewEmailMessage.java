package com.aspose.email.examples.email;

import com.aspose.email.Attachment;
import com.aspose.email.MailAddress;
import com.aspose.email.MailMessage;
import com.aspose.email.SaveOptions;
import com.aspose.email.examples.Utils;

public class AddAttachmentToANewEmailMessage {

	public static void main(String[] args) {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(CreateNewEmail.class) + "email/";
				
		//Create an instance of MailMessage class
		MailMessage message = new MailMessage();

		//From
		message.setFrom(new MailAddress("sender@sender.com"));

		//To
		message.getTo().addMailAddress(new MailAddress("receiver@gmail.com"));

		//Adding 1st attachment
		//Create an instance of Attachment class
		Attachment attachment;

		//Load an attachment
		attachment = new Attachment(dataDir + "1.txt");

		//Add attachment in instance of MailMessage class
		message.getAttachments().addItem(attachment);

		//Add 2nd Attachment
		message.getAttachments().addItem(new Attachment(dataDir + "1.jpg"));

		//Add 3rd Attachment
		message.getAttachments().addItem(new Attachment(dataDir + "1.doc"));

		//Add 4th Attachment
		message.getAttachments().addItem(new Attachment(dataDir + "1.rar"));

		//Add 5th Attachment
		message.getAttachments().addItem(new Attachment(dataDir + "1.pdf"));

		//Save message to disc
		message.save(dataDir + "AddAttachmentToANewEmailMessage_out.msg", SaveOptions.getDefaultMsg());

	}

}
