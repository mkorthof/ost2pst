package com.aspose.email.examples.imap;

import com.aspose.email.ImapClient;
import com.aspose.email.ImapFolderInfo;
import com.aspose.email.MailMessage;
import com.aspose.email.SecurityOptions;

public class AddANewMessageToAFolder {

	public static void main(String[] args) {
		ImapClient client = new ImapClient();
		client.setHost("imap.gmail.com");
		client.setPort(993);
		client.setUsername("username");
		client.setPassword("password");
		client.setSecurityOptions(SecurityOptions.Auto);
		
		// Create a message
		MailMessage msg = new MailMessage("user@domain1.com", "user@domain2.com", "subject", "message");

		// Subscribe to the Inbox folder
		client.selectFolder(ImapFolderInfo.IN_BOX);

		client.subscribeFolder(client.getCurrentFolder().getName());

		// Append the newly created message
		client.appendMessage(client.getCurrentFolder().getName(), msg);
	}

}
