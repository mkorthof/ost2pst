/*
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Email. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */

package programmersguide.programmingoutlook.workwithoutlookmsgfiles.readoutlooktemplatefile.java;

import com.aspose.email.*;

public class ReadOutlookTemplateFile
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/programmingoutlook/workwithoutlookmsgfiles/readoutlooktemplatefile/data/";

        // Load the Outlook template (OFT) file in MailMessage's instance
        MailMessage message = MailMessage.load(dataDir + "sample.oft", MailMessageLoadOptions.getDefaultMsg());

        // Set the sender and recipients information
        String senderDisplayName = "John";
        String senderEmailAddress = "john@abc.com";
        String recipientDisplayName = "William";
        String recipientEmailAddress = "william@xzy.com";

        message.setSender(new MailAddress(senderEmailAddress, senderDisplayName));
        message.getTo().addMailAddress(new MailAddress(recipientEmailAddress, recipientDisplayName));

        message.setHtmlBody(message.getHtmlBody().replace("DisplayName", "<b>" + recipientDisplayName + "</b>"));

        // Set the name, location and time in email body
        String meetingLocation = "<u>" + "Hall 1, Convention Center, New York, USA" + "</u>";
        String meetingTime = "<u>" + "Monday, June 28, 2013" + "</u>";

        message.setHtmlBody(message.getHtmlBody().replace("MeetingPlace", meetingLocation));
        message.setHtmlBody(message.getHtmlBody().replace("MeetingTime", meetingTime));

        // Save the message in MSG format and open in Office Outlook
        MapiMessage mapimessage = MapiMessage.fromMailMessage(message);
        mapimessage.setMessageFlags(MapiMessageFlags.MSGFLAG_UNSENT);
        mapimessage.save(dataDir + "invitation.msg");

        System.out.println("Successfully created message file from template.");
    }
}
