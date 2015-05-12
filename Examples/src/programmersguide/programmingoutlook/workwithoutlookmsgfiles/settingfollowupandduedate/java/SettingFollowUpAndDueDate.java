/*
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Email. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */

package programmersguide.programmingoutlook.workwithoutlookmsgfiles.settingfollowupandduedate.java;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aspose.email.*;

public class SettingFollowUpAndDueDate
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/programmingoutlook/workwithoutlookmsgfiles/settingfollowupandduedate/data/";

        //Instantiate an MSG file to load an MSG file from disk
        MapiMessage msg = MapiMessage.fromFile(dataDir + "message.msg");

        SimpleDateFormat rangeFormatter = new SimpleDateFormat("EEE, d MMM yyyy HH:mm");

        Date startDate = rangeFormatter.parse("Mon, 20 May 2013 12:00");
        Date dueDate = rangeFormatter.parse("Tue, 21 May 2013 12:00");
        Date reminderTime = rangeFormatter.parse("Wed, 15 May 2013 21:50");

        //Set up follow up flag with start date and due date
        FollowUpManager.setFlag(msg, "Follow up", startDate, dueDate);

        // Add a flag with a reminder
        FollowUpOptions followUpOptions = new FollowUpOptions("Follow up", startDate, dueDate, reminderTime);
        FollowUpManager.setOptions(msg, followUpOptions);

        // Add a flag to a message sent to someone else
        FollowUpManager.setFlagForRecipients(msg, "Follow up", reminderTime);

        // Simultaneously flag a message both for yourself and the recipients
        followUpOptions = new FollowUpOptions("Follow up", startDate, dueDate, reminderTime);
        followUpOptions.setRecipientsFlagRequest("Follow up");
        followUpOptions.setRecipientsReminderTime(reminderTime);
        FollowUpManager.setOptions(msg, followUpOptions);

        // Mark a message flag complete
        FollowUpManager.markAsCompleted(msg);

        // Remove a flag
        FollowUpManager.clearFlag(msg);

        // Read follow-up flag options from a message
        FollowUpOptions options = FollowUpManager.getOptions(msg);

        System.out.println("Follow up options set successfully.");    }
}
