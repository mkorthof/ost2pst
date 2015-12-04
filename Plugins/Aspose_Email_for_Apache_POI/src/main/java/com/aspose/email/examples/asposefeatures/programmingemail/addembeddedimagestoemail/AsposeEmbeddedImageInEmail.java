package com.aspose.email.examples.asposefeatures.programmingemail.addembeddedimagestoemail;

import com.aspose.email.LinkedResource;
import com.aspose.email.MailAddress;
import com.aspose.email.MailMessage;
import com.aspose.email.MailMessageSaveType;
import com.aspose.email.MediaTypeNames;
import com.aspose.email.examples.Utils;

public class AsposeEmbeddedImageInEmail
{
    public static void main(String[] args)
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(AsposeEmbeddedImageInEmail.class);

        // Create a new instance of MailMessage class
        MailMessage message = new MailMessage();

        // Set sender information
        message.setFrom(new MailAddress("from@domain.com", "Sender Name", false));

        // Add recipients
        message.getTo().addMailAddress(new MailAddress("to1@domain.com", "Recipient 1", false));
        message.getTo().addMailAddress(new MailAddress("to2@domain.com", "Recipient 2", false));

        // Set subject of the message
        message.setSubject("New message created by Aspose.Email for Java");

        // Set Html body. It also contains <img> tag with cid. cid = LinkedResource.ContentID
        message.setHtmlBody("<b>This line is in bold.</b> <br/> <br/>"
                + "<font color=blue>This line is in blue color</font><br><br>" +
                "Here is an embedded image.<img src=cid:companylogo>");

        // Add linked resource
        LinkedResource res = new LinkedResource(dataDir + "Aspose.png", MediaTypeNames.Image.PNG);
        res.setContentId("companylogo");

        // Add Linked resource to the message’s Linked resource collection
        message.getLinkedResources().addItem(res);

        // Save message in EML, MSG and MHTML formats
        message.save(dataDir + "New.eml", MailMessageSaveType.getEmlFormat());
        message.save(dataDir + "New.msg", MailMessageSaveType.getOutlookMessageFormat());
        message.save(dataDir + "New.mhtml");

        System.out.println("Done.");
    }
}
