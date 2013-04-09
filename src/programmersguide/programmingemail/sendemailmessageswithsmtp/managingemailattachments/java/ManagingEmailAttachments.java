/* 
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Email. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package programmersguide.programmingemail.sendemailmessageswithsmtp.managingemailattachments.java;

import com.aspose.email.*;

@SuppressWarnings("unchecked")

public class ManagingEmailAttachments
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/programmingemail/sendemailmessageswithsmtp/managingemailattachments/data/";


        // 1.
        // Add attachments

        //Create an instance of MailMessage class
        MailMessage message = new MailMessage();

        //From
        message.setFrom(new MailAddress("sender@sender.com"));

        //to whom
        message.getTo().add(new MailAddress("receiver@gmail.com"));

        //Adding 1st attachment
        //Create an instance of Attachment class
        Attachment attachment;

        //Load an attachment
        attachment = new Attachment(dataDir + "1.txt");

        //Add attachment in instance of MailMessage class
        message.getAttachments().add(attachment);

        //Add 2nd Attachment
        message.getAttachments().add(new Attachment(dataDir + "1.jpg"));

        //Add 3rd Attachment
        message.getAttachments().add(new Attachment(dataDir + "1.doc"));

        //Add 4th Attachment
        message.getAttachments().add(new Attachment(dataDir + "1.rar"));

        //Add 5th Attachment
        message.getAttachments().add(new Attachment(dataDir + "1.pdf"));

        //Save message to disk
        message.save(dataDir + "outputAttachments.msg",MessageFormat.getMsg());

        // Display status
        System.out.println("Attachments are added and resultant message is save successfully.");


        // 2.
        // Removing an attachment.
        System.out.println("Attachment Count: " + message.getAttachments().size());

        //Check if AttachmentCollection size is greater than 0
        if(message.getAttachments().size() > 0)
        {
            //Remove Attachment from index location 0
            message.getAttachments().remove(0);
            System.out.println("Attachment Count after removal of first attachment: " + message.getAttachments().size());
        }

        //Save message to disk
        message.save(dataDir + "outputAttachmentRemoved.msg",MessageFormat.getMsg());


        // 3.
        // Display remaining attachment names from message and save attachments

        //Initialize AttachmentCollection object with MailMessage Attachments
        AttachmentCollection attachments =  message.getAttachments();

        //Iterate over the AttachmentCollection
        for(int index = 0; index < attachments.size(); index++)
        {
            //Initialize Attachment object and Get the indexed Attachment reference
            Attachment atchmnt = (Attachment) attachments.get(index);

            //Display Attachment Name
            System.out.println(atchmnt.getName());

            //Save Attachment to disk
            String[] segments = atchmnt.getName().split("/");
            atchmnt.save(dataDir + "attachment_"+ segments[segments.length-1]);
        }

        // Display status
        System.out.println("\n\nAttachments addition, removal and retrieval has been performed successfully.");
    }
}




