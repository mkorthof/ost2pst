module Asposeemailjava
  module CreatePST
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Create an instance of PersonalStorage
        pst = Rjb::import('com.aspose.email.PersonalStorage').create(data_dir + "sample1.pst", 0)

        # Create a folder at root of pst
        pst.getRootFolder().addSubFolder("myInbox")

        # Add message to newly created folder
        mapi_message = Rjb::import('com.aspose.email.MapiMessage')
        pst.getRootFolder().getSubFolder("myInbox").addMessage(mapi_message.fromFile(data_dir + "Message.msg"))

        puts "Created PST successfully."
    end
  end
end
