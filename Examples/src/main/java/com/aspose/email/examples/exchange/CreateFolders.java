package com.aspose.email.examples.exchange;

import com.aspose.email.EWSClient;
import com.aspose.email.ExchangeFolderInfo;
import com.aspose.email.IEWSClient;

public class CreateFolders {

	public static void main(String[] args) {
		IEWSClient client = EWSClient.getEWSClient("exhcnage server uri", "Username", "Password", "domain");
		try {
			String inbox = client.getMailboxInfo().getInboxUri();
			String folderName1 = "EMAILNET-35054";
			String subFolderName0 = "2015";
			String folderName2 = folderName1 +  "/" +  subFolderName0;
			ExchangeFolderInfo rootFolderInfo = null;
			ExchangeFolderInfo folderInfo = null;
		    try {
		    	client.setUseSlashAsFolderSeparator(true);
		    	client.createFolder(client.getMailboxInfo().getInboxUri(), folderName1);
		    	client.createFolder(client.getMailboxInfo().getInboxUri(), folderName2);
		    } finally {
			    ExchangeFolderInfo subfolderInfo[] = new ExchangeFolderInfo[] { null };
			    boolean outRefCondition2 = client.folderExists(inbox, folderName1, subfolderInfo);
		        rootFolderInfo = subfolderInfo[0];
		        if (outRefCondition2) {
		        	ExchangeFolderInfo[] referenceToFolderInfo = { folderInfo };
		        	boolean outRefCondition3 = client.folderExists(inbox, folderName2, /*out*/ referenceToFolderInfo);
		        	folderInfo = referenceToFolderInfo[0];
		        	if (outRefCondition3) {
		        		client.deleteFolder(folderInfo.getUri(), true);
		    			client.deleteFolder(rootFolderInfo.getUri(), true);
		    		}
		  		}
		    }
		} finally {
			if (client != null)
		          client.dispose();
		}
	}
}
