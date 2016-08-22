package com.aspose.email.examples.pop3;

import com.aspose.email.HeaderCollection;
import com.aspose.email.Pop3Client;

public class RetrieveEmailHeaders {

	public static void main(String[] args) {
		Pop3Client client = new Pop3Client();
		client.setHost("exchange.aspose.com");
		client.setUsername("aspose-email.test3");
		client.setPassword("mahlakaaspose");

		HeaderCollection headers = client.getMessageHeaders(2);
		for (int i = 0; i < headers.size(); i++) {
			// Display key and value in the header collection
			System.out.print(headers.getKey(i));
			System.out.print(" : ");
			System.out.println(headers.get(i));
		}
	}

}
