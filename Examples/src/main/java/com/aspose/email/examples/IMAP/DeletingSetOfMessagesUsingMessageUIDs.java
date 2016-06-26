package com.aspose.email.examples.IMAP;

import com.aspose.email.ImapClient;
import com.aspose.email.ImapFolderInfo;
import com.aspose.email.ImapMessageInfoCollection;
import com.aspose.email.MailMessage;
import com.aspose.email.system.collections.generic.List;

public class DeletingSetOfMessagesUsingMessageUIDs {

	public static void main(String[] args) {
		final ImapClient client = new ImapClient("exchange.domain.com", "username", "password");
		try {
			System.out.println(client.getUidPlusSupported());

			// select the Inbox folder of server
			client.selectFolder(ImapFolderInfo.IN_BOX);

			// The following list variable will contain messages UIDs
			List<String> uidList = new List<String>();

			// Create 5 test messages and append them to server's mailbox
			final int messageNumber = 5;
			for (int i = 0; i < messageNumber; i++) {
				// Create a new message
				MailMessage message = new MailMessage("from@domain.com", "to@domain.com", "Deleting Multiple Messages using ImapClient based on Message UIDs", "EMAILNET-35226: Add ability in ImapClient to delete a set of messages");

				// Append the message to server
				String uid = client.appendMessage(message);

				// Add the message Unique Id to the storage list
				uidList.add(uid);
			}

			// Retrieve the list of messages and verify the message count
			final ImapMessageInfoCollection[] messageInfoCol = { null };
			messageInfoCol[0] = client.listMessages();
			System.out.println(messageInfoCol[0].size());

			// Now delete the messages using the messages' UIDs
			client.deleteMessagesByUids(uidList, true);
			client.commitDeletes();

			messageInfoCol[0] = client.listMessages();
			System.out.println(messageInfoCol[0].size());
		} finally {
			client.dispose();
		}

	}

}
