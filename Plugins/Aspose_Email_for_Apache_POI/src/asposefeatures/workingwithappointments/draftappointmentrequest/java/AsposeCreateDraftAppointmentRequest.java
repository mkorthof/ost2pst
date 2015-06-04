package asposefeatures.workingwithappointments.draftappointmentrequest.java;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import com.aspose.email.Appointment;
import com.aspose.email.AppointmentMethodType;
import com.aspose.email.MailAddress;
import com.aspose.email.MailAddressCollection;
import com.aspose.email.MailMessage;
import com.aspose.email.MapiMessage;
import com.aspose.email.WeeklyRecurrencePattern;

public class AsposeCreateDraftAppointmentRequest
{
	public static void main(String[] args)
	{
		String dataPath = "src/asposefeatures/workingwithappointments/draftappointmentrequest/data/";
		
		String sender = "test@gmail.com";
		String recipient = "test@email.com";

		MailMessage message = new MailMessage(sender, recipient, "", "");

		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		calendar.set(2012, Calendar.NOVEMBER, 1, 0, 0, 0);
		Date startDate = calendar.getTime();
		calendar.set(2012, Calendar.DECEMBER, 1);
		Date endDate = calendar.getTime();

		MailAddressCollection attendees = new MailAddressCollection();
		attendees.addMailAddress(new MailAddress("attendee_address@aspose.com", "Attendee"));
		WeeklyRecurrencePattern expected = new WeeklyRecurrencePattern(3);

		Appointment app = new Appointment("Appointment Location", "Appointment Summary", "Appointment Description",
		        startDate, endDate,
		        new MailAddress("organizer_address@aspose.com", "Organizer"), attendees, expected);

		//Set the Appointment as Draft
		app.setMethod(AppointmentMethodType.Publish);//.Method = AppointmentMethodType.Publish;

		message.addAlternateView(app.requestApointment());

		MapiMessage msg = MapiMessage.fromMailMessage(message);

		// Save the appointment as draft.
		msg.save(dataPath + "AsposeDraft.msg");
		
		System.out.println("Done");
	}
}
