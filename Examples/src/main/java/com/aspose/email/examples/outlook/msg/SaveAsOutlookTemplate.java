/* 
 * Copyright 2001-2016 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Email. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */

package com.aspose.email.examples.outlook.msg;

import com.aspose.email.MapiMessage;
import com.aspose.email.examples.Utils;
import com.aspose.email.system.IDisposable;

public class SaveAsOutlookTemplate {
	public static void main(String[] args) throws Exception {
		// ExStart: SaveAsOutlookTemplate
		// The path to the documents directory.
		String dataDir = Utils.getDataDir(ReadOutlookTemplateFile.class);

		MapiMessage mapi = new MapiMessage("test@from.to", "test@to.to", "template subject", "Template body");
		try {
			mapi.saveAsTemplate(dataDir + "mapiToOft.oft");
		} finally {
			if (mapi != null)
				((IDisposable) mapi).dispose();
		}

		System.out.println("Successfully created template message file.");
		// ExEnd: SaveAsOutlookTemplate
	}
}
