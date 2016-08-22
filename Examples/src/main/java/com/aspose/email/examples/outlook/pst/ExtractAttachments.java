package com.aspose.email.examples.outlook.pst;

import com.aspose.email.FolderInfo;
import com.aspose.email.MapiAttachment;
import com.aspose.email.MapiAttachmentCollection;
import com.aspose.email.PersonalStorage;
import com.aspose.email.examples.Utils;
import com.aspose.email.system.IDisposable;

public class ExtractAttachments {

	public static String dataDir = Utils.getSharedDataDir(ExtractAttachments.class) + "outlook/";

	public static void main(String[] args) {
		final PersonalStorage pst = PersonalStorage.fromFile(dataDir + "Sub.pst");
		
		try {
			FolderInfo folder = pst.getRootFolder().getSubFolder("Inbox");

			for (String entryId : (Iterable<String>) folder.enumerateMessagesEntryId()) {
				MapiAttachmentCollection attachments = pst.extractAttachments(entryId);

				if (attachments.size() != 0) {
					for (MapiAttachment attachment : (Iterable<MapiAttachment>) attachments) {
						attachment.save(attachment.getLongFileName());
					}
				}
			}
		} finally {
			if (pst != null)
				((IDisposable) pst).dispose();
		}

	}

}
