package com.aspose.email.examples.imap;

import com.aspose.email.ImapClient;
import com.aspose.email.ImapFolderInfo;
import com.aspose.email.ImapFolderInfoCollection;
import com.aspose.email.SecurityOptions;

public class GetFoldersInformation {

    public static void main(String[] args) {
        ImapClient client = new ImapClient();
        client.setHost("imap.gmail.com");
        client.setPort(993);
        client.setUsername("username");
        client.setPassword("password");
        client.setSecurityOptions(SecurityOptions.Auto);

        ImapFolderInfoCollection folderInfoColl = client.listFolders();
        // Iterate through the collection to get folder info one by one
        for (ImapFolderInfo folderInfo : folderInfoColl) {
            // Folder name
            System.out.println("Folder name is " + folderInfo.getName());
            // New messages in the folder
            System.out.println("New message count: " + folderInfo.getNewMessageCount());
            // Check whether its readonly
            System.out.println("Is it readonly? " + folderInfo.getReadOnly());
            // Total number of messages
            System.out.println("Total number of messages " + folderInfo.getTotalMessageCount());
        }
    }
}
