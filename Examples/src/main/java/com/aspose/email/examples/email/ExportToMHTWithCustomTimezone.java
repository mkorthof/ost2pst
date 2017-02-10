package com.aspose.email.examples.email;

import com.aspose.email.*;
import com.aspose.email.examples.Utils;

import java.util.Date;

/*
This project uses automatic dependency resolution feature of Maven to resolve Aspose.Email for Java API reference when the project is build. Please check https://maven.apache.org/what-is-maven.html for more information. If you do not wish to use Maven, you can manually download Aspose.Email for Java API from http://www.aspose.com/downloads, install it and then add its reference to this project. For any issues, questions or suggestions please feel free to contact us using http://www.aspose.com/community/forums/default.aspx
 */

public class ExportToMHTWithCustomTimezone {
    public static void main(String[] args)
    {
        // The path to the resource directory.
        String dataDir = Utils.getSharedDataDir(ExportToMHTWithCustomTimezone.class) + "email/";
        String filename= dataDir + "MSG file with RTF Formatting.msg";

        // ExStart:ExportToMHTWithCustomTimezone
        MailMessage msg = MailMessage.load(filename, new MsgLoadOptions());
        msg.setDate(new Date());

        // Set the timezone offset in seconds
        msg.setTimeZoneOffset(5*60*60*1000);

        MhtSaveOptions mhtOptions = new MhtSaveOptions();
        mhtOptions.setMhtFormatOptions(MhtFormatOptions.WriteHeader);
        msg.save(dataDir + "ExportToMHTWithCustomTimezone_out.mhtml", mhtOptions);
        // ExEnd:ExportToMHTWithCustomTimezone
    }
}
