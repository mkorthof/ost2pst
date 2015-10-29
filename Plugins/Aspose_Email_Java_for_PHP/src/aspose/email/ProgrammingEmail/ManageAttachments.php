<?php
namespace Aspose\Email\ProgrammingEmail;

use com\aspose\email\MailMessage as MailMessage;
use com\aspose\email\MailAddress as MailAddress;
use com\aspose\email\Attachment as Attachment;
use com\aspose\email\MessageFormat as MessageFormat;
class ManageAttachments{

    public static function run($dataDir=null){
        # Adding Attachments to a New Email Message
        ManageAttachments::add_attachments($dataDir);
    }

    public static function add_attachments($dataDir=null){

        # Create a new instance of MailMessage class
        $message =new MailMessage();

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

        # Adding attachment
        # Load an attachment

        $attachment = new Attachment($dataDir . "1.txt");

        # Add attachment in instance of MailMessage class
        $message->addAttachment($attachment);

        # Save message to disc
        $messageFormat=new MessageFormat();
        $message->save($dataDir . "Add-Attachment.msg", $messageFormat->getMsg());

        # Display Status
        print "Added attachment successfully.".PHP_EOL;

    }
}
?>