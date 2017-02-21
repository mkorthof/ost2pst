package com.aspose.email.examples.exchangeews;

import com.aspose.email.EWSClient;
import com.aspose.email.ExchangeMailboxInfo;
import com.aspose.email.IEWSClient;

public class ReadEmailsFromOtherUsersMailbox {

	public static void main(String[] args) {
		usingExchangeWebServiceClient();
	}

	public static void usingExchangeWebServiceClient() {
		// Create instance of EWSClient class by giving credentials
		IEWSClient client = EWSClient.getEWSClient("https://outlook.office365.com/exchangeews/exchange.asmx", "testUser", "pwd", "domain");

		// Get Exchange mailbox info of other email account
		ExchangeMailboxInfo mailboxInfo = client.getMailboxInfo("otherUser@domain.com");
	}
}
