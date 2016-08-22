package com.aspose.email.examples.outlook.pst;

import com.aspose.email.FolderInfo;
import com.aspose.email.MessageInfoCollection;
import com.aspose.email.PersonalStorage;
import com.aspose.email.examples.Utils;

public class ExtractingNMessagesFromAPSTFile {
	
	private static String dataDir = Utils.getSharedDataDir(ExtractingNMessagesFromAPSTFile.class) + "outlook/";
		
	public static void main(String[] args) {
		PersonalStorage pst = PersonalStorage.fromFile(dataDir + "SampleContacts.pst");
		FolderInfo inbox = pst.getRootFolder().getSubFolder("Contacts");
		MessageInfoCollection messages = inbox.getContents(1, 5); //Extracts messages starting from 1th index top and extract total 5th messages
	}

}
