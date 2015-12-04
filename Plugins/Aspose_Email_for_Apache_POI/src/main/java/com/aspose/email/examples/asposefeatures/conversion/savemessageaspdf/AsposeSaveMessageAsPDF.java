package com.aspose.email.examples.asposefeatures.conversion.savemessageaspdf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

import com.aspose.email.MailMessage;
import com.aspose.email.SaveOptions;
import com.aspose.words.Document;
import com.aspose.words.LoadFormat;
import com.aspose.words.LoadOptions;
import com.aspose.words.SaveFormat;

import com.aspose.email.examples.Utils;

public class AsposeSaveMessageAsPDF
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(AsposeSaveMessageAsPDF.class);

        FileInputStream fstream = new FileInputStream(dataDir + "message.msg");
        MailMessage eml = MailMessage.load(fstream);

        // Save the Message to output stream in MHTML format
        ByteArrayOutputStream emlStream = new ByteArrayOutputStream();
        eml.save(emlStream, SaveOptions.getDefaultMhtml());

        // Load the stream in Word document
        LoadOptions lo = new LoadOptions();
        lo.setLoadFormat(LoadFormat.MHTML);
        Document doc = new Document(new ByteArrayInputStream(
                        emlStream.toByteArray()), lo);

        // Save to disc
        doc.save(dataDir + "About Aspose.Pdf", SaveFormat.PDF);

        // or Save to stream
        ByteArrayOutputStream foStream = new ByteArrayOutputStream();
        doc.save(foStream, SaveFormat.PDF);

        System.out.println("Done");
    }
}
