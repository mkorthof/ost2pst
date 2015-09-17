package featurescomparison.workingwithheadersandbody.extractmessagebody.java;

import com.aspose.email.MailMessage;
import com.aspose.email.MessageFormat;

public class AsposeMsgBody
{
	public static void main(String[] args) throws Exception
	{
		String dataPath = "src/featurescomparison/workingwithheadersandbody/extractmessagebody/data/";
		
		MailMessage msg = MailMessage.load(dataPath + "message.msg");

		String messageTextBody = msg.getTextBody();
		
		System.out.println("Body:"+ msg.getBody());
		System.out.println("Text Body:"+ messageTextBody);
		System.out.println("Text Body HTML:"+ msg.getHtmlBody());
	}
}