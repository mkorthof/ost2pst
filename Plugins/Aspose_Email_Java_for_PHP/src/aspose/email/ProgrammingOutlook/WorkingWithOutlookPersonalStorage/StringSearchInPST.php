<?php
namespace Aspose\Email\ProgrammingOutlook\WorkingWithOutlookPersonalStorage;

use com\aspose\email\PersonalStorage as PersonalStorage;
use com\aspose\email\FileFormatVersion as FileFormatVersion;
use com\aspose\email\StandardIpmFolder as StandardIpmFolder;
use com\aspose\email\MapiMessage as MapiMessage;
use com\aspose\email\MailMessage as MailMessage;
use com\aspose\email\MailQueryBuilder as MailQueryBuilder;

class StringSearchInPST{

    public static function run($dataDir=null){

        $personalStorage=new PersonalStorage();
        $fileFormatVersion=new FileFormatVersion();
        $pst = $personalStorage->create($dataDir . "search.pst", $fileFormatVersion->Unicode);

        $standardIpmFolder=new StandardIpmFolder();
        $fi = $pst->createPredefinedFolder("Inbox", $standardIpmFolder->Inbox);

        $mapiMessage=new MapiMessage();
        $mailMessage=new MailMessage();
        $fi->addMessage($mapiMessage->fromMailMessage($mailMessage->load($dataDir . "search.pst")));

        $builder = new MailQueryBuilder();
        $builder->getFrom()->contains("automated", true);

        $query = $builder->getQuery();
        $coll = $fi->getContents($query);

        print "Total Results:" . (string)$coll->size();

    }
}
?>