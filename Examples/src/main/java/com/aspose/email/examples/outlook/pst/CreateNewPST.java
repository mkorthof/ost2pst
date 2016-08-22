package com.aspose.email.examples.outlook.pst;

import com.aspose.email.MapiMessage;
import com.aspose.email.PersonalStorage;
import com.aspose.email.examples.Utils;

public class CreateNewPST {
	
	public static String dataDir = Utils.getSharedDataDir(CreateNewPST.class) + "outlook/";
	
	public static void main(String[] args) {
		//Create an instance of PersonalStorage
		PersonalStorage pst = PersonalStorage.create(dataDir + "newSample_out.pst", 0);

		//Create a folder at root of PST
		pst.getRootFolder().addSubFolder("myInbox");

		//Add message to newly created folder
		pst.getRootFolder().getSubFolder("myInbox").addMessage(MapiMessage.fromFile(dataDir + "message.msg"));
	}

}
