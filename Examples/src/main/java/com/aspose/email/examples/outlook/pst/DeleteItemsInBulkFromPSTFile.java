package com.aspose.email.examples.outlook.pst;

import com.aspose.email.FolderInfo;
import com.aspose.email.MessageInfo;
import com.aspose.email.MessageInfoCollection;
import com.aspose.email.PersonalStorage;
import com.aspose.email.PersonalStorageQueryBuilder;
import com.aspose.email.examples.Utils;
import com.aspose.email.system.collections.generic.List;

public class DeleteItemsInBulkFromPSTFile {

	public static void main(String[] args) {
		String dataDir = Utils.getDataDir(DeleteItemsInBulkFromPSTFile.class);
		PersonalStorage pst = PersonalStorage.fromFile(dataDir + "test.pst");
		try {
			FolderInfo inbox = pst.getRootFolder().getSubFolder("Inbox");

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
