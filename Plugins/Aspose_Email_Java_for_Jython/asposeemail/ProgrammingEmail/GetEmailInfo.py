from asposeemail import Settings
from com.aspose.email import MailMessage
from com.aspose.email import MessageFormat

class GetEmailInfo:

    def __init__(self):
                        
        dataDir = Settings.dataDir + 'ProgrammingEmail/GetEmailInfo/'
        
        # Create MailMessage instance by loading an Eml file
        message_format = MessageFormat
        mailMessage=MailMessage()
        message = mailMessage.load(dataDir + "Message.eml")

        print "From: " 
        print message.getFrom()

        print "To: " 
        print message.getTo()

        print "Subject: " 
        print message.getSubject()

        print "HtmlBody: " 
        print message.getHtmlBody()

        print "TextBody: " 
        print message.getTextBody()
        
 
if __name__ == '__main__':        
    GetEmailInfo()