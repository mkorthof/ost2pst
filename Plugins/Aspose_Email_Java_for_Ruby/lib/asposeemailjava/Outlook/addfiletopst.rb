module Asposeemailjava
  module AddFileToPST
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        pst = Rjb::import('com.aspose.email.PersonalStorage').create(data_dir + "AddFile.pst", Rjb::import('com.aspose.email.FileFormatVersion').Unicode)

        fi = pst.createPredefinedFolder("Inbox", Rjb::import('com.aspose.email.StandardIpmFolder').Inbox)

        fi.addFile(data_dir + "Report.xlsx", "IPM.Document.Excel.Sheet.8")

        pst.dispose()

        puts "Added file to PST"
    end
  end
end
