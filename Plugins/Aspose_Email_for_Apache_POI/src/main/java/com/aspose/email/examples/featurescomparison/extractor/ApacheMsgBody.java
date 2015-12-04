package com.aspose.email.examples.featurescomparison.extractor;

import org.apache.poi.hsmf.MAPIMessage;

import com.aspose.email.examples.Utils;

public class ApacheMsgBody
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(ApacheMsgBody.class);

        MAPIMessage msg = new MAPIMessage(dataDir + "message.msg");
        System.out.println("Text Body:"+ msg.getTextBody());
    }
}
