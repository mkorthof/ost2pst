package com.aspose.email.examples.asposefeatures.programmingemail.readembeddedattachments;

import com.aspose.email.Attachment;
import com.aspose.email.MailMessage;
import com.aspose.email.MessageFormat;
import com.aspose.email.examples.Utils;

public class AsposeReadEmbeddedAttachments
{
    //private static String dataPath = "src/asposefeatures/programmingemail/readembeddedattachments/data/";
    // The path to the documents directory.
    private static String dataDir = Utils.getDataDir(AsposeReadEmbeddedAttachments.class);

    public static void main(String[] args)
    {
        try
        {
            System.out.println("Reading message with embedded messages....");

            MailMessage message = MailMessage.load(dataDir + "message.msg");
            ParseMessage(message);

            System.out.println("Success");
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        System.out.println("Done.");
    }

    private static void ParseMessage(MailMessage message)
    {
        System.out.println("Subject: " + message.getSubject());
        System.out.println("Extracting attachments....");
        for (int i = 0; i < message.getAttachments().size(); i++)
        {
            Attachment att = (Attachment) message.getAttachments().get_Item(i);
            System.out.println("Attachment Name: " + att.getName());

            // Get the name of attachment. If msg subject contains characters like :, /, \ etc., replace with space
            // because windows cannot save files with these characters
            // also save first 50 characters as file name to avoid long file names
            String attFileName = att.getName().replace(".eml", "").replace(":", " ").replace("\\", " ").replace("/", " ").replace("?", "");
            if (attFileName.length() > 50)
            {
                attFileName = attFileName.substring(0, 50);
            }
            String attExt = (att.getName().substring(att.getName().lastIndexOf("."), att.getName().lastIndexOf(".") + 4));

            // Save the attachment to disk
            att.save(dataDir + attFileName + attExt);

            // Check if it is an orphaned text attachment file (ATT00001.txt....) and of type eml
            if ((attExt.equals(".eml")) || (att.getContentType().getMediaType().equals("text/plain") && att.getName().contains(".txt") == true && att.getName().contains("ATT") == true))
            {
                // Try to load this text file in MailMessage
                MailMessage attMsg = MailMessage.load(dataDir + attFileName + attExt);
                // Call the function recursively to parse this message and attachments
                ParseMessage(attMsg);
            }
        }
    }
}