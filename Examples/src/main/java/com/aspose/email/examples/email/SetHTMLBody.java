package com.aspose.email.examples.email;

import com.aspose.email.MailMessage;
import com.aspose.email.SaveOptions;
import com.aspose.email.examples.Utils;

/*
This project uses automatic dependency resolution feature of Maven to resolve Aspose.Email for Java API reference when the project is build. Please check https://maven.apache.org/what-is-maven.html for more information. If you do not wish to use Maven, you can manually download Aspose.Email for Java API from http://www.aspose.com/downloads, install it and then add its reference to this project. For any issues, questions or suggestions please feel free to contact us using http://www.aspose.com/community/forums/default.aspx
 */

public class SetHTMLBody {
    public static void main(String[] args) {
        // ExStart:SetHTMLBody
        // Declare message as MailMessage instance
        MailMessage message = new MailMessage();

        // Specify HtmlBody
        message.setHtmlBody("<html><body>This is the HTML body</body></html>");
        // ExEnd:SetHTMLBody

        // The path to the resource directory.
        String dataDir = Utils.getSharedDataDir(SetHTMLBody.class) + "email/";
        message.save(dataDir + "SetHtmlBody_out.eml", SaveOptions.getDefaultEml());

    }
}

