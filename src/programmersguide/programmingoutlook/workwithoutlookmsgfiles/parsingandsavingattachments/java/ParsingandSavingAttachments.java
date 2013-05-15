/* 
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Email. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package programmersguide.programmingoutlook.workwithoutlookmsgfiles.parsingandsavingattachments.java;

import com.aspose.email.*;

public class ParsingandSavingAttachments
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/programmingoutlook/workwithoutlookmsgfiles/parsingandsavingattachments/data/";
        
        try
        {
           //Instantiate an MSG file to load an MSG file from disk
           MapiMessage outlookMessageFile=MapiMessage.fromFile(dataDir + "message.msg");

           //Loop through the attachments collection associated with the MapiMessage object
           for(int i=0;i<outlookMessageFile.getAttachments().size();i++)
           {
           	//Set a reference to the MapiAttachment object
           	MapiAttachment  outlookMessageAttachment = (MapiAttachment)outlookMessageFile.getAttachments().get(i);
           	
           	//Display attachment extension
           	System.out.println("Att extension : " + outlookMessageAttachment.getExtension());
           	
           	//Display attached file name
           	System.out.println("File Name : " + outlookMessageAttachment.getLongFileName());
           	
           	//Save attachment to the disk
           	outlookMessageAttachment.save(dataDir + outlookMessageAttachment.getDisplayName());
           }
        }
        catch(Exception ex)
        {
           System.out.println(ex.toString());
        }
    }
}




