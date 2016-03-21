from asposeemail import Settings
from com.aspose.email import MapiMessage

class ParseOutlookMessageFile:

    def __init__(self):
                        
        dataDir = Settings.dataDir + 'ProgrammingOutlook/WorkingWithOutlookMessageFiles/ParseOutlookMessageFile/'
        
        mapiMessage=MapiMessage()
        outlook_message_file = mapiMessage.fromFile(dataDir + "Message.msg")

        # Display sender's name
        print "Sender Name : " 
        print outlook_message_file.getSenderName()

        #Display Subject
        print "Subject : " 
        print outlook_message_file.getSubject()

        # Display Body
        print "Body : " 
        print outlook_message_file.getBody()
        
 
if __name__ == '__main__':        
    ParseOutlookMessageFile()