package com.aspose.email.examples.email;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import com.aspose.email.MailAddress;
import com.aspose.email.MailMessage;
import com.aspose.email.SaveOptions;
import com.aspose.email.examples.Utils;

public class EmailHeaders {

	public static void main(String[] args) {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(EmailHeaders.class) + "email/";
		
		// Set Email Headers
		setEmailHeaders(dataDir);
		
		// Get Decoded Header Value from HeaderCollection
		getDecodedHeaderValueFromHeaderCollection(dataDir);
		
		// Insert Header at Specific Location
		insertHeaderAtSpecificLocation(dataDir);
		
		// Extracting Email Headers
		extractingEmailHeaders(dataDir);
	}
	
	public static void setEmailHeaders(String dataDir) {
		// Create a new instance of MailMessage class
		MailMessage message = new MailMessage();

		// Set subject of the message
		message.setSubject("New message created by Aspose.Email for Java");

		// Set Html body
		message.setHtmlBody("<b>This line is in bold.</b> <br/> <br/>" +
				"<font color=blue>This line is in blue color</font>");

		// Set sender information
		message.setFrom(new MailAddress("from@domain.com", "Sender Name", false));

		// Add TO recipients
		message.getTo().addItem(new MailAddress("to@domain.com", "Recipient 1", false));

		// Message subject
		message.setSubject("Customizing Email Headers");

		// Specify Date
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));

		Date date = calendar.getTime();
		message.setDate(date);

		// Specify XMailer
		message.setXMailer("Aspose.Email");

		// Specify Secret Header
		message.getHeaders().add("secret-header", "mystery");

		// Save message to disc
		message.save(dataDir + "SetEmailHeaders_out.msg", SaveOptions.getDefaultMsg());

	}
	
	public static void getDecodedHeaderValueFromHeaderCollection(String dataDir) {
		MailMessage mail = MailMessage.load(dataDir + "test.eml");
		String decodedValue = mail.getHeaders().getDecodedValue("Thread-Topic");
		System.out.println(decodedValue);
	}
	
	public static void insertHeaderAtSpecificLocation(String dataDir) {
		// Insert Header at Specific Location
		MailMessage eml = MailMessage.load(dataDir + "test.eml");
		eml.getHeaders().insert("Received", "Value");
	}
	
	public static void extractingEmailHeaders(String dataDir) {
		//Create MailMessage instance by loading an EML file
		MailMessage message = MailMessage.load(dataDir + "test.eml");

		System.out.println("Printing all Headers:\n\n");

		//Print out all the headers
		for (int i=0; i< message.getHeaders().size(); i++)
			System.out.println(message.getHeaders().get(i));
	}

}
