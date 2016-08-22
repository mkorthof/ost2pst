package com.aspose.email.examples.outlook.pst;

import com.aspose.email.FileFormatVersion;
import com.aspose.email.FolderInfo;
import com.aspose.email.MapiMessage;
import com.aspose.email.MapiNote;
import com.aspose.email.NoteColor;
import com.aspose.email.PersonalStorage;
import com.aspose.email.StandardIpmFolder;
import com.aspose.email.examples.Utils;

public class AddMapiNoteToPST {
	
	public static String dataDir = Utils.getSharedDataDir(AddMapiNoteToPST.class) + "outlook/";
	
	public static void main(String[] args) {
		MapiMessage mess = MapiMessage.fromFile(dataDir + "Note.msg");

		// Note #1
		MapiNote note1 = (MapiNote) mess.toMapiMessageItem();
		note1.setSubject("Yellow color note");
		note1.setBody("This is a yellow color note");

		// Note #2
		MapiNote note2 = (MapiNote) mess.toMapiMessageItem();
		note2.setSubject("Pink color note");
		note2.setBody("This is a pink color note");
		note2.setColor(NoteColor.Pink);

		// Note #3
		MapiNote note3 = (MapiNote) mess.toMapiMessageItem();
		note2.setSubject("Blue color note");
		note2.setBody("This is a blue color note");
		note2.setColor(NoteColor.Blue);
		note3.setHeight(500);
		note3.setWidth(500);

		PersonalStorage pst = PersonalStorage.create(dataDir + "MapiNoteToPST_out.pst", FileFormatVersion.Unicode);
		FolderInfo notesFolder = pst.createPredefinedFolder("Notes", StandardIpmFolder.Notes);
		notesFolder.addMapiMessageItem(note1);
		notesFolder.addMapiMessageItem(note2);
		notesFolder.addMapiMessageItem(note3);
	}
}
