package com.aspose.email.examples.exchange;

import com.aspose.email.EWSClient;
import com.aspose.email.ExchangeMessageInfoCollection;
import com.aspose.email.IEWSClient;

public class AddHeadersInEWSRequests {

	public static void main(String[] args) {
		IEWSClient client = EWSClient.getEWSClient("exchange.domain.com/ews/Exchange.asmx", "username", "password", "");
		client.addHeader("X-AnchorMailbox", "username@domain.com");
		ExchangeMessageInfoCollection messageInfoCol = client.listMessages(client.getMailboxInfo().getInboxUri());
	}
}
