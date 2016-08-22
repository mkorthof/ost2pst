package com.aspose.email.examples.outlook.pst;

import com.aspose.email.FolderInfo;
import com.aspose.email.MessageInfoCollection;
import com.aspose.email.PersonalStorage;
import com.aspose.email.StandardIpmFolder;
import com.aspose.email.examples.Utils;

public class MoveItemsToOtherFoldersInAPST {
	
	public static String dataDir = Utils.getSharedDataDir(MoveItemsToOtherFoldersInAPST.class) + "outlook/";
	
	public static void main(String[] args) {
		PersonalStorage pst = PersonalStorage.fromFile(dataDir + "test.pst");
		
		FolderInfo inbox = pst.getPredefinedFolder(StandardIpmFolder.Inbox);
		FolderInfo deleted = pst.getPredefinedFolder(StandardIpmFolder.DeletedItems);
		FolderInfo subfolder = inbox.getSubFolder("Subfolder");

		// Move folder to the Deleted Items
		pst.moveItem(subfolder, deleted);

		// Move message to the Deleted Items
		MessageInfoCollection contents = subfolder.getContents();
		pst.moveItem(contents.get_Item(0), deleted);

		// Move all inbox subfolders to the Deleted Items
		inbox.moveSubfolders(deleted);

		// Move all subfolder contents to the Deleted Items
		subfolder.moveContents(deleted);
	}

}
