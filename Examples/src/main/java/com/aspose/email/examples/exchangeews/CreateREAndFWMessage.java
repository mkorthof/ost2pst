package com.aspose.email.examples.exchangeews;

import java.util.UUID;

import com.aspose.email.Attachment;
import com.aspose.email.EWSClient;
import com.aspose.email.ExchangeMessageInfoCollection;
import com.aspose.email.IEWSClient;
import com.aspose.email.MailMessage;

public class CreateREAndFWMessage {

	public static void main(String[] args) {
		IEWSClient client = EWSClient.getEWSClient("https://exchange.aspose.com/exchangeews/Exchange.asmx", "user1", "password", "");
		MailMessage message = new MailMessage("user1@domain.com", "user2@domain.com", "TestMailRefw - " + UUID.randomUUID().toString(),
				"TestMailRefw Implement ability to create RE and FW messages from source MSG file");

		client.send(message);

		try {
			Thread.sleep(50000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		
		ExchangeMessageInfoCollection messageInfoCol = client.listMessages(client.getMailboxInfo().getInboxUri());
		if (messageInfoCol.size() == 1)
			System.out.println("1 message in Inbox");
		else
			System.out.println("Error! No message in Inbox");

		MailMessage message1 = new MailMessage("user1@domain.com", "user2@domain.com", "TestMailRefw - " + UUID.randomUUID().toString(),
				"TestMailRefw Implement ability to create RE and FW messages from source MSG file");

		client.send(message1);
		try {
			Thread.sleep(50000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}

		// Wait for a while
		messageInfoCol = client.listMessages(client.getMailboxInfo().getInboxUri());

		if (messageInfoCol.size() == 2)
			System.out.println("2 messages in Inbox");
		else
			System.out.println("Error! No new message in Inbox");

		MailMessage message2 = new MailMessage("user1@domain.com", "user2@domain.com", "TestMailRefw - " + UUID.randomUUID().toString(),
				"TestMailRefw Implement ability to create RE and FW messages from source MSG file");
		message2.getAttachments().addItem(Attachment.createAttachmentFromString("Test attachment 1", "Attachment Name 1"));
		message2.getAttachments().addItem(Attachment.createAttachmentFromString("Test attachment 2", "Attachment Name 2"));

		client.reply(message2, messageInfoCol.get_Item(0));
		client.replyAll(message2, messageInfoCol.get_Item(0));
		client.forward(message2, messageInfoCol.get_Item(0));
	}
}
