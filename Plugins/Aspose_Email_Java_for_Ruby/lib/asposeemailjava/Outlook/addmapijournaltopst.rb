module Asposeemailjava
  module AddMapiJournalToPST
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        d1 = Rjb::import('java.util.Date').new
        cl = Rjb::import('java.util.Calendar').getInstance()
        cl.setTime(d1)
        cl.add(Rjb::import('java.util.Calendar').HOUR, 1)
        d2 = cl.getTime()

        journal = Rjb::import('com.aspose.email.MapiJournal').new("daily record", "called out in the dark", "Phone call", "Phone call")
        journal.setStartTime(d1)
        journal.setEndTime(d2)
        
        pst = Rjb::import('com.aspose.email.PersonalStorage').create(data_dir + "JournalPST.pst", Rjb::import('com.aspose.email.FileFormatVersion').Unicode)
        journal_folder = pst.createPredefinedFolder("Journal", Rjb::import('com.aspose.email.StandardIpmFolder').Journal)
        journal_folder.addMapiMessageItem(journal)

        puts "Added MapiJournal Successfully."
    end
  end
end
