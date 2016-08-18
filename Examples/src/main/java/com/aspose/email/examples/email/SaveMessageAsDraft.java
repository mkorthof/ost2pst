package com.aspose.email.examples.email;

import com.aspose.email.MailAddress;
import com.aspose.email.MailMessage;
import com.aspose.email.MapiMessage;
import com.aspose.email.MapiMessageFlags;
import com.aspose.email.examples.Utils;

public class SaveMessageAsDraft {

	public static void main(String[] args) {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(SaveMessageAsDraft.class) + "email/";

	    // Create a new instance of MailMessage class
	    MailMessage message = new MailMessage();

	    // Set sender information
	    message.setFrom(new MailAddress("from@domain.com", "Sender Name", false));

	    // Add recipients
	    message.getTo().addMailAddress(new MailAddress("to1@domain.com", "Recipient 1", false));
	    message.getTo().addMailAddress(new MailAddress("to2@domain.com", "Recipient 2", false));

	    // Set subject of the message
	    message.setSubject("New message created by Aspose.Email for Java");

	    // Set Html body of the message
	    message.setHtmlBody("<b>This line is in bold.</b> <br/> <br/>"
	            + "<font color=blue>This line is in blue color</font>");

	    // Create an instance of MapiMessage and load the MailMessag instance into it
	    MapiMessage mapiMsg = MapiMessage.fromMailMessage(message);

	    // Set the MapiMessageFlags as UNSENT and FROMME
	    mapiMsg.setMessageFlags(MapiMessageFlags.MSGFLAG_UNSENT | MapiMessageFlags.MSGFLAG_FROMME);

	    // Save the MapiMessage to disk
	    mapiMsg.save(dataDir + "New-Draft.msg");

	}

}
