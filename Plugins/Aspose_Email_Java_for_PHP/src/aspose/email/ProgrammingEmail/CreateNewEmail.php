<?php
namespace Aspose\Email\ProgrammingEmail;

use com\aspose\email\MailMessage as MailMessage;
use com\aspose\email\MailAddress as MailAddress;
use com\aspose\email\MailMessageSaveType as MailMessageSaveType;

class CreateNewEmail{

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

        # Add CC recipients
        $message->getCC()->add(new MailAddress("cc1@domain.com", "Recipient 3", false));
        $message->getCC()->add(new MailAddress("cc2@domain.com", "Recipient 4", false));

        # Save message in EML and MSG formats
        $mail_message_save_type = new MailMessageSaveType();
        $message->save($dataDir . "Message.eml", $mail_message_save_type->getEmlFormat());
        $message->save($dataDir . "Message.msg", $mail_message_save_type->getOutlookMessageFormat());
        # Display Status
        print "Created email messages Successfully.".PHP_EOL;
    }
}
?>