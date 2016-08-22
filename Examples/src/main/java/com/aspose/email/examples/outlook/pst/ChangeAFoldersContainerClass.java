package com.aspose.email.examples.outlook.pst;

import com.aspose.email.FolderInfo;
import com.aspose.email.PersonalStorage;
import com.aspose.email.examples.Utils;

public class ChangeAFoldersContainerClass {
	
	public static String dataDir = Utils.getSharedDataDir(ChangeAFoldersContainerClass.class) + "outlook/";
	
	public static void main(String[] args) {
		PersonalStorage pst  = PersonalStorage.fromFile(dataDir + "SampleContacts.pst");
		FolderInfo fi = pst.getRootFolder().getSubFolder("Contacts");
		fi.changeContainerClass("IPF.Note");
		pst.dispose();
	}

}
