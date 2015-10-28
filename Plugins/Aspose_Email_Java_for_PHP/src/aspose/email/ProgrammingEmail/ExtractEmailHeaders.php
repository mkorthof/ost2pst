<?php
namespace Aspose\Email\ProgrammingEmail;

use com\aspose\email\MailMessage as MailMessage;

class ExtractEmailHeaders{

    public static function run($dataDir=null){

        # Initialize and Load an existing EML file by specifying the MessageFormat
        $mailMessage=new MailMessage();

        $message = $mailMessage->load($dataDir . "Message.eml");

        print "Printing all Headers:".PHP_EOL;

        # Print out all the headers
        $i=0;
        while ($i < sizeof($message->getHeaders()->getCount())) {
            print $message.$message->getHeaders()->get($i);
            $i += 1;
        }
    }
}
?>