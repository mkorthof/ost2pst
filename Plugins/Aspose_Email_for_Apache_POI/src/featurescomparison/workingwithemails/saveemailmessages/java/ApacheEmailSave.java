package featurescomparison.workingwithemails.saveemailmessages.java;

import java.io.PrintWriter;

import org.apache.poi.hsmf.MAPIMessage;

public class ApacheEmailSave
{
	public static void main(String[] args) throws Exception
	{
		String dataPath = "src/featurescomparison/workingwithemails/saveemailmessages/data/";
		
		String filename = dataPath + "message.msg";
		MAPIMessage msg = new MAPIMessage(filename);
				
		PrintWriter txtOut = new PrintWriter(dataPath + "ApacheMessage.txt");
		txtOut.println("Email Body: " + msg.getTextBody());
		txtOut.close();
		
		System.out.println("Done ...");	 
	}
}
