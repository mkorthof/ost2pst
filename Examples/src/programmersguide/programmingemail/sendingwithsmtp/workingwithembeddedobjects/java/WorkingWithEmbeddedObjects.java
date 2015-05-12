/*
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Email. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */

package programmersguide.programmingemail.sendingwithsmtp.workingwithembeddedobjects.java;

import com.aspose.email.*;

public class WorkingWithEmbeddedObjects
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/programmingemail/sendingwithsmtp/workingwithembeddedobjects/data/";

        // Create a new instance of MailMessage class
        MailMessage message = new MailMessage();

        // Set sender information
        message.setFrom(new MailAddress("from@domain.com", "Sender Name", false));

        // Add recipients
        message.getTo().addItem(new MailAddress("to1@domain.com", "Recipient 1", false));
        message.getTo().addItem(new MailAddress("to2@domain.com", "Recipient 2", false));

        // Set subject of the message
        message.setSubject("New message created by Aspose.Email for Java");

        // Set Html body. It also contains <img> tag with cid. cid = LinkedResource.ContentID
        message.setHtmlBody("<b>This line is in bold.</b> <br/> <br/>"
                + "<font color=blue>This line is in blue color</font><br><br>" +
                "Here is an embedded image.<img src=cid:barcode>");

        // Add linked resource
        LinkedResource res = new LinkedResource(dataDir + "barcode.png");
        res.setContentId("barcode");

        // Add Linked resource to the message’s Linked resource colledction
        message.getLinkedResources().addItem(res);

        // Save message in MSG (optionally to EML and MHTML formats)
        //message.save(dataDir + "EmbeddedImage.eml", MailMessageSaveType.getEmlFormat());
        message.save(dataDir + "EmbeddedImage.msg", SaveOptions.getDefaultMsgUnicode());
        //message.save(dataDir + "EmbeddedImage.mhtml", MailMessageSaveType.getMHtmlFromat());

        // Display status
        System.out.println("\nEmbedded Image Object has been added to email message successfully.");
    }
}




