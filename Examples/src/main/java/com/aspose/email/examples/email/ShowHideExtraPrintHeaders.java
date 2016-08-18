package com.aspose.email.examples.email;

import com.aspose.email.MailMessage;
import com.aspose.email.MhtFormatOptions;
import com.aspose.email.MhtMessageFormatter;
import com.aspose.email.examples.Utils;

public class ShowHideExtraPrintHeaders {

	public static void main(String[] args) {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(ReadEmbeddedEmailAttachmentsFromMessage.class) + "email/";

		String pageHeader = "<div><div class='pageHeader'>&quot;Panditharatne, Mithra&quot; &lt;mithra.panditharatne@cibc.com&gt;<hr/></div>";
		MailMessage message = MailMessage.load(dataDir + "Message.eml");

		MhtMessageFormatter mailFormatter = new MhtMessageFormatter();
		int options = MhtFormatOptions.HideExtraPrintHeader | MhtFormatOptions.WriteCompleteEmailAddress;
		mailFormatter.format(message, options);
		if (!message.getHtmlBody().contains(pageHeader))
			System.out.println("True");
		else
			System.out.println("False");
	}
}
