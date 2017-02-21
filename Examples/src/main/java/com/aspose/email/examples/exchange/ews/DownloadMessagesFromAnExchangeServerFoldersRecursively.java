package com.aspose.email.examples.exchange.ews;

import java.io.File;

import com.aspose.email.EWSClient;
import com.aspose.email.ExchangeFolderInfo;
import com.aspose.email.ExchangeFolderInfoCollection;
import com.aspose.email.ExchangeMailboxInfo;
import com.aspose.email.ExchangeMessageInfo;
import com.aspose.email.ExchangeMessageInfoCollection;
import com.aspose.email.IEWSClient;
import com.aspose.email.MailMessage;
import com.aspose.email.SaveOptions;

public class DownloadMessagesFromAnExchangeServerFoldersRecursively {

	public static String username = "administrator";
	public static String password = "pwd";
	public static String domain = "ex2010.local";

	public static void main(String[] args) {
		recursiveMessages();
	}

	public static void recursiveMessages() {
		//Download Messages from Exchange Server Folders and Subfolders Recursively
		try {
			String rootFolder = domain + "-" + username;
			createDirectory(rootFolder);
			String inboxFolder = rootFolder + "\\Inbox";
			createDirectory(inboxFolder);

			System.out.println("Downloading all messages from Inbox....");
			// Create instance of IEWSClient class by giving credentials
			IEWSClient client = EWSClient.getEWSClient("https://outlook.office365.com/ews/exchange.asmx", username, password, domain);

			ExchangeMailboxInfo mailboxInfo = client.getMailboxInfo();
			System.out.println("Mailbox URI: " + mailboxInfo.getMailboxUri());
			String rootUri = client.getMailboxInfo().getRootUri();
			// List all the folders from Exchange server
			ExchangeFolderInfoCollection folderInfoCollection = client.listSubFolders(rootUri);
			for (ExchangeFolderInfo folderInfo : folderInfoCollection) {
				// Call the recursive method to read messages and get sub-folders
				listMessagesInFolder(client, folderInfo, rootFolder);
			}

			System.out.println("All messages downloaded.");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	private static void listMessagesInFolder(IEWSClient client, ExchangeFolderInfo folderInfo, String rootFolder) {
		// Create the folder in disk (same name as on IMAP server)
		String currentFolder = rootFolder + "\\" + folderInfo.getDisplayName();
		createDirectory(currentFolder);

		// List messages
		ExchangeMessageInfoCollection msgInfoColl = client.listMessages(folderInfo.getUri());
		System.out.println("Listing messages....");
		int i = 0;
		for (ExchangeMessageInfo msgInfo : msgInfoColl) {
			// Get subject and other properties of the message
			System.out.println("Subject: " + msgInfo.getSubject());

			// Get rid of characters like ? and :, which should not be included in a file name
			String fileName = msgInfo.getSubject().replace(":", " ").replace("?", " ");

			// Save the message in MSG format
			MailMessage msg = client.fetchMessage(msgInfo.getUniqueUri());
			//msg.save(currentFolder + "\\" + fileName + "-" + i + ".msg", MailMessageSaveType.getOutlookMessageFormatUnicode());
			msg.save(currentFolder + "\\" + fileName + "-" + i + ".msg", SaveOptions.getDefaultMsgUnicode());
			i++;
		}
		System.out.println("============================\n");
		try {
			// If this folder has sub-folders, call this method recursively to get messages
			ExchangeFolderInfoCollection folderInfoCollection = client.listSubFolders(folderInfo.getUri());
			for (ExchangeFolderInfo subfolderInfo : folderInfoCollection) {
				listMessagesInFolder(client, subfolderInfo, currentFolder);
			}
		} catch (Exception ex) {
		}
	}

	public static void createDirectory(String directoryName) {
		File theDir = new File(directoryName);
		// if the directory does not exist, create it
		if (!theDir.exists()) {
			System.out.println("creating directory: " + directoryName);
			boolean result = false;
			try {
				theDir.mkdir();
				result = true;
			} catch (SecurityException se) {
				//handle it
			}
			if (result) {
				System.out.println("DIR created");
			}
		}
	}
}
