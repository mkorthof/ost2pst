/* 
 * Copyright 2001-2015 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Email. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package com.aspose.email.examples.outlook.msg;

import com.aspose.email.MapiAttachment;
import com.aspose.email.MapiMessage;
import com.aspose.email.MapiRecipient;
import com.aspose.email.examples.Utils;

public class ParsingOutlookMessageFiles
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(ParsingOutlookMessageFiles.class);

        try
        {
            //Instantiate an MSG file to load an MSG file from disk
            MapiMessage outlookMessageFile=MapiMessage.fromFile(dataDir + "message.msg");

            //Display sender's name
            System.out.println("Sender Name : " + outlookMessageFile.getSenderName());

            //Display Subject
            System.out.println("Subject : " + outlookMessageFile.getSubject());

            //Display Body
            System.out.println("Body : " + outlookMessageFile.getBody());

            //Display Recipient's info
            System.out.println("\nRecipients : \n");

            //Loop through the recipients collection associated with the MapiMessage object
            for (int i=0; i<outlookMessageFile.getRecipients().size(); i++)
            {
                //Set a reference to the MapiRecipient object
                MapiRecipient rcp= (MapiRecipient) outlookMessageFile.getRecipients().get_Item(i);
                //Display recipient email address
                System.out.println("Email : " + rcp.getEmailAddress());
                //Display recipient name
                System.out.println("Name : " + rcp.getDisplayName());
                //Display recipient type
                System.out.println("Recipient Type : " + rcp.getRecipientType());
            }
        }
        catch(Exception ex)
        {
            System.out.println("Some error occurred while parsing the msg file.");
        }
    }
}
