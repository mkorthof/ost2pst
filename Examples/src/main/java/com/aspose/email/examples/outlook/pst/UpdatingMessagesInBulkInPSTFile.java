package com.aspose.email.examples.outlook.pst;

import java.io.UnsupportedEncodingException;

import com.aspose.email.FolderInfo;
import com.aspose.email.MapiProperty;
import com.aspose.email.MapiPropertyCollection;
import com.aspose.email.MapiPropertyTag;
import com.aspose.email.MessageInfo;
import com.aspose.email.MessageInfoCollection;
import com.aspose.email.PersonalStorage;
import com.aspose.email.PersonalStorageQueryBuilder;
import com.aspose.email.examples.Utils;
import com.aspose.email.system.collections.generic.List;

public class UpdatingMessagesInBulkInPSTFile {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String dataDir = Utils.getDataDir(UpdatingMessagesInBulkInPSTFile.class);

		PersonalStorage pst = PersonalStorage.fromFile(dataDir + "test.pst");
		try {
			FolderInfo inbox = pst.getRootFolder().getSubFolder("Inbox");

			// find messages having From = "someuser@domain.com"
			PersonalStorageQueryBuilder queryBuilder = new PersonalStorageQueryBuilder();
			queryBuilder.getFrom().contains("someuser@domain.com");
			MessageInfoCollection messages = inbox.getContents(queryBuilder.getQuery());
			List<String> changeList = new List<String>();
			for (MessageInfo messageInfo : messages) {
				changeList.add(messageInfo.getEntryIdString());
			}

			// Compose the new properties
			MapiPropertyCollection updatedProperties = new MapiPropertyCollection();
			updatedProperties.add(MapiPropertyTag.PR_SUBJECT_W, new MapiProperty(MapiPropertyTag.PR_SUBJECT_W, "New Subject".getBytes("UTF-8")));
			updatedProperties.add(MapiPropertyTag.PR_IMPORTANCE, new MapiProperty(MapiPropertyTag.PR_IMPORTANCE, new byte[] { 2, 0, 0, 0, 0, 0, 0, 0 }));

			// uddate messages having From = "someuser@domain.com" with new
			// properties
			inbox.changeMessages(changeList, updatedProperties);
		} finally {
			pst.dispose();
		}
	}

}
