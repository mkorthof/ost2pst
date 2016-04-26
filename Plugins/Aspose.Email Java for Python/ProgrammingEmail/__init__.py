__author__ = 'fahadadeel'
import jpype

class Converter:

    def __init__(self,dataDir):

        self.dataDir = dataDir
        self.MailMessage = jpype.JClass("com.aspose.email.MailMessage")
        self.SaveOptions = jpype.JClass("com.aspose.email.SaveOptions")

    def main(self):
        
        # Initialize and Load an existing EML file by specifying the MessageFormat
        mailMessage = self.MailMessage
        eml = mailMessage.load(self.dataDir + "Message.eml")

        # Save the Email message to disk in Unicode format
        saveOptions= self.SaveOptions
        eml.save(self.dataDir + "AnEmail.msg", saveOptions.getDefaultMsgUnicode())

        # Display Status
        print "Converted email to msg successfully."
        
class CreateNewEmail:
    
    def __init__(self,dataDir):

        self.dataDir = dataDir
        self.MailMessage = jpype.JClass("com.aspose.email.MailMessage")
        self.MailAddress = jpype.JClass("com.aspose.email.MailAddress")
        self.MailMessageSaveType = jpype.JClass("com.aspose.email.MailMessageSaveType")

    def main(self):
        
         # Create a instance of MailMessage class
        message = self.MailMessage()

        # Set subject of the message
        message.setSubject("New message created by Aspose.Email for Java")

        mail_address = self.MailAddress

        # Set Html body
        message.setHtmlBody("<b>This line is in bold.</b> <br/> <br/>" +
            "<font color=blue>This line is in blue color</font>")

        # Set sender information
        message.setFrom(self.MailAddress("from@domain.com", "Sender Name", False))

        # Add TO recipients
        message.getTo().addMailAddress(self.MailAddress("to1@domain.com", "Recipient 1", False))
        message.getTo().addMailAddress(self.MailAddress("to2@domain.com", "Recipient 2", False))

        # Add CC recipients
        message.getCC().addMailAddress(self.MailAddress("cc1@domain.com", "Recipient 3", False))
        message.getCC().addMailAddress(self.MailAddress("cc2@domain.com", "Recipient 4", False))

        # Save message in EML and MSG formats
        mail_message_save_type = self.MailMessageSaveType
        message.save(self.dataDir + "Message.eml", mail_message_save_type.getEmlFormat())
        message.save(self.dataDir + "Message.msg", mail_message_save_type.getOutlookMessageFormat())
        # Display Status
        print "Created email messages Successfully."
        
class CustomizeEmailHeaders:

    def __init__(self,dataDir):
        
        self.dataDir = dataDir
        self.MailMessage = jpype.JClass("com.aspose.email.MailMessage")
        self.MailAddress = jpype.JClass("com.aspose.email.MailAddress")
        self.MessageFormat = jpype.JClass("com.aspose.email.MessageFormat")
        self.TimeZone = jpype.JClass("java.util.TimeZone")
        self.Calendar = jpype.JClass("java.util.Calendar")

    def main(self):
                                
        # Create a instance of MailMessage class
        message = self.MailMessage()

            # Set subject of the message
        message.setSubject("New message created by Aspose.Email for Java")

        # Set Html body
        message.setHtmlBody("<b>This line is in bold.</b> <br/> <br/>" +
            "<font color=blue>This line is in blue color</font>")

        # Set sender information
        message.setFrom(self.MailAddress("from@domain.com", "Sender Name", False))

        # Add TO recipients
        message.getTo().addMailAddress(self.MailAddress("to@domain.com", "Recipient 1", False))

        # Message subject
        message.setSubject("Customizing Email Headers")

        # Specify Date
        timeZone = self.TimeZone
        calendar = self.Calendar
        calendar = calendar.getInstance(timeZone.getTimeZone("GMT"))

        date = calendar.getTime()
        message.setDate(date)

        # Specify XMailer
        message.setXMailer("Aspose.Email")

        # Specify Secret Header
        message.getHeaders().add("secret-header", "mystery")

        # Save message to disc
        messageFormat= self.MessageFormat
        message.save(self.dataDir + "MsgHeaders.msg", messageFormat.getMsg())

        # Display Status
        print "Customized message headers Successfully."
        
class GetEmailInfo:

    def __init__(self,dataDir):

        self.dataDir = dataDir
        self.MailMessage = jpype.JClass("com.aspose.email.MailMessage")
        self.MessageFormat = jpype.JClass("com.aspose.email.MessageFormat")
        self.MailAddress = jpype.JClass("com.aspose.email.MailAddress")
        self.MailMessageSaveType = jpype.JClass("com.aspose.email.MailMessageSaveType")
        
    def main(self):
                                
        # Create MailMessage instance by loading an Eml file
        message_format = self.MessageFormat
        mailMessage = self.MailMessage
        message = mailMessage.load(self.dataDir + "Message.eml")

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
        
class ManageAttachments:

    def __init__(self,dataDir):
        
        self.dataDir = dataDir
        self.MailMessage = jpype.JClass("com.aspose.email.MailMessage")
        self.MailAddress = jpype.JClass("com.aspose.email.MailAddress")
        self.Attachment = jpype.JClass("com.aspose.email.Attachment")
        self.MessageFormat = jpype.JClass("com.aspose.email.MessageFormat")
    
    def main(self):
              
        # Create a instance of MailMessage class
        message = self.MailMessage()

        # Set subject of the message
        message.setSubject("New message created by Aspose.Email for Java")

        mail_address = self.MailAddress

        # Set Html body
        message.setHtmlBody("<b>This line is in bold.</b> <br/> <br/>" +
            "<font color=blue>This line is in blue color</font>")

        # Set sender information
        message.setFrom(self.MailAddress("from@domain.com", "Sender Name", False))

        # Add TO recipients
        message.getTo().addMailAddress(self.MailAddress("to1@domain.com", "Recipient 1", False))

        # Adding attachment
        # Load an attachment

        attachment = self.Attachment(self.dataDir + "1.txt")

        # Add attachment in instance of MailMessage class
        message.addAttachment(attachment)

        # Save message to disc
        messageFormat = self.MessageFormat
        message.save(self.dataDir + "Add-Attachment.msg", messageFormat.getMsg())

        # Display Status
        print "Added attachment successfully."
        
class SaveMessageAsDraft:

    def __init__(self,dataDir):
        
        self.dataDir = dataDir
        self.MailMessage = jpype.JClass("com.aspose.email.MailMessage")
        self.MapiMessage = jpype.JClass("com.aspose.email.MapiMessage")
        self.MailAddress = jpype.JClass("com.aspose.email.MailAddress")
        self.Attachment = jpype.JClass("com.aspose.email.Attachment")
        self.MessageFormat = jpype.JClass("com.aspose.email.MessageFormat")
        self.MapiMessageFlags = jpype.JClass("com.aspose.email.MapiMessageFlags")
        
    def main(self):
                                
        # Create a instance of MailMessage class
        message = self.MailMessage()

        # Set subject of the message
        message.setSubject("New message created by Aspose.Email for Java")

        mail_address = self.MailAddress

        # Set Html body
        message.setHtmlBody("<b>This line is in bold.</b> <br/> <br/>" +
            "<font color=blue>This line is in blue color</font>")

        # Set sender information
        message.setFrom(self.MailAddress("from@domain.com", "Sender Name", False))

        # Add TO recipients
        message.getTo().addMailAddress(self.MailAddress("to1@domain.com", "Recipient 1", False))
        message.getTo().addMailAddress(self.MailAddress("to2@domain.com", "Recipient 2", False))

        # Create an instance of MapiMessage and load the MailMessag instance into it
        mapiMessage = self.MapiMessage
        mapi_msg = mapiMessage.fromMailMessage(message)

        # Set the MapiMessageFlags as UNSENT and FROMME
        mapi_message_flags = self.MapiMessageFlags
        
        # Save the MapiMessage to disk
        mapi_msg.save(self.dataDir + "New-Draft.msg")

        # Display Status
        print "Draft saved Successfully."
        
class UpdateEmail:

    def __init__(self,dataDir):
        
        self.dataDir = dataDir
        self.MailMessage = jpype.JClass("com.aspose.email.MailMessage")
        self.MailAddress = jpype.JClass("com.aspose.email.MailAddress")
        self.Attachment = jpype.JClass("com.aspose.email.Attachment")
        self.MessageFormat = jpype.JClass("com.aspose.email.MessageFormat")
        self.MailAddressCollection = jpype.JClass("com.aspose.email.MailAddressCollection")
        self.MailMessageSaveType = jpype.JClass("com.aspose.email.MailMessageSaveType")
    
    def main(self):
                                
        # Initialize and Load an existing MSG file by specifying the MessageFormat
        mailMessage = self.MailMessage
        email = mailMessage.load(self.dataDir + "Message.msg")

        # Initialize a String variable to get the Email Subject
        subject = email.getSubject()

        # Append some more information to Subject
        subject = subject + " This text is added to the existing subject"

        # Set the Email Subject
        email.setSubject('This text is added to the existing subject')

        # Initialize a String variable to get the Email's HTML Body
        body = email.getHtmlBody()

        # Apppend some more information to the Body variable
        body = body + "<br> This text is added to the existing body"

        # Set the Email Body
        email.setHtmlBody(body)

        # Initialize MailAddressCollection object
        contacts = self.MailAddressCollection()

        # Retrieve Email's TO list
        contacts = email.getTo()

        # Add another email address to collection
        contacts.add("to1@domain.com")

        # Set the collection as Email's TO list
        email.setTo(contacts)

        # Initialize MailAddressCollection
        contacts = self.MailAddressCollection()

        # Retrieve Email's CC list
        contacts = email.getCC()

        # Add another email address to collection
        contacts.add("cc2@domain.com")

        # Set the collection as Email's CC list
        email.setCC(contacts)

        # Save the Email message to disk by specifying the MessageFormat
        mailMessageSaveType = self.MailMessageSaveType
        email.save(self.dataDir + "UpdateMessage.msg", mailMessageSaveType.getOutlookMessageFormat())

        # Display Status
        print "Updated email message Successfully."