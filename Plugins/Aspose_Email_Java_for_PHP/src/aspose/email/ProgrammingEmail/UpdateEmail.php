<?php
namespace Aspose\Email\ProgrammingEmail;

use com\aspose\email\MailMessage as MailMessage;
use com\aspose\email\MailAddressCollection as MailAddressCollection;
use com\aspose\email\MailMessageSaveType as MailMessageSaveType;
class UpdateEmail{

    public static function run($dataDir=null){

        # Initialize and Load an existing MSG file by specifying the MessageFormat
        $mailMessage=new MailMessage();
        $email = $mailMessage->load($dataDir . "Message.msg");

        # Initialize a String variable to get the Email Subject
        $subject = $email->getSubject();

        # Append some more information to Subject
//        $subject = $subject . " This text is added to the existing subject".PHP_EOL;

        # Set the Email Subject
        $email->setSubject('This text is added to the existing subject');

        # Initialize a String variable to get the Email's HTML Body
        $body = $email->getHtmlBody();

        # Apppend some more information to the Body variable
        $body = $body . "<br> This text is added to the existing body".PHP_EOL;

        # Set the Email Body
        $email->setHtmlBody($body);

        # Initialize MailAddressCollection object
        $contacts = new MailAddressCollection();

        # Retrieve Email's TO list
        $contacts = $email->getTo();

        # Add another email address to collection
        $contacts->add("to1@domain.com");

        # Set the collection as Email's TO list
        $email->setTo($contacts);

        # Initialize MailAddressCollection
        $contacts = new MailAddressCollection();

        # Retrieve Email's CC list
        $contacts = $email->getCC();

        # Add another email address to collection
        $contacts->add("cc2@domain.com");

        # Set the collection as Email's CC list
        $email->setCC($contacts);

        # Save the Email message to disk by specifying the MessageFormat
        $mailMessageSaveType=new MailMessageSaveType();
        $email->save($dataDir . "UpdateMessage.msg", $mailMessageSaveType->getOutlookMessageFormat());

        # Display Status
        print "Updated email message Successfully.".PHP_EOL;
    }
}
?>