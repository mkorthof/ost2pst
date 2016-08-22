package com.aspose.email.examples.outlook.msg;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import com.aspose.email.FollowUpManager;
import com.aspose.email.FollowUpOptions;
import com.aspose.email.MailAddress;
import com.aspose.email.MailMessage;
import com.aspose.email.MapiMessage;
import com.aspose.email.MapiMessageFlags;
import com.aspose.email.examples.Utils;

public class SetFollowUpFlagAndDueDateForOutlookMessageFile {

	public static void main(String[] args) {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(SetFollowUpFlagAndDueDateForOutlookMessageFile.class) + "outlook/";
		
		// Setting a FollowUp flag
		settingAFollowUpFlag(dataDir);
		
		// Setting Follow Up for Recipients
		settingFollowUpForRecipients(dataDir);
		
		// Marking a FollowUp flag as Completed
		markingAFollowUpFlagAsCompleted(dataDir);
		
		// Removing a FollowUp flag
		removingAFollowUpFlag(dataDir);
		
		// Read FollowUp flag options for a message
		readFollowUpFlagOptionsForAMessage(dataDir);
	}

	public static void settingAFollowUpFlag(String dataDir) {
		MailMessage mailMsg = new MailMessage();
		mailMsg.setSender(new MailAddress("AETest12@gmail.com"));
		mailMsg.getTo().addMailAddress(new MailAddress("receiver@gmail.com"));
		mailMsg.setBody("This message will test if follow up options can be added to a new mapi message.");
		MapiMessage mapi = MapiMessage.fromMailMessage(mailMsg);

		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		calendar.set(2013, Calendar.MAY, 16, 14, 40, 0);
		Date dtStartDate = calendar.getTime();

		calendar.set(2013, Calendar.MAY, 16, 16, 40, 0);
		Date dtReminderDate = calendar.getTime();

		calendar.add(Calendar.DATE, 1);
		Date dtDueDate = calendar.getTime();
		
		FollowUpOptions options = new FollowUpOptions("Follow Up", dtStartDate, dtDueDate, dtReminderDate);
		FollowUpManager.setOptions(mapi, options);

		mapi.save(dataDir + "SetFollowUpflag_out.msg");
	}

	public static void settingFollowUpForRecipients(String dataDir) {
		MailMessage mailMsg = new MailMessage();
		mailMsg.setSender(new MailAddress("AETest12@gmail.com"));
		mailMsg.getTo().addMailAddress(new MailAddress("receiver@gmail.com"));
		mailMsg.setBody("This message will test if follow up options can be added to a new mapi message.");

		MapiMessage mapi = MapiMessage.fromMailMessage(mailMsg);
		mapi.setMessageFlags(MapiMessageFlags.MSGFLAG_UNSENT);  //mark this message as draft

		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		calendar.set(2013, Calendar.MAY, 16, 16, 40, 0);
		Date dtReminderDate = calendar.getTime();

		//Add the follow up flag for recipient now
		FollowUpManager.setFlagForRecipients(mapi, "Follow up", dtReminderDate);

		mapi.save(dataDir + "SetFollowUpForRecipients_out.msg");
	}
	
	public static void markingAFollowUpFlagAsCompleted(String dataDir) {
		MapiMessage mapi = MapiMessage.fromFile(dataDir + "message.msg");
		FollowUpManager.markAsCompleted(mapi);
		mapi.save(dataDir + "MarkedCompleted_out.msg");
	}
	
	public static void removingAFollowUpFlag(String dataDir) {
		MapiMessage mapi = MapiMessage.fromFile(dataDir + "message.msg");
		FollowUpManager.clearFlag(mapi);
		mapi.save(dataDir + "FollowUpFlagRemoved_out.msg");
	}
	
	public static void readFollowUpFlagOptionsForAMessage(String dataDir) {
		MapiMessage mapi = MapiMessage.fromFile(dataDir + "message.msg");
		FollowUpOptions options = FollowUpManager.getOptions(mapi);
	}

}
