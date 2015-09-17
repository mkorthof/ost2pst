package asposefeatures.workingwithmsgfiles.getfolderinfo.java;

import com.aspose.email.ImapClient;
import com.aspose.email.ImapFolderInfo;
import com.aspose.email.ImapFolderInfoCollection;
import com.aspose.email.SecurityOptions;

public class GetFolderInfo
{
	public static void main(String[] args)
	{
		ImapClient client = new ImapClient();
		client.setHost("--server--"); //imap.secureserver.net,
		client.setPort(993);
		client.setUsername("--username--");
		client.setPassword("--password--");
		client.setSecurityOptions(SecurityOptions.Auto);

		ImapFolderInfoCollection folderInfoColl = client.listFolders();
		// Iterate through the collection to get folder info one by one
		for (ImapFolderInfo folderInfo:folderInfoColl)
		{
		    // Folder name
		    System.out.println("Folder name is: " + folderInfo.getName());
		    ImapFolderInfo folderExtInfo = client.listFolder(folderInfo.getName());
		    // New messages in the folder
		    System.out.println("New message count: " + folderExtInfo.getNewMessageCount());
		    // Check whether its read only
		    System.out.println("Is it readonly? " + folderExtInfo.getReadOnly());
		    // Total number of messages
		    System.out.println("Total number of messages: " + folderExtInfo.getTotalMessageCount());
		    System.out.println("----------------------\n");
		}
		System.out.println("Done.");
	}
}
