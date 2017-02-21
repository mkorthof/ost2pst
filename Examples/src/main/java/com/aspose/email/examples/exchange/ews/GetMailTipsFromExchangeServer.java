package com.aspose.email.examples.exchange.ews;

import com.aspose.email.EWSClient;
import com.aspose.email.GetMailTipsOptions;
import com.aspose.email.IEWSClient;
import com.aspose.email.MailAddress;
import com.aspose.email.MailAddressCollection;
import com.aspose.email.MailTips;
import com.aspose.email.MailTipsType;

public class GetMailTipsFromExchangeServer {

	public static void main(String[] args) {
		
		// Create instance of EWSClient class by giving credentials
		IEWSClient client = EWSClient.getEWSClient("https://outlook.office365.com/ews/exchange.asmx", "testUser", "pwd", "domain");
		System.out.println("Connected to Exchange server...");

		// Provide mail tips options
		// Recipient addresses
		MailAddressCollection addrColl = new MailAddressCollection();
		addrColl.add("test.exchange@ex2010.local");
		addrColl.add("invalid.recipient@ex2010.local");

		GetMailTipsOptions options = new GetMailTipsOptions(new MailAddress("administrator@ex2010.local"), addrColl, MailTipsType.All);

		// Get Mail Tips
		MailTips[] tips = client.getMailTips(options);

		// Display information about each Mail Tip
		for (MailTips tip : tips) {
			// Display Out of office message, if present
			if (tip.getOutOfOffice() != null) {
				System.out.println("Out of office: " + tip.getOutOfOffice().getReplyBody().getMessage());
			}

			// Display the invalid email address in recipient, if present
			if (tip.getInvalidRecipient() == true) {
				System.out.println("The recipient address is invalid: " + tip.getRecipientAddress());
			}
		}
	}
}
