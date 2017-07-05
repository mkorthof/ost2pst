package com.aspose.email.examples.exchangeews;

import java.util.Calendar;
import java.util.UUID;

import com.aspose.email.Appointment;
import com.aspose.email.EWSClient;
import com.aspose.email.IEWSClient;
import com.aspose.email.MailAddress;
import com.aspose.email.MailAddressCollection;

public class CreatingUpdatingAndDeletingCalendarItemsUsingEWS {
    public static void main(String[] args)
    {
        // ExStart:CreatingUpdatingAndDeletingCalendarItemsUsingEWS
        IEWSClient client = EWSClient.getEWSClient("https://outlook.office365.com/exchangeews/exchange.asmx", "your.username", "your.password");
        Calendar date = Calendar.getInstance();
        Calendar startTime = Calendar.getInstance();
        startTime.set(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH), date.get(Calendar.HOUR_OF_DAY), 0, 0);
        Calendar endTime = Calendar.getInstance();
        endTime.set(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH), date.get(Calendar.HOUR_OF_DAY) + 1, 0, 0);
        String timeZone = "America/New_York";

        MailAddressCollection attendees = new MailAddressCollection();
        attendees.addMailAddress(new MailAddress("attendee_address@aspose.com", "Attendee"));

        Appointment app = new Appointment("Room 112", startTime.getTime(), endTime.getTime(), new MailAddress("organizeraspose-email.test3@domain.com"), attendees);
        app.setTimeZone(timeZone);
        app.setSummary("NETWORKNET-34136" + UUID.randomUUID().toString());
        app.setDescription("NETWORKNET-34136 Exchange 2007/EWS: Provide support for Add/Update/Delete calendar items");

        String uid = client.createAppointment(app);
        Appointment fetchedAppointment1 = client.fetchAppointment(uid);
        app.setLocation("Room 115");
        app.setSummary("New summary for " + app.getSummary());
        app.setDescription("New Description");
        client.updateAppointment(app);

        Appointment[] appointments1 = client.listAppointments();
        System.out.println("Total Appointments: "  + appointments1.length);
        Appointment fetchedAppointment2 = client.fetchAppointment(uid);
        System.out.println("Summary: " + fetchedAppointment2.getSummary());
        System.out.println("Location: " + fetchedAppointment2.getLocation());
        System.out.println("Description: " + fetchedAppointment2.getDescription());
        client.cancelAppointment(app);
        Appointment[] appointments2 = client.listAppointments();
        System.out.println("Total Appointments: " + appointments2.length);
        // ExEnd:CreatingUpdatingAndDeletingCalendarItemsUsingEWS
    }
}
