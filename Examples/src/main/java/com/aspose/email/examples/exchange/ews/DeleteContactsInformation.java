package com.aspose.email.examples.exchange.ews;

import com.aspose.email.Contact;
import com.aspose.email.EWSClient;
import com.aspose.email.IEWSClient;

public class DeleteContactsInformation {

	public static void main(String[] args) {
		IEWSClient client = EWSClient.getEWSClient("https://exchange.domain.com/ews/Exchange.asmx", "username", "password", "domain.com");
		String strContactToDelete = "John Teddy";
		
		Contact[] contacts = client.getContacts(client.getMailboxInfo().getContactsUri());
		for (Contact contact : contacts) {
			if (contact.getDisplayName().equals(strContactToDelete))
				client.deleteContact(contact);
		}
		client.dispose();
	}
}
