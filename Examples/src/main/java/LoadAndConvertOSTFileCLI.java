import com.aspose.email.FileFormat;
import com.aspose.email.FolderInfo;
import com.aspose.email.FolderInfoCollection;
import com.aspose.email.PersonalStorage;
// import com.aspose.email.examples.Utils;
import java.io.File;

public class LoadAndConvertOSTFileCLI {

	public static void main(String[] args) {
		String inputFile = "";
		String outputFile = "";
		boolean debug = false;
  		if (args.length != 0) {
  			if (debug) { 
  				System.out.println("DEBUG: args 0 " + args[0]);
  				System.out.println("DEBUG: args 1 " + args[1]);
  				System.out.println("DEBUG: args lenght " + args.length);
  			}
  			inputFile = args[0];
			outputFile = args[1];
		} else {
			System.out.println("Usage: ost2pst.jar <input.ost> <output.pst>");
			System.exit(0);
		}
		File f = new File(inputFile);	
		if (debug) { 
			System.out.println("DEBUG: exists " + f.exists());
			System.out.println("DEBUG: isFile " + f.isFile());
		}
		if (f.exists() && f.isFile()) {
			if (debug) { System.out.println("DEBUG: file " + f + " exists, and it is a file"); }
			//Read an OST file
			readAnOSTFile(inputFile);
		
			//Converting OST to PST
			convertOSTToPST(inputFile, outputFile);
		} else {
			System.out.println("ERROR: " + inputFile + "does not exist or is not a file");
			System.exit(1);
		}
	}

	public static void readAnOSTFile(String inputFile) {
		// Load the Outlook PST file
		System.out.println("INFO: loading pst file...");
		String strPSTFile = inputFile;
		PersonalStorage pst = PersonalStorage.fromFile(strPSTFile);

		// Get sub-folders of Root
		FolderInfoCollection folderInfoCollection = pst.getRootFolder().getSubFolders();
		// Loop over all the-sub folders
		for (int i = 0; i < folderInfoCollection.size(); i++) {
			// Display all the folders
			FolderInfo folderInfo = (FolderInfo) folderInfoCollection.get_Item(i);
			System.out.println("INFO: Folder " + i + " " + folderInfo.getDisplayName());
		}
	}

	public static void convertOSTToPST(String inputFile, String outputFile) {
		System.out.println("INFO: converting " + inputFile + " to " + outputFile + ", depending on filesize/cpu/etc this may take a while...");
		PersonalStorage ost = PersonalStorage.fromFile(inputFile);
		ost.saveAs(outputFile, FileFormat.Pst);
	}
}