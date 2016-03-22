from asposeemail import Settings
from com.aspose.email import MapiMessage
from com.aspose.email import NoteColor
from com.aspose.email import PersonalStorage
from com.aspose.email import FileFormatVersion
from com.aspose.email import StandardIpmFolder

from java.util import Date
from java.util import Calendar

class StringSearchInPST:

    def __init__(self):
                        
        dataDir = Settings.dataDir + 'ProgrammingOutlook/WorkingWithOutlookPersonalStorage/StringSearchInPST/'
        
        personalStorage=PersonalStorage()
        fileFormatVersion=FileFormatVersion
        pst = personalStorage.create(dataDir + "search.pst", fileFormatVersion.Unicode)

        standardIpmFolder=StandardIpmFolder
        fi = pst.createPredefinedFolder("Inbox", standardIpmFolder.Inbox)

        mapiMessage=MapiMessage()
        mailMessage=MailMessage()
        fi.addMessage(mapiMessage.fromMailMessage(mailMessage.load(dataDir + "search.pst")))

        builder = MailQueryBuilder()
        builder.getFrom().contains("automated", true)

        query = builder.getQuery()
        coll = fi.getContents(query)

        print "Total Results:" . coll.size()
        
 
if __name__ == '__main__':        
    StringSearchInPST()