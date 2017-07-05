package com.aspose.email.examples.email;

import java.util.Date;

import com.aspose.email.DeliveryNotificationOptions;
import com.aspose.email.MailAddress;
import com.aspose.email.MailMessage;
import com.aspose.email.MailPriority;
import com.aspose.email.MailSensitivity;
import com.aspose.email.SaveOptions;
import com.aspose.email.examples.Utils;

/*
This project uses automatic dependency resolution feature of Maven to resolve Aspose.Email for Java API reference when the project is build. Please check https://maven.apache.org/what-is-maven.html for more information. If you do not wish to use Maven, you can manually download Aspose.Email for Java API from http://www.aspose.com/downloads, install it and then add its reference to this project. For any issues, questions or suggestions please feel free to contact us using http://www.aspose.com/community/forums/default.aspx
 */

public class UseMailMessageFeatures {
    public static void main(String[] args) {
        // The path to the resource directory.
        String dataDir = Utils.getSharedDataDir(UseMailMessageFeatures.class) + "email/";

        // ExStart:MailMessageFeatures
        // Create a new message
        MailMessage message = new MailMessage();
        message.setFrom(new MailAddress("sender@gmail.com"));
        message.getTo().add("receiver@gmail.com");
        message.setSubject("Using MailMessage Features");

        // Specify message date
        message.setDate(new Date());

        // Specify message priority
        message.setPriority(MailPriority.High);

        // Specify message sensitivity
        message.setSensitivity(MailSensitivity.Normal);

        // Specify options for delivery notifications
        message.setDeliveryNotificationOptions(DeliveryNotificationOptions.OnSuccess);
        // ExEnd:MailMessageFeatures

        message.save(dataDir + "UseMailMessageFeatures_out.eml", SaveOptions.getDefaultEml());
    }
}
