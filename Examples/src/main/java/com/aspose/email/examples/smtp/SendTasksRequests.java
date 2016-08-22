package com.aspose.email.examples.smtp;

import com.aspose.email.FileCompatibilityMode;
import com.aspose.email.MailAddress;
import com.aspose.email.MailAddressCollection;
import com.aspose.email.MailMessage;
import com.aspose.email.MailMessageLoadOptions;
import com.aspose.email.MessageFormat;
import com.aspose.email.SmtpClient;
import com.aspose.email.examples.Utils;

public class SendTasksRequests {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(SendTasksRequests.class) + "SMTP/";
				
		MailMessageLoadOptions loadOptions = new MailMessageLoadOptions();
		loadOptions.setMessageFormat(MessageFormat.getMsg());
		loadOptions.setFileCompatibilityMode(FileCompatibilityMode.PreserveTnefAttachments);

		// load task from .msg file
		MailMessage eml = MailMessage.load(dataDir + "task.msg", loadOptions);
		eml.setFrom(new MailAddress("firstname.lastname@domain.com"));
		eml.getTo().clear();
		MailAddress address = new MailAddress("firstname.lastname@domain.com");
		MailAddressCollection addresses = new MailAddressCollection();
		addresses.addMailAddress(address);
		eml.setTo(addresses);

		SmtpClient client = new SmtpClient("smtp.gmail.com", 587, "brett.lee.aspose", "aspose1234");

		client.send(eml);
	}

}
