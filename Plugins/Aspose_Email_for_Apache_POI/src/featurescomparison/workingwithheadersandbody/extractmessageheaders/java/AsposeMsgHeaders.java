package featurescomparison.workingwithheadersandbody.extractmessageheaders.java;

import com.aspose.email.MailMessage;
import com.aspose.email.MessageFormat;

public class AsposeMsgHeaders
{
	public static void main(String[] args)
	{
		String dataPath = "src/featurescomparison/workingwithheadersandbody/extractmessageheaders/data/";
		
		MailMessage message = MailMessage.load(dataPath + "message.msg", MessageFormat.getMsg());

		//Gets Email Headers
		System.out.println("From: " 	+ message.getFrom());
		System.out.println("To: " 		+ message.getTo());
		System.out.println("CC: " 		+ message.getCC());
		System.out.println("Bcc: " 		+ message.getBcc());
		System.out.println("Subject: " 	+ message.getSubject());		
	}
}