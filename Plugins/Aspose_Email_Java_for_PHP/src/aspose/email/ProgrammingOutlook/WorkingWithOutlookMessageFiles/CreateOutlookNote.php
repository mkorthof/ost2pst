<?php
namespace Aspose\Email\ProgrammingOutlook\WorkingWithOutlookMessageFiles;

use com\aspose\email\MapiNote as MapiNote;
use com\aspose\email\NoteColor as NoteColor;
use com\aspose\email\NoteSaveFormat as NoteSaveFormat;
class CreateOutlookNote{

    public static function run($dataDir=null){

        $note = new MapiNote();
        $note->setSubject("Blue color note");
        $note->setBody("This is a blue color note");
        $noteColor=new NoteColor();
        $note->setColor($noteColor->Blue);
        $note->setHeight(500);
        $note->setWidth(500);

        $noteSaveFormat=new NoteSaveFormat();

        $note->save($dataDir . "MapiNote.msg", $noteSaveFormat->Msg);

        print "Created outlook note successfully.".PHP_EOL;
    }


}
?>