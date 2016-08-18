package com.aspose.email.examples.email;

import com.aspose.email.Appointment;
import com.aspose.email.EmlLoadOptions;
import com.aspose.email.EmlSaveOptions;
import com.aspose.email.FileCompatibilityMode;
import com.aspose.email.HtmlFormatOptions;
import com.aspose.email.HtmlSaveOptions;
import com.aspose.email.MailAddress;
import com.aspose.email.MailMessage;
import com.aspose.email.MailMessageSaveType;
import com.aspose.email.MapiConversionOptions;
import com.aspose.email.MapiMessage;
import com.aspose.email.MapiRecipient;
import com.aspose.email.MhtFormatOptions;
import com.aspose.email.MhtSaveOptions;
import com.aspose.email.MsgSaveOptions;
import com.aspose.email.SaveOptions;
import com.aspose.email.examples.Utils;

public class ConvertEmailMessages {

	public static void main(String[] args) {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(CreateNewEmail.class) + "email/";
		
		// Loading EML and Saving as EML
		loadingEMLAndSavingAsEML(dataDir);
		
		// Loading EML and Saving as EML Preserving the Original Boundaries
		loadingAndSavingAsEMLPreservingTheOriginalBoundaries(dataDir);
		
		// Saving as EML Preserving TNEF Attachments
		savingAsEMLPreservingTNEFAttachments(dataDir);
		
		// Loading EML, Saving to MSG
		loadingEMLSavingToMSG(dataDir);
		
		// Saving as MSG with Preserved Dates
		savingAsMSGWithPreservedDates(dataDir);
		
		// Saving MailMessage as MHTML
		savingMailMessageAsMHTML(dataDir);
		
		// Converting to MHTML with Optional Settings
		convertingToMHTMLWithOptionalSettings(dataDir);
		
		// Rendering Calendar Events to MHTML
		renderingCalendarEventsToMHTML(dataDir);
		
		// Saving Message as HTML
		savingMessageAsHTML(dataDir);
		
		// Preserving Original Email Address
		preservingOriginalEmailAddress(dataDir);
		
		// Status of Recipients from a Meeting Request
		statusOfRecipientsFromAMeetingRequest(dataDir);
	}

	public static void loadingEMLAndSavingAsEML(String dataDir) {
		MailMessage msg = MailMessage.load(dataDir + "test.eml", new EmlLoadOptions());
		// Save the Email message to disk by using the SaveOptions
		msg.save(dataDir + "LoadAndSaveFileAsEML_out.eml", SaveOptions.getDefaultEml());
	}

	public static void loadingAndSavingAsEMLPreservingTheOriginalBoundaries(String dataDir) {
		MailMessage eml = MailMessage.load(dataDir + "test.eml");
		// Save as eml with preserved original boundares
		EmlSaveOptions emlSaveOptions = new EmlSaveOptions(MailMessageSaveType.getEmlFormat());
		emlSaveOptions.setPreserveOriginalBoundaries(true);
		eml.save(dataDir + "PreserveOriginalBoundaries_out.eml", emlSaveOptions);
	}

	public static void savingAsEMLPreservingTNEFAttachments(String dataDir) {
		MailMessage eml = MailMessage.load(dataDir + "PreserveOriginalBoundaries.eml");
		// Save as eml with preserved thef attachment
		EmlSaveOptions emlSaveOptions = new EmlSaveOptions(MailMessageSaveType.getEmlFormat());
		emlSaveOptions.setFileCompatibilityMode(FileCompatibilityMode.PreserveTnefAttachments);
		eml.save(dataDir + "PreserveTNEFAttachment_out.eml", emlSaveOptions);
	}

	public static void loadingEMLSavingToMSG(String dataDir) {
		// Initialize and Load an existing EML file by specifying the MessageFormat
		MailMessage eml = MailMessage.load(dataDir + "test.eml");
		//Save the Email message to disk in Unicode format
		eml.save(dataDir + "LoadingEMLSavingToMSG_out.msg", SaveOptions.getDefaultMsgUnicode());
	}

	public static void savingAsMSGWithPreservedDates(String dataDir) {
		MailMessage eml = MailMessage.load(dataDir + "test.eml");
		// Save as msg with preserved dates
		MsgSaveOptions msgSaveOptions = new MsgSaveOptions(MailMessageSaveType.getOutlookMessageFormatUnicode());
		msgSaveOptions.setPreserveOriginalDates(true);
		eml.save(dataDir + "SavingAsMSGWithPreservedDates_out.msg", msgSaveOptions);
	}

	public static void savingMailMessageAsMHTML(String dataDir) {
		// Initialize and Load an existing EML file by specifying the MessageFormat
		MailMessage eml = MailMessage.load(dataDir + "test.eml");
		eml.save(dataDir + "SavingMailMessageAsMHTML_out.mthml", SaveOptions.getDefaultMhtml());
	}

	public static void convertingToMHTMLWithOptionalSettings(String dataDir) {
		MailMessage eml = MailMessage.load(dataDir + "test.eml");
		// Save as Mht with header
		MhtSaveOptions mhtSaveOptions = new MhtSaveOptions();
		int iSaveOptions = MhtFormatOptions.WriteHeader | MhtFormatOptions.HideExtraPrintHeader;
		mhtSaveOptions.setMhtFormatOptions(iSaveOptions);
		eml.save(dataDir + "ConvertingToMHTMLWithOptionalSettings_out.mht", mhtSaveOptions);
	}

	public static void renderingCalendarEventsToMHTML(String dataDir) {
		Appointment appointment = Appointment.load(dataDir + "test.ics");
		MailMessage outlookMsg = new MailMessage();
		outlookMsg.addAlternateView(appointment.requestApointment());
		MhtSaveOptions opt = SaveOptions.getDefaultMhtml();
		opt.setMhtFormatOptions(opt.getMhtFormatOptions() | MhtFormatOptions.RenderCalendarEvent);
		outlookMsg.save(dataDir + "RenderingCalendarEventsToMHTML_out.mht", opt);
	}

	public static void savingMessageAsHTML(String dataDir) {
		MailMessage msg = MailMessage.load(dataDir + "Message.msg");
		msg.save(dataDir + "SavingMessageAsHTML_out1.html", SaveOptions.getDefaultHtml());

		//or

		MailMessage eml = MailMessage.load(dataDir + "test.eml");
		HtmlSaveOptions options = SaveOptions.getDefaultHtml();
		options.setEmbedResources(false);
		options.setHtmlFormatOptions(HtmlFormatOptions.WriteHeader | HtmlFormatOptions.WriteCompleteEmailAddress);
		eml.save(dataDir + "SavingMessageAsHTML_out2.html", options);
	}

	public static void preservingOriginalEmailAddress(String dataDir) {
		MailMessage mailMsg = new MailMessage();
		mailMsg.setSubject("This is subject");
		mailMsg.setBody("This is body");
		String address = "a\"xasadf@xam.com";
		mailMsg.setFrom(new MailAddress(address));
		mailMsg.getTo().addMailAddress(new MailAddress(address));

		MapiConversionOptions cOpt = MapiConversionOptions.getUnicodeFormat();
		cOpt.setPreserveOriginalAddresses(true);

		MapiMessage outlookMsg = MapiMessage.fromMailMessage(mailMsg, cOpt);
		outlookMsg.save(dataDir + "PreservingOriginalEmailAddress_out.msg");
	}

	public static void statusOfRecipientsFromAMeetingRequest(String dataDir) {
		MapiMessage msg = MapiMessage.fromFile(dataDir + "Message.msg");
		for (MapiRecipient rec : msg.getRecipients()) {
			rec.getRecipientTrackStatus();
		}
	}

}
