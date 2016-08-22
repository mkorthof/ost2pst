package com.aspose.email.examples.smtp;

import com.aspose.email.MailMessage;
import com.aspose.email.SecurityOptions;
import com.aspose.email.SmtpClient;
import com.aspose.email.examples.Utils;

public class ForwardAnEmailUsingSMTPClient {

	public static void main(String[] args) {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(SendTasksRequests.class) + "SMTP/";
				
		//Create an instance of SmtpClient class
		SmtpClient client = new SmtpClient();

		//Specify your mailing host server
		client.setHost("mail.server.com");

		//Specify your mail user name
		client.setUsername("username");

		//Specify your mail password
		client.setPassword("password");

		//Specify your Port #
		client.setPort(587);

		//Specify security option
		client.setSecurityOptions(SecurityOptions.SSLExplicit);

		MailMessage msg = MailMessage.load(dataDir + "test.eml");

		client.forward("Recipient1@domain.com", "Recipient2@domain.com", msg);
	}

}
