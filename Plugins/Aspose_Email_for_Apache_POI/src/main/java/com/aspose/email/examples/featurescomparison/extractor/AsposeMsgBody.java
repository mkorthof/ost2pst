package com.aspose.email.examples.featurescomparison.extractor;

import com.aspose.email.MailMessage;
import com.aspose.email.MessageFormat;
import com.aspose.email.examples.Utils;

public class AsposeMsgBody
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(AsposeMsgBody.class);

        MailMessage msg = MailMessage.load(dataDir + "message.msg");

        System.out.println("Body:"+ msg.getBody());
        System.out.println("Text Body:"+ msg.getTextBody());
        System.out.println("Text Body HTML:"+ msg.getHtmlBody());
    }
}
