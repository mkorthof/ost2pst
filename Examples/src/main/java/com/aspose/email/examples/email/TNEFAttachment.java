package com.aspose.email.examples.email;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.aspose.email.Attachment;
import com.aspose.email.MailMessage;
import com.aspose.email.MailMessageInterpretor;
import com.aspose.email.MailMessageInterpretorFactory;
import com.aspose.email.MapiMessage;
import com.aspose.email.examples.Utils;

public class TNEFAttachment {

	public static void main(String[] args) throws FileNotFoundException {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(SaveMessageAsDraft.class) + "email/";

		// Adding New Attachments to Main Message Containing TNEF
		addNewAttachmentToMessageContainingTNEF(dataDir);
		
		// Creating TNEF EML from MSG
		creatingTNEFEMLFromMSG(dataDir);
		
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
		MailMessageInterpretor mi = MailMessageInterpretorFactory.getInstance().getIntepretor(msg.getMessageClass());
		MailMessage eml = mi.interpretAsTnef(msg);
	}

	public static void detectIfAMessageIsTNEF(String dataDir) {
		MailMessage mail = MailMessage.load(dataDir + "test.eml");
		boolean isTnef = mail.getOriginalIsTnef();
		System.out.println("isTnef: " + isTnef);
	}
}
