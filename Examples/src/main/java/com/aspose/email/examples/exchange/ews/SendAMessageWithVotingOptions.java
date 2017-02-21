package com.aspose.email.examples.exchange.ews;

import com.aspose.email.EWSClient;
import com.aspose.email.FollowUpOptions;
import com.aspose.email.IEWSClient;
import com.aspose.email.MailMessage;

public class SendAMessageWithVotingOptions {

	public static void main(String[] args) {
		String address = "firstname.lastname@aspose.com";
		IEWSClient client = EWSClient.getEWSClient("https://exchange.aspose.com/ews/Exchange.asmx", "username", "password", "aspose.com");
		MailMessage message = new MailMessage(address, address, "Flagged message", "Make it nice and short, but descriptive. The description may appear in search engines' search results pages...");

		FollowUpOptions options = new FollowUpOptions();
		options.setVotingButtons("Yes;No;Maybe;Exactly!");
		client.send(message, options);
	}

}
