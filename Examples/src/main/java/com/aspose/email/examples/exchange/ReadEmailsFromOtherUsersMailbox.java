package com.aspose.email.examples.exchange;

import com.aspose.email.EWSClient;
import com.aspose.email.ExchangeClient;
import com.aspose.email.ExchangeMailboxInfo;
import com.aspose.email.IEWSClient;

public class ReadEmailsFromOtherUsersMailbox {

	public static void main(String[] args) {
		usingExchangeClient();
		
		usingExchangeWebServiceClient();
	}

	public static void usingExchangeClient() {
		// Create instance of ExchangeClient class by giving credentials
		ExchangeClient client = new ExchangeClient("http://MachineName/exchange/Username", "Username", "password", "domain");

		// Get Exchange mailbox info of other email account
		ExchangeMailboxInfo mailboxInfo = client.getMailboxInfo("otherUser@domain.com");
	}

	public static void usingExchangeWebServiceClient() {
		// Create instance of EWSClient class by giving credentials
		IEWSClient client = EWSClient.getEWSClient("https://outlook.office365.com/ews/exchange.asmx", "testUser", "pwd", "domain");

		// Get Exchange mailbox info of other email account
		ExchangeMailboxInfo mailboxInfo = client.getMailboxInfo("otherUser@domain.com");
	}
}
