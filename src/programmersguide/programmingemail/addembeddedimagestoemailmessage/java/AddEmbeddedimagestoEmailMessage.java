/* 
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Email. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package programmersguide.programmingemail.addembeddedimagestoemailmessage.java;

import com.aspose.email.*;

public class AddEmbeddedimagestoEmailMessage
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/programmingemail/addembeddedimagestoemailmessage/data/";
        
        // Create a new instance of MailMessage class
        MailMessage message = new MailMessage();

        // Set sender information
        message.setFrom(new MailAddress("from@domain.com", "Sender Name", false));

        // Add recipients
        message.getTo().add(new MailAddress("to1@domain.com", "Recipient 1", false));
        message.getTo().add(new MailAddress("to2@domain.com", "Recipient 2", false));

        // Set subject of the message
        message.setSubject("New message created by Aspose.Email for Java");

        // Set Html body. It also contains <img> tag with cid. cid = LinkedResource.ContentID
        message.setHtmlBody("<b>This line is in bold.</b> <br/> <br/>"
                + "<font color=blue>This line is in blue color</font><br><br>" +
                "Here is an embedded image.<img src=cid:companylogo>");

        // Add linked resource
        LinkedResource res = new LinkedResource(dataDir + "aspose-logo.png");
        res.setContentId("companylogo");

        // Add Linked resource to the message’s Linked resource colledction
        message.getLinkedResources().add(res);

        // Save message in EML, MSG and MHTML formats
        message.save(dataDir + "message.out.eml", MailMessageSaveType.getEmlFormat());
        message.save(dataDir + "message.out.msg", MailMessageSaveType.getOutlookMessageFormat());
        message.save(dataDir + "message.out.mhtml", MailMessageSaveType.getMHtmlFromat());
        
        //Print message
        System.out.println("Image embedded in email message successfully. Check output files.");
    }
}