from asposeemail import Settings
from com.aspose.email import MapiMessage
from com.aspose.email import NoteColor
from com.aspose.email import PersonalStorage
from com.aspose.email import FileFormatVersion
from com.aspose.email import StandardIpmFolder

from java.util import Date
from java.util import Calendar

class CreatePST:

    def __init__(self):
                        
        dataDir = Settings.dataDir + 'ProgrammingOutlook/WorkingWithOutlookPersonalStorage/CreatePST/'
        
        # Create an instance of PersonalStorage
        personalStorage=PersonalStorage()
        pst = personalStorage.create(dataDir + "sample1.pst", 0)

        # Create a folder at root of pst
        pst.getRootFolder().addSubFolder("myInbox")

        # Add message to newly created folder
        mapi_message = MapiMessage()
        pst.getRootFolder().getSubFolder("myInbox").addMessage(mapi_message.fromFile(dataDir + "Message.msg"))

        print "Created PST successfully."
        
 
if __name__ == '__main__':        
    CreatePST()