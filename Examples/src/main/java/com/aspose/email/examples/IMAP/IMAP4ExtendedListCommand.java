package com.aspose.email.examples.IMAP;

import com.aspose.email.ImapClient;
import com.aspose.email.ImapFolderInfo;
import com.aspose.email.ImapFolderInfoCollection;

public class IMAP4ExtendedListCommand {

	public static void main(String[] args) {
		ImapClient client = new ImapClient("imap.gmail.com", 993, "username", "password");

		ImapFolderInfoCollection folderInfoCol = client.listFolders("*");
		System.out.println("Extended List Supported: " + client.getExtendedListSupported());
		for (ImapFolderInfo folderInfo : folderInfoCol)
			switch (folderInfo.getName()) {
			case "[Gmail]/All Mail":
				System.out.println("Has Children: " + folderInfo.hasChildren());
				break;
			case "[Gmail]/Bin":
				System.out.println("Bin has children? " + folderInfo.hasChildren());
				break;
			case "[Gmail]/Drafts":
				System.out.println("Drafts has children? " + folderInfo.hasChildren());
				break;
			case "[Gmail]/Important":
				System.out.println("Important has Children? " + folderInfo.hasChildren());
				break;
			case "[Gmail]/Sent Mail":
				System.out.println("Sent Mail has Children? " + folderInfo.hasChildren());
				break;
			case "[Gmail]/Spam":
				System.out.println("Spam has Children? " + folderInfo.hasChildren());
				break;
			case "[Gmail]/Starred":
				System.out.println("Starred has Children? " + folderInfo.hasChildren());
				break;
			}
	}

}
