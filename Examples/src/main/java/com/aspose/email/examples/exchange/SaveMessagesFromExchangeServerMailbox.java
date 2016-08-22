package com.aspose.email.examples.exchange;

import com.aspose.email.EWSClient;
import com.aspose.email.ExchangeClient;
import com.aspose.email.ExchangeMessageInfo;
import com.aspose.email.ExchangeMessageInfoCollection;
import com.aspose.email.IEWSClient;
import com.aspose.email.MailMessage;
import com.aspose.email.SaveOptions;
import com.aspose.email.examples.Utils;
import com.aspose.email.system.io.MemoryStream;

public class SaveMessagesFromExchangeServerMailbox {

	// The path to the resource directory.
	public static final String dataDir = Utils.getSharedDataDir(SaveMessagesFromExchangeServerMailbox.class) + "exchange/";

	public static void main(String[] args) {
		saveMessagesAsEML();
		
		saveMessagesAsEMLUsingEWS();
		
		saveMessagesToAMemoryStream();
		
		saveMessagesToAMemoryStreamUsingEWS();
		
		saveMessagesInMSGFormat();
		
		saveMessagesInMSGFormatUsingEWS();
	}

	public static void saveMessagesAsEML() {
		// Create instance of ExchangeClient class by giving credentials
		ExchangeClient client = new ExchangeClient("http://servername/exchange/username", "username", "password", "domain");

		// Call ListMessages method to list messages info from Inbox
		ExchangeMessageInfoCollection msgCollection = client.listMessages(client.getMailboxInfo().getInboxUri());

		for (ExchangeMessageInfo msgInfo : msgCollection) {
			String strMessageURI = msgInfo.getUniqueUri();

			// Now save the message in disk
			client.saveMessage(strMessageURI, dataDir + msgInfo.getMessageId() + ".eml");
		}
	}

	public static void saveMessagesAsEMLUsingEWS() {
		// Create instance of IEWSClient class by giving credentials
		IEWSClient client = EWSClient.getEWSClient("https://outlook.office365.com/ews/exchange.asmx", "testUser", "pwd", "domain");

		// Call ListMessages method to list messages info from Inbox
		ExchangeMessageInfoCollection msgCollection = client.listMessages(client.getMailboxInfo().getInboxUri());
		
		for (ExchangeMessageInfo msgInfo : msgCollection) {
			String strMessageURI = msgInfo.getUniqueUri();

			// Now save the message in disk
			client.saveMessage(strMessageURI, dataDir + msgInfo.getMessageId() + ".eml");
		}
	}

	public static void saveMessagesToAMemoryStream() {
		// Create instance of ExchangeClient class by giving credentials
		ExchangeClient client = new ExchangeClient("http://ex07sp1/exchange/Administrator", "user", "pwd", "domain");

		// Call ListMessages method to list messages info from Inbox
		ExchangeMessageInfoCollection msgCollection = client.listMessages(client.getMailboxInfo().getInboxUri());

		// Loop through the collection to get Message URI
		for (ExchangeMessageInfo msgInfo : msgCollection) {
			String strMessageURI = msgInfo.getUniqueUri();

			// Now save the message in memory stream
			MemoryStream stream = new MemoryStream();
			client.saveMessage(strMessageURI, stream);

			// You can save the stream to some storage location e.g. database
		}
	}

	public static void saveMessagesToAMemoryStreamUsingEWS() {
		// Create instance of EWSClient class by giving credentials
		IEWSClient client = EWSClient.getEWSClient("https://outlook.office365.com/ews/exchange.asmx", "testUser", "pwd", "domain");

		// Call ListMessages method to list messages info from Inbox
		ExchangeMessageInfoCollection msgCollection = client.listMessages(client.getMailboxInfo().getInboxUri());

		// Loop through the collection to get Message URI
		for (ExchangeMessageInfo msgInfo : msgCollection) {
			String strMessageURI = msgInfo.getUniqueUri();

			// Now save the message in memory stream
			MemoryStream stream = new MemoryStream();
			client.saveMessage(strMessageURI, stream);

			// You can save the stream to some storage location e.g. database
		}
	}

	public static void saveMessagesInMSGFormat() {
		// Create instance of ExchangeClient class by giving credentials
		ExchangeClient client = new ExchangeClient("http://ex07sp1/exchange/Administrator", "user", "pwd", "domain");

		// Call ListMessages method to list messages info from Inbox
		ExchangeMessageInfoCollection msgCollection = client.listMessages(client.getMailboxInfo().getInboxUri());

		for (ExchangeMessageInfo msgInfo : msgCollection) {
			String strMessageURI = msgInfo.getUniqueUri();

			// Now get the message details using FetchMessage()
			MailMessage msg = client.fetchMessage(strMessageURI);

			// Save message as MSG
			msg.save(dataDir + msgInfo.getMessageId() + ".msg", SaveOptions.getDefaultMsg());
		}
	}

	public static void saveMessagesInMSGFormatUsingEWS() {
		// Create instance of EWSClient class by giving credentials
		IEWSClient client = EWSClient.getEWSClient("https://outlook.office365.com/ews/exchange.asmx", "testUser", "pwd", "domain");

		// Call ListMessages method to list messages info from Inbox
		ExchangeMessageInfoCollection msgCollection = client.listMessages(client.getMailboxInfo().getInboxUri());

		for (ExchangeMessageInfo msgInfo : msgCollection) {
			String strMessageURI = msgInfo.getUniqueUri();

			// Now get the message details using FetchMessage()
			MailMessage msg = client.fetchMessage(strMessageURI);

			// Save message as MSg
			msg.save(dataDir + msgInfo.getMessageId() + ".msg", SaveOptions.getDefaultMsg());
		}
	}
}
