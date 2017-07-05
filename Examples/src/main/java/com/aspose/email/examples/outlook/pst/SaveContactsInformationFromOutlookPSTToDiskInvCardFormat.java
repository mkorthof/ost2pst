package com.aspose.email.examples.outlook.pst;

import com.aspose.email.ContactSaveFormat;
import com.aspose.email.FolderInfo;
import com.aspose.email.MapiContact;
import com.aspose.email.MessageInfo;
import com.aspose.email.MessageInfoCollection;
import com.aspose.email.PersonalStorage;
import com.aspose.email.examples.Utils;

public class SaveContactsInformationFromOutlookPSTToDiskInvCardFormat {
	
	public static String dataDir = Utils.getSharedDataDir(ChangeAFoldersContainerClass.class) + "outlook/";
	
	public static void main(String[] args) {
		// Load the Outlook PST file
		PersonalStorage pst = PersonalStorage.fromFile(dataDir + "Outlook.pst");
		
		// Get the Contacts folder
		FolderInfo folderInfo = pst.getRootFolder().getSubFolder("Contacts");
		
		// Loop through all the contacts in this folder
		MessageInfoCollection messageInfoCollection = folderInfo.getContents();
		for (int i = 0; i < messageInfoCollection.size(); i++) {
			MessageInfo messageInfo = messageInfoCollection.get_Item(i);
			// Get the contact information
			MapiContact contact = (MapiContact) pst.extractMessage(messageInfo).toMapiMessageItem();
			// Display some contents on screen
			System.out.println("Name: " + contact.getNameInfo().getDisplayName() + " - " + messageInfo.getEntryIdString());
			// Save to disk in vCard VCF format
			contact.save(dataDir + "Contacts" + contact.getNameInfo().getDisplayName() + ".vcf", ContactSaveFormat.VCard);
		}
	}

}
