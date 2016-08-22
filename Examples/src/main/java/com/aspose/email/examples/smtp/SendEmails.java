package com.aspose.email.examples.smtp;

import com.aspose.email.MailMessage;
import com.aspose.email.SecurityOptions;
import com.aspose.email.SmtpClient;

public class SendEmails {

	public static void main(String[] args) {
		// Initialize SmtpClient object
		SmtpClient client = new SmtpClient("smtp.gmail.com", 587, "username", "password");

		// Set Security options for the server
		client.setSecurityOptions(SecurityOptions.Auto);

		// Create a new Email Message
		MailMessage msg = new MailMessage("senderemail@gmail.com", "recieveremail@gmail.com", "First Message from Java", "Body");
		System.out.println("Sending message..");
		
		// Send the Message now
		client.send(msg);
	}

}
