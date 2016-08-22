package com.aspose.email.examples.outlook.pst;

import com.aspose.email.FolderInfo;
import com.aspose.email.MessageInfo;
import com.aspose.email.MessageInfoCollection;
import com.aspose.email.PersonalStorage;
import com.aspose.email.examples.Utils;

public class GetMessageInformationFromPSTFile {

	public static void main(String[] args) {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(GetMessageInformationFromPSTFile.class) + "outlook/";

		String pstFileName = dataDir + "PersonalStorage.pst";
		
		// load the Outlook PST file
		PersonalStorage pst = PersonalStorage.fromFile(pstFileName);
		
		FolderInfo folderInfo = pst.getRootFolder();
		// call the recursive method to display the folder contents
		displayFolderContents(folderInfo, pst);
	}

	private static void displayFolderContents(FolderInfo folderInfo, PersonalStorage pst) {
		// display the folder name
		System.out.println("Folder: " + folderInfo.getDisplayName());
		// display information about messages inside this folder
		MessageInfoCollection messageInfoCollection = folderInfo.getContents();
		for (int i = 0; i < messageInfoCollection.size(); i++) {
			MessageInfo messageInfo = (MessageInfo) messageInfoCollection.get_Item(i);
			System.out.println("Subject: " + messageInfo.getSubject());
			System.out.println("Sender: " + messageInfo.getSenderRepresentativeName());
			System.out.println("To: " + messageInfo.getDisplayTo());
			System.out.println("CC: " + messageInfo.getDisplayCC());
			System.out.println("EntryID: " + messageInfo.getEntryIdString());
		}

		// call this method recursively for each subfolder
		if (folderInfo.hasSubFolders() == true) {
			for (int i = 0; i < folderInfo.getSubFolders().size(); i++) {
				FolderInfo subfolderInfo = (FolderInfo) folderInfo.getSubFolders().get_Item(i);
				displayFolderContents(subfolderInfo, pst);
			}
		}
	}
	
}
