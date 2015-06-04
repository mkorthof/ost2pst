package featurescomparison.workingwithheadersandbody.extractmessageheaders.java;

import org.apache.poi.hsmf.MAPIMessage;

public class ApacheMsgHeaders
{
	public static void main(String[] args) throws Exception
	{
		String dataPath = "src/featurescomparison/workingwithheadersandbody/extractmessageheaders/data/";
		
		MAPIMessage msg = new MAPIMessage(dataPath + "message.msg");
		
		System.out.println("From: " + msg.getDisplayFrom());
		System.out.println("To: " + msg.getDisplayTo());
		System.out.println("CC: " + msg.getDisplayCC());
		System.out.println("BCC: " + msg.getDisplayBCC());
		System.out.println("Subject: " + msg.getSubject());
	}
}
