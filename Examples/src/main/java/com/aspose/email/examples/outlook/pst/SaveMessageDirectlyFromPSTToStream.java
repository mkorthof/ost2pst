package com.aspose.email.examples.outlook.pst;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.aspose.email.FolderInfo;
import com.aspose.email.MessageInfo;
import com.aspose.email.PersonalStorage;
import com.aspose.email.examples.Utils;

public class SaveMessageDirectlyFromPSTToStream {
	
	// Base folder to load and save files used in this demo
	private static String dataDir = Utils.getSharedDataDir(SaveMessageDirectlyFromPSTToStream.class) + "outlook/";
		
	public static void main(String[] args) throws FileNotFoundException {
		saveMessageFromPSTToStream1();
		
		saveMessageFromPSTToStream2();
		
		saveMessageFromPSTToStream3();
	}

	public static void saveMessageFromPSTToStream1() {
		PersonalStorage pst = PersonalStorage.fromFile(dataDir + "PersonalStorage.pst");
		FolderInfo inbox = pst.getRootFolder().getSubFolder("myInbox");
		MessageInfo messageInfo;
		for (Object obj : inbox.enumerateMessages()) {
			messageInfo = (MessageInfo) obj;
			pst.saveMessageToStream(messageInfo.getEntryIdString(), new ByteArrayOutputStream());
		}
	}

	public static void saveMessageFromPSTToStream2() throws FileNotFoundException {
		// Save message to file
		PersonalStorage pst = PersonalStorage.fromFile(dataDir + "PersonalStorage.pst");
		FolderInfo inbox = pst.getRootFolder().getSubFolder("myInbox");
		MessageInfo messageInfo;
		for (Object obj : inbox.enumerateMessages()) {
			messageInfo = (MessageInfo) obj;

			FileOutputStream fop = null;
			File file;
			file = new File(messageInfo.getSubject() + ".msg");
			fop = new FileOutputStream(file);
			pst.saveMessageToStream(messageInfo.getEntryIdString(), fop);
		}
	}

	public static void saveMessageFromPSTToStream3() {
		// To enumerate entryId of messages you may use FolderInfo.enumerateMessagesEntryId() method:
		PersonalStorage pst = PersonalStorage.fromFile(dataDir + "PersonalStorage.pst");
		FolderInfo inbox = pst.getRootFolder().getSubFolder("myInbox");
		String entryId;
		for (Object obj : inbox.enumerateMessagesEntryId()) {
			entryId = (String) obj;

			pst.saveMessageToStream(entryId, new ByteArrayOutputStream());
		}
	}
}
