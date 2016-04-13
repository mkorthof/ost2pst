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

public class SearchMessagesWithPagingSupport
{
    public static void main(String[] args) throws Exception
    {
		//ExStart: SearchMessagesWithPagingSupport
		ImapClient client = new ImapClient("host.domain.com", 889, "username", "password");
		
		client.setSecurityOptions(SecurityOptions.Auto);

        int itemsPerPage = 5;
        String body = "2222222222222";
        ImapQueryBuilder iqb = new ImapQueryBuilder();
        iqb.getBody().contains(body);
        MailQuery query = iqb.getQuery();

        client.selectFolder(ImapFolderInfo.IN_BOX);
        ImapMessageInfoCollection totalMessageInfoCol = client.listMessages(query);

        List<ImapPageInfo> pages = new List<ImapPageInfo>();
        ImapPageInfo pageInfo = client.listMessagesByPage(ImapFolderInfo.IN_BOX, query, itemsPerPage);
        pages.add(pageInfo);
        while (!pageInfo.getLastPage())
        {
            pageInfo = client.listMessagesByPage(ImapFolderInfo.IN_BOX, query, pageInfo.getNextPage());
            pages.add(pageInfo);
        }
        int retrievedItems = 0;
        for (ImapPageInfo folderCol : (Iterable<ImapPageInfo>) pages)
            retrievedItems += folderCol.getItems().size();
        client.dispose(); 

        // Display Status.
        System.out.println("Execution completed.");
		//ExEnd: SearchMessagesWithPagingSupport
    }
}