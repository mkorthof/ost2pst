/* 
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Email. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package programmersguide.programmingemail.savemessageasdraft.java;

import com.aspose.email.*;

public class SaveMessageAsDraft
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/programmingemail/savemessageasdraft/data/";

        // Create a new instance of MailMessage class
        MailMessage message = new MailMessage();

        // Set sender information
        message.setFrom(new MailAddress("from@domain.com", "Sender Name", false));

        // Add recipients
        message.getTo().add(new MailAddress("to1@domain.com", "Recipient 1", false));
        message.getTo().add(new MailAddress("to2@domain.com", "Recipient 2", false));

        // Set subject of the message
        message.setSubject("New message created by Aspose.Email for Java");

        // Set Html body of the message
        message.setHtmlBody("<b>This line is in bold.</b> <br/> <br/>"
                + "<font color=blue>This line is in blue color</font>");

        // Create an instance of MapiMessage and load the MailMessag instance into it
        MapiMessage mapiMsg = MapiMessage.fromMailMessage(message);

        // Set the MapiMessageFlags as UNSENT and FROMME
        mapiMsg.setMessageFlags(MapiMessageFlags.MSGFLAG_UNSENT | MapiMessageFlags.MSGFLAG_FROMME);

        // Save the MapiMessage to disk
        mapiMsg.save(dataDir + "New-Draft.msg");

        // Display Status.
        System.out.println("Message saved as draft successfully.");
    }
}




