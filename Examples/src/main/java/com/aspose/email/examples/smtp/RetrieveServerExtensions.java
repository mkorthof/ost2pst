package com.aspose.email.examples.smtp;

import com.aspose.email.SecurityOptions;
import com.aspose.email.SmtpClient;

public class RetrieveServerExtensions {

	public static void main(String[] args) {
		SmtpClient client = new SmtpClient("smtp.gmail.com",587,"username","password");
		client.setSecurityOptions(SecurityOptions.Auto);
		String[] caps = client.getCapabilities();
		for (String str:caps)
			System.out.println(str);
	}
	
}
