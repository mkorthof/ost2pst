/*
 * Copyright 2001-2015 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Email. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */

//This feature is available from Aspose.Email for Java 5.4.0 onwards
package programmersguide.programmingoutlook.WorkingWithPSTFiles.SplitPSTFiles.Java;

import com.aspose.email.*;

import java.io.File;

public class SplitPSTFiles
{
    static String currentFolder;
    static int messageCount;

    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/programmingoutlook/WorkingWithPSTFiles/SplitPSTFiles/Data";

        // Display Status.
        System.out.println("MSG file created and saved successfully.");
    }
    public void split()
    {
        String path = "Emailnet_33397";
        String sourceFileName = dataDir + "Outlook.pst";

        final PersonalStorage pst = PersonalStorage.fromFile(sourceFileName);
        try /*JAVA: was using*/
        {
            pst.StorageProcessed.add( new StorageProcessedEventHandler() {
                public void invoke(Object sender, StorageProcessedEventArgs e) {
                    pstSplit_OnStorageProcessed(sender, e);
                }
            });
            pst.ItemMoved.add( new ItemMovedEventHandler() {
                public void invoke(Object sender, ItemMovedEventArgs e) {
                    pstSplit_OnItemMoved(sender, e);
                }
            });
            pst.splitInto(5000000, dataDir + "chunks\");
        }
        finally { if (pst != null) (pst).dispose(); }
    }
    private void pstSplit_OnStorageProcessed(Object sender, StorageProcessedEventArgs e)
    {
        if (currentFolder != null)
        {
            System.out.println(" Added " + messageCount + " messages to " + currentFolder);
        }

        messageCount = 0;
        currentFolder = null;
        System.out.println("*** The chunk is processed: " + e.getFileName());
    }

    private void pstSplit_OnItemMoved(Object sender, ItemMovedEventArgs e)
    {
        if (currentFolder == null)
        {
            currentFolder = e.getDestinationFolder().retrieveFullPath();
        }

        String folderPath = e.getDestinationFolder().retrieveFullPath();

        if (!folderPath.equals(currentFolder))
        {
            System.out.println(" Added " + messageCount + " messages to " + currentFolder);
            messageCount = 0;
            currentFolder = folderPath;
        }

        messageCount++;
    }
}




