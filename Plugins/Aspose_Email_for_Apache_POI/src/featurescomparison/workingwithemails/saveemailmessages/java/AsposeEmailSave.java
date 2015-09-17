package featurescomparison.workingwithemails.saveemailmessages.java;

import com.aspose.email.MailMessage;
import com.aspose.email.MessageFormat;

public class AsposeEmailSave
{
	public static void main(String[] args)
	{
		String dataPath = "src/featurescomparison/workingwithemails/saveemailmessages/data/";
		
		MailMessage messageMSG 	= MailMessage.load(dataPath + "message.msg");
				
		messageMSG.save(dataPath + "AsposeMessage.msg", MessageFormat.getMsg());
		
		messageMSG.save(dataPath + "AsposeMessage.eml", MessageFormat.getEml());
		messageMSG.save(dataPath + "AsposeMessage.emlx", MessageFormat.getEmlx());
		messageMSG.save(dataPath + "AsposeMessage.mht", MessageFormat.getMht());
		
		System.out.println("Done ...");
	}
}