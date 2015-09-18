package asposefeatures.conversion.savemessageaspdf.java;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

import com.aspose.email.MailMessage;
import com.aspose.email.SaveOptions;
import com.aspose.words.Document;
import com.aspose.words.LoadFormat;
import com.aspose.words.LoadOptions;
import com.aspose.words.SaveFormat;

public class SaveMessageAsPDF
{
	public static void main(String[] args) throws Exception
	{
		String dataPath = "src/asposefeatures/conversion/savemessageaspdf/data/";

		FileInputStream fstream = new FileInputStream(dataPath + "message.msg");
		MailMessage eml = MailMessage.load(fstream);

		// Save the Message to output stream in MHTML format
		ByteArrayOutputStream emlStream = new ByteArrayOutputStream();
		eml.save(emlStream, SaveOptions.getDefaultMhtml());

		// Load the stream in Word document
		LoadOptions lo = new LoadOptions();
		lo.setLoadFormat(LoadFormat.MHTML);
		Document doc = new Document(new ByteArrayInputStream(
				emlStream.toByteArray()), lo);

		// Save to disc
		doc.save(dataPath + "About Aspose.Pdf", SaveFormat.PDF);

		// or Save to stream
		ByteArrayOutputStream foStream = new ByteArrayOutputStream();
		doc.save(foStream, SaveFormat.PDF);
		
		System.out.println("Done");
	}
}
