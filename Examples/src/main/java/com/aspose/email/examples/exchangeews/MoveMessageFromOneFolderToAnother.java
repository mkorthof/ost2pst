package com.aspose.email.examples.exchangeews;

import com.aspose.email.EWSClient;
import com.aspose.email.ExchangeMailboxInfo;
import com.aspose.email.ExchangeMessageInfo;
import com.aspose.email.ExchangeMessageInfoCollection;
import com.aspose.email.IEWSClient;

public class MoveMessageFromOneFolderToAnother {

	public static void main(String[] args) {
		moveMessagesBetweenFoldersUsingEWS();
	}

	public static void moveMessagesBetweenFoldersUsingEWS() {
		// Create instance of IEWSClient class by giving credentials
		IEWSClient client = EWSClient.getEWSClient("https://outlook.office365.com/exchangeews/exchange.asmx", "testUser", "pwd", "domain");
		ExchangeMailboxInfo mailboxInfo = client.getMailboxInfo();

		// List all messages from Inbox folder
		System.out.println("Listing all messages from Inbox....");
		ExchangeMessageInfoCollection msgInfoColl = client.listMessages(mailboxInfo.getInboxUri());
		for (ExchangeMessageInfo msgInfo : msgInfoColl) {
			// Move message to "Processed" folder, after processing certain messages
			// based on some criteria
			if (msgInfo.getSubject() != null && msgInfo.getSubject().contains("process this message") == true) {
				// Move it
				client.moveItem(msgInfo.getUniqueUri(), client.getMailboxInfo().getRootUri() + "/Processed/" + msgInfo.getSubject());
				System.out.println("Message moved...." + msgInfo.getSubject());
			} else {
				// Do something else
			}
		}
	}
}
