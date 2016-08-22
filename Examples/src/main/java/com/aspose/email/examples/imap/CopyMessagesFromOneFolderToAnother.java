package com.aspose.email.examples.imap;

import com.aspose.email.ImapClient;
import com.aspose.email.ImapFolderInfo;
import com.aspose.email.ImapMessageInfo;
import com.aspose.email.ImapMessageInfoCollection;
import com.aspose.email.MailMessage;
import com.aspose.email.examples.Utils;
import com.aspose.email.system.collections.generic.List;

public class CopyMessagesFromOneFolderToAnother {
		
	public static void main(String[] args) throws InterruptedException {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(CopyMessagesFromOneFolderToAnother.class) + "IMAP/";
		
		final ImapClient client = new ImapClient("exchange.domain.com", "username", "password");
		try {
			String folderName = dataDir + "EMAILNET-35242";
			if (!client.existFolder(folderName))
				client.createFolder(folderName);
			try {
				/*
				 * we need to check if this functionality is supported in case of Gmail. 
				 * Use the getMoveSupported method for this purpose if required 
				 * switch (serverType) { 
				 * 		case TestServerType.Gmail:
				 * 			msAssert.isTrue(client.getMoveSupported());
				 * 			break; 
				 * }
				 */

				//Select the Inbox folder of mailbox
				client.selectFolder(ImapFolderInfo.IN_BOX);

				//create a couple of messages that we'll append to the mailbox for testing
				MailMessage message1 = new MailMessage("username@domain.com", "to@domain.com", "Message 1: Copying Multiple Messages on a Single API call",
						"EMAILNET-35242 Improvement of copy method.Add ability to 'copy' multiple messages per invocation.");

				//Append the message to the server
				String uniqueId1 = client.appendMessage(message1);

				//Create another test message
				MailMessage message2 = new MailMessage("username@domain.com", "to@domain.com", "Message 2: Copying Multiple Messages on a Single API call",
						"EMAILNET-35242 Improvement of copy method.Add ability to 'copy' multiple messages per invocation.");

				//Append the message to the server
				String uniqueId2 = client.appendMessage(message2);

				//wait for some time so that we are sure that the messages have been appended to the mailbox
				Thread.sleep(5000);

				//Create a list of Unique IDs for appended messages
				List<String> t = new List<String>();
				t.add(uniqueId1);
				t.add(uniqueId2);

				//Copy the list of messages to the destination folder
				client.copyMessagesByUids(t, folderName, true);

				//Now select the destination folder and verify that the messages have been copied to that folder
				client.selectFolder(folderName);
				ImapMessageInfoCollection msgsColl = client.listMessages();
				for (ImapMessageInfo msgInfo : msgsColl)
					System.out.println(msgInfo.getSubject());
			} finally {
				try {
					client.deleteFolder(folderName);
				} catch (java.lang.RuntimeException e) {
				}
			}
		} finally {
			client.dispose();
		}

	}

}
