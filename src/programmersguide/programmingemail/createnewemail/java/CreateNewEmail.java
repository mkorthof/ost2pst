/* 
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Email. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package programmersguide.programmingemail.createnewemail.java;

import com.aspose.email.*;

public class CreateNewEmail
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/programmingemail/createnewemail/data/";

        // Create a new instance of MailMessage class
        MailMessage message = new MailMessage();

        // Set subject of the message
        message.setSubject("New message created by Aspose.Email for Java");

        // Set Html body
        message.setHtmlBody("<b>This line is in bold.</b> <br/> <br/>" +
                "<font color=blue>This line is in blue color</font>");

        // Set sender information
        message.setFrom(new MailAddress("from@domain.com", "Sender Name", false));

        // Add TO recipients
        message.getTo().add(new MailAddress("to1@domain.com", "Recipient 1", false));
        message.getTo().add(new MailAddress("to2@domain.com", "Recipient 2", false));

        //Add CC recipients
        message.getCC().add(new MailAddress("cc1@domain.com", "Recipient 3", false));
        message.getCC().add(new MailAddress("cc2@domain.com", "Recipient 4", false));

        // Save message in EML, MSG and MHTML formats
        message.save(dataDir + "Message.eml", MailMessageSaveType.getEmlFormat());
        message.save(dataDir + "Message.msg", MailMessageSaveType.getOutlookMessageFormat());
        message.save(dataDir + "Message.mhtml", MailMessageSaveType.getMHtmlFromat());

        // Display Status.
        System.out.println("New Emails created successfully.");
    }
}




