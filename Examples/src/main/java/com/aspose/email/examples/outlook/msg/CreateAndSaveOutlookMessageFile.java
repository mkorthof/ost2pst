package com.aspose.email.examples.outlook.msg;

import com.aspose.email.MailAddress;
import com.aspose.email.MailAddressCollection;
import com.aspose.email.MailMessage;
import com.aspose.email.MapiConversionOptions;
import com.aspose.email.MapiMessage;
import com.aspose.email.examples.Utils;

public class CreateAndSaveOutlookMessageFile {

	public static void main(String[] args) {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(CreateAndSaveOutlookMessageFile.class) + "outlook/";
		createAndSaveOutlookMessageFile(dataDir);
		
		//RTF body compression method use to generate a smaller size MSG
		bodyCompressionFlagSetToTrue(dataDir);
		
		//By setting RTF body compression flag to false, cause messages to create with improved speed
		bodyCompressionFlagSetToFalse(dataDir);
	}

	public static void createAndSaveOutlookMessageFile(String dataDir) {
		// Create an instance of MailMessage class
		MailMessage mailMsg = new MailMessage();

		// Set FROM field of the message
		mailMsg.setFrom(new MailAddress("from@domain.com"));

		// Create an instance of MailAddressCollection
		MailAddressCollection addressCol = new MailAddressCollection();

		// Add an address to MailAddressCollection
		addressCol.addMailAddress(new MailAddress("to@domain.com"));

		// Set the MailAddressCollection as TO field of the message
		mailMsg.setTo(addressCol);

		// Set SUBJECT of the message
		mailMsg.setSubject("creating an outlook message file");

		// Set BODY of the message
		mailMsg.setTextBody("This message is created by Aspose.Email for Java");

		// Create an instance of MapiMessage class and pass MailMessage as argument
		MapiMessage outlookMsg = MapiMessage.fromMailMessage(mailMsg);

		// Path and file name where message file will be saved
		String strMsgFile = dataDir + "message_out.msg";

		// Save the message (msg) file
		outlookMsg.save(strMsgFile);
	}
	
	public static void bodyCompressionFlagSetToTrue(String dataDir) {
		MailMessage msg = MailMessage.load(dataDir + "message.msg");
		MapiConversionOptions options = new MapiConversionOptions();
		options.setUseBodyCompression(true);
		MapiMessage ae_mapi = MapiMessage.fromMailMessage(msg, options);
	}
	
	public static void bodyCompressionFlagSetToFalse(String dataDir) {
		MailMessage msg = MailMessage.load(dataDir + "message.msg");
		MapiConversionOptions options = new MapiConversionOptions();
		MapiMessage ae_mapi = MapiMessage.fromMailMessage(msg, options);
	}

}
