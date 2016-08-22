package com.aspose.email.examples.outlook.pst;

import java.io.File;

import com.aspose.email.FolderInfo;
import com.aspose.email.MapiMessage;
import com.aspose.email.MessageInfo;
import com.aspose.email.MessageInfoCollection;
import com.aspose.email.PersonalStorage;
import com.aspose.email.examples.Utils;

public class PSTExtractMessages {

	// Base folder to load and save files used in this demo
	private static String dataDir = Utils.getSharedDataDir(PSTExtractMessages.class) + "outlook/";

	public static void main(String[] args) {
		
		String pstFileName = dataDir + "PersonalStorage.pst";
		// Load the Outlook PST file
		PersonalStorage pst = PersonalStorage.fromFile(pstFileName);

		// Get the folders and messages information
		FolderInfo folderInfo = pst.getRootFolder();

		// Create a folder for this PST
		String strRootFolderName = "PersonalStorage.pst".replace(".pst", "") + ".Java";
		new File(dataDir + strRootFolderName).mkdir();

		// Call the recursive method to extract msg files from each folder
		extractMsgFiles(folderInfo, pst, dataDir + strRootFolderName);

	}

	private static void extractMsgFiles(FolderInfo folderInfo, PersonalStorage pst, String strPSTFile) {
		// Display the folder name
		System.out.println("Folder: " + folderInfo.getDisplayName());

		// Create folder to store the messages
		String folderName = strPSTFile + "\\" + folderInfo.getDisplayName();
		new File(folderName).mkdir();

		// Loop through all the messages in this folder
		MessageInfoCollection messageInfoCollection = folderInfo.getContents();
		for (int i = 0; i < messageInfoCollection.size(); i++) {
			MessageInfo messageInfo = (MessageInfo) messageInfoCollection.get_Item(i);
			System.out.println("Saving message " + messageInfo.getSubject() + "....");
			// Get the message in MapiMessage instance
			MapiMessage message = pst.extractMessage(messageInfo);
			// Delete special characters which are invalid to use as windows file name
			String messageName = null;
			if (message.getSubject() == null || message.getSubject().isEmpty() == true) {
				messageName = getRidOfIllegalFileNameCharacters(messageInfo.getEntryIdString());
			} else {
				messageName = getRidOfIllegalFileNameCharacters(message.getSubject());
			}

			// Save this message to disk in MSG format
			message.save(folderName + "\\" + messageName + ".msg");
		}

		// Call this method recursively for each subfolder
		if (folderInfo.hasSubFolders() == true) {
			for (int i = 0; i < folderInfo.getSubFolders().size(); i++) {
				FolderInfo subfolderInfo = (FolderInfo) folderInfo.getSubFolders().get_Item(i);
				extractMsgFiles(subfolderInfo, pst, strPSTFile);
			}
		}
	}

	private static String getRidOfIllegalFileNameCharacters(String strName) {
		String strLegalName = strName.replace(":", " ").replace("\\", " ").replace("?", " ").replace("/", " ").replace("|", " ").replace("*", " ").replace("<", " ").replace(">", " ")
				.replace("\t", " ").replace("\"", " ");
		if (strLegalName.length() >= 100) {
			strLegalName = strLegalName.substring(0, 100);
		}
		return strLegalName;
	}
}
