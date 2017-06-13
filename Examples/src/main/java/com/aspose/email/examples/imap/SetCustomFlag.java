package com.aspose.email.examples.imap;

import com.aspose.email.ImapClient;
import com.aspose.email.ImapFolderInfo;
import com.aspose.email.ImapMessageFlags;
import com.aspose.email.ImapMessageInfo;
import com.aspose.email.ImapMessageInfoCollection;
import com.aspose.email.MailMessage;

public class SetCustomFlag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SetCustomFlagForAMessage();
	}

	public static void SetCustomFlagForAMessage()
	{
		//ExStart: SetCustomFlag
		// Create a message
		MailMessage message = new MailMessage("user@domain1.com", "user@domain2.com", "subject", "message");

		ImapClient client = new ImapClient("host.domain.com", 587, "username", "password");
		
		//Append the message to mailbox
		String uid = client.appendMessage(ImapFolderInfo.IN_BOX, message);

		//Add custom flags to the added message
		client.addMessageFlags(uid, ImapMessageFlags.op_BitwiseOr(
		        ImapMessageFlags.keyword("custom1")
		        ,ImapMessageFlags.keyword("custom1_0")));

		//Retrieve the messages for checking the presence of custom flag
		client.selectFolder(ImapFolderInfo.IN_BOX);

		ImapMessageInfoCollection messageInfos = client.listMessages();
		for (ImapMessageInfo inf: messageInfos)
		{
		    ImapMessageFlags[] flags = inf.getFlags().split();

		    if (inf.containsKeyword("custom1"))
		        System.out.println("Keyword found");
		}
		//ExEnd: SetCustomFlag
	}
}
