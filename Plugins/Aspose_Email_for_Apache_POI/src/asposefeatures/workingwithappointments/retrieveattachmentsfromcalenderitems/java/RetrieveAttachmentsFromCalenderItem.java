package asposefeatures.workingwithappointments.retrieveattachmentsfromcalenderitems.java;

import com.aspose.email.Appointment;
import com.aspose.email.Attachment;

public class RetrieveAttachmentsFromCalenderItem
{
	public static void main(String[] args)
	{
		String dataPath = "src/asposefeatures/workingwithappointments/retrieveattachmentsfromcalenderitems/data/";
				
		String savedFile = dataPath + "AppWithAttachments.ics";
		
		Appointment app2 = Appointment.load(savedFile);
		System.out.println("Total Attachments: "  + app2.getAttachments().size());
		for (int i=0; i< app2.getAttachments().size();i++)
		{
			Attachment att = app2.getAttachments().get_Item(i);
			System.out.println(att.getName());

	        //Save the attachment to disc
	        att.save(att.getName());
		}
	}
}