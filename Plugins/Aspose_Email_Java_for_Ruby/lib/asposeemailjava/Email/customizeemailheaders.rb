module Asposeemailjava
  module CustomizeEmailHeaders
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'
                
        # Create a new instance of MailMessage class
        message = Rjb::import('com.aspose.email.MailMessage').new

        # Set subject of the message
        message.setSubject("New message created by Aspose.Email for Java")

        # Set Html body
        message.setHtmlBody("<b>This line is in bold.</b> <br/> <br/>" +
                "<font color=blue>This line is in blue color</font>")

        # Set sender information
        message.setFrom(Rjb::import('com.aspose.email.MailAddress').new("from@domain.com", "Sender Name", false))

        # Add TO recipients
        message.getTo().add(Rjb::import('com.aspose.email.MailAddress').new("to@domain.com", "Recipient 1", false))

        # Message subject
        message.setSubject("Customizing Email Headers")

        # Specify Date
        calendar = Rjb::import('java.util.Calendar').getInstance(Rjb::import('java.util.TimeZone').getTimeZone("GMT"))

        date = calendar.getTime()
        message.setDate(date)

        # Specify XMailer
        message.setXMailer("Aspose.Email")

        # Specify Secret Header
        message.getHeaders().add("secret-header", "mystery")

        # Save message to disc
        message.save(data_dir + "MsgHeaders.msg", Rjb::import('com.aspose.email.MessageFormat').getMsg())

        # Display Status
        puts "Customized message headers Successfully."
    end
  end
end
