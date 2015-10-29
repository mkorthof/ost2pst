<?php
namespace Aspose\Email\ProgrammingOutlook\WorkingWithOutlookPersonalStorage;

use java\util\Date as Date;
use java\util\Calendar as Calendar;
use com\aspose\email\MapiJournal as MapiJournal;
use com\aspose\email\PersonalStorage as PersonalStorage;
use com\aspose\email\FileFormatVersion as FileFormatVersion;
use com\aspose\email\StandardIpmFolder as StandardIpmFolder;

class AddMapiJournalToPST{

    public static function run($dataDir=null){

        $d1 = new Date();
        $calendar=new Calendar();
        $cl = $calendar->getInstance();
        $cl->setTime($d1);
        $cl->add($calendar->HOUR, 1);
        $d2 = $cl->getTime();

        $journal = new MapiJournal("daily record", "called out in the dark", "Phone call", "Phone call");
        $journal->setStartTime($d1);
        $journal->setEndTime($d2);

        $personalStorage=new PersonalStorage();
        $fileFormatVersion=new FileFormatVersion();
        $pst = $personalStorage->create($dataDir . "JournalPST.pst", $fileFormatVersion->Unicode);

        $standardIpmFolder=new StandardIpmFolder();

        $journal_folder = $pst->createPredefinedFolder("Journal", $standardIpmFolder->Journal);
        $journal_folder->addMapiMessageItem($journal);

        print "Added MapiJournal Successfully.".PHP_EOL;
    }
}
?>