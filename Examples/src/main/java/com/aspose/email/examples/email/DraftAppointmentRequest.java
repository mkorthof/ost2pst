package com.aspose.email.examples.email;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import com.aspose.email.AlternateView;
import com.aspose.email.Appointment;
import com.aspose.email.AppointmentMethodType;
import com.aspose.email.ContentType;
import com.aspose.email.MailAddress;
import com.aspose.email.MailAddressCollection;
import com.aspose.email.MailMessage;
import com.aspose.email.MapiMessage;
import com.aspose.email.examples.Utils;

public class DraftAppointmentRequest {

	public static void main(String[] args) {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(SaveMessageAsDraft.class) + "email/";
		
		//Create a Draft Appointment Request
		createADraftAppointmentRequest(dataDir);
		
		// Draft Appointment Creation from Text
		draftAppointmentCreationFromText(dataDir);
	}

	public static void createADraftAppointmentRequest(String dataDir) {
		String sender = "test@gmail.com";
		String recipient = "test@email.com";

		MailMessage message = new MailMessage(sender, recipient, "", "");

		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		calendar.set(2016, Calendar.NOVEMBER, 1, 0, 0, 0);
		Date startDate = calendar.getTime();
		calendar.set(2016, Calendar.DECEMBER, 1);
		Date endDate = calendar.getTime();

		MailAddressCollection attendees = new MailAddressCollection();
		attendees.addMailAddress(new MailAddress("attendee_address@aspose.com", "Attendee"));
		//WeeklyRecurrencePattern expected = new WeeklyRecurrencePattern(3);

		Appointment app = new Appointment("", startDate, endDate, new MailAddress("organizer_address@aspose.com", "Organizer"), attendees);
		/*
		 * Appointment app = new Appointment("Appointment Location",
		 * "Appointment Summary", "Appointment Description", startDate, endDate,
		 * new MailAddress("organizer_address@aspose.com", "Organizer"),
		 * attendees, expected);
		 */
		//Set the Appointment as Draft
		app.setMethod(AppointmentMethodType.Publish);

		message.addAlternateView(app.requestApointment());

		MapiMessage msg = MapiMessage.fromMailMessage(message);

		// Save the appointment as draft.
		msg.save(dataDir + "appointment-draft.msg");
	}

	public static void draftAppointmentCreationFromText(String dataDir) {
		String ical = "BEGIN:VCALENDAR\r\nMETHOD:PUBLISH\r\nPRODID:-//Aspose Ltd//iCalender Builder (v3.0)//EN\r\nVERSION:2.0\r\nBEGIN:VEVENT\r\nATTENDEE;CN=test@gmail.com:mailto:test@gmail.com\r\nDTSTART:20130220T171439\r\nDTEND:20130220T174439\r\nDTSTAMP:20130220T161439Z\r\nEND:VEVENT\r\nEND:VCALENDAR";

		String sender = "test@gmail.com";
		String recipient = "test@email.com";

		MailMessage message = new MailMessage(sender, recipient, "", "");
		AlternateView av = AlternateView.createAlternateViewFromString(ical, new ContentType("text/calendar"));
		message.getAlternateViews().addItem(av);
		MapiMessage msg = MapiMessage.fromMailMessage(message);

		// Save the appointment as draft.
		msg.save(dataDir + "DraftAppointment.msg");
	}

}
