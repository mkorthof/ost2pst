package com.aspose.email.examples.outlook.pst;

import com.aspose.email.FileFormatVersion;
import com.aspose.email.FolderInfo;
import com.aspose.email.PersonalStorage;
import com.aspose.email.StandardIpmFolder;
import com.aspose.email.examples.Utils;

public class AddFilesToPST {
	
	public static String dataDir = Utils.getSharedDataDir(AddFilesToPST.class) + "outlook/";
	
	public static void main(String[] args) {
		PersonalStorage pst = PersonalStorage.create(dataDir + "AddFilesToPST_out.pst", FileFormatVersion.Unicode);
		FolderInfo fi = pst.createPredefinedFolder("Inbox", StandardIpmFolder.Inbox);
		fi.addFile(dataDir + "Report.xlsx", "IPM.Document.Excel.Sheet.8");
		pst.dispose();
	}

}
