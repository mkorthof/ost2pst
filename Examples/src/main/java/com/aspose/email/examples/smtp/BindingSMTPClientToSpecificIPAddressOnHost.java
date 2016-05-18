/* 
 * Copyright 2001-2016 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Email. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */

package com.aspose.email.examples.smtp;

import java.net.InetSocketAddress;
import com.aspose.email.BindIPEndPointHandler;
import com.aspose.email.SecurityOptions;
import com.aspose.email.SmtpClient;

public class BindingSMTPClientToSpecificIPAddressOnHost {
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