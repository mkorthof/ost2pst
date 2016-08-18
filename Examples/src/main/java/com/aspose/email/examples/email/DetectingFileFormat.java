package com.aspose.email.examples.email;

import com.aspose.email.FileFormatInfo;
import com.aspose.email.FileFormatUtil;
import com.aspose.email.examples.Utils;

public class DetectingFileFormat {

	public static void main(String[] args) {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(CreateNewEmail.class) + "email/";
				
		//Detect file format
		FileFormatInfo info = FileFormatUtil.detectFileFormat(dataDir + "Message.msg");

		//Gets the detected load format
		System.out.println("The message format is: " + info.getFileFormatType());
	}

}
