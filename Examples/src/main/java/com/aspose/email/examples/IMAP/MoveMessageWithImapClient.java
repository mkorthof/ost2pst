/* 
 * Copyright 2001-2016 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Email. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package com.aspose.email.examples.exchange;
import com.aspose.email.ImapClient;
import com.aspose.email.ImapFolderInfo;
import com.aspose.email.ImapMessageInfoCollection;
import com.aspose.email.ImapPageInfo;
import com.aspose.email.ImapQueryBuilder;

public class MoveMessageWithImapClient
{
    public static void main(String[] args) throws Exception
    {
	    //ExStart: MoveMessageWithImapClient
	    ImapClient client = new ImapClient("host.domain.com", 587, "username", "password");
	    client.setSecurityOptions(SecurityOptions.Auto);
	    
	    try
	    {
	        String folderName = "EMAILNET-35151";
	        if (!client.existFolder(folderName))
	            client.createFolder(folderName);
	        try
	        {
	            MailMessage message = new MailMessage(
	                "from@gmail.com",
	                "to@gmail.com",
	                "EMAILNET-35151 - ",
	                "EMAILNET-35151 ImapClient: Provide option to Move Message");
	            client.selectFolder(ImapFolderInfo.IN_BOX);
	            String uniqueId = client.appendMessage(ImapFolderInfo.IN_BOX, message);
	            ImapMessageInfoCollection messageInfoCol1 = client.listMessages();
	            client.moveMessage(uniqueId, folderName);
	            client.commitDeletes();
	            client.selectFolder(folderName);
	            messageInfoCol1 = client.listMessages();
	            client.selectFolder(ImapFolderInfo.IN_BOX);
	            messageInfoCol1 = client.listMessages();
	        }
	        finally
	        {
	            try { client.deleteFolder(folderName); }
	            catch(java.lang.RuntimeException e) { }
	        }
	    }
	    finally { if (client != null)
	    	client.dispose(); 
	    }

        // Display Status.
        System.out.println("Execution completed.");
		//ExEnd: MoveMessageWithImapClient
    }
}