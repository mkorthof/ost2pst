/** 
 * Copyright 2001-2016 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Slides. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
package com.aspose.email.examples.outlook.msg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.aspose.email.MapiMessage;
import com.aspose.email.examples.Utils;

public class InsertAndReplaceMSGAttachment {
	
	public static void main(String[] args) throws FileNotFoundException {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(InsertAndReplaceMSGAttachment.class) + "outlook/";
		
		insertMSGAttachmentAtSpecificLocation(dataDir);
		
		replaceEmbeddedMSGAttachmentContents(dataDir);
	}
	
	public static void insertMSGAttachmentAtSpecificLocation(String dataDir) throws FileNotFoundException {
		MapiMessage msg = MapiMessage.fromFile(dataDir + "WithEmbeddedMsg.msg");
		msg.getAttachments().get_Item(0).save(dataDir + "attachment_out.msg");	
		MapiMessage emb = MapiMessage.fromStream(new FileInputStream(dataDir + "WithEmbeddedMsg.msg"));
		
		msg.getAttachments().insert(1, "new 11", emb);
		
		msg.save(dataDir + "insertMSGAttachment_out.msg");
	}
	
	public static void replaceEmbeddedMSGAttachmentContents(String dataDir) throws FileNotFoundException {
		MapiMessage msg = MapiMessage.fromFile(dataDir + "insertMSGAttachment_out.msg");
		msg.getAttachments().get_Item(0).save(dataDir + "attachment_out.msg");
		MapiMessage emb = MapiMessage.fromStream(new FileInputStream(dataDir + "insertMSGAttachment_out.msg"));

		msg.getAttachments().replace(1, "new 1", emb);
		
		msg.save(dataDir + "replaceEmbeddedMSGAttachment_out.msg");
	}
}
