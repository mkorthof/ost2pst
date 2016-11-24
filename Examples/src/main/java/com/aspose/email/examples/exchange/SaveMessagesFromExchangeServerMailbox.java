package com.aspose.email.examples.exchange;

import com.aspose.email.EWSClient;
import com.aspose.email.ExchangeClient;
import com.aspose.email.ExchangeMessageInfo;
import com.aspose.email.ExchangeMessageInfoCollection;
import com.aspose.email.IEWSClient;
import com.aspose.email.MailMessage;
import com.aspose.email.SaveOptions;
import com.aspose.email.examples.Utils;
import com.aspose.email.system.exceptions.FileNotFoundException;
import com.aspose.email.system.exceptions.IOException;
import com.aspose.email.system.io.MemoryStream;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class SaveMessagesFromExchangeServerMailbox {

	// The path to the resource directory.
	public static final String dataDir = Utils.getSharedDataDir(SaveMessagesFromExchangeServerMailbox.class) + "exchange/";

	public static void main(String[] args) {
		saveMessagesAsEML();
		
		saveMessagesAsEMLUsingEWS();

        saveMessagesToOutputStream();

        saveMessagesToOutputStreamUsingEWS();
		
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

	public static void saveMessagesToOutputStream() {
		// Create instance of ExchangeClient class by giving credentials
		ExchangeClient client = new ExchangeClient("http://ex07sp1/exchange/Administrator", "user", "pwd", "domain");

		// Call ListMessages method to list messages info from Inbox
		ExchangeMessageInfoCollection msgCollection = client.listMessages(client.getMailboxInfo().getInboxUri());

		// Loop through the collection to get Message URI
		for (ExchangeMessageInfo msgInfo : msgCollection) {
			String strMessageURI = msgInfo.getUniqueUri();

            try {
                OutputStream outputStream = new FileOutputStream(dataDir + msgInfo.getMessageId() + "_Out.eml");
                client.saveMessage(strMessageURI, outputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
		}
	}

	public static void saveMessagesToOutputStreamUsingEWS() {
		// Create instance of EWSClient class by giving credentials
		IEWSClient client = EWSClient.getEWSClient("https://outlook.office365.com/ews/exchange.asmx", "testUser", "pwd", "domain");

		// Call ListMessages method to list messages info from Inbox
		ExchangeMessageInfoCollection msgCollection = client.listMessages(client.getMailboxInfo().getInboxUri());

		// Loop through the collection to get Message URI
		for (ExchangeMessageInfo msgInfo : msgCollection) {
			String strMessageURI = msgInfo.getUniqueUri();

            try {
                OutputStream outputStream = new FileOutputStream(dataDir + msgInfo.getMessageId() + "_Out.eml");
                client.saveMessage(strMessageURI, outputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
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
