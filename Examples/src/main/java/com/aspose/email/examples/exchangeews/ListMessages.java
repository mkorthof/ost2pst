package com.aspose.email.examples.exchangeews;

import com.aspose.email.EWSClient;
import com.aspose.email.ExchangeMessageInfo;
import com.aspose.email.ExchangeMessageInfoCollection;
import com.aspose.email.IEWSClient;

public class ListMessages {

	public static void main(String[] args) {

		// Connects to an Exchange Server using EWS and lists messages from the Inbox folder
		listMessagesFromInboxFolderOnExchangeServerUsingEWS();

		listMessagesFromOtherFoldersOnExchangeServerUsingEWS();
	}

	public static void listMessagesFromInboxFolderOnExchangeServerUsingEWS() {
		// Create instance of ExchangeClient class by giving credentials
		IEWSClient client = EWSClient.getEWSClient("https://exchange.aspose.com/exchangeews/Exchange.asmx/", "aspose-email.test3", "mahlakaaspose", "");
		// Call ListMessages method to list messages info from Inbox
		ExchangeMessageInfoCollection msgCollection = client.listMessages(client.getMailboxInfo().getInboxUri());

		// Loop through the collection to display the basic information
		for (ExchangeMessageInfo msgInfo : msgCollection) {
			System.out.println("Subject: " + msgInfo.getSubject());
			System.out.println("From: " + msgInfo.getFrom());
			System.out.println("To: " + msgInfo.getTo());
			System.out.println("Sent Date: " + msgInfo.getDate());
			System.out.println("Read?: " + msgInfo.isRead());
			System.out.println("Message ID: " + msgInfo.getMessageId());
			System.out.println("Unique URI: " + msgInfo.getUniqueUri());
			System.out.println("==================================");
		}
	}

	public static void listMessagesFromOtherFoldersOnExchangeServerUsingEWS() {
		// Create instance of EWSClient class by giving credentials
		IEWSClient client = EWSClient.getEWSClient("https://outlook.office365.com/exchangeews/exchange.asmx", "testUser", "pwd", "domain");

		// Get folder URI
		String strFolderURI = "";
		strFolderURI = client.getMailboxInfo().getInboxUri();
		strFolderURI = client.getMailboxInfo().getDeletedItemsUri();
		strFolderURI = client.getMailboxInfo().getDraftsUri();
		strFolderURI = client.getMailboxInfo().getSentItemsUri();

		// Get list of messages from the specified folder
		ExchangeMessageInfoCollection msgCollection = client.listMessages(strFolderURI);
	}
}
