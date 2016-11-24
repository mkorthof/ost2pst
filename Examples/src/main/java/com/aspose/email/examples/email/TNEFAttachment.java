package com.aspose.email.examples.email;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.aspose.email.*;
import com.aspose.email.examples.Utils;

public class TNEFAttachment {

	public static void main(String[] args) throws FileNotFoundException {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(TNEFAttachment.class) + "email/";

		// Adding New Attachments to Main Message Containing TNEF
		addNewAttachmentToMessageContainingTNEF(dataDir);

		// Creating TNEF EML from MSG
		creatingTNEFEMLFromMSG(dataDir);
		
		// Create the TNEF
		createTNEF(dataDir);
		
		//Detecting if a Message is TNEF
		detectIfAMessageIsTNEF(dataDir);
	}

	public static void addNewAttachmentToMessageContainingTNEF(String dataDir) throws FileNotFoundException {
		String fileName = "MainMessage.eml";
		String attachName = "barcode.png";
		String outFileName = "test_out.eml";

		FileInputStream fi = new FileInputStream(dataDir + attachName);
		MailMessage eml = MailMessage.load(dataDir + fileName);
		eml.getAttachments().addItem(new Attachment(fi, "barcode.png", "image/png"));
		eml.save(dataDir + outFileName);
	}

	public static void creatingTNEFEMLFromMSG(String dataDir) {
		MapiMessage msg = MapiMessage.fromFile(dataDir + "Message.msg");
		MailConversionOptions options = new MailConversionOptions();
		options.setConvertAsTnef (true);
		MailMessage mail = msg.toMailMessage(options);
	}
	
	public static void createTNEF(String dataDir) {
		MsgLoadOptions msgLoadOptions = new MsgLoadOptions();
		// The PreserveTnefAttachments option with MessageFormat.Msg will create the TNEF eml.
		msgLoadOptions.setPreserveTnefAttachments(true);

		MailMessage eml = MailMessage.load(dataDir + "test.eml", msgLoadOptions);
	}
	
	public static void detectIfAMessageIsTNEF(String dataDir) {
		MailMessage mail = MailMessage.load(dataDir + "test.eml");
		boolean isTnef = mail.getOriginalIsTnef();
		System.out.println("isTnef: " + isTnef);
	}
}
