package com.aspose.email.examples.exchangeews;

import com.aspose.email.EWSClient;
import com.aspose.email.ExchangeFolderInfo;
import com.aspose.email.ExchangeFolderInfoCollection;
import com.aspose.email.ExchangeMessageInfo;
import com.aspose.email.ExchangeMessageInfoCollection;
import com.aspose.email.IEWSClient;
import com.aspose.email.MailMessage;
import com.aspose.email.SaveOptions;

public class DownloadMessagesFromPublicFolders {

	public static void main(String[] args) {
		downloadMessagesFromPublicFolders();
	}

	public static void downloadMessagesFromPublicFolders() {
		// Create instance of IEWSClient class by giving credentials
		IEWSClient client = EWSClient.getEWSClient("https://outlook.office365.com/exchangeews/exchange.asmx", "testUser", "pwd", "domain");

		ExchangeFolderInfoCollection folders = client.listPublicFolders();
		for (ExchangeFolderInfo publicFolder : folders) {
		    System.out.println("Name: " + publicFolder.getDisplayName());
		    System.out.println("Subfolders count: " + publicFolder.getChildFolderCount());
		    listMessagesFromSubFolder(publicFolder, client);
		}
	}

	private static void listMessagesFromSubFolder(ExchangeFolderInfo publicFolder, IEWSClient client) {
		System.out.println("Folder Name: " + publicFolder.getDisplayName());
		ExchangeMessageInfoCollection msgInfoCollection = client.listMessagesFromPublicFolder(publicFolder);
		for (ExchangeMessageInfo messageInfo : msgInfoCollection) {
			MailMessage msg = client.fetchMessage(messageInfo.getUniqueUri());
			System.out.println(msg.getSubject());
			msg.save(msg.getSubject() + ".msg", SaveOptions.getDefaultMsgUnicode());
		}

		// Call this method recursively for any subfolders
		if (publicFolder.getChildFolderCount() > 0) {
			ExchangeFolderInfoCollection folderInfoColl = client.listSubFolders(publicFolder);
			for (ExchangeFolderInfo folderInfo : folderInfoColl) {
				listMessagesFromSubFolder(folderInfo, client);
			}
		}
	}
}
