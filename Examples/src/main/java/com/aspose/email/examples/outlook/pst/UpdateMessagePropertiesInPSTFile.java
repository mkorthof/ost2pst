package com.aspose.email.examples.outlook.pst;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

import com.aspose.email.FolderInfo;
import com.aspose.email.MapiNamedProperty;
import com.aspose.email.MapiProperty;
import com.aspose.email.MapiPropertyCollection;
import com.aspose.email.MapiPropertyTag;
import com.aspose.email.MapiPropertyType;
import com.aspose.email.MessageInfo;
import com.aspose.email.MessageInfoCollection;
import com.aspose.email.PersonalStorage;
import com.aspose.email.PersonalStorageQueryBuilder;
import com.aspose.email.examples.Utils;
import com.aspose.email.system.collections.generic.List;

public class UpdateMessagePropertiesInPSTFile {

	public static String dataDir = Utils.getSharedDataDir(UpdateMessagePropertiesInPSTFile.class) + "outlook/";

	public static void main(String[] args) throws Exception {
		// Update Messages in Bulk in PST file
		updateMessagesInBulkInPSTFile();

		// Updating Custom Properties for PST Items
		updateCustomPropertiesInPst();
	}

	private static void updateMessagesInBulkInPSTFile() throws UnsupportedEncodingException {
		PersonalStorage pst = PersonalStorage.fromFile(dataDir + "test.pst");
		try {
			FolderInfo inbox = pst.getRootFolder().getSubFolder("Inbox");

			// Find messages having From = "someuser@domain.com"
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

			// Update messages having From = "someuser@domain.com" with new properties
			inbox.changeMessages(changeList, updatedProperties);
		} finally {
			pst.dispose();
		}
	}

	public static void updateCustomPropertiesInPst() throws Exception {
		PersonalStorage pst = PersonalStorage.fromFile(dataDir + "test.pst");
		try {
			FolderInfo testFolder = pst.getRootFolder().getSubFolder("Inbox");

			// Create the collection of message properties for adding or updating
			MapiPropertyCollection newProperties = new MapiPropertyCollection();

			// Normal property
			MapiProperty property = new MapiProperty(MapiPropertyTag.PR_ORG_EMAIL_ADDR_W, "test_address@org.com".getBytes("UTF-8"));

			// Custom named property
			MapiProperty namedProperty1 = new MapiNamedProperty(generateNamedPropertyTag(0, MapiPropertyType.PT_LONG), 
																	"ITEM_ID", 
																	UUID.randomUUID(), 
																	new byte[] { 123, 0, 0, 0 });

			// PidLidLogFlags named property
			MapiProperty namedProperty2 = new MapiNamedProperty(generateNamedPropertyTag(1, MapiPropertyType.PT_LONG), 
																0x0000870C,
																UUID.fromString("0006200A-0000-0000-C000-000000000046"), 
																new byte[] { 0, 0, 0, 0 });

			newProperties.add(namedProperty1.getTag(), namedProperty1);
			newProperties.add(namedProperty2.getTag(), namedProperty2);
			newProperties.add(property.getTag(), property);

			testFolder.changeMessages(testFolder.enumerateMessagesEntryId(), newProperties);
		} finally {
			pst.dispose();
		}
	}

	private static long generateNamedPropertyTag(long index, /* MapiPropertyType */int dataType) {
		return (((0x8000 | index) << 16) | dataType) & 0x00000000FFFFFFFFL;
	}
}
