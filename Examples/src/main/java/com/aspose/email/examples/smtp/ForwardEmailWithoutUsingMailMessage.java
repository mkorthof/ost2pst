package com.aspose.email.examples.smtp;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.aspose.email.MailAddressCollection;
import com.aspose.email.SecurityOptions;
import com.aspose.email.SmtpClient;

public class ForwardEmailWithoutUsingMailMessage {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//ExStart: ForwardEmailWithoutMailMessage
		String host = "mail.domain.com";
		String name = "username";
		int smtpPort = 587;
		String password = "password";
		
		MailAddressCollection recipients = new MailAddressCollection();
		
		recipients.add("to1@domain.com, to2@domain.com");
		
		SmtpClient client = new SmtpClient(host, smtpPort, name, password, SecurityOptions.SSLExplicit);
				
		String fileName = "test.eml";
		
		FileOutputStream fos = new FileOutputStream(fileName); 
		
		client.forward("Sender@doomain.com", recipients, fos);
		       
		fos.close();
		//ExEnd: ForwardEmailWithoutMailMessage
	}

}
