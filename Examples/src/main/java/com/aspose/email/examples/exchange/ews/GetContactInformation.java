package com.aspose.email.examples.exchange.ews;

import com.aspose.email.Contact;
import com.aspose.email.EWSClient;
import com.aspose.email.ExchangeListContactsOptions;
import com.aspose.email.IEWSClient;

public class GetContactInformation {

	public static void main(String[] args) {

	}

	public static void getContactsFromAnExchangeServer() {
		IEWSClient client = EWSClient.getEWSClient("https://exchange.domain.com/ews/Exchange.asmx", "username", "password", "domain.com");
		// List all the contacts
		Contact[] contacts = client.getContacts(client.getMailboxInfo().getContactsUri());
		// Loop through all contacts
		for (Contact contact : contacts) {
			// Display name and email address
			System.out.println("Name: " + contact.getDisplayName() + ", Email Address: " + contact.getEmailAddresses().get_Item(0));
		}
	}

	public static void resolveContactsUsingContactName() {
		IEWSClient client = EWSClient.getEWSClient("https://exchange.domain.com/ews/Exchange.asmx", "username", "password", "domain.com");

		// List all the contacts
		Contact[] contacts = client.resolveContacts("Changed Name");
		// Loop through all contacts
		for (Contact contact : contacts) {
			// Display name and email address
			System.out.println("Name: " + contact.getDisplayName() + ", Email Address: " + contact.getEmailAddresses().get_Item(0));
		}
	}
	
	public static void fetchContactById() {
		IEWSClient client = EWSClient.getEWSClient("https://exchange.domain.com/ews/Exchange.asmx", "username", "password", "domain.com");
		Contact fetchedContact = client.getContact("id");
	}
}
