package com.aspose.email.examples.exchange;

import com.aspose.email.EWSClient;
import com.aspose.email.IEWSClient;
import com.aspose.email.MailMessage;

public class CopyAMessageToAnotherFolder {

	public static void main(String[] args) {
		// Create instance of EWSClient class by giving credentials
		IEWSClient client = EWSClient.getEWSClient("https://outlook.office365.com/ews/exchange.asmx", "testUser", "pwd", "domain");

		MailMessage message = new MailMessage("from@domain.com", "to@domain.com", "EMAILNET-34997 - ", "EMAILNET-34997 Exchange: Copy a message and get reference to the new Copy item");
		String messageUri = client.appendMessage(message);
		String newMessageUri = client.copyItem(messageUri, client.getMailboxInfo().getDeletedItemsUri());
	}
}
