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

public class ListMessagesWithPagingSupport
{
    public static void main(String[] args) throws Exception
    {
		//ExStart: ListMessagesWithPagingSupport
		IEWSClient client = EWSClient.getEWSClient("exchange.domain.com", "username", "password");
		try
		{
		    try
		    {
		        int itemsPerPage = 5;
		
		        List<ExchangeMessagePageInfo> pages = new List<ExchangeMessagePageInfo>();
		        ExchangeMessagePageInfo pageInfo = client.listMessagesByPage(client.getMailboxInfo().getInboxUri(), itemsPerPage);
		
		        pages.addItem(pageInfo);
		        while (!pageInfo.getLastPage())
		        {
		            pageInfo = client.listMessagesByPage(client.getMailboxInfo().getInboxUri(), itemsPerPage, pageInfo.getPageOffset() + 1);
		            pages.addItem(pageInfo);
		        }
		        int retrievedItems = 0;
		        for (ExchangeMessagePageInfo pageCol : (Iterable<ExchangeMessagePageInfo>) pages)
		            retrievedItems += pageCol.getItems().size();
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