/* 
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Email. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package programmersguide.programmingemail.sendemailmessageswithsmtp.loadsaveappointmentinicsformat.java;

import com.aspose.email.*;
import java.util.Date;

@SuppressWarnings("unchecked")

public class LoadSaveAppointmentInICSFormat
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/programmingemail/sendemailmessageswithsmtp/loadsaveappointmentinicsformat/data/";

        // 1.
        // Create and save an Appointment to disk.

        // Create and initialize an instance of the Appointment class
        MailAddressCollection cColletion = new MailAddressCollection();//("attendees@domain.com");
        cColletion.add("attendees@domain.com");

        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(2011, 2, 8, 13, 0, 0);

        java.util.Calendar cal1 = java.util.Calendar.getInstance();
        cal1.set(2011, 2, 8, 14, 0, 0);

        Date dateRepresentation = cal.getTime();
        Appointment appointment = new Appointment(
                "Meeting Room 3 at Office Headquarters",
                "Monthly Meeting",
                "Please confirm your availability.",
                cal.getTime(),
                cal1.getTime(),
                new MailAddress("from@domain.com"),
                cColletion);

        // Save the appointment to disk in ICS format
        appointment.save(dataDir + "test.ics", AppointmentSaveFormat.Ics);

        // Display Status.
        System.out.println("Appointment created and saved to disk successfully.");


        // 2.
        // Load an Appointment just created and saved to disk and display its details.

        // Load the appointment in ICS format
        Appointment loadedAppointment = Appointment.load(dataDir + "test.ics");

        // Display Status.
        System.out.println("\n\nLoaded Appointment details are as follows:");

        // Display the appointment information on screen
        System.out.println("Summary: " + loadedAppointment.getSummary());
        System.out.println("Location: " + loadedAppointment.getLocation());
        System.out.println("Description: " + loadedAppointment.getDescription());
        System.out.println("Start date: " + loadedAppointment.getStartDate());
        System.out.println("End date: " + loadedAppointment.getEndDate());
        System.out.println("Organizer: " + appointment.getOrganizer());
        System.out.println("Attendees: " + appointment.getAttendees());

        // Display Status.
        System.out.println("\nAppointment loaded and information displayed successfully.");
    }
}




