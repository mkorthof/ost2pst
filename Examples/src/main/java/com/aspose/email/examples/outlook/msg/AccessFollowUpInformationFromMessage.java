package com.aspose.email.examples.outlook.msg;

import com.aspose.email.MapiMessage;
import com.aspose.email.MapiPropertyTag;
import com.aspose.email.MapiRecipient;
import com.aspose.email.examples.Utils;

public class AccessFollowUpInformationFromMessage {

	public static void main(String[] args) {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(AccessFollowUpInformationFromMessage.class) + "outlook/";
		
		// Retrieving Read and Delivery Receipt Information
		retrievingReadAndDeliveryReceiptInformation(dataDir);
		
		// Read the Vote Results Information
		readTheVoteResultsInformation(dataDir);
	}

	public static void retrievingReadAndDeliveryReceiptInformation(String dataDir) {
		MapiMessage msg = MapiMessage.fromFile(dataDir + "message.msg");
		for (MapiRecipient recipient : msg.getRecipients()) {
			System.out.println("Recipient: " + recipient.getDisplayName());

			// Get the PR_RECIPIENT_TRACKSTATUS_TIME_DELIVERY property
			System.out.println("Delivery time: " + recipient.getProperties().get_Item(MapiPropertyTag.PR_RECIPIENT_TRACKSTATUS_TIME_DELIVERY).getDateTime());

			// Get the PR_RECIPIENT_TRACKSTATUS_TIME_READ property
			System.out.println("Read time" + recipient.getProperties().get_Item(MapiPropertyTag.PR_RECIPIENT_TRACKSTATUS_TIME_READ).getDateTime());
		}
	}
	
	public static void readTheVoteResultsInformation(String dataDir) {
		MapiMessage msg = MapiMessage.fromFile(dataDir + "message.msg");
		for (MapiRecipient recipient:msg.getRecipients())
		{
			System.out.println("Recipient:" + recipient.getDisplayName());

			// Get the PR_RECIPIENT_AUTORESPONSE_PROP_RESPONSE property
			System.out.println("Response: "+  recipient.getProperties().get_Item(MapiPropertyTag.PR_RECIPIENT_AUTORESPONSE_PROP_RESPONSE).getString());

			// Get the PR_RECIPIENT_TRACKSTATUS_TIME property
			System.out.println("Response time: {0}" + recipient.getProperties().get_Item(MapiPropertyTag.PR_RECIPIENT_TRACKSTATUS_TIME).getDateTime());
		}
	}
}
