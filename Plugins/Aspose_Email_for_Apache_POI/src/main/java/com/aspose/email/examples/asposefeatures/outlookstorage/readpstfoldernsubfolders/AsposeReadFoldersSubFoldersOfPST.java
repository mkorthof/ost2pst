package com.aspose.email.examples.asposefeatures.outlookstorage.readpstfoldernsubfolders;

import com.aspose.email.FolderInfo;
import com.aspose.email.FolderInfoCollection;
import com.aspose.email.PersonalStorage;
import com.aspose.email.examples.Utils;

public class AsposeReadFoldersSubFoldersOfPST
{
    public static void main(String[] args)
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(AsposeReadFoldersSubFoldersOfPST.class);

        // Load the Outlook PST file
        PersonalStorage pst = PersonalStorage.fromFile(dataDir + "sample.pst");

        // Get the Display Name of the PST file
        System.out.println("Display Name: " + pst.getDisplayName());

        // Get the folders information
        FolderInfoCollection folderInfoCollection = pst.getRootFolder().getSubFolders();
        // Browse through each folder to display folder name and number of messages
        for (int i = 0; i < folderInfoCollection.size(); i++)
        {
            FolderInfo folderInfo = (FolderInfo) folderInfoCollection.get_Item(i);
            System.out.println("Folder: " + folderInfo.getDisplayName());
            System.out.println("Total items: " + folderInfo.getContentCount());
            System.out.println("Total unread items: " + folderInfo.getContentUnreadCount());
            System.out.println("-----------------------------------");
        }
    }
}
