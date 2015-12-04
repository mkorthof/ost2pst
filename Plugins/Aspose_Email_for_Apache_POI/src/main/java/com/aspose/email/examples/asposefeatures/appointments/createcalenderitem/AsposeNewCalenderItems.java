package com.aspose.email.examples.asposefeatures.appointments.createcalenderitem;

import java.util.Date;

import com.aspose.email.AppointmentSaveFormat;
import com.aspose.email.MapiCalendar;
import com.aspose.email.examples.Utils;

public class AsposeNewCalenderItems
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(AsposeNewCalenderItems.class);

        // Create the appointment
        MapiCalendar appointment = new MapiCalendar(
            "LAKE ARGYLE WA 6743",
            "Appointment",
            "This is a very important meeting :)",
            new Date(2012, 10, 2, 13, 0, 0),
            new Date(2012, 10, 2, 14, 0, 0));

        appointment.save(dataDir + "AsposeCalendarItem.ics", AppointmentSaveFormat.Ics);
    }
}