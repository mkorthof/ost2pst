module Asposeemailjava
  module Converter
    def initialize()
        # Loading EML, Saving to MSG 
        convert_eml_to_msg()
    end
    
    def convert_eml_to_msg()    
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Initialize and Load an existing EML file by specifying the MessageFormat
        eml = Rjb::import('com.aspose.email.MailMessage').load(data_dir + "Message.eml")

        # Save the Email message to disk in Unicode format
        eml.save(data_dir + "AnEmail.msg", Rjb::import('com.aspose.email.SaveOptions').getDefaultMsgUnicode())

        # Display Status
        puts "Converted eml to msg successfully."
    end
  end
end
