/* 
 * Copyright 2001-2015 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Email. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package com.aspose.email.examples.outlook.pst;

import com.aspose.email.PersonalStorage;
import com.aspose.email.examples.Utils;

import java.io.File;

public class NewPSTAddSubfolders
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(NewPSTAddSubfolders.class);

        String dst = dataDir + "PersonalStorage.pst";

        // Delete the PST, if it already exists
        File filePst = new File(dst);
        if (filePst.exists())
            filePst.delete();

        //create an instance of PersonalStorage
        PersonalStorage pst = PersonalStorage.create(dst, 0);

        //create a folder at root of pst
        pst.getRootFolder().addSubFolder("myInbox");

        //add message to newly created folder
        //pst.getRootFolder().getSubFolder("myInbox").addMessage(MapiMessage.fromFile(dataDir + "New-out.msg"));

        // Display Status.
        System.out.println("PST created, addition of folder done successfully.");
    }
}
