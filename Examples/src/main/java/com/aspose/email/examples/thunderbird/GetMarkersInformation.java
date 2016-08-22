package com.aspose.email.examples.thunderbird;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.aspose.email.MailMessage;
import com.aspose.email.MboxrdStorageReader;
import com.aspose.email.MboxrdStorageWriter;
import com.aspose.email.examples.Utils;
import com.aspose.email.system.IDisposable;

public class GetMarkersInformation {

	// The path to the resource directory.
	public static String dataDir = Utils.getSharedDataDir(GetMarkersInformation.class) + "Thunderbird/";

	public static void main(String[] args) throws IOException {
		readingMessages();
		writingMessages();
	}

	public static void readingMessages() throws IOException {
		//Getting Marker information while reading messages from Mbox storage file
		FileInputStream stream = new FileInputStream(dataDir + "Outlook.pst");
		try {
			MboxrdStorageReader reader = new MboxrdStorageReader(stream, false);
			try {
				MailMessage msg;
				String[] fromMarker = { null };
				while ((msg = reader.readNextMessage(/* out */fromMarker)) != null) {
					System.out.println(fromMarker[0]);
					msg.dispose();
				}
			} finally {
				if (reader != null)
					reader.dispose();
			}
		} finally {
			if (stream != null)
				stream.close();
		}
	}

	public static void writingMessages() throws IOException {
		//Getting marker information while writing messages to Mbox storage file
		FileOutputStream writeStream = new FileOutputStream(dataDir + "inbox");
		try {
			MboxrdStorageWriter writer = new MboxrdStorageWriter(writeStream, false);
			try {
				MailMessage msg = MailMessage.load(dataDir + "Message.msg");
				String[] fromMarker = { null };
				writer.writeMessage(msg, fromMarker);
				System.out.println(fromMarker[0]);
			} finally {
				if (writer != null)
					((IDisposable) writer).dispose();
			}
		} finally {
			if (writeStream != null)
				writeStream.close();
		}
	}
}
