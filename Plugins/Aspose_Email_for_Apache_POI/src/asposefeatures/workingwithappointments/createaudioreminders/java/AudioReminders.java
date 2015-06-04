package asposefeatures.workingwithappointments.createaudioreminders.java;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import com.aspose.email.Appointment;
import com.aspose.email.AppointmentSaveFormat;
import com.aspose.email.MailAddress;
import com.aspose.email.MailAddressCollection;
import com.aspose.email.MailMessage;
import com.aspose.email.MapiCalendar;
import com.aspose.email.MapiMessage;
import com.aspose.email.WeeklyRecurrencePattern;

public class AudioReminders
{
	public static void main(String[] args)
	{
		String dataPath = "src/asposefeatures/workingwithappointments/createaudioreminders/data/";
		
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		calendar.set(2012, Calendar.NOVEMBER, 1, 0, 0, 0);
		Date startDate = calendar.getTime();
		calendar.set(2012, Calendar.DECEMBER, 1);
		Date endDate = calendar.getTime();

		MailAddressCollection attendees = new MailAddressCollection();
		attendees.addMailAddress(new MailAddress("attendee_address@domain.com", "Attendee"));
		WeeklyRecurrencePattern expected = new WeeklyRecurrencePattern(3);

		Appointment app = new Appointment("Appointment Location", "Appointment Summary", "Appointment Description",
											startDate, endDate,
											new MailAddress("organizer_address@domain.com", "Organizer"), attendees, expected);
		MailMessage msg = new MailMessage();
		msg.addAlternateView(app.requestApointment());
		MapiMessage mapi = MapiMessage.fromMailMessage(msg);
		MapiCalendar cal = (MapiCalendar)mapi.toMapiMessageItem();

		cal.setRemainderSet(true);
		cal.setRemainderDelta(58);//58 min before start of event
		cal.setReminderFileParameter(dataPath + "logon.wav");
		cal.save(dataPath + "AsposeAudioReminder.ics", AppointmentSaveFormat.Ics);
		
		System.out.println("Done");
	}
}