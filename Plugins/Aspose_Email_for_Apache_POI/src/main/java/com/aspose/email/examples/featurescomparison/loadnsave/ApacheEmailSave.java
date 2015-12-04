package com.aspose.email.examples.featurescomparison.loadnsave;

import java.io.PrintWriter;

import org.apache.poi.hsmf.MAPIMessage;

import com.aspose.email.examples.Utils;

public class ApacheEmailSave
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(ApacheEmailSave.class);

        String filename = dataDir + "message.msg";
        MAPIMessage msg = new MAPIMessage(filename);

        PrintWriter txtOut = new PrintWriter(dataDir + "ApacheMessage.txt");
        txtOut.println("Email Body: " + msg.getTextBody());
        txtOut.close();
    }
}
