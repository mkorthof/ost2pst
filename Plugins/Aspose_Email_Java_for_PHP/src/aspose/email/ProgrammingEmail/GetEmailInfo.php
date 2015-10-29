<?php
namespace Aspose\Email\ProgrammingEmail;

use com\aspose\email\MessageFormat as MessageFormat;
use com\aspose\email\MailMessage as MailMessage;

class GetEmailInfo{

    public static function run($dataDir=null){

        # Create MailMessage instance by loading an Eml file
        $message_format = new MessageFormat();
        $mailMessage=new MailMessage();
        $message = $mailMessage->load($dataDir . "Message.eml");

        print "From: " . (string)$message->getFrom();

        print "To: " . (string)$message->getTo();

        print "Subject: " . (string)$message->getSubject();

        print "HtmlBody: " . (string)$message->getHtmlBody();

        print "TextBody: " . (string)$message->getTextBody();
    }

}
?>