package com.aspose.email.examples.asposefeatures.appointments.formattingappointment;

import com.aspose.email.Appointment;
import com.aspose.email.AppointmentFormattingOptions;
import com.aspose.email.examples.Utils;

public class AsposeFormatAppointments
{
    public static void main(String[] args)
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(AsposeFormatAppointments.class);

        Appointment appointment = Appointment.load(dataDir + "appointment.ics");
        AppointmentFormattingOptions formattingOptions = new AppointmentFormattingOptions();
        formattingOptions.setLocationFormat("Where: {0}");
        formattingOptions.setTitleFormat("Subject: {0}");
        formattingOptions.setDescriptionFormat("\r\n*~*~*~*~*~*~*~*~*~*\r\n{0}");
        System.out.println(appointment.getAppointmentText(formattingOptions));
    }
}
