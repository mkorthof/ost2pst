package featurescomparison.workingwithemails.loademailmessages.java;

import com.aspose.email.MailMessage;
import com.aspose.email.MessageFormat;

public class AsposeLoadEmailMsg
{
	public static void main(String[] args)
	{
		String dataPath = "src/featurescomparison/workingwithemails/loademailmessages/data/";
		
		System.out.println("Loading Message");
		//Create MailMessage instance by loading an Eml/Msg/Emlx/Mht file
		MailMessage messageMSG = MailMessage.load(dataPath + "message.msg",
				MessageFormat.getMsg());

		MailMessage messageEML 	= MailMessage.load(dataPath + "message.eml", MessageFormat.getEml());
		//MailMessage messageEMLX = MailMessage.load("data/message.emlx", MessageFormat.getEmlx());
		//MailMessage messageMHT 	= MailMessage.load("data/message.mht", MessageFormat.getMht());
		
		System.out.println("Done ...");
	}
}
