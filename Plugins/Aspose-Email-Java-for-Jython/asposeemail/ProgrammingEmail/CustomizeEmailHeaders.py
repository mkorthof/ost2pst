from asposeemail import Settings
from com.aspose.email import MailMessage
from com.aspose.email import MailAddress
from com.aspose.email import MessageFormat
from java.util import TimeZone
from java.util import Calendar


class CustomizeEmailHeaders:

    def __init__(self):
                        
        dataDir = Settings.dataDir + 'ProgrammingEmail/CustomizeEmailHeaders/'
        
        # Create a instance of MailMessage class
        message = MailMessage()

            # Set subject of the message
        message.setSubject("New message created by Aspose.Email for Java")

        # Set Html body
        message.setHtmlBody("<b>This line is in bold.</b> <br/> <br/>" +
            "<font color=blue>This line is in blue color</font>")

        # Set sender information
        message.setFrom(MailAddress("from@domain.com", "Sender Name", False))

        # Add TO recipients
        message.getTo().add(MailAddress("to@domain.com", "Recipient 1", False))

        # Message subject
        message.setSubject("Customizing Email Headers")

        # Specify Date
        timeZone=TimeZone()
        calendar=Calendar()
        calendar = calendar.getInstance(timeZone.getTimeZone("GMT"))

        date = calendar.getTime()
        message.setDate(date)

        # Specify XMailer
        message.setXMailer("Aspose.Email")

        # Specify Secret Header
        message.getHeaders().add("secret-header", "mystery")

        # Save message to disc
        messageFormat=MessageFormat()
        message.save(dataDir + "MsgHeaders.msg", messageFormat.getMsg())

        # Display Status
        print "Customized message headers Successfully."
 
if __name__ == '__main__':        
    CustomizeEmailHeaders()