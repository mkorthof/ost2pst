package asposefeatures.programmingemail.addembeddedimagestoemail.java;

import com.aspose.email.LinkedResource;
import com.aspose.email.MailAddress;
import com.aspose.email.MailMessage;
import com.aspose.email.MailMessageSaveType;
import com.aspose.email.MediaTypeNames;

public class EmbeddedImageInEmail
{
	public static void main(String[] args)
	{
		String dataPath = "src/asposefeatures/programmingemail/addembeddedimagestoemail/data/";
		
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
	    LinkedResource res = new LinkedResource(dataPath + "Aspose.png", MediaTypeNames.Image.PNG);
	    res.setContentId("companylogo");

	    // Add Linked resource to the message’s Linked resource collection
	    message.getLinkedResources().addItem(res);

	    // Save message in EML, MSG and MHTML formats
	    message.save(dataPath + "New.eml", MailMessageSaveType.getEmlFormat());
	    message.save(dataPath + "New.msg", MailMessageSaveType.getOutlookMessageFormat());
	    message.save(dataPath + "New.mhtml", MailMessageSaveType.getMHtmlFromat());
	    
	    System.out.println("Done.");
	}
}
