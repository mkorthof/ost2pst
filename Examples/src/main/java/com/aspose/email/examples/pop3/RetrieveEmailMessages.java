package com.aspose.email.examples.pop3;

import com.aspose.email.MailMessage;
import com.aspose.email.Pop3Client;
import com.aspose.email.Pop3MessageInfo;
import com.aspose.email.Pop3MessageInfoCollection;
import com.aspose.email.SaveOptions;
import com.aspose.email.SecurityOptions;

public class RetrieveEmailMessages {

	public static void main(String[] args) {
		retrieveMessagesUsingSequenceNumber();
		
		retrieveMessagesUsingMessageUniqueURI();
		
		retrieveAndSaveDirectlyToDisc();
	}

	public static void retrieveMessagesUsingSequenceNumber() {
		Pop3Client client = new Pop3Client();
		client.setHost("pop.aspose.com");
		client.setUsername("username");
		client.setPassword("password");
		client.setSecurityOptions(SecurityOptions.Auto);

		int iMessageCount = client.getMessageCount();
		System.out.println("Total Messages: " + iMessageCount);

		for (int i = 1; i <= iMessageCount; i++) {
			MailMessage eml = client.fetchMessage(i);
			System.out.println(eml.getSubject());
			//Save to disc in EML format to disc
			eml.save(i + ".eml", SaveOptions.getDefaultEml());
			//Save to disc in Outlook MSG format to disc
			eml.save(i + ".msg", SaveOptions.getDefaultMsgUnicode());
		}
	}

	public static void retrieveMessagesUsingMessageUniqueURI() {
		Pop3Client client = new Pop3Client();
		client.setHost("Pop.domain.com");
		client.setUsername("username");
		client.setPassword("password");
		client.setSecurityOptions(SecurityOptions.Auto);

		Pop3MessageInfoCollection coll = client.listMessages();
		for (Pop3MessageInfo msgInfo : coll) {
			MailMessage eml = client.fetchMessage(msgInfo.getUniqueId());
			//Save to disc in EML format to disc
			eml.save(eml.getSubject().replace(":", "") + ".eml", SaveOptions.getDefaultEml());
			//Save to disc in Outlook MSG format to disc
			eml.save(eml.getSubject().replace(":", "") + ".msg", SaveOptions.getDefaultMsgUnicode());
		}
	}

	public static void retrieveAndSaveDirectlyToDisc() {
		Pop3Client client = new Pop3Client();
		client.setHost("Pop.domain.com");
		client.setUsername("username");
		client.setPassword("password");
		client.setSecurityOptions(SecurityOptions.Auto);

		int iMessageCount = client.getMessageCount();

		for (int i = 1; i < iMessageCount; i++)
			client.saveMessage(i, i + ".eml");
	}

}
