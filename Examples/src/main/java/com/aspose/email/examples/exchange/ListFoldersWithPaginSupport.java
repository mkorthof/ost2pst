/* 
 * Copyright 2001-2016 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Email. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package com.aspose.email.examples.exchange;

import com.aspose.email.Appointment;
import com.aspose.email.AppointmentPageInfo;
import com.aspose.email.EWSClient;
import com.aspose.email.ExchangeDelegateFolderPermissionLevel;
import com.aspose.email.ExchangeDelegateUser;
import com.aspose.email.ExchangeFolderInfoCollection;
import com.aspose.email.ExchangeFolderPageInfo;
import com.aspose.email.ExchangeMessagePageInfo;

public class ListFoldersWithPagingSupport
{
    public static void main(String[] args) throws Exception
    {
		//ExStart: ListFoldersWithPagingSupport
	    final IEWSClient client = EWSClient.getEWSClient("exchange.domain.com", "username", "password");
	    try
	    {
	        int itemsPerPage = 5;
	        ExchangeFolderInfoCollection totalFoldersCollection = client.listSubFolders(client.getMailboxInfo().getRootUri());

	        //////////////////////////////////////////////////////

	        List<ExchangeFolderPageInfo> pages = new List<ExchangeFolderPageInfo>();
	        ExchangeFolderPageInfo pagedFoldersCollection = client.listSubFoldersByPage(client.getMailboxInfo().getRootUri(), itemsPerPage);

	        pages.addItem(pagedFoldersCollection);
	        while (!pagedFoldersCollection.getLastPage())
	        {
	            pagedFoldersCollection = client.listSubFoldersByPage(client.getMailboxInfo().getRootUri(), itemsPerPage, pagedFoldersCollection.getPageOffset() + 1);
	            pages.addItem(pagedFoldersCollection);
	        }
	        int retrievedFolders = 0;
	        for (ExchangeFolderPageInfo pageCol : (Iterable<ExchangeFolderPageInfo>) pages)
	            retrievedFolders += pageCol.getItems().size();

	    }
	    finally { if (client != null) 
	    	((IDisposable)client).dispose(); 
	    }

        // Display Status.
        System.out.println("Execution completed.");
		//ExEnd: ListFoldersWithPagingSupport
    }
}