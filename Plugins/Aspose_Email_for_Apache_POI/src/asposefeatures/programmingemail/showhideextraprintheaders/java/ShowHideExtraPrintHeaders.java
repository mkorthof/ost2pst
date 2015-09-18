package asposefeatures.programmingemail.showhideextraprintheaders.java;

import com.aspose.email.MailMessage;
import com.aspose.email.MhtFormatOptions;
import com.aspose.email.MhtMessageFormatter;

public class ShowHideExtraPrintHeaders
{
	public static void main(String[] args)
	{
		String dataPath = "src/asposefeatures/programmingemail/showhideextraprintheaders/data/";
		
		String pageHeader = "<div><div class='pageHeader'>&quot;Panditharatne, Mithra&quot; &lt;mithra.panditharatne@cibc.com&gt;<hr/></div>";
		MailMessage message = MailMessage.load(dataPath + "message.eml");

		MhtMessageFormatter mailFormatter = new MhtMessageFormatter();
		int options =  MhtFormatOptions.HideExtraPrintHeader | MhtFormatOptions.WriteCompleteEmailAddressToMht;

		mailFormatter.format(message, options);

		if(!message.getHtmlBody().contains(pageHeader))
			System.out.println("True");
		else
			System.out.println("False");
	}
}
