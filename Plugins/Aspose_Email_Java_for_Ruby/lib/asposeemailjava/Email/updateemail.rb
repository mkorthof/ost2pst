module Asposeemailjava
  module UpdateEmail
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'
                
        # Initialize and Load an existing MSG file by specifying the MessageFormat
        email = Rjb::import('com.aspose.email.MailMessage').load(data_dir + "Message.msg")

        # Initialize a String variable to get the Email Subject
        subject = email.getSubject()
        
        # Append some more information to Subject
        subject = subject + " This text is added to the existing subject"
        
        # Set the Email Subject
        email.setSubject(subject)

        # Initialize a String variable to get the Email's HTML Body
        body = email.getHtmlBody()

        # Apppend some more information to the Body variable
        body = body + "<br> This text is added to the existing body"

        # Set the Email Body
        email.setHtmlBody(body)

        # Initialize MailAddressCollection object
        contacts = Rjb::import('com.aspose.email.MailAddressCollection').new

        # Retrieve Email's TO list
        contacts = email.getTo()
        
        # Add another email address to collection
        contacts.add("to1@domain.com")

        # Set the collection as Email's TO list
        email.setTo(contacts)

        # Initialize MailAddressCollection
        contacts = Rjb::import('com.aspose.email.MailAddressCollection').new

        # Retrieve Email's CC list
        contacts = email.getCC()
        
        # Add another email address to collection
        contacts.add("cc2@domain.com")

        # Set the collection as Email's CC list
        email.setCC(contacts)

        # Save the Email message to disk by specifying the MessageFormat
        email.save(data_dir + "UpdateMessage.msg", Rjb::import('com.aspose.email.MailMessageSaveType').getOutlookMessageFormat())

        # Display Status
        puts "Updated email message Successfully."
    end
  end
end
