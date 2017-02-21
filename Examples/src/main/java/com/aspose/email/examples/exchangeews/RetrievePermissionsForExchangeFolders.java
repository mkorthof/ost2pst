package com.aspose.email.examples.exchangeews;

import com.aspose.email.EWSClient;
import com.aspose.email.ExchangeBasePermission;
import com.aspose.email.ExchangeFolderInfo;
import com.aspose.email.ExchangeFolderInfoCollection;
import com.aspose.email.ExchangeFolderPermission;
import com.aspose.email.ExchangeFolderPermissionCollection;
import com.aspose.email.ExchangeMailboxInfo;
import com.aspose.email.ExchangePermissionCollection;
import com.aspose.email.IEWSClient;

public class RetrievePermissionsForExchangeFolders {

	public static void main(String[] args) {
		String folderName = "DesiredFolderName";

		// Create instance of EWSClient class by giving credentials
		IEWSClient client = EWSClient.getEWSClient("https://outlook.office365.com/exchangeews/exchange.asmx", "testUser", "pwd", "domain");
		ExchangeFolderInfoCollection folders = client.listPublicFolders();
		ExchangeFolderPermissionCollection permissions = new ExchangeFolderPermissionCollection();
		ExchangeFolderInfo publicFolder = null;
		try {
			for (ExchangeFolderInfo folderInfo : folders)
				if (folderInfo.getDisplayName().equals(folderName))
					publicFolder = folderInfo;

			if (publicFolder == null)
				System.out.println("public folder was not created in the root public folder");

			ExchangePermissionCollection folderPermissionCol = client.getFolderPermissions(publicFolder.getUri());
			for (ExchangeBasePermission perm : folderPermissionCol) {
				ExchangeFolderPermission permission = (ExchangeFolderPermission) perm;//perm as ExchangeFolderPermission;
				if (permission == null)
					System.out.println("Permission is null.");
				else {
					System.out.println("User's primary smtp address: " + permission.getUserInfo().getPrimarySmtpAddress().toString());
					System.out.println("User can create Items: " + permission.canCreateItems());
					System.out.println("User can delete Items: " + permission.getDeleteItems());
					System.out.println("Is Folder Visible: " + permission.isFolderVisible());
					System.out.println("Is User owner of this folder: " + permission.isFolderOwner());
					System.out.println("User can read items: " + permission.getReadItems());
				}
			}
			ExchangeMailboxInfo mailboxInfo = client.getMailboxInfo();
			//Get the Permissions for the Contacts Folder
			ExchangePermissionCollection contactsPermissionCol = client.getFolderPermissions(mailboxInfo.getContactsUri());
			//Get the Permissions for the Calendar Folder
			ExchangePermissionCollection calendarPermissionCol = client.getFolderPermissions(mailboxInfo.getContactsUri());
		} finally {
			//Do the needful
		}
	}
}
