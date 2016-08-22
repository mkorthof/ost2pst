package com.aspose.email.examples.exchange;

import com.aspose.email.EWSClient;
import com.aspose.email.IEWSClient;
import com.aspose.email.MapiContact;
import com.aspose.email.MapiContactNamePropertySet;

public class AddContactsInformation {

	public static void main(String[] args) {
		IEWSClient client = EWSClient.getEWSClient("https://exchange.domain.com/ews/Exchange.asmx", "username", "password", "domain.com");

		//Initialize MapiContact object and populate contact information
		MapiContact contact = new MapiContact();
		contact.setElectronicAddresses(null);
		contact.setTelephones(null);
		contact.setNameInfo(new MapiContactNamePropertySet("John", "", "Doe"));
		//Create the contact on the Exchange server
		client.createContact(contact);
	}

}
