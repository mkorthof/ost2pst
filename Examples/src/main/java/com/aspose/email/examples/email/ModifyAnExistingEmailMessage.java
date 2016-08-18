package com.aspose.email.examples.email;

import com.aspose.email.MailAddressCollection;
import com.aspose.email.MailMessage;
import com.aspose.email.examples.Utils;

public class ModifyAnExistingEmailMessage {

	public static void main(String[] args) {
		
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(CreateNewEmail.class) + "email/";

		//Initialize and Load an existing MSG file by specifying the MessageFormat
		MailMessage email = MailMessage.load(dataDir + "Message.msg");

		//Initialize a String variable to get the Email Subject
		String subject = email.getSubject();
		//Append some more information to Subject
		subject = subject + " This text is added to the existing subject";
		//Set the Email Subject
		email.setSubject(subject);

		//Initialize a String variable to get the Email's HTML Body
		String body = email.getHtmlBody();
		//Apppend some more information to the Body variable
		body = body + "<br> This text is added to the existing body";
		//Set the Email Body
		email.setHtmlBody(body);

		//Initialize MailAddressCollection object
		MailAddressCollection contacts = new MailAddressCollection();

		//Retrieve Email's TO list
		contacts = email.getTo();
		//Check if TO list has some values
		if (contacts.size() > 0) {
			//Remove the first email address
			contacts.removeAt(0);
			//Add another email address to collection
			contacts.add("to1@domain.com");
		}
		//Set the collection as Email's TO list
		email.setTo(contacts);

		//Initialize MailAddressCollection
		contacts = new MailAddressCollection();

		//Retrieve Email's CC list
		contacts = email.getCC();
		//Add another email address to collection
		contacts.add("cc2@domain.com");
		//Set the collection as Email's CC list
		email.setCC(contacts);

		//Save the Email message to disk
		email.save(dataDir + "ModifingAnExistingEmailMessage_out.msg");

	}

}
