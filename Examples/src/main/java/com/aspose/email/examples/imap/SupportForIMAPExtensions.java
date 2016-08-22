package com.aspose.email.examples.imap;

import com.aspose.email.ImapClient;
import com.aspose.email.ImapFolderInfo;
import com.aspose.email.ImapFolderInfoCollection;
import com.aspose.email.ImapIdentificationInfo;
import com.aspose.email.SecurityOptions;

public class SupportForIMAPExtensions {

	public static void main(String[] args) {
		// Support for IMAP4 ID Extension
		supportForIMAP4IDExtension();
		
		// IMAP4 Extended List Command
		IMAP4ExtendedListCommand();
	}

	public static void supportForIMAP4IDExtension() {
		ImapClient client = new ImapClient("imap.gmail.com", 993, "username", "password");
		client.setSecurityOptions(SecurityOptions.Auto);

		System.out.println(client.getIdSupported());

		ImapIdentificationInfo serverIdentificationInfo1 = client.introduceClient();
		ImapIdentificationInfo serverIdentificationInfo2 = client.introduceClient(ImapIdentificationInfo.getDefaultValue());

		System.out.println(serverIdentificationInfo1 + "," + serverIdentificationInfo2);
		System.out.println(serverIdentificationInfo1.getName());
		System.out.println(serverIdentificationInfo1.getVendor());
		System.out.println(serverIdentificationInfo1.getSupportUrl());
		System.out.println(serverIdentificationInfo1.getVersion());
	}

	public static void IMAP4ExtendedListCommand() {
		ImapClient client = new ImapClient("imap.gmail.com", 993, "username", "password");

		ImapFolderInfoCollection folderInfoCol = client.listFolders("*");
		System.out.println("Extended List Supported: " + client.getExtendedListSupported());
		
		for (ImapFolderInfo folderInfo : folderInfoCol) {
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
}
