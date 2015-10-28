<?php
namespace Aspose\Email\ProgrammingOutlook\WorkingWithOutlookMessageFiles;

use com\aspose\email\MapiMessage as MapiMessage;

class ParseOutlookMessageFile{

    public static function run($dataDir=null){

        $mapiMessage=new MapiMessage();
        $outlook_message_file = $mapiMessage->fromFile($dataDir . "Message.msg");

        # Display sender's name
        print "Sender Name : " . $outlook_message_file->getSenderName();

        #Display Subject
        print "Subject : " . $outlook_message_file->getSubject();

        # Display Body
        print "Body : " . $outlook_message_file->getBody();
    }
}
?>