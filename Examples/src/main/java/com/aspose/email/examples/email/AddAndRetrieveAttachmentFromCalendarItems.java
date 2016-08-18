package com.aspose.email.examples.email;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import com.aspose.email.Appointment;
import com.aspose.email.AppointmentSaveFormat;
import com.aspose.email.Attachment;
import com.aspose.email.MailAddress;
import com.aspose.email.MailAddressCollection;
import com.aspose.email.WeeklyRecurrencePattern;
import com.aspose.email.examples.Utils;

public class AddAndRetrieveAttachmentFromCalendarItems {

	public static void main(String[] args) throws IOException {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(AddAndRetrieveAttachmentFromCalendarItems.class) + "email/";
		
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		calendar.set(2016, Calendar.NOVEMBER, 1, 0, 0, 0);
		Date startDate = calendar.getTime();
		calendar.set(2016, Calendar.DECEMBER, 1);
		Date endDate = calendar.getTime();

		MailAddressCollection attendees = new MailAddressCollection();
		attendees.addMailAddress(new MailAddress("attendee_address@domain.com", "Attendee"));
		WeeklyRecurrencePattern expected = new WeeklyRecurrencePattern(3);

		Appointment app = new Appointment("Appointment Location", "Appointment Summary", "Appointment Description", startDate, endDate, new MailAddress("organizer_address@domain.com", "Organizer"),
				attendees, expected);

		//Attach a file from disc to this appointment
		File file = new File(dataDir + "sample.xlsx");
		FileInputStream fis = new FileInputStream(file);

		Attachment att = new Attachment(fis, file.getName());
		app.getAttachments().addItem(att);
		fis.close();
		String savedFile = "appWithAttachments.ics";
		app.save(dataDir + savedFile, AppointmentSaveFormat.Ics);

		Appointment app2 = Appointment.load(dataDir + savedFile);
		System.out.println("Total Attachments: " + app2.getAttachments().size());
		
		for (int i = 0; i < app2.getAttachments().size(); i++) {
			att = app2.getAttachments().get_Item(i);
			System.out.println(att.getName());

			//Save the attachment to disc
			att.save(dataDir + att.getName());
		}
	}
}
