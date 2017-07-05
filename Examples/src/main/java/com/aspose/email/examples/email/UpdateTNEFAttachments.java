package com.aspose.email.examples.email;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.aspose.email.EmlLoadOptions;
import com.aspose.email.EmlSaveOptions;
import com.aspose.email.FileCompatibilityMode;
import com.aspose.email.LinkedResource;
import com.aspose.email.MailMessage;
import com.aspose.email.MailMessageSaveType;
import com.aspose.email.SaveOptions;
import com.aspose.email.examples.Utils;

/*
This project uses automatic dependency resolution feature of Maven to resolve Aspose.Email for Java API reference when the project is build. Please check https://maven.apache.org/what-is-maven.html for more information. If you do not wish to use Maven, you can manually download Aspose.Email for Java API from http://www.aspose.com/downloads, install it and then add its reference to this project. For any issues, questions or suggestions please feel free to contact us using http://www.aspose.com/community/forums/default.aspx
 */

public class UpdateTNEFAttachments {
    public static void main(String[] args)
    {
        // The path to the resource directory.
        String dataDir = Utils.getSharedDataDir(UpdateTNEFAttachments.class) + "email/";
        TestUpdateResources(dataDir);
    }

    // ExStart:UpdateTNEFAttachments
    public static void TestUpdateResources(String dataDir)
    {
        String fileName = dataDir + "tnefEMl1.eml";
        String imgFileName = dataDir + "Untitled.jpg";
        String outFileName = dataDir + "01_SAVE_Preserve_out.eml";
        MailMessage originalMailMessage = MailMessage.load(fileName);
        EmlLoadOptions emlOp = new EmlLoadOptions();
        UpdateResources(originalMailMessage, imgFileName);
        EmlSaveOptions emlSo = new EmlSaveOptions(MailMessageSaveType.getEmlFormat());
        emlSo.setFileCompatibilityMode(FileCompatibilityMode.PreserveTnefAttachments);
        originalMailMessage.save(outFileName, emlSo);
    }

    private static void UpdateResources(MailMessage msg, String imgFileName)
    {
        for (int i = 0; i < msg.getAttachments().size(); i++)
        {
            if (msg.getAttachments().get_Item(i).getContentType().getName().endsWith("jpg"))
            {
                try {
                    File attFile = new File(imgFileName);
                    msg.getAttachments().get_Item(i).setContentStream(new FileInputStream(attFile));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            else if (msg.getAttachments().get_Item(i).getContentType().getName().endsWith("eml"))
            {

                ByteArrayOutputStream ms = new ByteArrayOutputStream();
                msg.getAttachments().get_Item(i).save(ms);
                //ms.reset();
                ByteArrayInputStream ims = new ByteArrayInputStream(ms.toByteArray());
                MailMessage embeddedMessage = MailMessage.load(ims);
                UpdateResources(embeddedMessage, imgFileName);
                ByteArrayOutputStream outProcessedEmbedded = new ByteArrayOutputStream();
                embeddedMessage.save(outProcessedEmbedded, SaveOptions.getDefaultMsgUnicode());
                //outProcessedEmbedded.reset();
                ByteArrayInputStream inProcessedEmbedded = new ByteArrayInputStream(outProcessedEmbedded.toByteArray());
                msg.getAttachments().get_Item(i).setContentStream(inProcessedEmbedded);
            }
        }

        for (LinkedResource att : msg.getLinkedResources())
        {
            if (att.getContentType().getMediaType() == "image/jpg")
            {
                try {
                    File embeddedFile = new File(imgFileName);
                    FileInputStream es = null;
                    es = new FileInputStream(embeddedFile);
                    att.setContentStream(es );
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    // ExEnd:UpdateTNEFAttachments
}
