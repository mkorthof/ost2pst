package com.aspose.email.examples.exchangeews;

import com.aspose.email.AppointmentPageInfo;
import com.aspose.email.EWSClient;
import com.aspose.email.IEWSClient;
import com.aspose.email.system.IDisposable;
import com.aspose.email.system.collections.generic.List;

public class ListAppointmentsWithPagingSupport {

	public static void main(String[] args) {
		// ExStart:ListAppointmentsWithPagingSupport
		IEWSClient client = EWSClient.getEWSClient("exchange.domain.com", "username", "password");
		try {    
	        //Define total number of items per page
	        int itemsPerPage = 2;
	        List<AppointmentPageInfo> pages = new List<AppointmentPageInfo>();
	        AppointmentPageInfo pagedAppointmentCol = client.listAppointmentsByPage(itemsPerPage);
	        pages.addItem(pagedAppointmentCol);
	        while (!pagedAppointmentCol.getLastPage())
	        {
	            pagedAppointmentCol = client.listAppointmentsByPage(itemsPerPage, pagedAppointmentCol.getPageOffset() + 1);
	            pages.addItem(pagedAppointmentCol);
	        }
	        //Verify the number of appointments retrieved using the paging support
	        int retrievedItems = 0;
	        for (AppointmentPageInfo folderCol : (Iterable<AppointmentPageInfo>) pages)
	            retrievedItems += folderCol.getItems().size();
	        System.out.println("Total items retrieved: " + retrievedItems);
		} finally { 
			if (client != null) 
				((IDisposable)client).dispose(); 
		}
		// ExEnd:ListAppointmentsWithPagingSupport
	}
}
