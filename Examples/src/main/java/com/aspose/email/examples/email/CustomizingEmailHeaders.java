/* 
 * Copyright 2001-2016 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Email. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */

package com.aspose.email.examples.email;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import com.aspose.email.MailAddress;
import com.aspose.email.MailMessage;
import com.aspose.email.SaveOptions;

public class CustomizingEmailHeaders {
	public static void main(String[] args) {

		// Create a new instance of MailMessage class
		MailMessage message = new MailMessage();

		// Set subject of the message
		message.setSubject("New message created by Aspose.Email for Java");

		// Set Html body
		message.setHtmlBody(
				"<b>This line is in bold.</b> <br/> <br/>" + "<font color=blue>This line is in blue color</font>");

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

		// Insert Header at Specific Location
		message.getHeaders().insert("Received", "Value");

		// Save message to disc
		message.save("MsgHeaders.msg", SaveOptions.getDefaultMsg());
	}
}
