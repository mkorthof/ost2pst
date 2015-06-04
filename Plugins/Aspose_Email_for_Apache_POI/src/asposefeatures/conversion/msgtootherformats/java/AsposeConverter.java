package asposefeatures.conversion.msgtootherformats.java;

import com.aspose.email.MailMessage;
import com.aspose.email.MailMessageSaveType;
import com.aspose.email.MessageFormat;

public class AsposeConverter
{
	public static void main(String[] args)
	{
		String dataPath = "src/asposefeatures/conversion/msgtootherformats/data/";
		
	    // Initialize and Load an existing MSG file by specifying the MessageFormat
	    MailMessage msg = MailMessage.load(dataPath + "message.msg", MessageFormat.getMsg());

	    // Save the Email message to disk by specifying the EML and MHT MailMessageSaveType
	    msg.save(dataPath + "AsposeMessage.eml", MailMessageSaveType.getEmlFormat());
	    msg.save(dataPath + "Asposemessage.mhtml", MailMessageSaveType.getMHtmlFromat());
	    
	    System.out.println("Done");
	}
}