package com.aspose.email.examples.exchange.ews;

import com.aspose.email.Contact;
import com.aspose.email.EWSClient;
import com.aspose.email.IEWSClient;

public class UpdateContactInformation {

	public static void main(String[] args) {
		IEWSClient client = EWSClient.getEWSClient("https://exchange.domain.com/ews/Exchange.asmx", "username", "password", "domain.com");
		// List all the contacts
		Contact[] contacts = client.getContacts(client.getMailboxInfo().getContactsUri());
		
		Contact contact = contacts[0];
		System.out.println("Name: " + contact.getDisplayName());
		contact.setDisplayName("David Ch");
		client.updateContact(contact);
	}

}
