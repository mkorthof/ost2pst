package com.aspose.email.examples.exchange;

import com.aspose.email.ImapClient;
import com.aspose.email.ImapFolderInfo;
import com.aspose.email.ImapMessageInfo;
import com.aspose.email.ImapMessageInfoCollection;
import com.aspose.email.MailMessage;
import com.aspose.email.SaveOptions;
import com.aspose.email.examples.Utils;
import com.aspose.email.examples.email.AddAndRetrieveAttachmentFromCalendarItems;

public class ConnectToExchangeServerUsingIMAP {
	
	// The path to the resource directory.
	public static String dataDir = Utils.getSharedDataDir(AddAndRetrieveAttachmentFromCalendarItems.class) + "exchange/";
			
	public static void main(String[] args) {
		connectToExchangeServerUsingIMAP();
		useMessageInfoObjectSequenceNumberToSaveAMessage();
	}

	public static void connectToExchangeServerUsingIMAP() {
		// Connect to Exchange Server using ImapClient class
		ImapClient imapClient = new ImapClient("imap.gmail.com", 993, "username", "password");

		// Select the Inbox folder
		imapClient.selectFolder(ImapFolderInfo.IN_BOX);

		// Get the list of messages
		ImapMessageInfoCollection msgCollection = imapClient.listMessages();
		for (ImapMessageInfo msgInfo : msgCollection) {
			System.out.println(msgInfo.getSubject());
		}
	}

	public static void useMessageInfoObjectSequenceNumberToSaveAMessage() {
		ImapClient imapClient = new ImapClient("imap.gmail.com", 993, "username", "password");
		imapClient.selectFolder(ImapFolderInfo.IN_BOX);

		// Get the list of messages
		ImapMessageInfoCollection msgCollection = imapClient.listMessages();
		for (ImapMessageInfo msgInfo : msgCollection) {
			//Fetch the message from Inbox using its SequenceNumber from msgInfo
			MailMessage msg = imapClient.fetchMessage(msgInfo.getSequenceNumber());

			//Save the message to disc now
			msg.save(dataDir + msgInfo.getSequenceNumber() + ".msg", SaveOptions.getDefaultMsgUnicode());
		}
	}
}
