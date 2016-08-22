package com.aspose.email.examples.exchange;

import com.aspose.email.EWSClient;
import com.aspose.email.ExchangeFolderInfoCollection;
import com.aspose.email.ExchangeFolderPageInfo;
import com.aspose.email.IEWSClient;
import com.aspose.email.system.IDisposable;
import com.aspose.email.system.collections.generic.List;

public class ListingFoldersWithPagingSupport {

	public static void main(String[] args) {
		final IEWSClient client = EWSClient.getEWSClient("exchange.domain.com", "username", "password");

		try {
			//Items per page
			int itemsPerPage = 5;

			ExchangeFolderInfoCollection totalFoldersCollection = client.listSubFolders(client.getMailboxInfo().getRootUri());
			List<ExchangeFolderPageInfo> pages = new List<ExchangeFolderPageInfo>();
			ExchangeFolderPageInfo pagedFoldersCollection = client.listSubFoldersByPage(client.getMailboxInfo().getRootUri(), itemsPerPage);
			pages.addItem(pagedFoldersCollection);

			while (!pagedFoldersCollection.getLastPage()) {
				pagedFoldersCollection = client.listSubFoldersByPage(client.getMailboxInfo().getRootUri(), itemsPerPage, pagedFoldersCollection.getPageOffset() + 1);

				pages.addItem(pagedFoldersCollection);
			}

			//Verify the items retrieved
			int retrievedFolders = 0;
			for (ExchangeFolderPageInfo pageCol : (Iterable<ExchangeFolderPageInfo>) pages)
				retrievedFolders += pageCol.getItems().size();

			System.out.println("Retrieved folders count: " + retrievedFolders);
		} finally {
			if (client != null)
				((IDisposable) client).dispose();
		}
	}
}
