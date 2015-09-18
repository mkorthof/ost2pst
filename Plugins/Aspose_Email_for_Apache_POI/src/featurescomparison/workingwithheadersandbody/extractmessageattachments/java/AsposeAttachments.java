package featurescomparison.workingwithheadersandbody.extractmessageattachments.java;

import com.aspose.email.Attachment;
import com.aspose.email.AttachmentCollection;
import com.aspose.email.MailMessage;
import com.aspose.email.MessageFormat;

public class AsposeAttachments
{
	public static void main(String[] args)
	{
		String dataPath = "src/featurescomparison/workingwithheadersandbody/extractmessageattachments/data/";
		
		MailMessage message = MailMessage.load(dataPath + "message.msg");

		AttachmentCollection attachments = message.getAttachments();
		
		for (int i = 0; i < attachments.size(); i++)
		{
		    Attachment att = (Attachment) attachments.get_Item(i);
		    System.out.println("Attachment Name: " + att.getName());
		
		    // Get the name of attachment. If msg subject contains characters like :, /, \ etc., replace with space
		    // because windows cannot save files with these characters
		    // also save first 50 characters as file name to avoid long file names
		    String attFileName = att.getName().replace(".eml", "").replace(":", " ").replace("\\", " ").replace("/", " ").replace("?", "");
		    if (attFileName.length() > 50)
		    {
		        attFileName = attFileName.substring(0, 50);
		    }
		
		    // Save the attachment to disk
		    att.save(dataPath + "att/" + attFileName);
		}
		System.out.println("Done ...");
	}
}