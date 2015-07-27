/* 
 * Copyright 2001-2015 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Email. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package com.aspose.email.examples.email;

import com.aspose.email.MailAddress;
import com.aspose.email.MailMessage;
import com.aspose.email.SaveOptions;
import com.aspose.email.examples.Utils;

public class DraftAppointmentRequest
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(DraftAppointmentRequest.class);

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
        message.getTo().addMailAddress(new MailAddress("to1@domain.com", "Recipient 1", false));
        message.getTo().addMailAddress(new MailAddress("to2@domain.com", "Recipient 2", false));

        //Add CC recipients
        message.getCC().addMailAddress(new MailAddress("cc1@domain.com", "Recipient 3", false));
        message.getCC().addMailAddress(new MailAddress("cc2@domain.com", "Recipient 4", false));

        // Save message in EML, MSG and MHTML formats
        message.save(dataDir + "Message.eml", SaveOptions.getDefaultEml());
        message.save(dataDir + "Message.msg", SaveOptions.getDefaultMsg());
        message.save(dataDir + "Message.mhtml", SaveOptions.getDefaultMhtml());

        // Display Status.
        System.out.println("New Emails created successfully.");
    }
}
