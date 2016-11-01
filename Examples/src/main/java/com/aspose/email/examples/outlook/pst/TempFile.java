/** 
 * Copyright 2001-2016 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Slides. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
package com.aspose.email.examples.outlook.pst;

import java.io.File;

import com.aspose.email.ItemMovedEventArgs;
import com.aspose.email.ItemMovedEventHandler;
import com.aspose.email.PersonalStorage;
import com.aspose.email.StorageProcessedEventArgs;
import com.aspose.email.StorageProcessedEventHandler;
import com.aspose.email.examples.Utils;

/**
 * @author muhammadsohailismail
 *
 */
public class TempFile {
	
	public static String dataDir = Utils.getSharedDataDir(SplitAndMergePSTFile.class) + "outlook/";
	
	public static int messageCount = 0;
	public static String currentFolder = Utils.getSharedDataDir(SplitAndMergePSTFile.class) + "outlook/";
	public static int totalAdded = 0;
	
	public static void main(String[] args) {
		
		//Splitting PST into Multiple PST files
		splitPSTIntoMultiplePSTFiles();
	}
	
	public static void splitPSTIntoMultiplePSTFiles() {

        String sourceFileName = dataDir + "source.pst";

        final PersonalStorage pst = PersonalStorage.fromFile(sourceFileName);
        try {
            pst.StorageProcessed.add(new StorageProcessedEventHandler() {
                public void invoke(Object sender, StorageProcessedEventArgs e) {
                    pstSplit_OnStorageProcessed(sender, e);
                }
            });
            pst.ItemMoved.add(new ItemMovedEventHandler() {
                public void invoke(Object sender, ItemMovedEventArgs e) {
                    pstSplit_OnItemMoved(sender, e);
                }
            });

            deleteAllFilesInDirectory(new File(dataDir + "chunks/"));
            pst.splitInto(542720, dataDir + "chunks/");
        } finally {
            if (pst != null)
                (pst).dispose();
        }
    }

    public static void deleteAllFilesInDirectory(File dir) {
        for(String s: dir.list()){
            File currentFile = new File(dir.getPath(), s);
            currentFile.delete();
        }
    }

    private static void destinationFolder_ItemMoved(Object sender, ItemMovedEventArgs e) {
		totalAdded++;
	}

	private static void pstMerge_OnStorageProcessed(Object sender, StorageProcessedEventArgs e) {
		System.out.println("*** The storage is merging: {0}" + e.getFileName());
	}

	private static void pstMerge_OnItemMoved(Object sender, ItemMovedEventArgs e) {
		if (currentFolder == null) {
			currentFolder = e.getDestinationFolder().retrieveFullPath();
		}

		String folderPath = e.getDestinationFolder().retrieveFullPath();

		if (!folderPath.equals(currentFolder)) {
			System.out.println(" Added " + messageCount + " messages to " + currentFolder);
			messageCount = 0;
			currentFolder = folderPath;
		}

		messageCount++;
		totalAdded++;
	}

	private static void pstSplit_OnStorageProcessed(Object sender, StorageProcessedEventArgs e) {
		if (currentFolder != null) {
			System.out.println(" Added " + messageCount + " messages to " + currentFolder);
		}

		messageCount = 0;
		currentFolder = null;
		System.out.println("*** The chunk is processed: " + e.getFileName());
	}

	private static void pstSplit_OnItemMoved(Object sender, ItemMovedEventArgs e) {
		if (currentFolder == null) {
			currentFolder = e.getDestinationFolder().retrieveFullPath();
		}

		String folderPath = e.getDestinationFolder().retrieveFullPath();

		if (!folderPath.equals(currentFolder)) {
			System.out.println(" Added " + messageCount + " messages to " + currentFolder);
			messageCount = 0;
			currentFolder = folderPath;
		}

		messageCount++;
	}
}
