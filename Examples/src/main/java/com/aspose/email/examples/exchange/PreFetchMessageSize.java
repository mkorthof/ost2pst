package com.aspose.email.examples.exchange;

import com.aspose.email.EWSClient;
import com.aspose.email.ExchangeMessageInfo;
import com.aspose.email.ExchangeMessageInfoCollection;
import com.aspose.email.IEWSClient;

public class PreFetchMessageSize {

	public static void main(String[] args) {
		// Create instance of ExchangeWebServiceClient class by giving credentials
		IEWSClient client = EWSClient.getEWSClient("https://outlook.office365.com/ews/exchange.asmx", "testUser", "pwd", "domain");

		// Call ListMessages method to list messages info from Inbox
		ExchangeMessageInfoCollection msgCollection = client.listMessages(client.getMailboxInfo().getInboxUri());

		// Loop through the collection to display the basic information
		for (ExchangeMessageInfo msgInfo : msgCollection) {
			System.out.println("Subject: " + msgInfo.getSubject());
			System.out.println("From: " + msgInfo.getFrom().toString());
			System.out.println("To: " + msgInfo.getTo().toString());
			System.out.println("Message Size: " + msgInfo.getSize());
			System.out.println("==================================");
		}
	}

}
