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

public class ListAppointmentsWithPagingSupport
{
    public static void main(String[] args) throws Exception
    {
		//ExStart: ListAppointmentsWithPagingSupport
	    final IEWSClient client = EWSClient.getEWSClient("exchange.domain.com", "username", "password");
	    +
	    try
	    {
	        try
	        {
	            int appNumber = 10;
	            int itemsPerPage = 2;
	            List<AppointmentPageInfo> pages = new List<AppointmentPageInfo>();
	            AppointmentPageInfo pagedAppointmentCol = client.listAppointmentsByPage(itemsPerPage);
	            pages.addItem(pagedAppointmentCol);
	            while (!pagedAppointmentCol.getLastPage())
	            {
	                pagedAppointmentCol = client.listAppointmentsByPage(itemsPerPage, pagedAppointmentCol.getPageOffset() + 1);
	                pages.addItem(pagedAppointmentCol);
	            }
	            int retrievedItems = 0;
	            for (AppointmentPageInfo folderCol : (Iterable<AppointmentPageInfo>) pages)
	                retrievedItems += folderCol.getItems().size();
	        }
	        finally
	        {
	        }
	    }
	    finally { if (client != null) ((IDisposable)client).dispose(); }

        // Display Status.
        System.out.println("Execution completed.");
	//ExEnd: ListAppointmentsWithPagingSupport
    }
}