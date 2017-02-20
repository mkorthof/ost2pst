package com.aspose.email.examples.exchange;

import com.aspose.email.EWSClient;
import com.aspose.email.ExchangeFolderInfo;
import com.aspose.email.ExchangeMailboxInfo;
import com.aspose.email.ExchangeMessageInfo;
import com.aspose.email.ExchangeMessageInfoCollection;
import com.aspose.email.IEWSClient;
import com.aspose.email.MailMessage;

public class AccessMailboxCustomFoldersOrSubfolders {

	public static void main(String[] args) {
		IEWSClient _client = EWSClient.getEWSClient("https://exchange.domain.com/ews/Exchange.asmx/", "user", "password", "");
		//Create ExchangeMailboxInfo instance to save default mailbox info
		ExchangeMailboxInfo mailbox = _client.getMailboxInfo();

		//Declare ExchangeMessageInfoCollection instance for storing messages info collection
		ExchangeMessageInfoCollection messages = null;

		//Declare variable for getting specified custom folder URI
		ExchangeFolderInfo subfolderInfo[] = new ExchangeFolderInfo[] { null };

		//Check if specified custom folder exists
		//PROBLEM: at this line
		_client.folderExists(mailbox.getInboxUri(), "592633", subfolderInfo);

		if (subfolderInfo != null) {
			//Get all the messages info from the target URI
			messages = _client.listMessages(subfolderInfo[0].getUri());

			//Parse all the messages info collection
			for (ExchangeMessageInfo info : messages) {
				String strMessageURI = info.getUniqueUri();

				// now get the message details using FetchMessage()
				MailMessage msg = _client.fetchMessage(strMessageURI);

				// display message details
				System.out.println("Subject: " + msg.getSubject());
			}
		} /*else {
			System.out.println("Target folder not found");
		}*/
	}
}
