package com.aspose.email.examples.email;

import com.aspose.email.MailMessage;

/**
 * Created by hp on 1/27/2017.
 */
public class RemoveLRTracesFromMessageBody {

    public static void main(String[] args) {

        //ExStart: RemoveLRTracesFromMessageBody
        String fileName = "test.eml";

        MailMessage msg = MailMessage.load(fileName);

        msg.getLinkedResources().removeAt(0, true);

        msg.getAlternateViews().get_Item(0).getLinkedResources().clear(true);
        //ExEnd: RemoveLRTracesFromMessageBody
    }
}
