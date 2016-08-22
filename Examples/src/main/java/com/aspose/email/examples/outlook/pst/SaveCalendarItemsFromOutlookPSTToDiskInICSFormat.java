package com.aspose.email.examples.outlook.pst;

import com.aspose.email.AppointmentSaveFormat;
import com.aspose.email.FolderInfo;
import com.aspose.email.MapiCalendar;
import com.aspose.email.MessageInfo;
import com.aspose.email.MessageInfoCollection;
import com.aspose.email.PersonalStorage;
import com.aspose.email.examples.Utils;

public class SaveCalendarItemsFromOutlookPSTToDiskInICSFormat {

	public static String dataDir = Utils.getSharedDataDir(ChangeAFoldersContainerClass.class) + "outlook/";

	public static void main(String[] args) {
		// Load the Outlook PST file
		PersonalStorage pst = PersonalStorage.fromFile(dataDir + "Outlook.pst");
		
		// Get the Calendar folder
		FolderInfo folderInfo = pst.getRootFolder().getSubFolder("Calendar");
		
		// Loop through all the calendar items in this folder
		MessageInfoCollection messageInfoCollection = folderInfo.getContents();
		for (MessageInfo messageInfo : messageInfoCollection) {
			// Get the calendar information
			MapiCalendar calendar = (MapiCalendar) pst.extractMessage(messageInfo).toMapiMessageItem();
			// Display some contents on screen
			System.out.println("Name: " + calendar.getSubject());
			// Save to disk in ICS format
			calendar.save("Calendar: " + calendar.getSubject() + ".ics", AppointmentSaveFormat.Ics);
		}
	}

}
