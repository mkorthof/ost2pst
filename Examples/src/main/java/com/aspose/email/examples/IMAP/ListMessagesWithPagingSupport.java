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

public class ListMessagesWithPagingSupport
{
    public static void main(String[] args) throws Exception
    {
	    //ExStart: ListMessagesWithPagingSupport
	    ImapClient client = new ImapClient("server.domain.com", 587, "username", "password");
	    client.setSecurityOptions(SecurityOptions.Auto);
	    
	    try
	    {
	        try
	        {
	            int messagesNum = 12;
	            int itemsPerPage = 5;

	            List<ImapPageInfo> pages = new List<ImapPageInfo>();
	            ImapPageInfo pageInfo = client.listMessagesByPage(itemsPerPage);
	            pages.addItem(pageInfo);
	            while (!pageInfo.getLastPage())
	            {
	                pageInfo = client.listMessagesByPage(pageInfo.getNextPage());
	                pages.addItem(pageInfo);
	            }
	            int retrievedItems = 0;
	            for (ImapPageInfo folderCol : (Iterable<ImapPageInfo>) pages)
	                retrievedItems += folderCol.getItems().size();
	        }
	        finally
	        {
	        }
	    }
	    finally { if (client != null) 
	    	((IDisposable)client).dispose(); 
	    }

        // Display Status.
        System.out.println("Execution completed.");
		//ExEnd: ListMessagesWithPagingSupport
    }
}