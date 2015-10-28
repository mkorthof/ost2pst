<?php
namespace Aspose\Email\ProgrammingOutlook\WorkingWithOutlookPersonalStorage;

use com\aspose\email\PersonalStorage as PersonalStorage;
use com\aspose\email\PersonalStorageQueryBuilder as PersonalStorageQueryBuilder;
use com\aspose\email\MapiImportance as MapiImportance;
use com\aspose\email\MapiMessageFlags as MapiMessageFlags;
class SearchMessagesAndFoldersInPST{

    public static function run($dataDir=null){

        # Load the Outlook PST file
        $personalStorage=new PersonalStorage();
        $pst = $personalStorage->fromFile($dataDir . "sample1.pst");

        $folder = $pst->getRootFolder()->getSubFolder("myInbox");
        $builder = new PersonalStorageQueryBuilder();

            # High importance messages
        $mapiImportance=new MapiImportance();
        $builder->getImportance()->equals($mapiImportance->High);
        $messages = $folder->getContents($builder->getQuery());
        print "Messages with High Imp:" . (string)$messages->size();

        #builder = new PersonalStorageQueryBuilder();
        $builder->getMessageClass()->equals("IPM.Note");
        $messages = $folder->getContents($builder->getQuery());
        print "Messages with IPM.Note:" . (string)$messages->size();

        # Messages with attachments AND high importance
        $builder->getImportance()->equals($mapiImportance->High);

        $mapiMessageFlags=new MapiMessageFlags();

        $builder->hasFlags($mapiMessageFlags->MSGFLAG_HASATTACH);
        $messages = $folder->getContents($builder->getQuery());
        print "Messages with atts: " . (string)$messages->size();

        # Messages with size > 15 KB
        $builder->getMessageSize()->greater(15000);
        $messages = $folder->getContents($builder->getQuery());
        print "messags size > 15Kb:" . (string)$messages->size();

        # Unread messages
        $builder->hasNoFlags($mapiMessageFlags->MSGFLAG_READ);
        $messages = $folder->getContents($builder->getQuery());
        print "Unread:" . (string)$messages->size();//.to_s

        # Unread messages with attachments
        $builder->hasNoFlags($mapiMessageFlags->MSGFLAG_READ);
        $builder->hasFlags($mapiMessageFlags->MSGFLAG_HASATTACH);
        $messages = $folder->getContents($builder->getQuery());
        print "Unread msgs with atts: " . (string)$messages->size();
    }
}
?>