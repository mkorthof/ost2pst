from asposeemail import Settings
from com.aspose.email import MailMessage

class ExtractEmailHeaders:

    def __init__(self):
                        
        dataDir = Settings.dataDir + 'ProgrammingEmail/ExtractEmailHeaders/'
        
        # Initialize and Load an existing EML file by specifying the MessageFormat
        mailMessage=MailMessage()

        message = mailMessage.load(dataDir + "Message.eml")

        print "Printing all Headers:"

        # Print out all the headers
        i=0
        while (i < message.getHeaders().getCount()):
            print message.getHeaders().get(i)
            i += 1
        
 
if __name__ == '__main__':        
    ExtractEmailHeaders()