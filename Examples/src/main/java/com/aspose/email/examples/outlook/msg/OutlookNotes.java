package com.aspose.email.examples.outlook.msg;

import com.aspose.email.MapiMessage;
import com.aspose.email.MapiNote;
import com.aspose.email.NoteColor;
import com.aspose.email.NoteSaveFormat;
import com.aspose.email.examples.Utils;

public class OutlookNotes {

	public static void main(String[] args) {
		
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(OutlookNotes.class) + "outlook/";
		
		createAndSaveOutlookNote(dataDir);
		
		readAMapiNote(dataDir);
	}

	public static void createAndSaveOutlookNote(String dataDir) {
		MapiNote note3 = new MapiNote();
		note3.setSubject("Blue color note");
		note3.setBody("This is a blue color note");
		note3.setColor(NoteColor.Blue);
		note3.setHeight(500);
		note3.setWidth(500);
		note3.save(dataDir + "MapiNote_out.msg", NoteSaveFormat.Msg);
	}

	public static void readAMapiNote(String dataDir) {
		MapiMessage note = MapiMessage.fromFile(dataDir + "MapiNote_out.msg");
		MapiNote note2 = (MapiNote) note.toMapiMessageItem();
	}

}
