package com.aspose.email.examples.exchange;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aspose.email.Appointment;
import com.aspose.email.EWSClient;
import com.aspose.email.IEWSClient;
import com.aspose.email.MailAddress;
import com.aspose.email.MailAddressCollection;

public class CalendarItems {

	public static void main(String[] args) throws ParseException {
		IEWSClient client = EWSClient.getEWSClient("https://exchange.domain.com/ews/Exchange.asmx", "username", "password", "domain.com");
		
		// Create an appointment
		MailAddressCollection attendees = new MailAddressCollection();
		attendees.addItem(new MailAddress("attendee_address@aspose.com", "Attendee"));

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String strStartTime = "02-04-2013 11:30:00";
		Date startTime = dateformat.parse(strStartTime);
		String strEndTime = "02-04-2013 12:30:00";
		Date endTime = dateformat.parse(strEndTime);
		
		Appointment app = new Appointment("Room 112", startTime, endTime, new MailAddress("organizeraspose-email.test3@domain.com"), attendees);
		app.setTimeZone("GMT");
		String uid = client.createAppointment(app);
		
		// Update an appointment
		Appointment fetchedAppointment1 = client.fetchAppointment(uid);
		app.setLocation("Room 115");
		app.setSummary("New summary for " + app.getSummary());
		app.setDescription("New Description");
		client.updateAppointment(app);

		Appointment[] appointments1 = client.listAppointments();
		System.out.println("Total Appointments: " + appointments1.length);
		
		// Delete/Cancel an appointment
		Appointment fetchedAppointment2 = client.fetchAppointment(uid);
		System.out.println("Summary: " + fetchedAppointment2.getSummary());
		System.out.println("Location: " + fetchedAppointment2.getLocation());
		System.out.println("Description: " + fetchedAppointment2.getDescription());
		client.cancelAppointment(app);

		Appointment[] appointments2 = client.listAppointments();
		System.out.println("Total Appointments: " + appointments2.length);
	}
}
