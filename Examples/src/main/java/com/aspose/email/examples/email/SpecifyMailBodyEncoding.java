package com.aspose.email.examples.email;

import com.aspose.email.AlternateView;
import com.aspose.email.MailAddress;
import com.aspose.email.MailMessage;
import com.aspose.email.SmtpClient;

import java.nio.charset.Charset;

/*
This project uses automatic dependency resolution feature of Maven to resolve Aspose.Email for Java API reference when the project is build. Please check https://maven.apache.org/what-is-maven.html for more information. If you do not wish to use Maven, you can manually download Aspose.Email for Java API from http://www.aspose.com/downloads, install it and then add its reference to this project. For any issues, questions or suggestions please feel free to contact us using http://www.aspose.com/community/forums/default.aspx
 */

public class SpecifyMailBodyEncoding {
    public static void main(String[] args) {
        // ExStart:SpecifyMailBodyEncoding
        // Declare message as MailMessage instance
        MailMessage message = new MailMessage();

        // Specify From, To, HtmlBody, BodyEncoding field
        message.setFrom(new MailAddress("sender@sender.com"));
        message.getTo().add("receiver@receiver.com");
        message.setHtmlBody("<html><body>This is the Html body</body></html>");
        message.setBodyEncoding(Charset.forName("US-ASCII"));

        // Create an instance of SmtpClient Class and Specify your mailing host server, Username, Password and Port
        SmtpClient client = new SmtpClient();
        client.setHost("smtp.server.com");
        client.setUsername("Username");
        client.setPassword("Password");
        client.setPort(25);

        try
        {
            // Client.Send will send this message
            client.send(message);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        // ExEnd:SpecifyMailBodyEncoding
    }
}
