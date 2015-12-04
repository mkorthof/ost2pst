package com.aspose.email.examples.asposefeatures.conversion.msgtootherformats;

import com.aspose.email.MailMessage;
import com.aspose.email.MailMessageSaveType;
import com.aspose.email.MessageFormat;
import com.aspose.email.examples.Utils;

public class AsposeConverter
{
    public static void main(String[] args)
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(AsposeConverter.class);

        // Initialize and Load an existing MSG file by specifying the MessageFormat
        MailMessage msg = MailMessage.load(dataDir + "message.msg");

        // Save the Email message to disk
        msg.save(dataDir + "AsposeMessage.eml");
        msg.save(dataDir + "Asposemessage.mhtml");

        System.out.println("Done");
    }
}