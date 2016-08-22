package com.aspose.email.examples.outlook.msg;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import com.aspose.email.Appointment;
import com.aspose.email.AppointmentSaveFormat;
import com.aspose.email.MailAddress;
import com.aspose.email.MailAddressCollection;
import com.aspose.email.MailMessage;
import com.aspose.email.MapiCalendar;
import com.aspose.email.MapiMessage;
import com.aspose.email.MapiRecipient;
import com.aspose.email.examples.Utils;

public class CalendarItems {

	public static void main(String[] args) {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(CalendarItems.class) + "outlook/";
		
		//Creating and Saving Calendar Items
		creatAndSaveCalendarItems(dataDir);
		
		//Saving the Calendar Item as MSG
		savingTheCalendarItemAsMSG(dataDir);
		
		//Adding Display Reminder to a Calendar
		addDisplayReminderToACalendar(dataDir);
		
		//Adding Audio Reminder to a Calendar
		addAudioReminderToACalendar(dataDir);
		
		//Getting Recipient Status from MapiCalendar
		getRecipientStatusFromMapiCalendar(dataDir);
	}

	public static void creatAndSaveCalendarItems(String dataDir) {
		// Create the appointment
		MapiCalendar appointment = new MapiCalendar();
		appointment.setLocation("LAKE ARGYLE WA 6743");
		appointment.setSubject("Appointment");
		appointment.setBody("This is a very important meeting");

		Date startDate = null;
		Calendar cal = GregorianCalendar.getInstance();
		cal.set(2016, 10, 2);
		startDate = cal.getTime();

		Date endDate = null;
		cal = GregorianCalendar.getInstance();
		cal.set(2016, 10, 3);
		endDate = cal.getTime();

		appointment.setStartDate(startDate);
		appointment.setEndDate(endDate);

		appointment.save(dataDir + "CalendarItem_out.ics", AppointmentSaveFormat.Ics);
	}

	public static void savingTheCalendarItemAsMSG(String dataDir) {
		// Create the appointment
		MapiCalendar appointment = new MapiCalendar();
		appointment.save(dataDir + "CalendarItemAsMSG_out.ics", AppointmentSaveFormat.Ics);
	}

	public static void addDisplayReminderToACalendar(String dataDir) {
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		calendar.set(2016, Calendar.NOVEMBER, 1, 0, 0, 0);
		Date startDate = calendar.getTime();
		calendar.set(2016, Calendar.DECEMBER, 1);
		Date endDate = calendar.getTime();
		
		MailAddressCollection attendees = new MailAddressCollection();
		attendees.addItem(new MailAddress("attendee_address@domain.com", "Attendee"));
		
		Appointment app = new Appointment("Home", startDate, endDate, new MailAddress("organizer@domain.com", "Organizer"), attendees);
		
		MailMessage msg = new MailMessage();
		msg.addAlternateView(app.requestApointment());
		MapiMessage mapi = MapiMessage.fromMailMessage(msg);
		MapiCalendar cal = (MapiCalendar) mapi.toMapiMessageItem();

		cal.setReminderSet(true);
		cal.setReminderDelta(45); //45 min before start of event

		String savedFile = dataDir + "calendarWithDisplayReminder_out.ics";
		cal.save(savedFile, AppointmentSaveFormat.Ics);
	}
	
	public static void addAudioReminderToACalendar(String dataDir) {
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		calendar.set(2016, Calendar.NOVEMBER, 1, 0, 0, 0);
		Date startDate = calendar.getTime();
		calendar.set(2016, Calendar.DECEMBER, 1);
		Date endDate = calendar.getTime();

		MailAddressCollection attendees = new MailAddressCollection();
		attendees.addItem(new MailAddress("attendee_address@domain.com", "Attendee"));

		Appointment app = new Appointment("Home", startDate, endDate, new MailAddress("organizer@domain.com", "Organizer"), attendees);
		
		MailMessage msg = new MailMessage();
		msg.addAlternateView(app.requestApointment());
		MapiMessage mapi = MapiMessage.fromMailMessage(msg);
		MapiCalendar cal = (MapiCalendar)mapi.toMapiMessageItem();

		cal.setReminderSet(true);
		cal.setReminderDelta(58); //58 min before start of event
		cal.setReminderFileParameter(dataDir + "Alarm01.wav");
		
		String savedFile = dataDir + "calendarWithAudioReminder_out.ics";
		cal.save(savedFile, AppointmentSaveFormat.Ics);
	}
	
	public static void getRecipientStatusFromMapiCalendar(String dataDir) {
		MapiMessage msg = MapiMessage.fromFile(dataDir + "messageMapi.msg");
		for (MapiRecipient rec : msg.getRecipients())
		{
		    System.out.println(rec.getRecipientTrackStatus());
		}
	}
}
