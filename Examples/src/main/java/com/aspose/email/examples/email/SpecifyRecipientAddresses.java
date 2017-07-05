package com.aspose.email.examples.email;

import com.aspose.email.MailAddress;
import com.aspose.email.MailAddressCollection;
import com.aspose.email.MailMessage;
import com.aspose.email.SmtpClient;

/*
This project uses automatic dependency resolution feature of Maven to resolve Aspose.Email for Java API reference when the project is build. Please check https://maven.apache.org/what-is-maven.html for more information. If you do not wish to use Maven, you can manually download Aspose.Email for Java API from http://www.aspose.com/downloads, install it and then add its reference to this project. For any issues, questions or suggestions please feel free to contact us using http://www.aspose.com/community/forums/default.aspx
 */

public class SpecifyRecipientAddresses {

    public static void main(String[] args) {
        // ExStart:SpecifyRecipientAddresses
        // Declare message as MailMessage instance
        // Create an Instance of MailMessage class
        MailMessage message = new MailMessage();

        // Specify From address
        message.setFrom(new MailAddress("sender@sender.com"));

        //  Specify recipients’ mail addresses
        MailAddressCollection toList = new MailAddressCollection();
        toList.add("receiver1@receiver.com");
        toList.add("receiver2@receiver.com");
        toList.add("receiver3@receiver.com");
        message.setTo(toList);

        // Specify CC addresses
        MailAddressCollection ccList = new MailAddressCollection();
        ccList.add("CC1@receiver.com");
        ccList.add("CC2@receiver.com");
        message.setCC(ccList);

        // Specify BCC addresses
        MailAddressCollection bccList = new MailAddressCollection();
        bccList.add("Bcc1@receiver.com");
        bccList.add("Bcc2@receiver.com");
        message.setBcc(bccList);

        // Create an instance of SmtpClient Class
        SmtpClient client = new SmtpClient();

        // Specify your mailing host server, Username, Password, Port
        client.setHost("smtp.server.com");
        client.setUsername("Username");
        client.setPassword("Password");
        client.setPort(25);

        try
        {
            // Client.Send will send this message
            client.send(message);

            // Display ‘Message Sent’, only if message sent successfully
            System.out.println("Message sent");
        }

        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        // ExEnd:SpecifyRecipientAddresses
    }
}
