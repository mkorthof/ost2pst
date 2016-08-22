package com.aspose.email.examples.outlook.pst;

import com.aspose.email.FolderInfo;
import com.aspose.email.FolderInfoCollection;
import com.aspose.email.MapiImportance;
import com.aspose.email.MapiMessageFlags;
import com.aspose.email.MessageInfoCollection;
import com.aspose.email.PersonalStorage;
import com.aspose.email.PersonalStorageQueryBuilder;
import com.aspose.email.examples.Utils;

public class SearchMessagesAndFoldersInAPST {
	
	public static String dataDir = Utils.getSharedDataDir(SearchMessagesAndFoldersInAPST.class) + "outlook/";
	
	public static void main(String[] args) {
		PersonalStorage pst = PersonalStorage.fromFile(dataDir + "Outlook.pst");

		FolderInfo folder = pst.getRootFolder().getSubFolder("Inbox");
		PersonalStorageQueryBuilder builder = new PersonalStorageQueryBuilder();

		// High importance messages
		builder.getImportance().equals((int) MapiImportance.High);
		MessageInfoCollection messages = folder.getContents(builder.getQuery());
		System.out.println("Messages with High Imp:" + messages.size());

		builder = new PersonalStorageQueryBuilder();
		builder.getMessageClass().equals("IPM.Note");
		messages = folder.getContents(builder.getQuery());
		System.out.println("Messages with IPM.Note:" + messages.size());

		builder = new PersonalStorageQueryBuilder();
		// Messages with attachments AND high importance
		builder.getImportance().equals((int) MapiImportance.High);
		builder.hasFlags(MapiMessageFlags.MSGFLAG_HASATTACH);
		messages = folder.getContents(builder.getQuery());
		System.out.println("Messages with atts: " + messages.size());

		builder = new PersonalStorageQueryBuilder();
		// Messages with size > 15 KB
		builder.getMessageSize().greater(15000);
		messages = folder.getContents(builder.getQuery());
		System.out.println("messags size > 15Kb:" + messages.size());

		builder = new PersonalStorageQueryBuilder();
		// Unread messages
		builder.hasNoFlags(MapiMessageFlags.MSGFLAG_READ);
		messages = folder.getContents(builder.getQuery());
		System.out.println("Unread:" + messages.size());

		builder = new PersonalStorageQueryBuilder();
		// Unread messages with attachments
		builder.hasNoFlags(MapiMessageFlags.MSGFLAG_READ);
		builder.hasFlags(MapiMessageFlags.MSGFLAG_HASATTACH);
		messages = folder.getContents(builder.getQuery());
		System.out.println("Unread msgs with atts: " + messages.size());

		// Folder with name of 'SubInbox'
		builder = new PersonalStorageQueryBuilder();
		builder.getFolderName().equals("SubInbox");
		FolderInfoCollection folders = folder.getSubFolders(builder.getQuery());
		System.out.println("Folder having subfolder: " + folders.size());

		builder = new PersonalStorageQueryBuilder();
		// Folders with subfolders
		builder.hasSubfolders();
		folders = folder.getSubFolders(builder.getQuery());
		System.out.println(folders.size());
	}

}
