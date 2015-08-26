module Asposeemailjava
  module StringSearchInPST
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Load the Outlook PST file
        pst = Rjb::import('com.aspose.email.PersonalStorage').create(data_dir + "search.pst", Rjb::import('com.aspose.email.FileFormatVersion').Unicode)

        fi = pst.createPredefinedFolder("Inbox", Rjb::import('com.aspose.email.StandardIpmFolder').Inbox)

        fi.addMessage(Rjb::import('com.aspose.email.MapiMessage').fromMailMessage(Rjb::import('com.aspose.email.MailMessage').load(data_dir + "search.pst")))

        builder = Rjb::import('com.aspose.email.MailQueryBuilder').new
        builder.getFrom().contains("automated", true)

        query = builder.getQuery()
        coll = fi.getContents(query)

        puts "Total Results:" + coll.size().to_s
    end
  end
end
