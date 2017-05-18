package com.aspose.email.examples.outlook.pst;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import com.aspose.email.FileFormatVersion;
import com.aspose.email.FolderInfo;
import com.aspose.email.MapiCalendar;
import com.aspose.email.MapiCalendarDailyRecurrencePattern;
import com.aspose.email.MapiCalendarEventRecurrence;
import com.aspose.email.MapiCalendarExceptionInfo;
import com.aspose.email.MapiCalendarRecurrenceEndType;
import com.aspose.email.MapiCalendarRecurrencePattern;
import com.aspose.email.MapiCalendarRecurrencePatternType;
import com.aspose.email.MapiRecipientCollection;
import com.aspose.email.MapiRecipientType;
import com.aspose.email.PersonalStorage;
import com.aspose.email.StandardIpmFolder;

public class ModifyDeleteOccurrencesFromRecurrence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static void modifyDeleteOccurrenceFromRecurrence() throws IOException
	{
		//ExStart: ModifyDeleteOccurrencesFromRecurrence
		Date startDate = addHours(new Date(), 12);

		MapiCalendarEventRecurrence recurrence = new MapiCalendarEventRecurrence();
		recurrence.setRecurrencePattern(new MapiCalendarDailyRecurrencePattern());
		
		MapiCalendarRecurrencePattern pattern = recurrence.getRecurrencePattern();
		pattern.setPatternType(MapiCalendarRecurrencePatternType.Day);
		pattern.setPeriod(1);
		pattern.setEndType(MapiCalendarRecurrenceEndType.NeverEnd);

		Date exceptionDate = addDays(startDate, 1);

		// adding one exception
		MapiCalendarExceptionInfo exceptionInfo = new MapiCalendarExceptionInfo();
		exceptionInfo.setLocation("London");
		exceptionInfo.setSubject("Subj");
		exceptionInfo.setOriginalStartDate(exceptionDate);
		exceptionInfo.setStartDateTime(exceptionDate);
		exceptionInfo.setEndDateTime(addHours(exceptionDate, 5));
		pattern.getExceptions().addItem(exceptionInfo);
		pattern.getModifiedInstanceDates().addItem(exceptionDate);
		
		// every modified instance also has to have an entry in the DeletedInstanceDates field with the original instance date.
		pattern.getDeletedInstanceDates().addItem(exceptionDate);

		// adding one deleted instance
		pattern.getDeletedInstanceDates().addItem(addHours(exceptionDate, 2));

		MapiRecipientCollection recColl = new MapiRecipientCollection();
		recColl.add("recepient@gmail.com", "R1", MapiRecipientType.MAPI_TO);
		
		MapiCalendar newCal = new MapiCalendar(
		    "This is Location",
		    "This is Summary",
		    "This is recurrence test",
		    startDate,
		    addHours(startDate, 3),
		    "organizer@domain.com",
		    recColl);
		newCal.setRecurrence(recurrence);

		ByteArrayOutputStream memory = new ByteArrayOutputStream();
		try {
		    PersonalStorage pst = PersonalStorage.create(memory, FileFormatVersion.Unicode);
		    
		    FolderInfo calendarFolder = pst.createPredefinedFolder("Calendar", StandardIpmFolder.Appointments);
		    
		    calendarFolder.addMapiMessageItem(newCal);
		}
		finally {
		    memory.close();
		}
		//ExEnd: ModifyDeleteOccurrencesFromRecurrence
	}
	
	static Date addHours(Date date, int amount) {
	    Calendar c = Calendar.getInstance();
	    c.setTime(date);
	    c.add(Calendar.HOUR, amount);
	    return c.getTime();
	}

	static Date addDays(Date date, int amount) {
	    Calendar c = Calendar.getInstance();
	    c.setTime(date);
	    c.add(Calendar.DATE, amount);
	    return c.getTime();
	}
}
