module Asposeemailjava
  module ParseOutlookMessageFile
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        outlook_message_file = Rjb::import('com.aspose.email.MapiMessage').fromFile(data_dir + "Message.msg")

        # Display sender's name
        puts "Sender Name : " + outlook_message_file.getSenderName().to_s

        #Display Subject
        puts "Subject : " + outlook_message_file.getSubject().to_s

        # Display Body
        puts "Body : " + outlook_message_file.getBody().to_s
    end
  end
end
