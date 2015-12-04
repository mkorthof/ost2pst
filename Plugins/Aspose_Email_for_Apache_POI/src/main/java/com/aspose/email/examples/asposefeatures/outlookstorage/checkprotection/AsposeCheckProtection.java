package com.aspose.email.examples.asposefeatures.outlookstorage.checkprotection;

import com.aspose.email.MapiPropertyTag;
import com.aspose.email.PersonalStorage;
import com.aspose.email.examples.Utils;

public class AsposeCheckProtection
{
    public static void main(String[] args)
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(AsposeCheckProtection.class);

        // Load the Outlook PST file
        PersonalStorage pst = PersonalStorage.fromFile(dataDir + "sample.pst");
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
