package com.aspose.email.examples.smtp;

import com.aspose.email.*;
import com.aspose.email.examples.Utils;

public class SendTasksRequests {

	public static void main(String[] args) {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(SendTasksRequests.class) + "SMTP/";

		MsgLoadOptions msgLoadOptions = new MsgLoadOptions();
		msgLoadOptions.setPreserveTnefAttachments(true);

		// load task from .msg file
		MailMessage eml = MailMessage.load(dataDir + "task.msg", msgLoadOptions);
		eml.setFrom(new MailAddress("firstname.lastname@domain.com"));
		eml.getTo().clear();
		MailAddress address = new MailAddress("firstname.lastname@domain.com");
		MailAddressCollection addresses = new MailAddressCollection();
		addresses.addMailAddress(address);
		eml.setTo(addresses);

		SmtpClient client = new SmtpClient("smtp.gmail.com", 587, "brett.lee.aspose", "aspose1234");

		client.send(eml);
	}

}
