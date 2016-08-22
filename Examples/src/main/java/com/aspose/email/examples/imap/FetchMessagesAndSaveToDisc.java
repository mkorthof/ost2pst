package com.aspose.email.examples.imap;

import com.aspose.email.ImapClient;
import com.aspose.email.ImapFolderInfo;
import com.aspose.email.ImapMessageInfo;
import com.aspose.email.ImapMessageInfoCollection;
import com.aspose.email.MailMessage;
import com.aspose.email.SaveOptions;
import com.aspose.email.SecurityOptions;

public class FetchMessagesAndSaveToDisc {

	public static void main(String[] args) {
		// Listing Messages from Inbox of IMAP server
		listMessagesFromInboxOfIMAPServer();
		
		// Listing Messages from a Folder
		listMessagesRecursivelyFromFolders();
		
		// Fetching Messages By Sequence Number and Saving to Disc
		fetchMessagesBySequenceNumber();
		
		// Fetching Messages By Message Id and Saving to Disc
		fetchMessagesByMessageId();
		
		// Retrieving "N" number of Messages from Server
		retrieveNNumberOfMessagesFromServer();
	}

	public static void listMessagesFromInboxOfIMAPServer() {
		ImapClient client = new ImapClient();
		client.setHost("imap.gmail.com");
		client.setPort(993);
		client.setUsername("username");
		client.setPassword("password");
		client.setSecurityOptions(SecurityOptions.Auto);

		client.selectFolder(ImapFolderInfo.IN_BOX);
		ImapMessageInfoCollection coll = client.listMessages();
	}

	public static void listMessagesRecursivelyFromFolders() {
		ImapClient client = new ImapClient();
		client.setHost("imap.gmail.com");
		client.setPort(993);
		client.setUsername("username");
		client.setPassword("password");
		client.setSecurityOptions(SecurityOptions.Auto);

		ImapMessageInfoCollection coll = client.listMessages("Inbox", true); //any folder name can be used

		for (ImapMessageInfo msgInfo : coll) {
			System.out.println("Message Subject: " + msgInfo.getSubject());
			System.out.println("From: " + msgInfo.getSender().getAddress());
			System.out.println("Sent Date: " + msgInfo.getDate());
			System.out.println("Mime Message Id: " + msgInfo.getMessageId());
		}
	}

	public static void fetchMessagesBySequenceNumber() {
		ImapClient client = new ImapClient();
		client.setHost("imap.gmail.com");
		client.setPort(993);
		client.setUsername("username");
		client.setPassword("password");
		client.setSecurityOptions(SecurityOptions.Auto);

		client.selectFolder(ImapFolderInfo.IN_BOX);
		ImapMessageInfoCollection coll = client.listMessages();

		for (int i = 1; i < coll.size(); i++) {
			MailMessage eml = client.fetchMessage(i); //use the sequence number to fetch messages
			eml.save(eml.getSubject() + ".eml", SaveOptions.getDefaultEml()); //save as EML
			eml.save(eml.getSubject() + ".msg", SaveOptions.getDefaultMsg()); //save as MSG
		}
	}

	public static void fetchMessagesByMessageId() {
		ImapClient client = new ImapClient();
		client.setHost("imap.gmail.com");
		client.setPort(993);
		client.setUsername("username");
		client.setPassword("password");
		client.setSecurityOptions(SecurityOptions.Auto);

		client.selectFolder(ImapFolderInfo.IN_BOX);
		ImapMessageInfoCollection coll = client.listMessages();

		for (ImapMessageInfo msgInfo : coll) {
			MailMessage eml = client.fetchMessage(msgInfo.getUniqueId()); //use the sequence number to fetch messages

			eml.save(eml.getSubject() + ".eml", SaveOptions.getDefaultEml()); //save as EML

			eml.save(eml.getSubject() + ".msg", SaveOptions.getDefaultMsg()); //save as MSG
		}
	}

	public static void retrieveNNumberOfMessagesFromServer() {
		ImapClient client = new ImapClient();
		client.setHost("imap.gmail.com");
		client.setPort(993);
		client.setUsername("username");
		client.setPassword("password");
		client.setSecurityOptions(SecurityOptions.Auto);

		ImapMessageInfoCollection coll = client.listMessages(5); //List 5 messages from the server

		for (ImapMessageInfo msgInfo : coll) {
			System.out.println("Message Subject: " + msgInfo.getSubject());
			System.out.println("From: " + msgInfo.getSender().getAddress());
			System.out.println("Sent Date: " + msgInfo.getDate());
			System.out.println("Mime Message Id: " + msgInfo.getMessageId());
		}
	}

}
