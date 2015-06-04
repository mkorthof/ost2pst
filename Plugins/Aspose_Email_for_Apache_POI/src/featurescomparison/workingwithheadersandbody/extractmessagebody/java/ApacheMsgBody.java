package featurescomparison.workingwithheadersandbody.extractmessagebody.java;

import org.apache.poi.hsmf.MAPIMessage;

public class ApacheMsgBody
{
	public static void main(String[] args) throws Exception
	{
		String dataPath = "src/featurescomparison/workingwithheadersandbody/extractmessagebody/data/";
		
		MAPIMessage msg = new MAPIMessage(dataPath + "message.msg");
	    
		double startTime = System.nanoTime();
		
		String messageTextBody = msg.getTextBody();
		
		System.out.println("Text Body:"+ messageTextBody);		
	}
}
