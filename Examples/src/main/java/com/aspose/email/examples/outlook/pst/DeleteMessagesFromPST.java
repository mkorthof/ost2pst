package com.aspose.email.examples.outlook.pst;

import com.aspose.email.FolderInfo;
import com.aspose.email.MessageInfo;
import com.aspose.email.MessageInfoCollection;
import com.aspose.email.PersonalStorage;
import com.aspose.email.PersonalStorageQueryBuilder;
import com.aspose.email.StandardIpmFolder;
import com.aspose.email.examples.Utils;
import com.aspose.email.system.collections.generic.List;

public class DeleteMessagesFromPST {

	public static String dataDir = Utils.getSharedDataDir(DeleteMessagesFromPST.class) + "outlook/";

	public static void main(String[] args) {
		//Delete Items from PST One by One
		deleteItemsFromPSTOneByOne();

		//Delete Items in Bulk from a PST file
		deleteItemsInBulkFromPSTFile();
	}

	public static void deleteItemsFromPSTOneByOne() {
		// Load the Outlook PST file
		PersonalStorage pst = PersonalStorage.fromFile(dataDir + "SampleContacts.pst");

		// Get the Sent Items folder
		FolderInfo folderInfo = pst.getPredefinedFolder(StandardIpmFolder.Contacts);
		MessageInfoCollection messageInfoCollection = folderInfo.getContents();
		for (int i = 0; i < messageInfoCollection.size(); i++) {
			MessageInfo messageInfo = messageInfoCollection.get_Item(i);
			System.out.println("Deleting " + messageInfo.getSubject() + ".....\n");
			if (messageInfo.getSubject().contains("Sebastian")) { //== "some delete condition")
				// Delete this item
				folderInfo.deleteChildItem(messageInfo.getEntryId());
				System.out.println("Message Deleted");
			}
		}
	}

	public static void deleteItemsInBulkFromPSTFile() {
		PersonalStorage pst = PersonalStorage.fromFile(dataDir + "SampleContacts.pst");
		try {
			FolderInfo inbox = pst.getRootFolder().getSubFolder("Contacts");
			// find messages having From = "someuser@domain.com"
			PersonalStorageQueryBuilder queryBuilder = new PersonalStorageQueryBuilder();
			queryBuilder.getFrom().contains("someuser@domain.com");
			MessageInfoCollection messages = inbox.getContents(queryBuilder.getQuery());
			List<String> deleteList = new List<String>();
			for (MessageInfo messageInfo : messages) {
				deleteList.add(messageInfo.getEntryIdString());
			}

			// delete messages having From = "someuser@domain.com"
			inbox.deleteChildItems(deleteList);
		} finally {
			pst.dispose();
		}
	}

}
