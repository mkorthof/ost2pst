from asposeemail import Settings
from com.aspose.email import MailMessage
from com.aspose.email import SaveOptions

class Converter:

    def __init__(self):
                
        # Loading EML, Saving to MSG
        self.convert_eml_to_msg()
        
    def convert_eml_to_msg(dataDir):
        
        dataDir = Settings.dataDir + 'ProgrammingEmail/Converter/'
        
        # Initialize and Load an existing EML file by specifying the MessageFormat
        mailMessage = MailMessage()
        eml = mailMessage.load(dataDir + "Message.eml")

        # Save the Email message to disk in Unicode format
        saveOptions= SaveOptions
        eml.save(dataDir + "AnEmail.msg", saveOptions.getDefaultMsgUnicode())

        # Display Status
        print "Converted email to msg successfully."
 
if __name__ == '__main__':        
    Converter()