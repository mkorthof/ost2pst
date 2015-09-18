package asposefeatures.workingwithappointments.addattachmentstocalenderitems.java;

import java.io.File;
import java.io.FileInputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import com.aspose.email.Appointment;
import com.aspose.email.AppointmentSaveFormat;
import com.aspose.email.Attachment;
import com.aspose.email.MailAddress;
import com.aspose.email.MailAddressCollection;
import com.aspose.email.WeeklyRecurrencePattern;

public class AddAttachmentToCalenderItems
{
	public static void main(String[] args) throws Exception
	{
		String dataPath = "src/asposefeatures/workingwithappointments/addattachmentstocalenderitems/data/";
		
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		calendar.set(2012, Calendar.NOVEMBER, 1, 0, 0, 0);
		Date startDate = calendar.getTime();
		calendar.set(2012, Calendar.DECEMBER, 1);
		Date endDate = calendar.getTime();

		MailAddressCollection attendees = new MailAddressCollection();
		attendees.addItem(new MailAddress("attendee_address@domain.com", "Attendee"));
		WeeklyRecurrencePattern expected = new WeeklyRecurrencePattern(3);

		Appointment app = new Appointment("Appointment Location", "Appointment Summary", "Appointment Description",
											startDate, endDate,
											new MailAddress("organizer_address@domain.com", "Organizer"), attendees, expected);

		//Attach a file from disc to this appointment
		File file = new File(dataPath + "AsposeXLS.xls");
		FileInputStream fis = new FileInputStream(file);

		Attachment att = new Attachment(fis, file.getName());
		app.getAttachments().addItem(att);
		fis.close();
		
		String savedFile = dataPath + "AppWithAttachments.ics";
		app.save(savedFile, AppointmentSaveFormat.Ics);
		
		System.out.println("Done.");
	}
}
