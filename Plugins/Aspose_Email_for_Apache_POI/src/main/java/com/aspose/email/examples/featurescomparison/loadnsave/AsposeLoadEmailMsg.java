package com.aspose.email.examples.featurescomparison.loadnsave;

import com.aspose.email.MailMessage;
import com.aspose.email.MessageFormat;
import com.aspose.email.examples.Utils;

public class AsposeLoadEmailMsg
{
    public static void main(String[] args)
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(AsposeLoadEmailMsg.class);

        //Create MailMessage instance by loading an Eml/Msg/Emlx/Mht file
        MailMessage messageMSG 	= MailMessage.load(dataDir + "message.msg");
        MailMessage messageEML 	= MailMessage.load(dataDir + "message.eml");
        MailMessage messageEMLX = MailMessage.load(dataDir + "message.emlx");
        MailMessage messageMHT 	= MailMessage.load(dataDir + "message.mht");
    }
}
