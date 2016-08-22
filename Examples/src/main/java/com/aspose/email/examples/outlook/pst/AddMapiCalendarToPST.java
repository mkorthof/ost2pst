package com.aspose.email.examples.outlook.pst;

import java.util.Calendar;
import java.util.Date;

import com.aspose.email.FileFormatVersion;
import com.aspose.email.FolderInfo;
import com.aspose.email.MapiCalendar;
import com.aspose.email.MapiRecipientCollection;
import com.aspose.email.MapiRecipientType;
import com.aspose.email.PersonalStorage;
import com.aspose.email.StandardIpmFolder;
import com.aspose.email.examples.Utils;

public class AddMapiCalendarToPST {
	
	public static String dataDir = Utils.getSharedDataDir(AddMapiTaskToPST.class) + "outlook/";
	
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2016);
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date startDate = cal.getTime();
		
		cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2016);
		cal.set(Calendar.MONTH, Calendar.FEBRUARY);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date endDate = cal.getTime();
				
		// Create the appointment
		MapiCalendar appointment = new MapiCalendar("LAKE ARGYLE WA 6743", "Appointment", "This is a very important meeting.", startDate, endDate);

		// Create the meeting
		MapiRecipientCollection attendees = new MapiRecipientCollection();
		attendees.add("ReneeAJones@armyspy.com", "Renee A. Jones", MapiRecipientType.MAPI_TO);
		attendees.add("SzllsyLiza@dayrep.com", "Szollosy Liza", MapiRecipientType.MAPI_TO);

		MapiCalendar meeting = new MapiCalendar("Meeting Room 3 at Office Headquarters", "Meeting", "Please confirm your availability.", startDate,
				endDate, "CharlieKhan@dayrep.com", attendees);
		PersonalStorage pst = PersonalStorage.create(dataDir + "MapiCalendarToPST_out.pst", FileFormatVersion.Unicode);
		FolderInfo calendarFolder = pst.createPredefinedFolder("Calendar", StandardIpmFolder.Appointments);
		calendarFolder.addMapiMessageItem(appointment);
		calendarFolder.addMapiMessageItem(meeting);
	}

}
