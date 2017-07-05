package com.aspose.email.examples.email;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/*
This project uses automatic dependency resolution feature of Maven to resolve Aspose.Email for Java API reference when the project is build. Please check https://maven.apache.org/what-is-maven.html for more information. If you do not wish to use Maven, you can manually download Aspose.Email for Java API from http://www.aspose.com/downloads, install it and then add its reference to this project. For any issues, questions or suggestions please feel free to contact us using http://www.aspose.com/community/forums/default.aspx
 */

import com.aspose.email.MailMessage;
import com.aspose.email.MsgLoadOptions;
import com.aspose.email.examples.Utils;

public class CheckMessageForEncryption {
    public static  void main(String[] args)
    {
        // The path to the resource directory.
        String dataDir = Utils.getSharedDataDir(EncryptAndDecryptMessage.class) + "email/";

        String publicCertFileName = dataDir + "MyKey.cer";
        String privateCertFileName = dataDir + "MyPFX.pfx";
        Path publicCertFilePath = Paths.get(publicCertFileName);
        Path privateCertFilePath = Paths.get(privateCertFileName);

        // ExStart:CheckMessageForEncryption
        // Create a message
        MailMessage originalMsg = MailMessage.load(dataDir + "Message.msg", new MsgLoadOptions());
        if (originalMsg.isEncrypted() == true)
            System.out.println("Its encrypted");
        else
            System.out.println("Its NOT encrypted");

        // Encrypt the message
        MailMessage mailMsg = null;
        try {
            mailMsg = originalMsg.encrypt(Files.readAllBytes(publicCertFilePath), "");
            if (mailMsg.isEncrypted() == true)
                System.out.println("Its encrypted");
            else
                System.out.println("Its NOT encrypted");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Decrypt the message
        try {
            mailMsg = mailMsg.decrypt(Files.readAllBytes(privateCertFilePath), "password");
            if (mailMsg.isEncrypted() == true)
                System.out.println("Its encrypted");
            else
                System.out.println("Its NOT encrypted");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // ExEnd:CheckMessageForEncryption
    }
}
