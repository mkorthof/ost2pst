package com.aspose.email.examples.exchangeews;

import com.aspose.email.EWSClient;
import com.aspose.email.IEWSClient;
import com.aspose.email.UnifiedMessagingConfiguration;

public class GetUnifiedMessagingConfigurationInformation {

	public static void main(String[] args) {
		IEWSClient client = EWSClient.getEWSClient("https://exchange.domain.com/exchangeews/Exchange.asmx", "username", "password", "domain.com");
		UnifiedMessagingConfiguration umConf = client.getUMConfiguration();
	}

}
