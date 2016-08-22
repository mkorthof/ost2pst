package com.aspose.email.examples.pop3;

import com.aspose.email.Pop3Client;
import com.aspose.email.Pop3MailboxInfo;

public class GetMailboxInformation {

	public static void main(String[] args) {
		Pop3Client client = new Pop3Client();
		client.setHost("exchange.domain.com");
		client.setUsername("username");
		client.setPassword("password");

		Pop3MailboxInfo mailBoxInfo = client.getMailboxInfo();
		System.out.println("Number of mesages in mailbox are: " + mailBoxInfo.getMessageCount());

		// Get occupied size
		long nOccupiedSize = mailBoxInfo.getOccupiedSize();
		System.out.println("Occupied size is " + nOccupiedSize);
	}

}
