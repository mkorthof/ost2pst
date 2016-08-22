package com.aspose.email.examples.outlook.msg;

import com.aspose.email.MailAddress;
import com.aspose.email.MailMessage;
import com.aspose.email.MapiMessage;
import com.aspose.email.MapiMessageFlags;
import com.aspose.email.examples.Utils;
import com.aspose.email.system.IDisposable;

public class ReadAndWriteOutlookTemplateFile {

	public static void main(String[] args) {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(ReadAndWriteOutlookTemplateFile.class) + "outlook/";
		
		// Load the template using the MailMessage class, update properties and save the message in MSG format.
		readAndWriteOutlookTemplateFile(dataDir);
		
		saveAsOutlookTemplateFile(dataDir);
	}

	public static void readAndWriteOutlookTemplateFile(String dataDir) {
		// Load the Outlook template (OFT) file in MailMessage's instance
		MailMessage message = MailMessage.load(dataDir + "sample.oft");

		// Set the sender and recipients information
		String senderDisplayName = "John";
		String senderEmailAddress = "john@abc.com";
		String recipientDisplayName = "William";
		String recipientEmailAddress = "william@xzy.com";

		message.setSender(new MailAddress(senderEmailAddress, senderDisplayName));
		message.getTo().addMailAddress(new MailAddress(recipientEmailAddress, recipientDisplayName));
		message.setHtmlBody(message.getHtmlBody().replace("DisplayName", "<b>" + recipientDisplayName + "</b>"));

		// Set the name, location and time in email body
		String meetingLocation = "<u>" + "Hall 1, Convention Center, New York, USA" + "</u>";
		String meetingTime = "<u>" + "Monday, June 28, 2010" + "</u>";
		message.setHtmlBody(message.getHtmlBody().replace("MeetingPlace", meetingLocation));
		message.setHtmlBody(message.getHtmlBody().replace("MeetingTime", meetingTime));
		// Save the message in MSG format and open in Office Outlook
		MapiMessage mapimessage = MapiMessage.fromMailMessage(message);
		mapimessage.setMessageFlags(MapiMessageFlags.MSGFLAG_UNSENT);
		mapimessage.save(dataDir + "Invitation.msg");
	}

	public static void saveAsOutlookTemplateFile(String dataDir) {

		MapiMessage mapi = new MapiMessage("test@from.to", "test@to.to", "template subject", "Template body");
		try {
			mapi.saveAsTemplate(dataDir + "mapiToOft.oft");
		} finally {
			if (mapi != null)
				((IDisposable) mapi).dispose();
		}
	}
}
