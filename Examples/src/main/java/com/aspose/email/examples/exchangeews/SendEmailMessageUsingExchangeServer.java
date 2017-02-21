package com.aspose.email.examples.exchangeews;

import com.aspose.email.EWSClient;
import com.aspose.email.IEWSClient;
import com.aspose.email.MailAddress;
import com.aspose.email.MailAddressCollection;
import com.aspose.email.MailMessage;

public class SendEmailMessageUsingExchangeServer {

	public static void main(String[] args) {
		sendEmailMessageUsingExchangeServerUsingEWS();
	}

	public static void sendEmailMessageUsingExchangeServerUsingEWS() {
		// Create instance of IEWSClient class by giving credentials
		IEWSClient client = EWSClient.getEWSClient("https://outlook.office365.com/exchangeews/exchange.asmx", "testUser", "pwd", "domain");

		// Create instance of type MailMessage
		MailMessage msg = new MailMessage();
		msg.setFrom(new MailAddress("sender@domain.com"));
		MailAddressCollection collTo = new MailAddressCollection();
		collTo.add("recipient@domain.com");
		msg.setTo(collTo);
		msg.setSubject("Sending message from exchange server");
		msg.setHtmlBody("<h3>sending message from exchange server</h3>");

		// Send the message
		client.send(msg);
	}

}
