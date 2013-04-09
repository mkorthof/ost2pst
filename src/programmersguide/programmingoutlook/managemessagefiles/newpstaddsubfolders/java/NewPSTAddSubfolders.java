/* 
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Email. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package programmersguide.programmingoutlook.managemessagefiles.newpstaddsubfolders.java;

import com.aspose.email.*;

public class NewPSTAddSubfolders
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/programmingoutlook/managemessagefiles/newpstaddsubfolders/data/";

        //create an instance of PersonalStorage
        PersonalStorage pst = PersonalStorage.create(dataDir + "PersonalStorage.pst", 0);

        //create a folder at root of pst
        pst.getRootFolder().addSubFolder("myInbox");

        //add message to newly created folder
        //pst.getRootFolder().getSubFolder("myInbox").addMessage(MapiMessage.fromFile(dataDir + "New-out.msg"));

        // Display Status.
        System.out.println("PST created, addition of folder done successfully.");
    }
}




