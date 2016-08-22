package com.aspose.email.examples.exchange;

import com.aspose.email.EWSClient;
import com.aspose.email.ExchangeClient;
import com.aspose.email.IEWSClient;

public class ConnectToExchangeServer {

	public static void main(String[] args) {
		// Connecting to Exchange using ExchangeClient
		getExchangeClient();
		
		// Connecting to Exchange Server using Exchange Web Service (EWS)
		getEWSClient();
	}

	public static ExchangeClient getExchangeClient() {
		// Create instance of ExchangeClient class by giving credentials
		ExchangeClient client = new ExchangeClient("http://MachineName/exchange/Username", "Username", "password", "domain");
		return client;
	}

	public static IEWSClient getEWSClient() {
		IEWSClient client = EWSClient.getEWSClient("https://exchange.domain.com/ews/Exchange.asmx/", "user", "password", "");
		return client;
	}

}
