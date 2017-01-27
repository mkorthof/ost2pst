package com.aspose.email.examples.email;

import com.aspose.email.EmlLoadOptions;
import com.aspose.email.MailMessage;
import com.aspose.email.MapiConversionOptions;
import com.aspose.email.MapiMessage;

/**
 * Created by hp on 1/27/2017.
 */
public class PreservingEmbeddedMsgFormat {

    public static void main(String[] args) {
        //ExStart: PreservingEmbeddedMsgFormat
        MailMessage eml = MailMessage.load("path", new EmlLoadOptions());

        MapiConversionOptions options = MapiConversionOptions.getUnicodeFormat();

        options.setPreserveEmbeddedMessageFormat(true);

        MapiMessage msg = MapiMessage.fromMailMessage(eml, options);
        //ExEnd: PreservingEmbeddedMsgFormat
    }
}
