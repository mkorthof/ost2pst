package com.aspose.email.examples.outlook.pst;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

import com.aspose.email.FolderInfo;
import com.aspose.email.ItemMovedEventArgs;
import com.aspose.email.ItemMovedEventHandler;
import com.aspose.email.MailQuery;
import com.aspose.email.PersonalStorage;
import com.aspose.email.PersonalStorageQueryBuilder;
import com.aspose.email.StandardIpmFolder;
import com.aspose.email.StorageProcessedEventArgs;
import com.aspose.email.StorageProcessedEventHandler;
import com.aspose.email.examples.Utils;
import com.aspose.email.system.collections.generic.List;

public class SplitAndMergePSTFile {

	public static String dataDir = Utils.getSharedDataDir(SplitAndMergePSTFile.class) + "outlook/";

	public static int messageCount = 0;
	public static int totalAdded = 0;
	public static String currentFolder = null;
	
	/**
	 * Following examples will only work if you have Aspose License file. 
	 */
	public static void main(String[] args) {
		
		try {
			Utils.applyALicense();
		} catch(Exception e) {
			System.out.println("License file is missing: " + e.getLocalizedMessage());
		}
		
		//Splitting PST into Multiple PST files
		splitPSTIntoMultiplePSTFiles(); 

		//Merging of Multiple PSTs into a Single PST
		mergeMultiplePSTsIntoASinglePST(); 
		
		//Merging Folders from another PST
		mergeFoldersFromAnotherPST();    
 		
		//Splitting PST based on Specified Criterion
		splitPSTBasedOnDefinedCriterion();
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
			pst.splitInto(542720 , dataDir + "chunks/");
		} finally {
			if (pst != null)
				(pst).dispose();
		}
	}

	public static void mergeMultiplePSTsIntoASinglePST() {
		
		// Path to files that will be merged into "source.pst".
		String mergeWithFolderPath = dataDir + "MergeWith";
		
		String mergeIntoFolderPath = dataDir + "MergeInto" + File.separator;
		
		// This will ensure that we can run this example as many times as we want. 
		// It will discard changes made to to the Source file in last run of this example.
		deleteAndRecopySampleFiles(mergeIntoFolderPath, dataDir + "MergeMultiplePSTsIntoASinglePST/");
		
		final PersonalStorage pst = PersonalStorage.fromFile(mergeIntoFolderPath + "source.pst");
		try {
			pst.StorageProcessed.add(new StorageProcessedEventHandler() {
				public void invoke(Object sender, StorageProcessedEventArgs e) {
					pstMerge_OnStorageProcessed(sender, e);
				}
			});
			pst.ItemMoved.add(new ItemMovedEventHandler() {
				public void invoke(Object sender, ItemMovedEventArgs e) {
					pstMerge_OnItemMoved(sender, e);
				}
			});
			//Get a collection of all files in the directory
			ArrayList<String> results = new ArrayList<String>();

			File[] files = new File(mergeWithFolderPath).listFiles();
			//If this path name does not denote a directory, then listFiles() returns null.
			if (files == null)
				return;

			for (File file : files) {
				if (file.isFile() && file.getName().endsWith(".pst")) {
					results.add(file.getAbsolutePath());
				}
			}
			
			String[] fileNames = results.toArray(new String[0]);
			pst.mergeWith(fileNames);
		} finally {
			if (pst != null)
				(pst).dispose();
		}
	}

	public static void mergeFoldersFromAnotherPST() {
		
		String sourceFileName = dataDir +  "Sources/source.pst";
		String destinationFolder = dataDir + "Destination" + File.separator;
		String destinationFileName = "destination.pst";
		
		// This will ensure that we can run this example as many times as we want. 
		// It will discard changes made to to the destination file "destination.pst" in last run of this example.
		deleteAndRecopySampleFiles(destinationFolder, dataDir + "MergeFoldersFromAnotherPST" + File.separator);
		
		final PersonalStorage destinationPst = PersonalStorage.fromFile(destinationFolder + destinationFileName);
		try {
			final PersonalStorage sourcePst = PersonalStorage.fromFile(sourceFileName);
			try {
				
				FolderInfo destFolder = destinationPst.getRootFolder().addSubFolder("FolderFromOtherPst" + (int) (Math.random() * 100));
				
				FolderInfo sourceFolder = sourcePst.getPredefinedFolder(StandardIpmFolder.Inbox);

				destFolder.ItemMoved.add(new ItemMovedEventHandler() {
					public void invoke(Object sender, ItemMovedEventArgs e) {
						destinationFolder_ItemMoved(sender, e);
					}
				});

				destFolder.mergeWith(sourceFolder);

				System.out.println("Total messages added: " + totalAdded);
			} finally {
				if (sourcePst != null)
					(sourcePst).dispose();
			}
		} finally {
			if (destinationPst != null)
				(destinationPst).dispose();
		}
	}

	public static void splitPSTBasedOnDefinedCriterion() {
		
		String fileName = dataDir + "source.pst";
		java.util.Calendar c = java.util.Calendar.getInstance();

		List<MailQuery> criteria = new List<MailQuery>();

		//Define a criterion based on Time
		PersonalStorageQueryBuilder pstQueryBuilder = new PersonalStorageQueryBuilder();
		c.set(2015, 1, 1, 0, 0, 0);
		pstQueryBuilder.getSentDate().since(c.getTime());
		c.set(2015, 12, 12, 0, 0, 0);
		pstQueryBuilder.getSentDate().before(c.getTime());
		criteria.addItem(pstQueryBuilder.getQuery());

		//specify some other criterion as well
		pstQueryBuilder = new PersonalStorageQueryBuilder();
		c.set(2012, 1, 1, 0, 0, 0);
		pstQueryBuilder.getSentDate().since(c.getTime());
		c.set(2012, 12, 12, 0, 0, 0);
		pstQueryBuilder.getSentDate().before(c.getTime());
		criteria.addItem(pstQueryBuilder.getQuery());

		final PersonalStorage pst = PersonalStorage.fromFile(fileName);
		try {
			deleteAllOutputFiles();
			pst.splitInto(criteria, dataDir);
		} finally {
			if (pst != null)
				pst.dispose();
		}
	}

	//Helping Methods
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
	
	public static void resetState() {
		messageCount = 0;
		totalAdded = 0;
		currentFolder = null;
	}
	
	public static void deleteAndRecopySampleFiles(String destFolder, String srcFolder) {
		
		try {
			deleteAllFilesInDirectory(new File(destFolder));
			//Copy destination file from Outlook folder into Destination folder
			File source = new File(srcFolder);
			File dest = new File(destFolder);
			FileUtils.copyDirectory(source, dest);
		} catch(IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
	
	public static void deleteAllFilesInDirectory(File dir) {
		for(String s: dir.list()){
		    File currentFile = new File(dir.getPath(), s);
		    currentFile.delete();
		}
	}
	
	public static void deleteAllOutputFiles() {
		File dir = new File(dataDir);
		for(String s: dir.list()){
			if(s.startsWith("Test_part") || s.startsWith("Personal folders_part")) {
				File file = new File(dir.getPath(), s);
				file.delete();
			}
		}
	}
	
}
