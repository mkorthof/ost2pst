package com.aspose.email.examples.exchangeews;

import com.aspose.email.EWSClient;
import com.aspose.email.ExchangeFolderInfo;
import com.aspose.email.ExchangeFolderInfoCollection;
import com.aspose.email.ExchangeFolderType;
import com.aspose.email.IEWSClient;

public class GetFolderTypeInformationUsingEWS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//ExStart: GetFolderTypeInformationUsingEWS
		IEWSClient client = EWSClient.getEWSClient("https://outlook.office365.com/ews/exchange.asmx", "username", "password");
		
		try 
		{
		    ExchangeFolderInfoCollection folderInfoCol = client.listSubFolders(client.getMailboxInfo().getRootUri());
		   
		    for (ExchangeFolderInfo folderInfo : folderInfoCol)
		    {
		        switch (folderInfo.getFolderType())
		        {
		            case ExchangeFolderType.Appointment:
		                // handle Appointment
		                break;
		            case ExchangeFolderType.Contact:
		                // handle Contact
		                break;
		            case ExchangeFolderType.Task:
		                // handle Task
		                break;
		            case ExchangeFolderType.Note:
		                // handle email message
		                break;
		            case ExchangeFolderType.StickyNote:
		                // handle StickyNote
		                break;
		            case ExchangeFolderType.Journal:
		                // handle Journal
		                break;
		            default:
		                break;
		        }
		    }
		} 
		finally 
		{
		    client.dispose();
		}
		//ExEnd: GetFolderTypeInformationUsingEWS
	}

}
