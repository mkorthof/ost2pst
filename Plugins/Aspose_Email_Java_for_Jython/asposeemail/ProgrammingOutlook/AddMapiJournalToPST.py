from asposeemail import Settings
from com.aspose.email import MapiJournal
from com.aspose.email import PersonalStorage
from com.aspose.email import FileFormatVersion
from com.aspose.email import StandardIpmFolder

from java.util import Date
from java.util import Calendar

class AddMapiJournalToPST:

    def __init__(self):
                        
        dataDir = Settings.dataDir + 'ProgrammingOutlook/WorkingWithOutlookPersonalStorage/AddMapiJournalToPST/'
        
        d1 = Date()
        calendar=Calendar
        cl = calendar.getInstance()
        cl.setTime(d1)
        cl.add(calendar.HOUR, 1)
        d2 = cl.getTime()

        journal = MapiJournal("daily record", "called out in the dark", "Phone call", "Phone call")
        journal.setStartTime(d1)
        journal.setEndTime(d2)

        personalStorage=PersonalStorage()
        fileFormatVersion=FileFormatVersion
        pst = personalStorage.create(dataDir + "JournalPST.pst", fileFormatVersion.Unicode)

        standardIpmFolder=StandardIpmFolder

        journal_folder = pst.createPredefinedFolder("Journal", standardIpmFolder.Journal)
        journal_folder.addMapiMessageItem(journal)

        print "Added MapiJournal Successfully."
        
 
if __name__ == '__main__':        
    AddMapiJournalToPST()
