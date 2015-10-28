<?php
namespace Aspose\Email\ProgrammingEmail;

use com\aspose\email\MailMessage as MailMessage;
use com\aspose\email\MailAddress as MailAddress;
use com\aspose\email\MessageFormat as MessageFormat;

use java\util\TimeZone as TimeZone;
use java\util\Calendar as Calendar;

class CustomizeEmailHeaders{

    public static function run($dataDir=null){

        # Create a new instance of MailMessage class
        $message = new MailMessage();

            # Set subject of the message
        $message->setSubject("New message created by Aspose.Email for Java");

        # Set Html body
        $message->setHtmlBody("<b>This line is in bold.</b> <br/> <br/>" .
            "<font color=blue>This line is in blue color</font>");

        # Set sender information
        $message->setFrom(new MailAddress("from@domain.com", "Sender Name", false));

        # Add TO recipients
        $message->getTo()->add(new MailAddress("to@domain.com", "Recipient 1", false));

        # Message subject
        $message->setSubject("Customizing Email Headers");

        # Specify Date

        $timeZone=new TimeZone();
        $calendar=new Calendar();
        $calendar = $calendar->getInstance($timeZone->getTimeZone("GMT"));

        $date = $calendar->getTime();
        $message->setDate($date);

        # Specify XMailer
        $message->setXMailer("Aspose.Email");

        # Specify Secret Header
        $message->getHeaders()->add("secret-header", "mystery");

        # Save message to disc
        $messageFormat=new MessageFormat();
        $message->save($dataDir . "MsgHeaders.msg", $messageFormat->getMsg());

        # Display Status
        print "Customized message headers Successfully.".PHP_EOL;
    }

}
?>