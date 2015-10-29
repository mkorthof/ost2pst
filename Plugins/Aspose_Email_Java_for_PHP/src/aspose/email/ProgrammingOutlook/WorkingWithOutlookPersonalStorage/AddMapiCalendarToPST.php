<?php
namespace Aspose\Email\ProgrammingOutlook\WorkingWithOutlookPersonalStorage;

use com\aspose\email\MapiCalendar as MapiCalendar;
use com\aspose\email\MapiRecipientCollection as MapiRecipientCollection;
use com\aspose\email\MapiRecipientType as MapiRecipientType;
use com\aspose\email\PersonalStorage as PersonalStorage;
use com\aspose\email\FileFormatVersion as FileFormatVersion;
use com\aspose\email\StandardIpmFolder as StandardIpmFolder;

use java\util\Date as Date;

class AddMapiCalendarToPST{

    public static function run($dataDir=null){

        # Create the appointment
        $appointment =new MapiCalendar(
                "LAKE ARGYLE WA 6743",
                "Appointment",
                "This is a very important meeting :)",
                new Date(2012, 10, 2),
                new Date(2012, 10, 2, 14, 0, 0));

        # Create the meeting
        $attendees = new MapiRecipientCollection();

        $mapiRecipientType=new MapiRecipientType();

        $attendees->add("ReneeAJones@armyspy.com", "Renee A. Jones", $mapiRecipientType->MAPI_TO);
        $attendees->add("SzllsyLiza@dayrep.com", "Szollosy Liza", $mapiRecipientType->MAPI_TO);

        $meeting = new MapiCalendar(
                "Meeting Room 3 at Office Headquarters",
                "Meeting",
                "Please confirm your availability.",
                new Date(2012, 10, 2, 13, 0, 0),
                new Date(2012, 10, 2, 14, 0, 0),
                "CharlieKhan@dayrep.com",
                $attendees
            );
        $personalStorage=new PersonalStorage();

        $fileFormatVersion=new FileFormatVersion();
        $standardIpmFolder=new StandardIpmFolder();

        $pst = $personalStorage->create($dataDir . "MapiCalendarToPST1.pst", $fileFormatVersion->Unicode);
        $calendar_folder = $pst->createPredefinedFolder("Calendar", $standardIpmFolder->Appointments);
//        $calendar_folder->addMapiMessageItem(appointment);
//        $calendar_folder->addMapiMessageItem(meeting);

        print "Added MapiCalendar Successfully.".PHP_EOL;
    }
}
?>