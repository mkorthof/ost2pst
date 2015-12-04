package com.aspose.email.examples.asposefeatures.appointments.getattachmentsfromcalender;

import com.aspose.email.Appointment;
import com.aspose.email.Attachment;
import com.aspose.email.examples.Utils;

public class AsposeGetAttachmentsFromCalender
{
    public static void main(String[] args)
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(AsposeGetAttachmentsFromCalender.class);

        String savedFile = dataDir + "AppWithAttachments.ics";

        Appointment app2 = Appointment.load(savedFile);
        System.out.println("Total Attachments: "  + app2.getAttachments().size());
        for (int i=0; i< app2.getAttachments().size();i++)
        {
                Attachment att = app2.getAttachments().get_Item(i);
                System.out.println(att.getName());

            //Save the attachment to disc
            att.save(dataDir + att.getName());
        }

        System.out.println("Done");
    }
}