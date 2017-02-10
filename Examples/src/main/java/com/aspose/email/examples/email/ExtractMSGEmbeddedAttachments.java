package com.aspose.email.examples.email;

import com.aspose.email.*;
import com.aspose.email.examples.Utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/*
This project uses automatic dependency resolution feature of Maven to resolve Aspose.Email for Java API reference when the project is build. Please check https://maven.apache.org/what-is-maven.html for more information. If you do not wish to use Maven, you can manually download Aspose.Email for Java API from http://www.aspose.com/downloads, install it and then add its reference to this project. For any issues, questions or suggestions please feel free to contact us using http://www.aspose.com/community/forums/default.aspx
 */

public class ExtractMSGEmbeddedAttachments {
    public static void main(String[] args)
    {
        // The path to the resource directory.
        String dataDir = Utils.getSharedDataDir(ExtractMSGEmbeddedAttachments.class) + "email/";

        ExtractInlineAttachments(dataDir);
    }

    // ExStart:ExtractMSGEmbeddedAttachments
    static void ExtractInlineAttachments(String dataDir)
    {
        MapiMessage message = MapiMessage.fromFile(dataDir + "MSG file with RTF Formatting.msg");
        MapiAttachmentCollection attachments = message.getAttachments();
        for (Object untypedAttachment : attachments)
        {
            MapiAttachment attachment = (MapiAttachment) untypedAttachment;
            if(IsAttachmentInline(attachment))
            {
                try
                {
                    SaveAttachment(attachment, UUID.randomUUID().toString());
                }
                catch (IOException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    static boolean IsAttachmentInline(MapiAttachment attachment)
    {
        MapiObjectProperty objectData = attachment.getObjectData();
        if (objectData == null)
            return false;

        for (Object prop : attachment.getObjectData().getProperties().getValues())
        {
            MapiProperty property = (MapiProperty)prop;
            if ("\u0003ObjInfo".equals(property.getName()))
            {
                byte[] data = property.getData();
                int odtPersist1 = data[1] << 8 | data[0];
                return (odtPersist1 & 0x40) == 0;
            }
        }
        return false;
    }

    static void SaveAttachment(MapiAttachment attachment, String fileName) throws IOException, FileNotFoundException
    {
        for (Object prop : attachment.getObjectData().getProperties().getValues())
        {
            MapiProperty property = (MapiProperty)prop;
            if ("Package".equals(property.getName()))
            {
                FileOutputStream fs;
                try
                {
                    fs = new FileOutputStream(fileName);
                    fs.write(property.getData(), 0, property.getData().length);
                }
                catch (java.io.IOException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
    // ExEnd:ExtractMSGEmbeddedAttachments
}
