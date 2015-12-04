package com.aspose.email.examples.asposefeatures.conversion.osttopst;

import com.aspose.email.FileFormat;
import com.aspose.email.PersonalStorage;
import com.aspose.email.examples.Utils;

public class AsposeOSTtoPST
{
    public static void main(String[] args)
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(AsposeOSTtoPST.class);

        PersonalStorage ost = PersonalStorage.fromFile(dataDir + "outlook.ost");

        ost.saveAs(dataDir + "AsposeOST-PST.pst", FileFormat.Pst);
        System.out.println("Done");
    }
}
