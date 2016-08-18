package com.aspose.email.examples.email;

import com.aspose.email.Appointment;
import com.aspose.email.AppointmentFormattingOptions;
import com.aspose.email.examples.Utils;

public class FormattingAnAppointment {

	public static void main(String[] args) {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(FormattingAnAppointment.class) + "email/";
		// Text Formatting
		textFormatting(dataDir);
		
		// HTML Formatting
		htmlFormatting(dataDir);
	}

	public static void textFormatting(String dataDir) {
		Appointment appointment = Appointment.load(dataDir + "test.ics");
		AppointmentFormattingOptions formattingOptions = new AppointmentFormattingOptions();
		formattingOptions.setLocationFormat("Where: {0}");
		formattingOptions.setTitleFormat("Subject: {0}");
		formattingOptions.setDescriptionFormat("\r\n*~*~*~*~*~*~*~*~*~*\r\n{0}");
		System.out.println(appointment.getAppointmentText(formattingOptions));
	}
	
	public static void htmlFormatting(String dataDir) {
		Appointment appointment = Appointment.load(dataDir + "test.ics");
		AppointmentFormattingOptions formattingOptions = AppointmentFormattingOptions.createAsHtml();
		formattingOptions.setLocationFormat("<FONT SIZE=2 FACE=\"Arial\"><b>Where: {0}</b></FONT><BR>");
		formattingOptions.setTitleFormat("<FONT SIZE=2 FACE=\"Arial\"><b>Subject: {0}</b></FONT><BR>");
		formattingOptions.setDescriptionFormat("<P><FONT SIZE=2 FACE=\"Arial\">-----------<br><i>{0}</i></FONT></P>");
		System.out.println(appointment.getAppointmentText(formattingOptions));
	}

}
