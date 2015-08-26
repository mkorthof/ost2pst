module Asposeemailjava
  module SearchMessagesAndFoldersInPST
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Load the Outlook PST file
        pst = Rjb::import('com.aspose.email.PersonalStorage').fromFile(data_dir + "sample.pst")

        folder = pst.getRootFolder().getSubFolder("myInbox")
        builder = Rjb::import('com.aspose.email.PersonalStorageQueryBuilder').new

        # High importance messages
        builder.getImportance().equals(Rjb::import('com.aspose.email.MapiImportance').High)
        messages = folder.getContents(builder.getQuery())
        puts "Messages with High Imp:" + messages.size().to_s

        #builder = new PersonalStorageQueryBuilder();
        builder.getMessageClass().equals("IPM.Note")
        messages = folder.getContents(builder.getQuery())
        puts "Messages with IPM.Note:" + messages.size().to_s

        # Messages with attachments AND high importance
        builder.getImportance().equals(Rjb::import('com.aspose.email.MapiImportance').High)
        builder.hasFlags(Rjb::import('com.aspose.email.MapiMessageFlags').MSGFLAG_HASATTACH)
        messages = folder.getContents(builder.getQuery())
        puts "Messages with atts: " + messages.size().to_s

        # Messages with size > 15 KB
        builder.getMessageSize().greater(15000)
        messages = folder.getContents(builder.getQuery())
        puts "messags size > 15Kb:" + messages.size().to_s

        # Unread messages
        builder.hasNoFlags(Rjb::import('com.aspose.email.MapiMessageFlags').MSGFLAG_READ)
        messages = folder.getContents(builder.getQuery())
        puts "Unread:" + messages.size().to_s

        # Unread messages with attachments
        builder.hasNoFlags(Rjb::import('com.aspose.email.MapiMessageFlags').MSGFLAG_READ)
        builder.hasFlags(Rjb::import('com.aspose.email.MapiMessageFlags').MSGFLAG_HASATTACH)
        messages = folder.getContents(builder.getQuery())
        puts "Unread msgs with atts: " + messages.size().to_s
    end
  end
end
