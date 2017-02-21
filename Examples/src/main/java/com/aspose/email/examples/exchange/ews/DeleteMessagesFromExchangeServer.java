package com.aspose.email.examples.exchange.ews;

import com.aspose.email.EWSClient;
import com.aspose.email.ExchangeMailboxInfo;
import com.aspose.email.ExchangeMessageInfo;
import com.aspose.email.ExchangeMessageInfoCollection;
import com.aspose.email.IEWSClient;

public class DeleteMessagesFromExchangeServer {

	public static void main(String[] args) {
		deleteMessagesFromExchangeServerUsingEWS();
	}

	public static void deleteMessagesFromExchangeServerUsingEWS() {
		// Create instance of IEWSClient class by giving credentials
		IEWSClient client = EWSClient.getEWSClient("https://outlook.office365.com/ews/exchange.asmx", "testUser", "pwd", "domain");
		ExchangeMailboxInfo mailboxInfo = client.getMailboxInfo();

		// List all messages from Inbox folder
		System.out.println("Listing all messages from Inbox....");
		ExchangeMessageInfoCollection msgInfoColl = client.listMessages(mailboxInfo.getInboxUri());
		for (ExchangeMessageInfo msgInfo : msgInfoColl) {
			// Delete message based on some criteria
			if (msgInfo.getSubject() != null && msgInfo.getSubject().contains("delete") == true) {
				// Delete it
				client.deleteMessage(msgInfo.getUniqueUri());
				System.out.println("Message deleted...." + msgInfo.getSubject());
			} else {
				// Do something else
			}
		}
	}
}
