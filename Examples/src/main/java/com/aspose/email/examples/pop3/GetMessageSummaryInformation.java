package com.aspose.email.examples.pop3;

import com.aspose.email.Pop3Client;
import com.aspose.email.Pop3MessageInfo;
import com.aspose.email.SecurityOptions;

public class GetMessageSummaryInformation {

	public static void main(String[] args) {
		// Retrieving Message Summary Information using Sequence Number
		retrieveMessageSummaryInformationUsingSequenceNumber();

		// Retrieving Message Summary Information using Unique Id
		retrieveMessageSummaryInformationUsingUniqueId();
	}

	public static void retrieveMessageSummaryInformationUsingSequenceNumber() {
		String seqNum = "sequence number of a message from server";
		Pop3Client client = new Pop3Client("host.domain.com", 456, "username", "password");
		client.setSecurityOptions(SecurityOptions.Auto);
		Pop3MessageInfo messageInfo = client.getMessageInfo(seqNum);

		if (messageInfo != null) {
			System.out.println(messageInfo.getSubject());
			System.out.println(messageInfo.getDate());
		}
	}

	public static void retrieveMessageSummaryInformationUsingUniqueId() {
		String uniqueId = "unique id of a message from server";
		Pop3Client client = new Pop3Client("host.domain.com", 456, "username", "password");
		client.setSecurityOptions(SecurityOptions.Auto);
		Pop3MessageInfo messageInfo = client.getMessageInfo(uniqueId);

		if (messageInfo != null) {
			System.out.println(messageInfo.getSubject());
			System.out.println(messageInfo.getDate());
		}
	}

}
