package com.aspose.email.examples.outlook.pst;

import com.aspose.email.FileFormatVersion;
import com.aspose.email.FolderInfo;
import com.aspose.email.MailMessage;
import com.aspose.email.MailQuery;
import com.aspose.email.MailQueryBuilder;
import com.aspose.email.MapiMessage;
import com.aspose.email.MessageInfoCollection;
import com.aspose.email.PersonalStorage;
import com.aspose.email.StandardIpmFolder;
import com.aspose.email.examples.Utils;
import com.aspose.email.system.IDisposable;

public class StringSearchingInPSTWithIgnoreCase {
	
	public static String dataDir = Utils.getSharedDataDir(StringSearchingInPSTWithIgnoreCase.class) + "outlook/";
	
	public static void main(String[] args) {
		PersonalStorage pst = PersonalStorage.create(dataDir + "StringSearchingInPST_out.pst", FileFormatVersion.Unicode);
		try {
			FolderInfo fi = pst.createPredefinedFolder("Inbox", StandardIpmFolder.Inbox);

			fi.addMessage(MapiMessage.fromMailMessage(MailMessage.load(dataDir + "message.msg")));

			MailQueryBuilder builder = new MailQueryBuilder();
			builder.getFrom().contains("automated", true);

			MailQuery query = builder.getQuery();
			MessageInfoCollection coll = fi.getContents(query);
		} finally {
			if (pst != null)
				((IDisposable) pst).dispose();
		}
	}
}
