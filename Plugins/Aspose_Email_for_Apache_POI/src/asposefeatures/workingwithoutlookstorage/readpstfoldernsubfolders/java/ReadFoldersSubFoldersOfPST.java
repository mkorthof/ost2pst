package asposefeatures.workingwithoutlookstorage.readpstfoldernsubfolders.java;

import com.aspose.email.FolderInfo;
import com.aspose.email.FolderInfoCollection;
import com.aspose.email.PersonalStorage;

public class ReadFoldersSubFoldersOfPST
{
	public static void main(String[] args)
	{
		String dataPath = "src/asposefeatures/workingwithoutlookstorage/readpstfoldernsubfolders/data/";
		
		// Load the Outlook PST file
		PersonalStorage pst = PersonalStorage.fromFile(dataPath + "personalStorage.pst");
		
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
