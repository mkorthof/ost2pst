package com.aspose.email.examples.asposefeatures.outlookstorage.readoft;

import com.aspose.email.MailAddress;
import com.aspose.email.MailMessage;
import com.aspose.email.MapiMessage;
import com.aspose.email.MapiMessageFlags;
import com.aspose.email.MessageFormat;
import com.aspose.email.examples.Utils;

public class AsposeReadOFT
{
    public static void main(String[] args)
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(AsposeReadOFT.class);

        // Load the Outlook template (OFT) file in MailMessage's instance
        MailMessage message = MailMessage.load(dataDir + "sample.oft");

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
        String meetingTime = "<u>" + "Monday, June 28, 2010" + "</u>";
        message.setHtmlBody(message.getHtmlBody().replace("MeetingPlace", meetingLocation));
        message.setHtmlBody(message.getHtmlBody().replace("MeetingTime", meetingTime));

        // Save the message in MSG format and open in Office Outlook
        MapiMessage mapimessage = new MapiMessage().fromMailMessage(message);
        mapimessage.setMessageFlags(MapiMessageFlags.MSGFLAG_UNSENT);
        mapimessage.save(dataDir + "AsposeInvitation.msg");

        System.out.println("Done");
    }
}