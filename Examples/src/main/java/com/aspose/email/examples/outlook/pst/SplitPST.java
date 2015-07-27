/* 
 * Copyright 2001-2015 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Email. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package com.aspose.email.examples.outlook.pst;

import com.aspose.email.*;
import com.aspose.email.examples.Utils;

import java.io.File;

public class SplitPST
{
    static String currentFolder;
    static int messageCount;

    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(SplitPST.class);

        String sourceFileName = dataDir + "Outlook.pst";
        String dirChunks = dataDir + "chunks\\";

        // Delete the folder, if it already exists
        File dir = new File(dirChunks);
        File[] splitFiles = dir.listFiles();
        for(File f : splitFiles) {
            f.delete();
        }

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
            pst.splitInto(500000, dirChunks);
        }
        finally { if (pst != null) (pst).dispose(); }
    }

    private static void pstSplit_OnStorageProcessed(Object sender, StorageProcessedEventArgs e)
    {
        if (currentFolder != null)
        {
            System.out.println(" Added " + messageCount + " messages to " + currentFolder);
        }

        messageCount = 0;
        currentFolder = null;
        System.out.println("*** The chunk is processed: " + e.getFileName());
    }

    private static void pstSplit_OnItemMoved(Object sender, ItemMovedEventArgs e)
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
