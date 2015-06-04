package asposefeatures.conversion.osttopst.java;

import com.aspose.email.FileFormat;
import com.aspose.email.PersonalStorage;

public class AsposeOSTtoPST
{
	public static void main(String[] args)
	{
		String dataPath = "src/asposefeatures/conversion/osttopst/data/";
		
		PersonalStorage ost = PersonalStorage.fromFile(dataPath + "outlook.ost");

		ost.saveAs(dataPath + "AsposeOST-PST.pst", FileFormat.Pst);
		System.out.println("Done");
	}
}
