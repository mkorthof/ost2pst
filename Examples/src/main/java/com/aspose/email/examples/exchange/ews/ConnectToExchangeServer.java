package com.aspose.email.examples.exchange.ews;

import com.aspose.email.EWSClient;
import com.aspose.email.IEWSClient;

public class ConnectToExchangeServer {

	public static void main(String[] args) {
		
		// Connecting to Exchange Server using Exchange Web Service (EWS)
		getEWSClient();
	}

	public static IEWSClient getEWSClient() {
		IEWSClient client = EWSClient.getEWSClient("https://exchange.domain.com/ews/Exchange.asmx/", "user", "password", "");
		return client;
	}

}
