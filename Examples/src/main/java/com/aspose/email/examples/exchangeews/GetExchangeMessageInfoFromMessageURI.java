package com.aspose.email.examples.exchangeews;

import java.util.UUID;

import com.aspose.email.EWSClient;
import com.aspose.email.ExchangeMessageInfo;
import com.aspose.email.ExchangeMessageInfoCollection;
import com.aspose.email.IEWSClient;
import com.aspose.email.MailMessage;
import com.aspose.email.system.IDisposable;
import com.aspose.email.system.collections.generic.List;

public class GetExchangeMessageInfoFromMessageURI {

	public static void main(String[] args) {
		final IEWSClient client = EWSClient.getEWSClient("exchange.domain.com", "username", "password");
		
		try {
			List<String> ids = new List<String>();
			List<MailMessage> messages = new List<MailMessage>();
			
			
			for (int i = 0; i < 5; i++) {
				MailMessage message = new MailMessage("from@domain.com", "to@domain.com", 
						"EMAILNET-35033 - " + UUID.randomUUID().toString(),
						"EMAILNET-35033 Messages saved from Sent Items folder doesn't contain 'To' field");
				messages.addItem(message);
				String uri = client.appendMessage(message);
				ids.addItem(uri);
			}

			ExchangeMessageInfoCollection messageInfoCol = client.listMessages(ids);
			for (ExchangeMessageInfo messageInfo : messageInfoCol) {
				// Do something ...
			}
		} finally {
			if (client != null)
				((IDisposable) client).dispose();
		}
	}
}
