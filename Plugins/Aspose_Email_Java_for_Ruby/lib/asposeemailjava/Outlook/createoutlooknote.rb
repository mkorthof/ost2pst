module Asposeemailjava
  module CreateOutlookNote
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        note = Rjb::import('com.aspose.email.MapiNote').new
        note.setSubject("Blue color note")
        note.setBody("This is a blue color note")
        note.setColor(Rjb::import('com.aspose.email.NoteColor').Blue)
        note.setHeight(500)
        note.setWidth(500)
        note.save(data_dir + "MapiNote.msg", Rjb::import('com.aspose.email.NoteSaveFormat').Msg)

        puts "Created outlook note successfully."
    end
  end
end
