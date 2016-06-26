package com.aspose.email.examples.IMAP;

import com.aspose.email.ImapClient;
import com.aspose.email.ImapIdentificationInfo;
import com.aspose.email.SecurityOptions;

public class SupportForIMAP4IDExtension {

	public static void main(String[] args) {
		ImapClient client = new ImapClient("imap.gmail.com", 993, "username", "password");

		client.setSecurityOptions(SecurityOptions.Auto);

		System.out.println(client.getIdSupported());
		ImapIdentificationInfo serverIdentificationInfo1 = client.introduceClient();
		ImapIdentificationInfo serverIdentificationInfo2 = client.introduceClient(ImapIdentificationInfo.getDefaultValue());

		System.out.println(serverIdentificationInfo1 + "," + serverIdentificationInfo2);

		System.out.println(serverIdentificationInfo1.getName());

		System.out.println(serverIdentificationInfo1.getVendor());

		System.out.println(serverIdentificationInfo1.getSupportUrl());

		System.out.println(serverIdentificationInfo1.getVersion());
	}

}
