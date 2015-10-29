<?php

require_once("../../java/Java.inc");

require_once __DIR__ . '/../vendor/autoload.php';  //Autoload files using Composer autoload

use Aspose\Email\ProgrammingEmail\Converter;
use Aspose\Email\ProgrammingEmail\CreateNewEmail;
use Aspose\Email\ProgrammingEmail\GetEmailInfo;
use Aspose\Email\ProgrammingEmail\ManageAttachments;
use Aspose\Email\ProgrammingEmail\SaveMessageAsDraft;
use Aspose\Email\ProgrammingEmail\UpdateEmail;

use Aspose\Email\ProgrammingOutlook\WorkingWithOutlookMessageFiles\CreateOutlookContact;
use Aspose\Email\ProgrammingOutlook\WorkingWithOutlookMessageFiles\CreateOutlookNote;
use Aspose\Email\ProgrammingOutlook\WorkingWithOutlookMessageFiles\ParseOutlookMessageFile;

use Aspose\Email\ProgrammingOutlook\WorkingWithOutlookPersonalStorage\AddFileToPST;
use Aspose\Email\ProgrammingOutlook\WorkingWithOutlookPersonalStorage\AddMapiCalendarToPST;
use Aspose\Email\ProgrammingOutlook\WorkingWithOutlookPersonalStorage\AddMapiContactToPST;
use Aspose\Email\ProgrammingOutlook\WorkingWithOutlookPersonalStorage\AddMapiJournalToPST;
use Aspose\Email\ProgrammingOutlook\WorkingWithOutlookPersonalStorage\AddMapiTaskToPST;
use Aspose\Email\ProgrammingOutlook\WorkingWithOutlookPersonalStorage\CreatePST;
use Aspose\Email\ProgrammingOutlook\WorkingWithOutlookPersonalStorage\SearchMessagesAndFoldersInPST;


print "Running Aspose\\Email\\ProgrammingEmail\\Converter::run()" . PHP_EOL;
Converter::run(__DIR__ . '/data/ProgrammingEmail/Converter/');

print "Running Aspose\\Email\\ProgrammingEmail\\CreateNewEmail::run()" . PHP_EOL;
CreateNewEmail::run(__DIR__ . '/data/ProgrammingEmail/CreateNewEmail/');


print "Running Aspose\\Email\\ProgrammingEmail\\GetEmailInfo::run()" . PHP_EOL;
GetEmailInfo::run(__DIR__ . '/data/ProgrammingEmail/GetEmailInfo/');

print "Running Aspose\\Email\\ProgrammingEmail\\ManageAttachments::run()" . PHP_EOL;
ManageAttachments::run(__DIR__ . '/data/ProgrammingEmail/ManageAttachments/');

print "Running Aspose\\Email\\ProgrammingEmail\\SaveMessageAsDraft::run()" . PHP_EOL;
SaveMessageAsDraft::run(__DIR__ . '/data/ProgrammingEmail/SaveMessageAsDraft/');

print "Running Aspose\\Email\\ProgrammingEmail\\UpdateEmail::run()" . PHP_EOL;
UpdateEmail::run(__DIR__ . '/data/ProgrammingEmail/UpdateEmail/');

print "Running Aspose\\Email\\ProgrammingOutlook\\WorkingWithOutlookMessageFiles\\CreateOutlookContact::run()" . PHP_EOL;
CreateOutlookContact::run(__DIR__ . '/data/ProgrammingOutlook/WorkingWithOutlookMessageFiles/CreateOutlookContact/');

print "Running Aspose\\Email\\ProgrammingOutlook\\WorkingWithOutlookMessageFiles\\CreateOutlookNote::run()" . PHP_EOL;
CreateOutlookNote::run(__DIR__ . '/data/ProgrammingOutlook/WorkingWithOutlookMessageFiles/CreateOutlookNote/');

print "Running Aspose\\Email\\ProgrammingOutlook\\WorkingWithOutlookMessageFiles\\ParseOutlookMessageFile::run()" . PHP_EOL;
ParseOutlookMessageFile::run(__DIR__ . '/data/ProgrammingOutlook/WorkingWithOutlookMessageFiles/ParseOutlookMessageFile/');

print "Running Aspose\\Email\\ProgrammingOutlook\\WorkingWithOutlookPersonalStorage\\AddFileToPST::run()" . PHP_EOL;
AddFileToPST::run(__DIR__ . '/data/ProgrammingOutlook/WorkingWithOutlookPersonalStorage/AddFileToPST/');

print "Running Aspose\\Email\\ProgrammingOutlook\\WorkingWithOutlookPersonalStorage\\AddMapiCalendarToPST::run()" . PHP_EOL;
AddMapiCalendarToPST::run(__DIR__ . '/data/ProgrammingOutlook/WorkingWithOutlookPersonalStorage/AddMapiCalendarToPST/');

print "Running Aspose\\Email\\ProgrammingOutlook\\WorkingWithOutlookPersonalStorage\\AddMapiContactToPST::run()" . PHP_EOL;
AddMapiContactToPST::run(__DIR__ . '/data/ProgrammingOutlook/WorkingWithOutlookPersonalStorage/AddMapiContactToPST/');

print "Running Aspose\\Email\\ProgrammingOutlook\\WorkingWithOutlookPersonalStorage\\AddMapiJournalToPST::run()" . PHP_EOL;
AddMapiJournalToPST::run(__DIR__ . '/data/ProgrammingOutlook/WorkingWithOutlookPersonalStorage/AddMapiJournalToPST/');

print "Running Aspose\\Email\\ProgrammingOutlook\\WorkingWithOutlookPersonalStorage\\AddMapiTaskToPST::run()" . PHP_EOL;
AddMapiTaskToPST::run(__DIR__ . '/data/ProgrammingOutlook/WorkingWithOutlookPersonalStorage/AddMapiTaskToPST/');

print "Running Aspose\\Email\\ProgrammingOutlook\\WorkingWithOutlookPersonalStorage\\CreatePST::run()" . PHP_EOL;
CreatePST::run(__DIR__ . '/data/ProgrammingOutlook/WorkingWithOutlookPersonalStorage/CreatePST/');

print "Running Aspose\\Email\\ProgrammingOutlook\\WorkingWithOutlookPersonalStorage\\SearchMessagesAndFoldersInPST::run()" . PHP_EOL;
SearchMessagesAndFoldersInPST::run(__DIR__ . '/data/ProgrammingOutlook/WorkingWithOutlookPersonalStorage/SearchMessagesAndFoldersInPST/');
