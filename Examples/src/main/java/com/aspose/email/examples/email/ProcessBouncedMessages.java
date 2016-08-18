package com.aspose.email.examples.email;

import com.aspose.email.BounceResult;
import com.aspose.email.MailMessage;
import com.aspose.email.examples.Utils;

public class ProcessBouncedMessages {

	public static void main(String[] args) {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(ProcessBouncedMessages.class) + "email/";
				
		String fileName = "failed.msg";
		MailMessage mail = MailMessage.load(dataDir + fileName);
		BounceResult result = mail.checkBounced();
		System.out.println(fileName);
		System.out.println("IsBounced : " + result.isBounced());
		System.out.println("Action : " + result.getAction());
		System.out.println("Recipient : " + result.getRecipient());
		System.out.println();

		fileName = "failed1.msg";
		mail = MailMessage.load(dataDir + fileName);
		result = mail.checkBounced();
		System.out.println(fileName);
		System.out.println("IsBounced : " + result.isBounced());
		System.out.println("Action : " + result.getAction());
		System.out.println("Recipient : " + result.getRecipient());
		System.out.println("Reason : " + result.getReason());
		System.out.println("Status : " + result.getStatus());
		System.out.println("OriginalMessage ToAddress 1: " + result.getOriginalMessage().getTo().get_Item(0).getAddress());
		System.out.println();

		fileName = "test.eml";
		mail = MailMessage.load(dataDir + fileName);
		result = mail.checkBounced();
		System.out.println(fileName);
		System.out.println("IsBounced : " + result.isBounced());
		System.out.println("Action : " + result.getAction());
		System.out.println("Recipient : " + result.getRecipient());

	}

}
