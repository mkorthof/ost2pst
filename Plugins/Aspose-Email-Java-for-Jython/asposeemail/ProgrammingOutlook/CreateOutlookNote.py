from asposeemail import Settings
from com.aspose.email import MapiNote
from com.aspose.email import NoteColor
from com.aspose.email import NoteSaveFormat

class CreateOutlookNote:

    def __init__(self):
                        
        dataDir = Settings.dataDir + 'ProgrammingOutlook/WorkingWithOutlookMessageFiles/CreateOutlookNote/'
        
        note = MapiNote()
        note.setSubject("Blue color note")
        note.setBody("This is a blue color note")
        noteColor = NoteColor
        note.setColor(noteColor.Blue)
        note.setHeight(500)
        note.setWidth(500)

        noteSaveFormat=NoteSaveFormat

        note.save(dataDir + "MapiNote.msg", noteSaveFormat.Msg)

        print "Created outlook note successfully."
        
 
if __name__ == '__main__':        
    CreateOutlookNote()