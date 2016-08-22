package com.aspose.email.examples.exchange;

import com.aspose.email.EWSClient;
import com.aspose.email.ExchangeMessageInfo;
import com.aspose.email.ExchangeMessageInfoCollection;
import com.aspose.email.IEWSClient;
import com.aspose.email.MailMessage;

public class ExchangeImpersonation {

	public static void main(String[] args) {
		// Create instance of EWSClient class by giving credentials
		IEWSClient client1 = EWSClient.getEWSClient("https://outlook.office365.com/ews/exchange.asmx", "testUser1", "pwd", "domain");
		// Create instance of EWSClient class by giving credentials
		IEWSClient client2 = EWSClient.getEWSClient("https://outlook.office365.com/ews/exchange.asmx", "testUser2", "pwd", "domain");
		String folder = "Drafts";
		try {
			for (ExchangeMessageInfo messageInfo : client1.listMessages(folder))
				client1.deleteMessage(messageInfo.getUniqueUri());
			String subj1 = String.format("NETWORKNET_33354 {0} {1}", "User", "User1");
			client1.appendMessage(folder, new MailMessage("User1@exchange.conholdate.local", "To@aspsoe.com", subj1, ""));

			for (ExchangeMessageInfo messageInfo : client2.listMessages(folder))
				client2.deleteMessage(messageInfo.getUniqueUri());
			String subj2 = String.format("NETWORKNET_33354 {0} {1}", "User", "User2");
			client2.appendMessage(folder, new MailMessage("User2@exchange.conholdate.local", "To@aspose.com", subj2, ""));

			ExchangeMessageInfoCollection messInfoColl = client1.listMessages(folder);
			System.out.println((messInfoColl.size() == 1) ? "success" : "failure");
			System.out.println((messInfoColl.get_Item(0).getSubject() == subj1) ? "success" : "failure");

			client1.impersonateUser(0, "User2@exchange.conholdate.local");/*
														 * PrimarySmtpAddress =
														 * 0,PrincipalName =
														 * 1,SID = 2,SmtpAddress
														 * = 3,
														 */
			ExchangeMessageInfoCollection messInfoColl1 = client1.listMessages(folder);
			System.out.println((messInfoColl1.size() == 1) ? "success" : "failure");
			System.out.println((messInfoColl1.get_Item(0).getSubject() == subj2) ? "success" : "failure");

			client1.resetImpersonation();
			ExchangeMessageInfoCollection messInfoColl2 = client1.listMessages(folder);
			System.out.println((messInfoColl2.size() == 1) ? "success" : "failure");
			System.out.println((messInfoColl1.get_Item(0).getSubject() == subj1) ? "success" : "failure");
		} finally {
			try {
				for (ExchangeMessageInfo messageInfo : client1.listMessages(folder))
					client1.deleteMessage(messageInfo.getUniqueUri());
				for (ExchangeMessageInfo messageInfo : client2.listMessages(folder))
					client2.deleteMessage(messageInfo.getUniqueUri());
			} catch (Exception ex) {
			}
		}
	}

}
