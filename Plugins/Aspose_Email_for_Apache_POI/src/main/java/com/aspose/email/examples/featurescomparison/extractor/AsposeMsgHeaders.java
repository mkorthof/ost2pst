package com.aspose.email.examples.featurescomparison.extractor;

import com.aspose.email.MailMessage;
import com.aspose.email.MessageFormat;
import com.aspose.email.examples.Utils;

public class AsposeMsgHeaders
{
    public static void main(String[] args)
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(AsposeMsgHeaders.class);

        MailMessage message = MailMessage.load(dataDir + "message.msg");

        //Gets Email Headers
        System.out.println("From: " 	+ message.getFrom());
        System.out.println("To: " 	+ message.getTo());
        System.out.println("CC: " 	+ message.getCC());
        System.out.println("Bcc: " 	+ message.getBcc());
        System.out.println("Subject: " 	+ message.getSubject());
    }
}
