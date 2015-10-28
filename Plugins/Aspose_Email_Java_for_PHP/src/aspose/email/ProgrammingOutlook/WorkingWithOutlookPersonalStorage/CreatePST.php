<?php
namespace Aspose\Email\ProgrammingOutlook\WorkingWithOutlookPersonalStorage;

use com\aspose\email\PersonalStorage as PersonalStorage;
use com\aspose\email\MapiMessage as MapiMessage;
class CreatePST{

    public static function run($dataDir=null){

        # Create an instance of PersonalStorage
        $personalStorage=new PersonalStorage();
        $pst = $personalStorage->create($dataDir . "sample1.pst", 0);

        # Create a folder at root of pst
        $pst->getRootFolder()->addSubFolder("myInbox");

        # Add message to newly created folder
        $mapi_message = new MapiMessage();
        $pst->getRootFolder()->getSubFolder("myInbox")->addMessage($mapi_message->fromFile($dataDir . "Message.msg"));

        print "Created PST successfully.".PHP_EOL;
    }
}
?>