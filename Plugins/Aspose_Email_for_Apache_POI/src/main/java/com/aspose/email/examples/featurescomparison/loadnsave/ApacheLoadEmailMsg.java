package com.aspose.email.examples.featurescomparison.loadnsave;

import org.apache.poi.hsmf.MAPIMessage;

import com.aspose.email.examples.Utils;

public class ApacheLoadEmailMsg
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(ApacheLoadEmailMsg.class);

        String filename = dataDir + "message.msg";
        MAPIMessage msg = new MAPIMessage(filename);
    }
}
