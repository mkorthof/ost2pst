package com.aspose.email.examples.outlook.pst;

import com.aspose.email.FileFormatVersion;
import com.aspose.email.FolderInfo;
import com.aspose.email.MapiMessage;
import com.aspose.email.MessageInfoCollection;
import com.aspose.email.PersonalStorage;
import com.aspose.email.examples.Utils;
import com.aspose.email.system.collections.generic.IGenericEnumerable;

public class AddBulkMessagesWithImprovedPerformance {

	public static String dataDir = Utils.getSharedDataDir(AddBulkMessagesWithImprovedPerformance.class) + "outlook/";

	public static void main(String[] args) {
		//Adding Messages from Another PST
		bulkAddFromAnotherPst();
		
		//Adding Bulk Messages from Disc
		addMessagesInBulkMode();
	}

	private static void bulkAddFromAnotherPst() {
		PersonalStorage pst = PersonalStorage.fromFile(dataDir + "SampleContacts.pst", false);
		try {
			PersonalStorage pstDest = PersonalStorage.fromFile(dataDir + "PersonalStorage.pst");
			try {
				// Get the folder by name
				FolderInfo folderInfo = pst.getRootFolder().getSubFolder("Contacts");
				MessageInfoCollection ms = folderInfo.getContents();

				// Get the folder by name
				FolderInfo f = pstDest.getRootFolder().getSubFolder("myInbox");
				f.addMessages(folderInfo.enumerateMapiMessages());

				FolderInfo fi = pstDest.getRootFolder().getSubFolder("myInbox");
				MessageInfoCollection msgs = fi.getContents();
			} finally {
				if (pstDest != null)
					pstDest.dispose();
			}
		} finally {
			if (pst != null)
				pst.dispose();
		}
	}

	@SuppressWarnings("unchecked")
	public static void addMessagesInBulkMode() {
		PersonalStorage pst = PersonalStorage.create(dataDir + "PersonalStorage.pst", FileFormatVersion.Unicode);
		FolderInfo folder = pst.getRootFolder().addSubFolder("myInbox");

		folder.addMessages((IGenericEnumerable<MapiMessage>) new MapiMessageCollection(dataDir));
	}
	
	

}
