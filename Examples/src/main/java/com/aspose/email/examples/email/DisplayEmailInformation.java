package com.aspose.email.examples.email;

import com.aspose.email.MailMessage;
import com.aspose.email.examples.Utils;

public class DisplayEmailInformation {

	public static void main(String[] args) {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(DisplayEmailInformation.class) + "email/";
		
		//Create MailMessage instance by loading an Eml file
		MailMessage message = MailMessage.load(dataDir + "test.eml");

		System.out.print("From: ");
		//Gets the sender info
		System.out.println(message.getFrom());
		
		System.out.print("To: ");
		//Gets the recipients info
		System.out.println(message.getTo());
		
		System.out.print("Subject: ");
		//Gets the subject
		System.out.println(message.getSubject());
		
		System.out.print("HtmlBody: ");
		//Gets the htmlbody
		System.out.println(message.getHtmlBody());
		
		System.out.print("TextBody: ");
		//Gets the textbody
		System.out.println(message.getBody());
		
		System.out.print("HtmlBodyText: ");
		//Gets the textbody from HTML
		System.out.println(message.getHtmlBodyText());

	}

}
