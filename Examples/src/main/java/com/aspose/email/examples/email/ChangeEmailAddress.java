package com.aspose.email.examples.email;

import com.aspose.email.MailAddress;
import com.aspose.email.MailMessage;
import com.aspose.email.SmtpClient;

/*
This project uses automatic dependency resolution feature of Maven to resolve Aspose.Email for Java API reference when the project is build. Please check https://maven.apache.org/what-is-maven.html for more information. If you do not wish to use Maven, you can manually download Aspose.Email for Java API from http://www.aspose.com/downloads, install it and then add its reference to this project. For any issues, questions or suggestions please feel free to contact us using http://www.aspose.com/community/forums/default.aspx
 */

public class ChangeEmailAddress {
    public static void main(String[] args) {
        // ExStart:ChangeEmailAddress
        MailMessage message = new MailMessage("Sender Name <sender@from.com>", "Kyle Huang <kyle@to.com>");

        // A To address with a friendly name can also be specified like this
        message.getTo().addMailAddress(new MailAddress("kyle@to.com", "Kyle Huang"));

        // Specify Cc and Bcc email address along with a friendly name
        message.getCC().addMailAddress(new MailAddress("guangzhou@cc.com", "Guangzhou Team"));
        message.getBcc().addMailAddress(new MailAddress("ahaq@bcc.com", "Ammad ulHaq "));

        // Create an instance of SmtpClient Class and Specify your mailing host server, Username, Password, Port
        SmtpClient client = new SmtpClient();
        client.setHost("smtp.server.com");
        client.setUsername("Username");
        client.setPassword("Password");
        client.setPort(25);

        try
        {
            // Client.Send will send this message
            client.send(message);
            System.out.println("Message sent");
        }

        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        // ExEnd:ChangeEmailAddress
    }
}
