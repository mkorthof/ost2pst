package com.aspose.email.examples.featurescomparison.loadnsave;

import com.aspose.email.MailMessage;
import com.aspose.email.MessageFormat;
import com.aspose.email.examples.Utils;

public class AsposeEmailSave
{
    public static void main(String[] args)
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(AsposeEmailSave.class);

        MailMessage messageMSG 	= MailMessage.load(dataDir + "message.msg");

        messageMSG.save(dataDir + "AsposeMessage.msg", MessageFormat.getMsg());
        messageMSG.save(dataDir + "AsposeMessage.eml", MessageFormat.getEml());
        messageMSG.save(dataDir + "AsposeMessage.emlx", MessageFormat.getEmlx());
        messageMSG.save(dataDir + "AsposeMessage.mht", MessageFormat.getMht());
    }
}
