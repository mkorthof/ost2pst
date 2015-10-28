<?php
namespace Aspose\Email\ProgrammingOutlook\WorkingWithOutlookPersonalStorage;

use com\aspose\email\PersonalStorage as PersonalStorage;
use com\aspose\email\FileFormatVersion as FileFormatVersion;
use com\aspose\email\StandardIpmFolder as StandardIpmFolder;

class AddFileToPST{

    public static function run($dataDir=null){

        $personalStorage=new PersonalStorage();
        $fileFormatVersion=new FileFormatVersion();

        $pst = $personalStorage->create($dataDir . "AddFile2.pst", $fileFormatVersion->Unicode);
        $standardIpmFolder=new StandardIpmFolder();
        $fi = $pst->createPredefinedFolder("Inbox", $standardIpmFolder->Inbox);

        $fi->addFile($dataDir . "Report.xlsx", "IPM.Document.Excel.Sheet.8");

        $pst->dispose();

        print "Added file to PST".PHP_EOL;
    }

}
?>