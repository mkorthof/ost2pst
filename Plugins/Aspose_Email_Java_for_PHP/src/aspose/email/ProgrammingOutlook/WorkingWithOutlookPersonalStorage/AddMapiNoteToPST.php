<?php
namespace Aspose\Email\ProgrammingOutlook\WorkingWithOutlookPersonalStorage;

use com\aspose\email\MapiMessage as MapiMessage;
use com\aspose\email\NoteColor as NoteColor;
use com\aspose\email\PersonalStorage as PersonalStorage;
use com\aspose\email\FileFormatVersion as FileFormatVersion;
use com\aspose\email\StandardIpmFolder as StandardIpmFolder;
class AddMapiNoteToPST{

    public static function run($dataDir=null){

        $mapiMessage=new MapiMessage();
        $mess = $mapiMessage->fromFile($dataDir . "MapiNote.msg");

        # Note #1
        $note1 = $mess->toMapiMessageItem();
        $note1->setSubject("Yellow color note");
        $note1->setBody("This is a yellow color note");

        # Note #2
        $note2 = $mess->toMapiMessageItem();
        $note2->setSubject("Pink color note");
        $note2->setBody("This is a pink color note");

        $noteColor=new NoteColor();

        $note2->setColor($noteColor->Pink);

        # Note #3
        $note3 = $mess->toMapiMessageItem();
        $note2->setSubject("Blue color note");
        $note2->setBody("This is a blue color note");
        $note2->setColor($noteColor->Blue);
        $note3->setHeight(500);
        $note3->setWidth(500);

        $personalStorage=new PersonalStorage();
        $fileFormatVersion=new FileFormatVersion();

        $pst = $personalStorage->create($dataDir . "MapiNoteToPST.pst", $fileFormatVersion->Unicode);

        $standardIpmFolder=new StandardIpmFolder();

        $notes_folder = $pst->createPredefinedFolder("Notes", $standardIpmFolder->Notes);
        $notes_folder->addMapiMessageItem($note1);
        $notes_folder->addMapiMessageItem($note2);
        $notes_folder->addMapiMessageItem($note3);

        print "Added MapiNote Successfully.".PHP_EOL;

    }

}
?>