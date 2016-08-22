package com.aspose.email.examples.exchange;

import com.aspose.email.EWSClient;
import com.aspose.email.ExchangeMessageInfoCollection;
import com.aspose.email.IEWSClient;
import com.aspose.email.MailMessage;
import com.aspose.email.SyncFolderResult;

public class SynchronizeFolderItems {

	public static void main(String[] args) {
		IEWSClient client = EWSClient.getEWSClient("https://exchange.aspose.com/ews/Exchange.asmx/", "elon.musk", "mahlaka1982");
		MailMessage message1 = new MailMessage("john.kerry@aspose.com", "aspose-email.test3@aspose.com", "EMAILNET-34738 ", "EMAILNET-34738 Sync Folder Items");
		client.send(message1);

		MailMessage message2 = new MailMessage("from@doamin.com", "to@domain.com", "EMAILNET-34738 - ", "EMAILNET-34738 Sync Folder Items");
		client.send(message2);
		
		ExchangeMessageInfoCollection messageInfoCol = client.listMessages(client.getMailboxInfo().getInboxUri());
		
		SyncFolderResult result = client.syncFolder(client.getMailboxInfo().getInboxUri(), null);
		System.out.println(result.getNewItems().size());
		System.out.println(result.getChangedItems().size());
		System.out.println(result.getReadFlagChanged().size());
		System.out.println(result.getDeletedItems().length);

	}

}
