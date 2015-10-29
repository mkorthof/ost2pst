<?php
namespace Aspose\Email\ProgrammingEmail;

use com\aspose\email\MailMessage as MailMessage;
use com\aspose\email\SaveOptions as SaveOptions;

class Converter{

    public static function run($dataDir=null){

        # Loading EML, Saving to MSG
        Converter::convert_eml_to_msg($dataDir);
    }

    public static function convert_eml_to_msg($dataDir=null){

        # Initialize and Load an existing EML file by specifying the MessageFormat
        $mailMessage=new MailMessage();
        $eml = $mailMessage->load($dataDir . "Message.eml");

        # Save the Email message to disk in Unicode format
        $saveOptions=new SaveOptions();
        $eml->save($dataDir . "AnEmail.msg", $saveOptions->getDefaultMsgUnicode());

        # Display Status
        print "Converted email to msg successfully.".PHP_EOL;

    }

}
?>