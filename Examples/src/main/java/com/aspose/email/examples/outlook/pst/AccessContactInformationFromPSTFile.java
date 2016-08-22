package com.aspose.email.examples.outlook.pst;

import com.aspose.email.FolderInfo;
import com.aspose.email.MapiContact;
import com.aspose.email.MapiMessage;
import com.aspose.email.MessageInfo;
import com.aspose.email.MessageInfoCollection;
import com.aspose.email.PersonalStorage;
import com.aspose.email.examples.Utils;

public class AccessContactInformationFromPSTFile {

	public static void main(String[] args) {

		String dataDir = Utils.getSharedDataDir(AccessContactInformationFromPSTFile.class) + "outlook/";

		// Load the Outlook PST file
		PersonalStorage pst = PersonalStorage.fromFile(dataDir + "SampleContacts.pst");

		// Get the Contacts folder
		FolderInfo folderInfo = pst.getRootFolder().getSubFolder("Contacts");

		// Loop through all the contacts in this folder
		MessageInfoCollection messageInfoCollection = folderInfo.getContents();

		for (int i = 0; i < messageInfoCollection.size(); i++) {
			MessageInfo messageInfo = (MessageInfo) messageInfoCollection.get_Item(i);
			//  Get the contact information
			MapiContact contact = (MapiContact) pst.extractMessage(messageInfo).toMapiMessageItem();
			//  Display some contents on screen
			System.out.println("Name: " + contact.getNameInfo().getDisplayName() + "\n");
			//  Save to disk in MSG format
			if (contact.getNameInfo().getDisplayName() != null) {
				MapiMessage message = pst.extractMessage(messageInfo); // Get rid of illegal characters that cannot be used as a file name
				String messageName = message.getSubject().replace(":", " ").replace("\\", " ").replace("?", " ").replace("/", " ");
				message.save(dataDir + messageName + ".msg");
			}
		}

	}
}
