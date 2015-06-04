package asposefeatures.workingwithoutlookstorage.checkprotection.java;

import com.aspose.email.MapiPropertyTag;
import com.aspose.email.PersonalStorage;

public class CheckProtection
{
	public static void main(String[] args)
	{
		String dataPath = "src/asposefeatures/workingwithoutlookstorage/checkprotection/data/";
		
		// Load the Outlook PST file
		PersonalStorage pst = PersonalStorage.fromFile(dataPath + "personalStorage.pst");
		if (isPasswordProtected(pst))
		{
			System.out.println("-- PROTECTED -- ");
		}
		else
		{
			System.out.println("-- NOT PROTECTED -- ");
		}
		
	}
	private static boolean isPasswordProtected(PersonalStorage pst)
    {
        // If the property exists and is nonzero, then the PST file is password protected.
        if (pst.getMessageStoreProperties().contains(MapiPropertyTag.PR_PST_PASSWORD))
        {
            long passwordHash = pst.getMessageStoreProperties().get_Item(MapiPropertyTag.PR_PST_PASSWORD).getLong();
            return passwordHash != 0;
        }

        return false;
    }
}
