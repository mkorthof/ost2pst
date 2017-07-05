package com.aspose.email.examples.outlook.pst;

import com.aspose.email.FileFormat;
import com.aspose.email.FolderInfo;
import com.aspose.email.FolderInfoCollection;
import com.aspose.email.PersonalStorage;
import com.aspose.email.examples.Utils;

public class LoadAndConvertOSTFile {

	public static String dataDir = Utils.getSharedDataDir(ExtractingNMessagesFromAPSTFile.class) + "outlook/";

	public static void main(String[] args) {
		//Read an OST file
		readAnOSTFile();
		
		//Converting OST to PST
		convertOSTToPST();
	}

	public static void readAnOSTFile() {
		// Load the Outlook PST file
		String strPSTFile = dataDir + "Sample.ost";
		PersonalStorage pst = PersonalStorage.fromFile(strPSTFile);

		// Get sub-folders of Root
		FolderInfoCollection folderInfoCollection = pst.getRootFolder().getSubFolders();
		// Loop over all the-sub folders
		for (int i = 0; i < folderInfoCollection.size(); i++) {
			// Display all the folders
			FolderInfo folderInfo = folderInfoCollection.get_Item(i);
			System.out.println(folderInfo.getDisplayName());
		}
	}

	public static void convertOSTToPST() {
		PersonalStorage ost = PersonalStorage.fromFile(dataDir + "input.ost");
		ost.saveAs(dataDir + "output.pst", FileFormat.Pst);
	}
}
