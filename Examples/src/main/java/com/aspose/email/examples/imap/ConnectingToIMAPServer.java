package com.aspose.email.examples.imap;

import com.aspose.email.ImapClient;
import com.aspose.email.SecurityOptions;

public class ConnectingToIMAPServer {

	public static void main(String[] args) {
		connectingToIMAPServer();
		connectingToAnSSLEnabledIMAPServer();
	}

	public static void connectingToIMAPServer() {
		ImapClient client = new ImapClient();
		client.setHost("imap.domain.com");
		client.setPort(993);
		client.setUsername("username");
		client.setPassword("password");
	}

	public static void connectingToAnSSLEnabledIMAPServer() {
		ImapClient client = new ImapClient();
		client.setHost("imap.gmail.com");
		client.setPort(993);
		client.setUsername("username");
		client.setPassword("password");
		client.setSecurityOptions(SecurityOptions.Auto);
	}

}
