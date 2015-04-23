/*
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Email. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */

package programmersguide.programmingemail.asposeemailhowtos.draftappointmentrequest.java;

import com.aspose.email.*;

import java.io.File;
import java.util.Date;
import java.util.TimeZone;

public class DraftAppointmentRequest
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/programmingemail/asposeemailhowtos/draftappointmentrequest/data/";
        new File(dataDir).mkdirs();

        String sender = "test@gmail.com";
        String recipient = "test@email.com";

        MailMessage message = new MailMessage(sender, recipient, "", "");

        java.util.Calendar calendar = java.util.Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        calendar.set(2012, java.util.Calendar.NOVEMBER, 1, 0, 0, 0);
        Date startDate = calendar.getTime();
        calendar.set(2012, java.util.Calendar.DECEMBER, 1);
        Date endDate = calendar.getTime();

        MailAddressCollection attendees = new MailAddressCollection();
        attendees.addItem(new MailAddress("attendee_address@aspose.com", "Attendee"));
        WeeklyRecurrencePattern expected = new WeeklyRecurrencePattern(3);



        Appointment app = new Appointment("Appointment Location", "Appointment Summary", "Appointment Description",
                startDate, endDate,
                new MailAddress("organizer_address@aspose.com", "Organizer"), attendees, expected);


        //Set the Appointment as Draft
        app.setMethod(AppointmentMethodType.Publish);//.Method = AppointmentMethodType.Publish;

        message.addAlternateView(app.requestApointment());

        MapiMessage msg = MapiMessage.fromMailMessage(message);

        // Save the appointment as draft.
        msg.save(dataDir + "draftAppointment.msg");

        // Display Status.
        System.out.println("Appointment Draft has been created successfully.");
    }
}




