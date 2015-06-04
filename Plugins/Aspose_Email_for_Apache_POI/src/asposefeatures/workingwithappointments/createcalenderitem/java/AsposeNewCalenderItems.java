package asposefeatures.workingwithappointments.createcalenderitem.java;

import java.util.Date;

import com.aspose.email.AppointmentSaveFormat;
import com.aspose.email.MapiCalendar;

public class AsposeNewCalenderItems
{
	public static void main(String[] args) throws Exception
	{
		String dataPath = "src/asposefeatures/workingwithappointments/createcalenderitem/data/";
		
		// Create the appointment
		MapiCalendar appointment = new MapiCalendar(
		    "LAKE ARGYLE WA 6743",
		    "Appointment",
		    "This is a very important meeting :)",
		    new Date(2012, 10, 2, 13, 0, 0),
		    new Date(2012, 10, 2, 14, 0, 0));

		appointment.save(dataPath + "AsposeCalendarItem.ics", AppointmentSaveFormat.Ics);
		System.out.println("Calender Item Saved.");
	}
}