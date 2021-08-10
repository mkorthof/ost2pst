package com.ost2pst;

// https://github.com/aspose-email/Aspose.Email-for-Java 

import com.aspose.email.FileFormat;
import com.aspose.email.FolderInfo;
import com.aspose.email.FolderInfoCollection;
import com.aspose.email.PersonalStorage;
import com.aspose.email.MapiMessage;
//import com.aspose.email.examples.Utils;

import java.io.File;
import java.io.RandomAccessFile;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class LoadAndConvertOSTFileCLI {

	public static void showUsage(int rc) {
		System.out.println("USAGE: ost2pst.jar <input.ost> <output.pst>    convert ost to pst");
		//System.out.println("       ost2pst.jar -c <input.ost> [-s <dir>]   read/save corrupted ost");
		System.exit(rc);
	}
	
	public static void main(String[] args) {
		String inputFile = "";
		String outputFile = "";
		File fIn = null;
		File fOut = null;
		boolean debug = false;
		boolean corruptedOst = false;
		boolean saveCorrupted = false;
		// TODO: add -s <dir> to set dataDir
        String dataDir = "outlook_restore";
		// Print version from pom.xml
		String sVer = String.format("OST2PST (%s)\n", Version.VERSION); 
		System.out.println("");
		System.out.println(sVer);
		// Handle arguments
		if (args.length == 0) {
			showUsage(0);
		} else {
		    for (String arg : args) {
		        if (arg.equals("-h"))
					showUsage(0);
		        if (arg.equals("-d"))
		        	debug = true;
		        if (arg.equals("-c"))
		        	corruptedOst = true; 
		        if (arg.equals("-s"))
		        	saveCorrupted = true;
		        	// TODO: option for dataDir
		    }
			if (corruptedOst) {
				try { inputFile = args[1]; }
				catch(Exception e) {
					System.out.println("ERROR: no input file specified");
					showUsage(2);
				}
			} else {
				try { inputFile = args[0]; }
				catch(Exception e) {
					System.out.println("ERROR: no input file specified");
					showUsage(2);
				}
				try { outputFile = args[1]; }
				catch(Exception e) {
					System.out.println("ERROR: no output file specified");
					showUsage(2);
				}
				fOut = new File(outputFile);
			}
			fIn = new File(inputFile);	
		}	
		if (debug) {
			System.out.printf("DEBUG: args.length=%s args[0]=\"%s\" args[1]=\"%s\"\n", args.length, args[0], args[1]);
			if (args.length > 2)
				System.out.printf("DEBUG: args[2]=%s\n", args[2]);
			if (args.length > 3)
				System.out.printf("DEBUG: args[3]=%s\n", args[3]);
			System.out.printf("DEBUG: fIn.exists=%s fIn.isFile=%s\n",  fIn.exists(), fIn.isFile());
			System.out.printf("DEBUG: corruptedOst=%s saveCorrupted=%s\n", corruptedOst, saveCorrupted);
		}
		// Check if input and output file exist
		if ( !(fIn.exists() && fIn.isFile())) {
			String sInErr = String.format("ERROR: input file \"%s\" does not exist", inputFile);
			System.out.println(sInErr);
			System.exit(2);
		}
		if (fIn.length() == 0) {
			String sInErr = String.format("ERROR: input file \"%s\" is empty", inputFile);
			System.out.println(sInErr);
			System.exit(2);
		}
		int fmtTypeNum = typeOSTFile(debug, inputFile);
		String fmtTypeStr = fileFormatType(debug, fmtTypeNum);
		System.out.printf("INFO: File format is \"%s\" (%d)\n", fmtTypeStr, fmtTypeNum);
		System.out.printf("INFO: Loading file \"%s\" (%s)\n", inputFile, humanReadableByteCountSI(fIn.length()));
		// Read corrupted OST file
		if (corruptedOst) {
			if (saveCorrupted) {
				File dOut = new File(dataDir.toString());
				if ( dOut.exists() && dOut.isDirectory()) {
					System.out.printf("ERROR: Dir '%s' already exists, exiting...\n", dataDir);
					System.exit(1);
				} else {
					dOut.mkdirs();
					System.out.printf("INFO: Restoring readable messages from corrupted file to dir '%s'...\n", dataDir);
				}
			} else {
				System.out.printf("INFO: Finding readable messages from corrupted file...\n");
				dataDir = null;
			}
			try (PersonalStorage pst = PersonalStorage.fromFile(inputFile)) {
			    exploreCorruptedPst(debug, pst, pst.getRootFolder().getEntryIdString(), dataDir);
			} catch (Exception e) {
				System.out.printf("ERROR: %s", e);
				System.exit(2);
			}
		} else {
			if ( fOut.exists() || fOut.isFile() ) {
				String sOutErr = String.format("ERROR: output file \"%s\" already exists", outputFile);
				System.out.println(sOutErr);
				System.exit(2);
			}
			// Read an OST file
			readAnOSTFile(debug, inputFile);
			// Converting OST to PST
			convertOSTToPST(debug, inputFile, outputFile);
		}
	}

	public static void readAnOSTFile(final boolean debug, String inputFile) {
		// Load the Outlook PST file
		PersonalStorage pst = null;
		FolderInfoCollection folderInfoCollection = null;
		try {
			pst = PersonalStorage.fromFile(inputFile);
		} catch (Exception e) {
			System.out.printf("ERROR: %s", e);
		}
		folderInfoCollection = pst.getRootFolder().getSubFolders();
		// Loop over all sub-folders
		for (int i = 1; i < folderInfoCollection.size(); i++) {
			// Display all the folders
			FolderInfo folderInfo = folderInfoCollection.get_Item(i);
			System.out.printf("%4s [%02d] Folder \"%s\"\n", " ", i, folderInfo.getDisplayName());
		}
		System.out.println("");
	}

	// Get data version (NDB version) from offset 10
	public static int typeOSTFile(final boolean debug, String inputFile) {
		RandomAccessFile raf = null;
		final byte[] fileTypeBytes = new byte[2];
		try {
            raf = new RandomAccessFile(inputFile, "r");
			raf.seek(10);
			raf.readFully(fileTypeBytes);
		} catch (Exception e) {
			System.out.printf("ERROR: %s", e);
		}
		finally {
			try {
				raf.close();
			}
			catch (Exception e){
				System.out.printf("ERROR: %s", e);
			}
		}
		return (int) fileTypeBytes[0];
	}

	// Get file format type: array index is 'wVer' and maps to description String
	public static String fileFormatType(final boolean debug, int fmtTypeNum) {
		String[] arr = new String[50];
		String fmtTypeStr = "Unknown";
		arr[14] = "32-bit ANSI";
		arr[15] = "32-bit ANSI";
		arr[21] = "64-bit Unicode, Visual Recovery";
		arr[23] = "64-bit Unicode";
		arr[36] = "64-bit Unicode 4k, Outlook 2013";
		if (arr[fmtTypeNum] != null) fmtTypeStr = arr[fmtTypeNum];
		return (String) fmtTypeStr;
	}

	public static void convertOSTToPST(final boolean debug, final String inputFile, final String outputFile) {
		if (typeOSTFile(debug, inputFile) != 36) {
			// Prepare task to convert and save
	        Runnable r = new Runnable() {
	            public void run() {
	            	PersonalStorage ost = PersonalStorage.fromFile(inputFile);
	            	try {
	            		ost.saveAs(outputFile, FileFormat.Pst);
	            	} catch (com.aspose.email.system.exceptions.NotImplementedException e) {
	            		System.out.println("");
	            		System.out.printf("ERROR: unable to save file, make sure input file format is supported\n");
	            		System.out.printf("ERROR: %s", e);
	            	} catch (Exception e) {
	            		System.out.println("");
	            		System.out.printf("ERROR: %s", e);
	            	}
	            }
	        };
	        // Start thread and task
	        new Thread(r).start();
			File fIn = new File(inputFile);
			File fOut = new File(outputFile);
			// Show progress
			String spin = "----\\\\\\\\||||////";  // ".oO@"
			int i = 0;
			System.out.printf("INFO: Converting \"%s\" to \"%s\"\n", inputFile, outputFile);
			while (fIn.length() > fOut.length()) {
				if (debug) System.out.println("DEBUG: fIn.length=" + fIn.length() + " fOut.length=" + fOut.length());
				if ((int)Math.round((100.0 * fOut.length() / fIn.length())) >= 99) {
					spin = String.format("%16s", " ");
				}
				String sConv = String.format("%5s %dMB/%dMB (%d%%) %s", " ",
					(int)(fOut.length() / 1024 / 1024),
					(int)(fIn.length() / 1024 / 1024),
					(int)Math.round((100.0 * fOut.length() / fIn.length())),
					spin.charAt(i % 16)
				);
				System.out.print(sameLine(sConv));
	            i++;
			}
			System.out.println("");
		} else {
			System.out.printf("INFO: Saving Outlook 2013/2016 files is not supported, exiting...\n");
			System.exit(1);
		}
	}
	
	/* http://programming.guide/java/formatting-byte-size-to-human-readable-format.html */
	public static String humanReadableByteCountSI(long bytes) {
	    if (-1000 < bytes && bytes < 1000) {
	        return bytes + " B";
	    }
	    CharacterIterator ci = new StringCharacterIterator("kMGTPE");
	    while (bytes <= -999_950 || bytes >= 999_950) {
	        bytes /= 1000;
	        ci.next();
	    }
	    return String.format("%.1f %cB", bytes / 1000.0, ci.current());
	}

	// Get random number 97-122 (ascii lc letters)
	public static int getRnd() {
		return (int)(Math.random()*(25))+97;
	}

	// Generate random output: "12345abcde"
	public static String getRndName() {
        int rndNumbers = getRnd();
		String rndLetters = "";
		for (int i=0; i < 5; i++) {
	        rndNumbers += getRnd();
	        rndLetters += (char) getRnd();
		}
	    return String.format("%s%s", rndNumbers*getRnd(), rndLetters);
	}

	// String on same line, 80 chars wide
	public static String sameLine(String text) {
		int sLen = (int)(80 - text.length());
		if (sLen != 0) {
			String sPad = String.format("%" + sLen + "s", " ");
			//return String.format(text.substring(0, Math.min(text.length(), 80)) + sPad + "\r");
			return text + sPad + "\r";
		}
		return null;
	}
	
	public class Items {
		private int cnt = 0;
		public void setCnt(int cnt) {
			this.cnt = cnt;
		}
		public int getCnt() {
		    return this.cnt;
		}
	}

	public static void exploreCorruptedPst(final boolean debug, PersonalStorage pst, String rootFolderId, String dataDir) {

		LoadAndConvertOSTFileCLI outerObj = new LoadAndConvertOSTFileCLI();  	
		LoadAndConvertOSTFileCLI.Items numMsg = outerObj.new Items();
		LoadAndConvertOSTFileCLI.Items numMsgErr = outerObj.new Items();
		LoadAndConvertOSTFileCLI.Items numFolder = outerObj.new Items();    	
		numFolder.cnt = 1;
		numMsg.cnt = 1;

		Iterable<String> messageIdList = pst.findMessages(rootFolderId);

        for (String messageId : messageIdList) {
	        try {
	            MapiMessage msg = pst.extractMessage(messageId);

	            // TODO: get body as text, add option
	            //System.out.printf(msg.getBody());
	            if (dataDir != null) {
		            // Save msg file, dont use '/' in filename
		            String msgFile = dataDir + "/" + messageId.replace("/", "_") + ".msg";
		            msg.save(msgFile);
		            //System.out.print(msgInfo);
		            System.out.print(sameLine(String.format("%5s [%02d/50] File: \"%s\"\r", " ", numMsg.getCnt(), msgFile)));
	            } else {
	            	System.out.printf("%5s [%02d/50] Subject: \"%s\"\n", " ", numMsg.getCnt(), msg.getSubject());
	            }
	            numMsg.cnt++;
	            numMsg.setCnt(numMsg.cnt);
	        } catch (Exception e) {
	        	if (numMsgErr.getCnt() > 100) {
	        		System.out.printf("\nMore than 100 unreadable items found, exiting...\n");
	        		System.exit(1);
	        	}
	            System.out.printf("\\nMessage reading error. Entry id: %s\\n", messageId);
		        numMsgErr.cnt++;
		        numMsgErr.setCnt(numMsgErr.cnt);
	        }
	    }

	    Iterable<String> folderIdList = pst.findSubfolders(rootFolderId);

	    // TODO: get/set folder to use in messages loop above
	    for (String subFolderId : folderIdList) {
	        if (subFolderId != rootFolderId) {
	            try {
	                FolderInfo subfolder = pst.getFolderById(subFolderId);
	                if (subfolder.getDisplayName().toString() != "") {
	                	System.out.printf("%5s [%02d] Folder: \"%s\"%8s\n", " ", numFolder.getCnt(), subfolder.getDisplayName(), " ");
	                	numFolder.cnt++;
	                	numFolder.setCnt(numFolder.cnt);
	                } else {
	                	System.out.printf("ERROR: could not display [%02d] subfolder=%s subFolderIdid=%s\n", numFolder.getCnt(), subfolder, subFolderId);
	                }
	            } catch (Exception e) {
	                System.out.printf("\nFolder reading error. Entry id: %s\n", subFolderId);
	            }
	            exploreCorruptedPst(debug, pst, subFolderId, dataDir);
	        }
	    }
	}

}
