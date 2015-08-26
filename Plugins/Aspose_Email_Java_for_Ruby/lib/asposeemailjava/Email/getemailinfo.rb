module Asposeemailjava
  module GetEmailInfo
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Create MailMessage instance by loading an Eml file
        message_format = Rjb::import('com.aspose.email.MessageFormat')
        message = Rjb::import('com.aspose.email.MailMessage').load(data_dir + "Message.eml")

        puts "From: " + message.getFrom().to_string

        puts "To: " + message.getTo().to_string

        puts "Subject: " + message.getSubject().to_s

        puts "HtmlBody: " + message.getHtmlBody().to_s

        puts "TextBody: " + message.getTextBody().to_s
    end
  end
end
