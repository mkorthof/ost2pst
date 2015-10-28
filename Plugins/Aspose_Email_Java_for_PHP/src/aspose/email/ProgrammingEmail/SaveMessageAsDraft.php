<?php
namespace Aspose\Email\ProgrammingEmail;

use com\aspose\email\MailMessage as MailMessage;
use com\aspose\email\MailAddress as MailAddress;
use com\aspose\email\MapiMessage as MapiMessage;
use com\aspose\email\MapiMessageFlags as MapiMessageFlags;
class SaveMessageAsDraft{

    public static function run($dataDir=null){
        # Create a new instance of MailMessage class
        $message = new MailMessage();

            # Set subject of the message
        $message->setSubject("New message created by Aspose.Email for Java");

        $mail_address = new MailAddress();

        # Set Html body
        $message->setHtmlBody("<b>This line is in bold.</b> <br/> <br/>" .
            "<font color=blue>This line is in blue color</font>");

        # Set sender information
        $message->setFrom(new MailAddress("from@domain.com", "Sender Name", false));

        # Add TO recipients
        $message->getTo()->add(new MailAddress("to1@domain.com", "Recipient 1", false));
        $message->getTo()->add(new MailAddress("to2@domain.com", "Recipient 2", false));

        # Create an instance of MapiMessage and load the MailMessag instance into it
        $mapiMessage=new MapiMessage();
        $mapi_msg = $mapiMessage->fromMailMessage($message);

        # Set the MapiMessageFlags as UNSENT and FROMME
        $mapi_message_flags = new MapiMessageFlags();
//        $mapi_msg->setMessageFlags($mapi_message_flags->MSGFLAG_UNSENT || $mapi_message_flags->MSGFLAG_FROMME);

        # Save the MapiMessage to disk
        $mapi_msg->save($dataDir . "New-Draft.msg");

        # Display Status
        print "Draft saved Successfully.".PHP_EOL;
    }

}
?>