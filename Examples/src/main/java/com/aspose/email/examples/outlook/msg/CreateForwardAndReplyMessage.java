package com.aspose.email.examples.outlook.msg;

import com.aspose.email.ForwardMessageBuilder;
import com.aspose.email.MapiMessage;
import com.aspose.email.OriginalMessageAdditionMode;
import com.aspose.email.ReplyMessageBuilder;
import com.aspose.email.examples.Utils;

public class CreateForwardAndReplyMessage {

	public static void main(String[] args) {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(CreateForwardAndReplyMessage.class) + "outlook/";
		
		createReplyMessage(dataDir);
		
		createForwardMessage(dataDir);
	}

	public static void createReplyMessage(String dataDir) {
		MapiMessage originalMsg = MapiMessage.fromFile(dataDir + "message1.msg");

		ReplyMessageBuilder builder = new ReplyMessageBuilder();
		builder.setReplyAll(true);
		builder.setAdditionMode(OriginalMessageAdditionMode.Textpart);
		builder.setResponseText(
				"<p><b>Dear Friend,</b>"
				+ "</p> I want to introduce my co-author and co-teacher. "
				+ "<p><a href=\"www.google.com\">This is a first link</a></p>"
				+ "<p><a href=\"www.google.com\">This is a second link</a></p>");
		MapiMessage replyMsg = builder.buildResponse(originalMsg);

		replyMsg.save(dataDir + "reply_out.msg");
	}

	public static void createForwardMessage(String dataDir) {
		MapiMessage originalMsg = MapiMessage.fromFile(dataDir + "message1.msg");
		
		ForwardMessageBuilder builder = new ForwardMessageBuilder();
		builder.setAdditionMode(OriginalMessageAdditionMode.Textpart);
		MapiMessage forwardMsg = builder.buildResponse(originalMsg);
		
		forwardMsg.save(dataDir + "forward_out.msg");
	}

}
