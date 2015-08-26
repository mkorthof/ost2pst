module Asposeemailjava
  module AddMapiNoteToPST
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        mess = Rjb::import('com.aspose.email.MapiMessage').fromFile(data_dir + "MapiNote.msg")

        # Note #1
        note1 = mess.toMapiMessageItem()
        note1.setSubject("Yellow color note")
        note1.setBody("This is a yellow color note")

        # Note #2
        note2 = mess.toMapiMessageItem()
        note2.setSubject("Pink color note")
        note2.setBody("This is a pink color note")
        note2.setColor(Rjb::import('com.aspose.email.NoteColor').Pink)

        # Note #3
        note3 = mess.toMapiMessageItem()
        note2.setSubject("Blue color note")
        note2.setBody("This is a blue color note")
        note2.setColor(Rjb::import('com.aspose.email.NoteColor').Blue)
        note3.setHeight(500)
        note3.setWidth(500)

        pst = Rjb::import('com.aspose.email.PersonalStorage').create(data_dir + "MapiNoteToPST.pst", Rjb::import('com.aspose.email.FileFormatVersion').Unicode)
        notes_folder = pst.createPredefinedFolder("Notes", Rjb::import('com.aspose.email.StandardIpmFolder').Notes)
        notes_folder.addMapiMessageItem(note1)
        notes_folder.addMapiMessageItem(note2)
        notes_folder.addMapiMessageItem(note3)

        puts "Added MapiNote Successfully."
    end
  end
end
