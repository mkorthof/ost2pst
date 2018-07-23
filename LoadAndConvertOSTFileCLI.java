package com.ost2pst;
import com.aspose.email.FileFormat;
import com.aspose.email.FolderInfo;
import com.aspose.email.FolderInfoCollection;
import com.aspose.email.PersonalStorage;
//import com.aspose.email.examples.Utils;
import java.io.File;

public class LoadAndConvertOSTFileCLI {
	
	public static void main(String[] args) {
		
		System.out.println("\nOST2PST (" + Version.VERSION + ")\n");
		String inputFile = "";
		String outputFile = "";
		boolean debug = false;
		if (args.length == 0) {
			System.out.println("Usage: ost2pst.jar <input.ost> <output.pst>"); System.exit(0);
		} else 
			try { inputFile = args[0]; } catch(Exception e) {
				System.out.println("ERROR: missing input file");
				System.out.println("Usage: ost2pst.jar <input.ost> <output.pst>"); System.exit(2);
			}
			try { outputFile = args[1]; } catch(Exception e) {
				System.out.println("ERROR: missing output file");
				System.out.println("Usage: ost2pst.jar <input.ost> <output.pst>"); System.exit(2);
			}
  			if (debug) { System.out.println("DEBUG: args.length " + args.length + "args[0] " + args[0] + " args[1] " + args[1]); }
		
		File fIn = new File(inputFile);	
		File fOut = new File(outputFile);
		if (debug) { System.out.println("DEBUG: inputfile exists " + fIn.exists() + " inputfile isFile " + fIn.isFile()); }
		if ( !(fIn.exists() && fIn.isFile()) ) {
			System.out.println("ERROR: input file " + inputFile + " does not exist"); System.exit(2);
		}
		if ( fOut.exists() || fOut.isFile() ) {
			System.out.println("ERROR: output file " + outputFile + " already exists"); System.exit(2);
		}		
		//Read an OST file
		readAnOSTFile(inputFile);
		
		//Converting OST to PST
		convertOSTToPST(inputFile, outputFile);
	}

	public static void readAnOSTFile(String inputFile) {
		// Load the Outlook PST file
		File f = new File(inputFile);
		System.out.println("INFO: Loading OST file " + inputFile + " (" + humanReadableByteCount(f.length(), true) + ")");
		PersonalStorage pst = PersonalStorage.fromFile(inputFile);

		// Get sub-folders of Root
		FolderInfoCollection folderInfoCollection = pst.getRootFolder().getSubFolders();
		// Loop over all the-sub folders
		for (int i = 0; i < folderInfoCollection.size(); i++) {
			// Display all the folders
			FolderInfo folderInfo = folderInfoCollection.get_Item(i);
			System.out.println("INFO: Folder " + i + " " + folderInfo.getDisplayName());
		}
	}

	public static void convertOSTToPST(final String inputFile, final String outputFile) {
        Runnable r = new Runnable() {
            public void run() {
            	PersonalStorage ost = PersonalStorage.fromFile(inputFile);
            	ost.saveAs(outputFile, FileFormat.Pst);
            }
        };

        new Thread(r).start();
		File fIn = new File(inputFile);
		File fOut = new File(outputFile);
		while (fIn.length() > fOut.length()) {
			System.out.print("INFO: Converting " + inputFile + " to " + outputFile  + " - " + fOut.length() + " / " + fIn.length() + " bytes\r");
		}
		System.out.println("");
	}
	
	
	// http://programming.guide/java/formatting-byte-size-to-human-readable-format.html
	public static String humanReadableByteCount(long bytes, boolean si) {
	    int unit = si ? 1000 : 1024;
	    if (bytes < unit) return bytes + " B";
	    int exp = (int) (Math.log(bytes) / Math.log(unit));
	    String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp-1) + (si ? "" : "i");
	    return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
	}	  
}
