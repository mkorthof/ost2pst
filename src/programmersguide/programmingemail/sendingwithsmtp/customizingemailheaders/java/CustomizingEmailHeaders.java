/*
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Email. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */

package programmersguide.programmingemail.sendingwithsmtp.customizingemailheaders.java;

import com.aspose.email.MailAddress;
import com.aspose.email.MailMessage;
import com.aspose.email.MessageFormat;

import java.io.File;
import java.util.Date;

public class CustomizingEmailHeaders
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/programmingemail/sendingwithsmtp/customizingemailheaders/data/";
        new File(dataDir).mkdirs();

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
        message.getTo().addItem(new MailAddress("to@domain.com", "Recipient 1", false));

        // Add CC recipients
        message.getCc().addItem(new MailAddress("cc@domain.com", "Recipient 2", false));

        // Add BCC recipients
        message.getBcc().addItem(new MailAddress("bcc@domain.com", "Recipient 3", false));

        //Message subject
        message.setSubject("Customizing Email Headers");

        //Specify Date
        java.util.Calendar calendar = java.util.Calendar.getInstance(java.util.TimeZone.getTimeZone("GMT"));

        Date date = calendar.getTime();
        message.setDate(date);

        //Specify XMailer
        message.setXMailer("Aspose.Email");

        //Specify Secret Header
        message.getHeaders().add("secret-header", "mystery");

        //Save message to disc
        message.save(dataDir + "MsgHeaders.msg", SaveOptions.getDefaultMsgUnicode());

        // Display status
        System.out.println("\nMessage Header has been added to email message successfully.");
    }
}




