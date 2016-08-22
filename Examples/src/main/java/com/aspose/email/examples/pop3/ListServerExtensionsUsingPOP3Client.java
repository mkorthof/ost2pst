package com.aspose.email.examples.pop3;

import com.aspose.email.Pop3Client;

public class ListServerExtensionsUsingPOP3Client {

	public static void main(String[] args) {
		Pop3Client client = new Pop3Client();
		client.setHost("pop.domain.com");
		client.setUsername("username");
		client.setPassword("password");

		String[] caps = client.getCapabilities();
		for (String str : caps)
			System.out.println(str);
	}
}
