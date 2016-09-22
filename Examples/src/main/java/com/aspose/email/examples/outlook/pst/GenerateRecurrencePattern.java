package com.aspose.email.examples.outlook.pst;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import com.aspose.email.AlternateView;
import com.aspose.email.Appointment;
import com.aspose.email.DateCollection;
import com.aspose.email.FileFormatVersion;
import com.aspose.email.FolderInfo;
import com.aspose.email.MailAddress;
import com.aspose.email.MailAddressCollection;
import com.aspose.email.MailMessage;
import com.aspose.email.MapiCalendar;
import com.aspose.email.MapiMessage;
import com.aspose.email.MessageInfo;
import com.aspose.email.PersonalStorage;
import com.aspose.email.RecurrencePattern;
import com.aspose.email.RecurrenceRule;
import com.aspose.email.WeeklyRecurrencePattern;
import com.aspose.email.examples.Utils;

public class GenerateRecurrencePattern {
	
	public static String dataDir = Utils.getSharedDataDir(GenerateRecurrencePattern.class) + "outlook/";
	
	public static void main(String[] args) {
		//Generate Recurrence Patterns
		generateOccurences();
		
		calculateNNextOccurrences();
	}

	public static void generateOccurences() {
		String tempFileName = dataDir + "NETWRKJAVA_33156.pst";
		
		//Prepare
		Appointment appointment = createAppointment();
		MailMessage mailMessage = createMessage();
		AlternateView alternateView = appointment.requestApointment();
		mailMessage.addAlternateView(alternateView);
		MapiMessage mapiMessage = MapiMessage.fromMailMessage(mailMessage);
		PersonalStorage pst = PersonalStorage.create(tempFileName, FileFormatVersion.Unicode);
		try {
			FolderInfo folder = pst.getRootFolder().addSubFolder("Calendar");
			folder.addMessage(mapiMessage);
		} finally {
			pst.dispose();
		}
		
		//Load
		pst = PersonalStorage.fromFile(tempFileName);
		try {
			FolderInfo folder = pst.getRootFolder().getSubFolder("Calendar");
			for (MessageInfo messageInfo : folder.getContents()) {
				MapiMessage message = pst.extractMessage(messageInfo);
				message.save(dataDir + "zzz_out.msg");
				MapiCalendar meeting = (MapiCalendar) message.toMapiMessageItem();
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				meeting.save(baos);
				String s = baos.toString();
				System.out.println(s);
				RecurrencePattern recurrencePattern = new RecurrencePattern( s);
				DateCollection occurrences = recurrencePattern.generateOccurrences();
				for (Object occurrence : occurrences) {
					System.out.println(occurrence);
				}
			}
		} finally {
			pst.dispose();
		}
		new File(tempFileName).delete();
	}

	public static Appointment createAppointment() {
		MailAddressCollection attendees = new MailAddressCollection();
		attendees.addItem(new MailAddress("attendee_address@aspose.com", "Attendee"));
		WeeklyRecurrencePattern expected = new WeeklyRecurrencePattern(3);
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		calendar.set(2016, Calendar.NOVEMBER, 1, 0, 0, 0);
		Date startDate = calendar.getTime();
		calendar.set(2016, Calendar.DECEMBER, 1);
		Date endDate = calendar.getTime();
		Appointment app = new Appointment("Appointment Location", "Appointment Summary", "Appointment Description", startDate, endDate, new MailAddress("organizer_address@aspose.com", "Organizer"),
				attendees, expected);
		return app;
	}

	public static MailMessage createMessage() {
		MailMessage mailMessage = new MailMessage("from_address@aspose.com", "to_address@aspose.com", "Mail Subject", "Mail Body");
		return mailMessage;
	}
	
	public static void calculateNNextOccurrences() {
		RecurrencePattern recurrencePattern = new RecurrencePattern();
		recurrencePattern.setStartDate(new Date());// = new DateTime(1997, 9, 10, 9, 0, 0);
		RecurrenceRule rule = recurrencePattern.getRules().add();
		rule.setFrequency(Frequency.Monthly);
		rule.setCount(2);
		rule.setInterval(18);
		rule.getByMonthDay().add(new int[] { 10, 11, 12, 13, 14, 15 });
		DateCollection expectedDates = recurrencePattern.generateOccurrences(1);
		System.out.println(expectedDates.size());
		for (Object occurrence : expectedDates) {
		    System.out.println(occurrence);
		}
	}
}
