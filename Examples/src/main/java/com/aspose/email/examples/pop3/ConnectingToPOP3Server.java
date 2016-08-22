package com.aspose.email.examples.pop3;

import com.aspose.email.Pop3Client;
import com.aspose.email.SecurityOptions;

public class ConnectingToPOP3Server {

	public static void main(String[] args) {
		//Connecting to a POP3 server
		connectingToPOP3Server();
		
		//Connecting to an SSL-Enabled POP3 Server
		connectingToAnSSLEnabledPOP3Server();
	}

	public static void connectingToPOP3Server() {
		Pop3Client client = new Pop3Client();
		client.setHost("pop.domain.com");
		client.setPort(110); //This can be different from server to server
		client.setUsername("username");
		client.setPassword("password");
	}

	public static void connectingToAnSSLEnabledPOP3Server() {
		Pop3Client client = new Pop3Client();
		client.setHost("pop.domain.com");
		client.setPort(587); //This can be different from server to server
		client.setUsername("username");
		client.setPassword("password");
		client.setSecurityOptions(SecurityOptions.Auto);
	}

}
