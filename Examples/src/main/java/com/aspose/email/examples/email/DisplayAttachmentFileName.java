package com.aspose.email.examples.email;

import com.aspose.email.Attachment;
import com.aspose.email.MailMessage;
import com.aspose.email.SaveOptions;
import com.aspose.email.examples.Utils;

/*
This project uses automatic dependency resolution feature of Maven to resolve Aspose.Email for Java API reference when the project is build. Please check https://maven.apache.org/what-is-maven.html for more information. If you do not wish to use Maven, you can manually download Aspose.Email for Java API from http://www.aspose.com/downloads, install it and then add its reference to this project. For any issues, questions or suggestions please feel free to contact us using http://www.aspose.com/community/forums/default.aspx
 */

public class DisplayAttachmentFileName {
    public  static void  main(String[] args)
    {
        // The path to the resource directory.
        String dataDir = Utils.getSharedDataDir(DisplayAttachmentFileName.class) + "email/";

        MailMessage message = MailMessage.load(dataDir + "messageWithAtt.eml");

        // ExStart:DisplayAttachmentFileName
        // Create a loop to display the no. of attachments present in email message
        for (Attachment attachment : message.getAttachments())
        {
            // Save your attachments here and Display the the attachment file name
            attachment.save(dataDir + attachment.getName());
            System.out.println(attachment.getName());
        }
        // ExEnd:DisplayAttachmentFileName
    }
}