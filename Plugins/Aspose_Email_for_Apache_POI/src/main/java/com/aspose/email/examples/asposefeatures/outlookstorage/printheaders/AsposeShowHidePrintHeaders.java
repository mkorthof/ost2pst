package com.aspose.email.examples.asposefeatures.outlookstorage.printheaders;

import com.aspose.email.MailMessage;
import com.aspose.email.MailMessageSaveOptions;
import com.aspose.email.MailMessageSaveType;
import com.aspose.email.examples.Utils;

public class AsposeShowHidePrintHeaders
{
    public static void main(String[] args)
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(AsposeShowHidePrintHeaders.class);

        MailMessage message = MailMessage.load(dataDir + "message.eml");
        String encodedPageHeader = "<div><div class=3D'page=Header'>&quot;Panditharatne, Mithra&quot; &lt;mithra=2Epanditharatne@cibc==2Ecom&gt;<hr/></div>";

        int saveOptions =  MailMessageSaveOptions.HideExtraPrintHeader;
        message.save(dataDir + "AsposeHideExtraHeaders.mhtml", MailMessageSaveType.getMHtmlFormat(), saveOptions);

        System.out.println("Done");
    }
}