package featurescomparison.workingwithemails.loademailmessages.java;

import org.apache.poi.hsmf.MAPIMessage;

public class ApacheLoadEmailMsg
{
	public static void main(String[] args) throws Exception
	{
		String dataPath = "src/featurescomparison/workingwithemails/loademailmessages/data/";

		String filename = dataPath + "message.msg";

		MAPIMessage msg = new MAPIMessage(filename);
		
		System.out.println("Done ...");	 
	}
}
