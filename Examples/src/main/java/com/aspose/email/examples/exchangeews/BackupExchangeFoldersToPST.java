package com.aspose.email.examples.exchangeews;

import com.aspose.email.EWSClient;
import com.aspose.email.ExchangeFolderInfo;
import com.aspose.email.ExchangeFolderInfoCollection;
import com.aspose.email.ExchangeMailboxInfo;
import com.aspose.email.IEWSClient;

public class BackupExchangeFoldersToPST {

	public static void main(String[] args) {
		// Create instance of IEWSClient class by providing credentials
		IEWSClient client = EWSClient.getEWSClient("https://exchange.domain.com/exchangeews/Exchange.asmx/", "user", "password", "");

		// Get Exchange mailbox info of other email account
		ExchangeMailboxInfo mailboxInfo = client.getMailboxInfo();
		ExchangeFolderInfo info = client.getFolderInfo(mailboxInfo.getInboxUri());
		ExchangeFolderInfoCollection fc = new ExchangeFolderInfoCollection();
		fc.addItem(info);
		client.backup(fc, "Backup.pst", 0); //0 for None, 1 for Recursive
	}

}
