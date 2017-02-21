package com.aspose.email.examples.exchangeews;

import java.util.Calendar;
import java.util.Date;

import com.aspose.email.Appointment;
import com.aspose.email.EWSClient;
import com.aspose.email.ExchangeFolderInfoCollection;
import com.aspose.email.IEWSClient;
import com.aspose.email.MailAddress;
import com.aspose.email.MailAddressCollection;
import com.aspose.email.system.IDisposable;

public class AddEventToSecondaryCalendar {

	public static void main(String[] args) {
		// ExStart:AddEventToSecondaryCalendar
		IEWSClient client = null;
		try {
			client = EWSClient.getEWSClient("https://outlook.office365.com/exchangeews/exchange.asmx", "username", "password");

			Calendar calendar = Calendar.getInstance();
			Date startTime = calendar.getTime();
			calendar.add(java.util.Calendar.HOUR, 1);
			Date endTime = calendar.getTime();
			String timeZone = "America/New_York";

			Appointment appointment = new Appointment("Room 121", startTime, endTime, 
					MailAddress.to_MailAddress("email1@aspose.com"),
					MailAddressCollection.to_MailAddressCollection("email2@aspose.com"));
			appointment.setTimeZone(timeZone);
			appointment.setSummary("EMAILNET-35198 - ".concat(java.util.UUID.randomUUID().toString()));
			appointment.setDescription("EMAILNET-35198 Ability to add Java event to Secondary Calendar of Office 365");

			// Create new calendar folder
			client.createFolder(client.getMailboxInfo().getCalendarUri(), "new calendar", null, "IPF.Appointment");

			ExchangeFolderInfoCollection calendarSubFolders = client.listSubFolders(client.getMailboxInfo().getCalendarUri());
			String newCalendarFolderUri = calendarSubFolders.get_Item(0).getUri();

			// Appointment API with calendar folder URI
			// Create Appointment
			client.createAppointment(appointment, newCalendarFolderUri);

			// Update Appointment
			appointment.setLocation("Room 122");
			client.updateAppointment(appointment, newCalendarFolderUri);

			// List Appointments
			Appointment[] listAppointments = client.listAppointments(newCalendarFolderUri);

			// List default calendar folder
			listAppointments = client.listAppointments(client.getMailboxInfo().getCalendarUri());

			// Cancel Appointment
			client.cancelAppointment(appointment, newCalendarFolderUri);

			listAppointments = client.listAppointments(newCalendarFolderUri);

			// Appointment API with context current calendar folder URI
			client.setCurrentCalendarFolderUri(newCalendarFolderUri);

			// Create Appointment
			client.createAppointment(appointment);
			appointment.setLocation("Room 122");

			// Update Appointment
			client.updateAppointment(appointment);

			// List Appointments
			listAppointments = client.listAppointments();

			// List default calendar folder
			listAppointments = client.listAppointments(client.getMailboxInfo().getCalendarUri());

			// Cancel Appointment
			client.cancelAppointment(appointment);

			listAppointments = client.listAppointments();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (client != null)
				((IDisposable) client).dispose();
		}
		// ExEnd:AddEventToSecondaryCalendar
	}
}
