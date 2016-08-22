package com.aspose.email.examples.smtp;

import java.net.InetSocketAddress;

import com.aspose.email.BindIPEndPointHandler;
import com.aspose.email.SecurityOptions;
import com.aspose.email.SmtpClient;

public class BindSMTPClientToSpecificIPAddressOnHost {

	public static void main(String[] args) {
		SmtpClient client = new SmtpClient("smtp.domain.com", // host
				587, // port
				"username", // username
				"password", // password
				SecurityOptions.Auto // Security Options
		);
		try {
			client.bindIPEndPoint(new BindIPEndPointHandler() {
				@Override
				public InetSocketAddress invoke(InetSocketAddress remoteEndPoint) {
					return new InetSocketAddress(0);
				}
			});
			client.noop();
		} finally {
			if (client != null)
				client.dispose();
		}
	}

}
