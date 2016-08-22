package com.aspose.email.examples.imap;

import com.aspose.email.ImapClient;
import com.aspose.email.ImapFolderInfo;
import com.aspose.email.ImapMessageFlags;
import com.aspose.email.SecurityOptions;

public class ChangeMessageFlags {

	public static void main(String[] args) {
		// Setting Message Flags
		setMessageFlags();
		
		// Removing Message Flags
		removingMessageFlags();
	}

	public static void setMessageFlags() {
		ImapClient client = new ImapClient();
		client.setHost("imap.gmail.com");
		client.setPort(993);
		client.setUsername("username");
		client.setPassword("password");
		client.setSecurityOptions(SecurityOptions.Auto);

		client.selectFolder(ImapFolderInfo.IN_BOX);
		// Mark the message as read
		client.changeMessageFlags(1, ImapMessageFlags.isRead());
	}

	public static void removingMessageFlags() {
		ImapClient client = new ImapClient();
		client.setHost("imap.gmail.com");
		client.setPort(993);
		client.setUsername("username");
		client.setPassword("password");
		client.setSecurityOptions(SecurityOptions.Auto);

		client.selectFolder(ImapFolderInfo.IN_BOX);
		// Mark the message as read
		client.removeMessageFlags(1, ImapMessageFlags.isRead());
	}

}
