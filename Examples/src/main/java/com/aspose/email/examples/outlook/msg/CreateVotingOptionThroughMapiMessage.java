package com.aspose.email.examples.outlook.msg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.aspose.email.FollowUpManager;
import com.aspose.email.FollowUpOptions;
import com.aspose.email.MapiMessage;
import com.aspose.email.MapiMessageFlags;
import com.aspose.email.examples.Utils;
import com.aspose.email.system.collections.IList;

public class CreateVotingOptionThroughMapiMessage {

	public static void main(String[] args) throws FileNotFoundException {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(CreateVotingOptionThroughMapiMessage.class) + "outlook/";
		
		createAPollUsingMapiMessage(dataDir);
		
		readingVotingOptionsFromAMapiMessage(dataDir);
		
		readingOnlyVotingButtons(dataDir);
	}

	public static void createAPollUsingMapiMessage(String dataDir) {
		// Set flag without dates
		MapiMessage msg = createTestMessage(false);

		FollowUpOptions options = new FollowUpOptions();
		options.setVotingButtons("Yes;No;Maybe;Exactly!");

		FollowUpManager.setOptions(msg, options);

		msg.save(dataDir + "MapiMsgWithPoll_out.msg");
	}

	public static void readingVotingOptionsFromAMapiMessage(String dataDir) {
		MapiMessage msg = MapiMessage.fromFile(dataDir + "MapiMsgWithPoll_out.msg");

		// This method can be useful when except voting buttons it is necessary to get other parameters (ex. a category)
		FollowUpOptions options = FollowUpManager.getOptions(msg);

		// Voting buttons will be introduced as a string with semi-column as a separator
		String votingButtons = options.getVotingButtons();
		System.out.println(votingButtons);
	}

	public static void readingOnlyVotingButtons(String dataDir) throws FileNotFoundException {
		InputStream ms = new FileInputStream(dataDir + "MapiMsgWithPoll_out.msg");
		MapiMessage testMsg = MapiMessage.fromStream(ms);

		// This method can be useful when it is necessary to read only voting buttons
		// Voting buttons will be introduced as a collection of string values
		IList buttons = FollowUpManager.getVotingButtons(testMsg);
	}
	
	public static void addRemoveOrClearVotingButton(String dataDir) throws FileNotFoundException {
		InputStream ms = new FileInputStream(dataDir + "MapiMsgWithPoll_out.msg");
		MapiMessage testMsg = MapiMessage.fromStream(ms);
		
		// ExStart:AddVotingButton
		FollowUpManager.addVotingButton(testMsg, "Indeed!");
		// ExEnd:AddVotingButton
		
		// ExStart:RemoveVotingButton
		FollowUpManager.removeVotingButton(testMsg, "Exactly!"); //Deleting a single button
		// ExEnd:RemoveVotingButton
		
		// ExStart:ClearVotingButtons
		FollowUpManager.clearVotingButtons(testMsg); //Deleting all buttons from a MapiMessage
		// ExEnd:ClearVotingButtons
	}
	
	public static MapiMessage createTestMessage(boolean draft) {
		MapiMessage msg = new MapiMessage("from@test.com", "to@test.com", "Flagged message",
				"Make it nice and short, but descriptive. The description may appear in search engines' search results pages...");

		if (!draft) {
			msg.setMessageFlags(msg.getFlags() ^ MapiMessageFlags.MSGFLAG_UNSENT);
		}

		return msg;
	}

}
