module Asposeemailjava
  module ExtractEmailHeaders
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'
                
        # Initialize and Load an existing EML file by specifying the MessageFormat
        message = Rjb::import('com.aspose.email.MailMessage').load(data_dir + "Message.eml")

        puts "Printing all Headers:"

        # Print out all the headers
        i=0
        while i < message.getHeaders().getCount()
            puts message.getHeaders().get(i)
            i +=1
        end    
    end
  end
end
