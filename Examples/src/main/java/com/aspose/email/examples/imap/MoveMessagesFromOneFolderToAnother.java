package com.aspose.email.examples.imap;

import com.aspose.email.ImapClient;
import com.aspose.email.ImapFolderInfo;
import com.aspose.email.ImapMessageInfoCollection;
import com.aspose.email.MailMessage;
import com.aspose.email.SecurityOptions;
import com.aspose.email.examples.Utils;

public class MoveMessagesFromOneFolderToAnother {
	
	// The path to the resource directory.
	public static final String dataDir = Utils.getSharedDataDir(MoveMessagesFromOneFolderToAnother.class) + "IMAP/";
			
	public static void main(String[] args) {
		// Initiate IMAP client with user name and password
		ImapClient client = new ImapClient("host.domain.com", 587, "username", "password");
		client.setSecurityOptions(SecurityOptions.Auto);

		try {
			//Create a test folder in the mailbox
			String folderName = dataDir + "EMAILNET-35151";
			if (!client.existFolder(folderName))
				client.createFolder(folderName);
			try {
				//Append a new message to the created folder
				MailMessage message = new MailMessage("from@gmail.com", "to@gmail.com", "EMAILNET-35151 - ", "EMAILNET-35151 ImapClient: Provide option to Move Message");

				client.selectFolder(ImapFolderInfo.IN_BOX);

				String uniqueId = client.appendMessage(ImapFolderInfo.IN_BOX, message);

				//Verify that the message is added
				ImapMessageInfoCollection messageInfoCol1 = client.listMessages();

				//move the message to the created folder using its unique id
				client.moveMessage(uniqueId, folderName);

				//this is necessary to complete the transaction
				client.commitDeletes();

				//select the created folder
				client.selectFolder(folderName);

				//verify that the message is moved to the new folder
				messageInfoCol1 = client.listMessages();

				//verify that the message is moved from the source folder
				client.selectFolder(ImapFolderInfo.IN_BOX);

				messageInfoCol1 = client.listMessages();
			} finally {
				try {
					client.deleteFolder(folderName);
				} catch (java.lang.RuntimeException e) {
				}
			}
		} finally {
			if (client != null)
				client.dispose();
		}

	}

}
