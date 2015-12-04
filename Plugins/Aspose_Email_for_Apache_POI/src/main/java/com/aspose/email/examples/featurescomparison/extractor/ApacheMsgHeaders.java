package com.aspose.email.examples.featurescomparison.extractor;

import org.apache.poi.hsmf.MAPIMessage;

import com.aspose.email.examples.Utils;

public class ApacheMsgHeaders
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(ApacheMsgHeaders.class);

        MAPIMessage msg = new MAPIMessage(dataDir + "message.msg");

        System.out.println("From: " + msg.getDisplayFrom());
        System.out.println("To: " + msg.getDisplayTo());
        System.out.println("CC: " + msg.getDisplayCC());
        System.out.println("BCC: " + msg.getDisplayBCC());
        System.out.println("Subject: " + msg.getSubject());
    }
}
