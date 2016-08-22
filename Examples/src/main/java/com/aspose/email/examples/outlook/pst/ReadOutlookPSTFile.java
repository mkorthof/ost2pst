package com.aspose.email.examples.outlook.pst;

import com.aspose.email.FolderInfo;
import com.aspose.email.FolderInfoCollection;
import com.aspose.email.FolderKind;
import com.aspose.email.MessageInfo;
import com.aspose.email.PersonalStorage;
import com.aspose.email.examples.Utils;
import com.aspose.email.system.IDisposable;

public class ReadOutlookPSTFile {

	public static void main(String[] args) {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(ReadOutlookPSTFile.class) + "outlook/";
		
		loadAPSTFile(dataDir);
		
		displayFolderAndMessageInformationForPSTFile(dataDir);
		
		parseSearchableFolders(dataDir);
		
		retrieParentFolderInformationFromMessageInfo(dataDir);
	}

	public static void loadAPSTFile(String dataDir) {
		// Load the Outlook PST file
		PersonalStorage pst = PersonalStorage.fromFile(dataDir + "PersonalStorage.pst");
	}

	public static void displayFolderAndMessageInformationForPSTFile(String dataDir) {
		// Load the Outlook PST file
		PersonalStorage pst = PersonalStorage.fromFile(dataDir + "PersonalStorage.pst");

		// Get the folders information
		FolderInfoCollection folderInfoCollection = pst.getRootFolder().getSubFolders();
		// Browse through each folder to display folder name and number of messages
		for (int i = 0; i < folderInfoCollection.size(); i++) {
			FolderInfo folderInfo = (FolderInfo) folderInfoCollection.get_Item(i);
			System.out.println("FolderId: " + folderInfo.getEntryIdString());
			System.out.println("Folder: " + folderInfo.getDisplayName());
			System.out.println("Total items: " + folderInfo.getContentCount());
			System.out.println("Total unread items: " + folderInfo.getContentUnreadCount());
			System.out.println("-----------------------------------");
		}
	}

	public static void parseSearchableFolders(String dataDir) {
		final PersonalStorage pst = PersonalStorage.fromFile(dataDir + "PersonalStorage.pst");

		FolderInfo finder = pst.getFolderById("AAAAAOu+OWXNsrFFkK4GgGGmk0yCgAAA");
		FolderInfoCollection coll = finder.getSubFolders(FolderKind.Search);
		System.out.println(coll.size()); //This should print 17

		coll = finder.getSubFolders(FolderKind.Normal);
		System.out.println(coll.size()); //This should print 0

		coll = finder.getSubFolders(FolderKind.Search | FolderKind.Normal);
		System.out.println(coll.size()); //This should print 17
	}

	public static void retrieParentFolderInformationFromMessageInfo(String dataDir) {
		final PersonalStorage[] pst = { PersonalStorage.fromFile(dataDir + "PersonalStorage.pst") };
		try {
			for (FolderInfo folder : (Iterable<FolderInfo>) pst[0].getRootFolder().getSubFolders()) {
				for (MessageInfo msg : (Iterable<MessageInfo>) folder.enumerateMessages()) {
					FolderInfo fi = pst[0].getParentFolder(msg.getEntryId());
				}
			}
		} finally {
			if (pst[0] != null)
				((IDisposable) pst[0]).dispose();
		}
	}

}
