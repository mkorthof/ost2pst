package com.aspose.email.examples.exchange.ews;

import com.aspose.email.EWSClient;
import com.aspose.email.ExchangeFolderInfo;
import com.aspose.email.ExchangeFolderInfoCollection;
import com.aspose.email.ExchangeMailboxInfo;
import com.aspose.email.IEWSClient;

public class ListAllFolders {

	public static void main(String[] args) {
		listAllFolders();
	}

	private static void listAllFolders() {
		try {
			IEWSClient client = EWSClient.getEWSClient("Exchange Server uri", "username", "password", "domain");
			System.out.println("Downloading all messages from Inbox....");
			ExchangeMailboxInfo mailboxInfo = client.getMailboxInfo();
			System.out.println("Mailbox URI: " + mailboxInfo.getMailboxUri());
			String rootUri = client.getMailboxInfo().getRootUri();
			// List all the folders from Exchange server
			ExchangeFolderInfoCollection folderInfoCollection = client.listSubFolders(rootUri);
			for (ExchangeFolderInfo folderInfo : folderInfoCollection) {
				// Call the recursive method to read messages and get sub-folders
				listSubFolders(client, folderInfo);
			}

			System.out.println("All messages downloaded.");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	private static void listSubFolders(IEWSClient client, ExchangeFolderInfo folderInfo) {
		// Create the folder in disk (same name as on IMAP server)
		System.out.println(folderInfo.getDisplayName());
		try {
			// If this folder has sub-folders, call this method recursively to get messages
			ExchangeFolderInfoCollection folderInfoCollection = client.listSubFolders(folderInfo.getUri());
			for (ExchangeFolderInfo subfolderInfo : folderInfoCollection) {
				listSubFolders(client, subfolderInfo);
			}
		} catch (Exception ex) {
		}
	}
}
