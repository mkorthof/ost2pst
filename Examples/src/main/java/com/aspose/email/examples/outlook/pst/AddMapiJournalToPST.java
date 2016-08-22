package com.aspose.email.examples.outlook.pst;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Date;

import com.aspose.email.FileFormatVersion;
import com.aspose.email.FolderInfo;
import com.aspose.email.MapiJournal;
import com.aspose.email.PersonalStorage;
import com.aspose.email.StandardIpmFolder;
import com.aspose.email.examples.Utils;

public class AddMapiJournalToPST {

	public static String dataDir = Utils.getSharedDataDir(AddMapiTaskToPST.class) + "outlook/";

	public static void main(String[] args) throws FileNotFoundException {
		// Create a New MapiJournal and Add to Journal subfolder
		addMapiJournalToPST();

		//Add Attachments to MapiJournal
		addAttachmentsToMapiJournal();
	}

	public static void addMapiJournalToPST() {
		Date d1 = new Date();
		Calendar cl = Calendar.getInstance();
		cl.setTime(d1);
		cl.add(Calendar.HOUR, 1);
		Date d2 = cl.getTime();

		MapiJournal journal = new MapiJournal("daily record", "called out in the dark", "Phone call", "Phone call");
		journal.setStartTime(d1);
		journal.setEndTime(d2);
		PersonalStorage pst = PersonalStorage.create(dataDir + "JournalPST_out.pst", FileFormatVersion.Unicode);
		FolderInfo journalFolder = pst.createPredefinedFolder("Journal", StandardIpmFolder.Journal);
		journalFolder.addMapiMessageItem(journal);
	}

	public static void addAttachmentsToMapiJournal() throws FileNotFoundException {
		Date d1 = new Date();
		Calendar cl = Calendar.getInstance();
		cl.setTime(d1);
		cl.add(Calendar.HOUR, 1);
		Date d2 = cl.getTime();

		MapiJournal journal = new MapiJournal("daily record", "called out in the dark", "Phone call", "Phone call");
		journal.setStartTime(d1);
		journal.setEndTime(d2);

		//Add companies Information
		String[] companies = { "Company 1", "Company 2", "Company 3" };
		journal.setCompanies(companies);

		//Add attachments
		String[] attachFileNames = new String[] { "1.png", "Invitation.doc", "logo.jpg" };
		for (String att : attachFileNames) {
			//Load the attachment in a byte array
			File file = new File(dataDir + att);
			//FileInputStream fin = null;
			//fin = new FileInputStream(file);
			byte data[] = new byte[(int) file.length()];

			//Add the attachment to the Journal entry
			journal.getAttachments().add(att, data);
		}

		//Save the Journal Item as MSG file
		journal.save(dataDir + "JournalWithAttachments_out.msg");
	}

}
