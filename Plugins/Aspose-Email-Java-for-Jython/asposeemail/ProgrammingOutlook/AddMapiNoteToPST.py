from asposeemail import Settings
from com.aspose.email import MapiMessage
from com.aspose.email import NoteColor
from com.aspose.email import PersonalStorage
from com.aspose.email import FileFormatVersion
from com.aspose.email import StandardIpmFolder

from java.util import Date
from java.util import Calendar

class AddMapiNoteToPST:

    def __init__(self):
                        
        dataDir = Settings.dataDir + 'ProgrammingOutlook/WorkingWithOutlookPersonalStorage/AddMapiNoteToPST/'
        
        mapiMessage=MapiMessage()
        mess = mapiMessage.fromFile(dataDir + "MapiNote.msg")

        # Note #1
        note1 = mess.toMapiMessageItem()
        note1.setSubject("Yellow color note")
        note1.setBody("This is a yellow color note")

        # Note #2
        note2 = mess.toMapiMessageItem()
        note2.setSubject("Pink color note")
        note2.setBody("This is a pink color note")

        noteColor=NoteColor

        note2.setColor(noteColor.Pink)
        noteColor
        

        # Note #3
        note3 = mess.toMapiMessageItem()
        note2.setSubject("Blue color note")
        note2.setBody("This is a blue color note")
        note2.setColor(noteColor.Blue)
        note3.setHeight(500)
        note3.setWidth(500)

        personalStorage=PersonalStorage()
        fileFormatVersion=FileFormatVersion()

        pst = personalStorage.create(dataDir + "MapiNoteToPST.pst", fileFormatVersion.Unicode)

        standardIpmFolder=StandardIpmFolder()

        notes_folder = pst.createPredefinedFolder("Notes", standardIpmFolder.Notes)
        notes_folder.addMapiMessageItem(note1)
        notes_folder.addMapiMessageItem(note2)
        notes_folder.addMapiMessageItem(note3)

        print "Added MapiNote Successfully."
        
 
if __name__ == '__main__':        
    AddMapiNoteToPST()