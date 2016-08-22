package com.aspose.email.examples.smtp;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import com.aspose.email.Appointment;
import com.aspose.email.MailAddress;
import com.aspose.email.MailAddressCollection;
import com.aspose.email.MailMessage;
import com.aspose.email.SecurityOptions;
import com.aspose.email.SmtpClient;

public class SendMeetingRequest {

	public static void main(String[] args) {
		//Initialize SmtpClient object
		SmtpClient client = new SmtpClient("smtp.gmail.com", 587, "senderUserName", "password");

		//Set Security options for the server
		client.setSecurityOptions(SecurityOptions.Auto);

		//Create an instance of the MailMessage class
		MailMessage msg = new MailMessage();
		msg.setFrom(new MailAddress("senderEmail@gmail.com"));

		//Set the recipient, who will receive the meeting request.
		//Basically, the recipient is the same as the meeting attendees.
		MailAddressCollection coll = new MailAddressCollection();
		coll.addItem(new MailAddress("recepientEmail@gmail.com"));
		msg.setTo(coll);

		//Set the start and end date of meeting
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		calendar.set(2015, Calendar.JANUARY, 19, 19, 0, 0); //19 Jan, 2015 - 1900
		Date startDate = calendar.getTime();
		calendar.set(2015, Calendar.JANUARY, 19, 20, 0, 0);
		Date endDate = calendar.getTime();

		//create Appointment instance
		Appointment app = new Appointment("Room 112", //location
				startDate, //start time
				endDate, //end time
				msg.getFrom(), //organizer
				msg.getTo() //attendee
		);

		app.setSummary("Demonstration of Aspose.Email Smtp Client's Capabilities");
		app.setDescription("Discuss for the next release");

		//add appointment to the message
		msg.addAlternateView(app.requestApointment());

		//Send the Meeting request
		client.send(msg);
	}
}
