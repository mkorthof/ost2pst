/*
 * Copyright 2001-2015 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Email. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */


//This example works from Aspose.Email for Java 5.4.0 onwards
package programmersguide.programmingoutlook.WorkingWithPSTFiles.MergePSTFiles.Java;

import com.aspose.email.*;

import java.io.File;

public class MergePSTFiles
{
    static String currentFolder;
    static int messageCount;
    static int totalAdded;

    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/programmingoutlook/WorkingWithPSTFiles/MergePSTFiles/Data";

        // Display Status.
        System.out.println("MSG file created and saved successfully.");
    }

    public void merge()
    {
        totalAdded = 0;
        String path = "Emailnet_33397";
        String destinationFileName = "Destination.pst";
        String sourceFolderPath = "Sources";
        String testFileName = "test.pst";

        //File.copy(destinationFileName, testFileName, true);

        final PersonalStorage pst = PersonalStorage.fromFile(testFileName);
        try /*JAVA: was using*/
        {
            pst.StorageProcessed.add( new StorageProcessedEventHandler() {
                public void invoke(Object sender, StorageProcessedEventArgs e) {
                    pstMerge_OnStorageProcessed(sender, e);
                }
            });
            pst.ItemMoved.add( new ItemMovedEventHandler() {
                public void invoke(Object sender, ItemMovedEventArgs e) {
                    pstMerge_OnItemMoved(sender, e);
                }
            });
            //Get a collection of all the html files in the directory
            List<String> results = new ArrayList<String>();
            String[] fileNames;


            File[] files = new File(sourceFolderPath).listFiles();
            //If this pathname does not denote a directory, then listFiles() returns null.
            if (files != null)
                fileNames = new String[files.length];
            else
                return;

            for (File file : files) {
                if (file.isFile()) {
                    results.add(file.getName());
                }
            }
            pst.mergeWith(fileNames);
            System.out.println("Total messages added: " + totalAdded);
        }
        finally { if (pst != null) (pst).dispose(); }
    }
    public void moveFoldersFromOtherPst()
    {
        totalAdded = 0;
        String path = "moveFoldersFromOtherPst";
        String destinationFileName = "Destination.pst";
        String sourceFileName = "Sources\\Source1.pst";
        String testFileName = "test.pst";


        final PersonalStorage destinationPst = PersonalStorage.fromFile(testFileName);
        try /*JAVA: was using*/
        {
        final PersonalStorage sourcePst = PersonalStorage.fromFile(sourceFileName);
        try /*JAVA: was using*/
        {
            FolderInfo destinationFolder = destinationPst.getRootFolder().addSubFolder("FolderFromOtherPst");
            FolderInfo sourceFolder = sourcePst.getPredefinedFolder(StandardIpmFolder.DeletedItems);

            destinationFolder.ItemMoved.add( new ItemMovedEventHandler() {
                    public void invoke(Object sender, ItemMovedEventArgs e) {
                        destinationFolder_ItemMoved(sender, e);
                    }
                });

            destinationFolder.mergeWith(sourceFolder);

            System.out.println("Total messages added: " + totalAdded);
        }
        finally { if (sourcePst != null) (sourcePst).dispose(); }
        }
        finally { if (destinationPst != null) (destinationPst).dispose(); }
    }

    private void destinationFolder_ItemMoved(Object sender, ItemMovedEventArgs e)
    {
        totalAdded++;
    }

    private void pstMerge_OnStorageProcessed(Object sender, StorageProcessedEventArgs e)
    {
        System.out.println("*** The storage is merging: {0}" +  e.getFileName());
    }

    private void pstMerge_OnItemMoved(Object sender, ItemMovedEventArgs e)
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
        totalAdded++;
    }
}




