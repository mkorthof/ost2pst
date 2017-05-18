package com.aspose.email.examples.exchangeews;

import com.aspose.email.EWSClient;
import com.aspose.email.ExchangeMessageInfoCollection;
import com.aspose.email.IEWSClient;

public class GetMessageClassInformationUsingEWS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ExStart: GetMessageClassInformationUsingEWS
		IEWSClient client = EWSClient.getEWSClient("https://outlook.office365.com/exchange/ews.asmx", "username", "password");
		
		ExchangeMessageInfoCollection list = client.listMessages(client.getMailboxInfo().getDeletedItemsUri());
		
		System.out.println(list.get_Item(0).getMessageInfoType());
		//ExEnd: GetMessageClassInformationUsingEWS
	}

}
