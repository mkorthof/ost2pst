package com.aspose.email.examples.exchange;

import com.aspose.email.EWSClient;
import com.aspose.email.ExchangeClient;
import com.aspose.email.ExchangeMailboxInfo;
import com.aspose.email.IEWSClient;

public class GetMailboxInformationFromExchangeServer {

	public static void main(String[] args) {
		// Getting Mailbox Information from an Exchange Server
		getMailboxInformationFromAnExchangeServer();
		
		// Getting Mailbox Information from Exchange Web Services
		getMailboxInformationFromExchangeWebServices();
		
	}

	public static void getMailboxInformationFromAnExchangeServer() {
		// Create instance of ExchangeClient class by giving credentials
		ExchangeClient client = new ExchangeClient("https://MachineName/exchange/Username", "Username", "password", "domain");
		System.out.println("Mailbox size: " + client.getMailboxSize() + " bytes");
		
		ExchangeMailboxInfo mailboxInfo = client.getMailboxInfo();
		System.out.println("Mailbox URI: " + mailboxInfo.getMailboxUri());
		System.out.println("Inbox folder URI: " + mailboxInfo.getInboxUri());
		System.out.println("Sent Items URI: " + mailboxInfo.getSentItemsUri());
		System.out.println("Drafts folder URI: " + mailboxInfo.getDraftsUri());
	}
	
	public static void getMailboxInformationFromExchangeWebServices() {
		// Create instance of EWSClient class by giving credentials
		IEWSClient client = EWSClient.getEWSClient("https://exchange.name.com/ews/Exchange.asmx/", "username", "password", "");	
		System.out.println("Mailbox size: " + client.getMailboxSize() + " bytes");

		ExchangeMailboxInfo mailboxInfo = client.getMailboxInfo();
		System.out.println("Mailbox URI: " + mailboxInfo.getMailboxUri());
		System.out.println("Inbox folder URI: " + mailboxInfo.getInboxUri());
		System.out.println("Sent Items URI: " + mailboxInfo.getSentItemsUri());
		System.out.println("Drafts folder URI: " + mailboxInfo.getDraftsUri());
	}
}
