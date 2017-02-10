package com.aspose.email.examples.email;


import com.aspose.email.MailMessage;
import com.aspose.email.examples.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
This project uses automatic dependency resolution feature of Maven to resolve Aspose.Email for Java API reference when the project is build. Please check https://maven.apache.org/what-is-maven.html for more information. If you do not wish to use Maven, you can manually download Aspose.Email for Java API from http://www.aspose.com/downloads, install it and then add its reference to this project. For any issues, questions or suggestions please feel free to contact us using http://www.aspose.com/community/forums/default.aspx
 */

public class EncryptAndDecryptMessage {
    public  static  void main(String[] args)
    {
        // The path to the resource directory.
        String dataDir = Utils.getSharedDataDir(EncryptAndDecryptMessage.class) + "email/";

        // ExStart:EncryptAndDecryptMessage
        String publicCertFileName = dataDir + "MyKey.cer";
        String privateCertFileName = dataDir + "MyPFX.pfx";
        Path publicCertFilePath = Paths.get(publicCertFileName);
        Path privateCertFilePath = Paths.get(privateCertFileName);

        // Create a message
        MailMessage msg = new MailMessage("atneostthaecrcount@gmail.com", "atneostthaecrcount@gmail.com", "Test subject", "Test Body");

        // Encrypt the message
        MailMessage eMsg = null;
        try {
            eMsg = msg.encrypt(Files.readAllBytes(publicCertFilePath), "");
            if (eMsg.isEncrypted() == true)
                System.out.println("Its encrypted");
            else
                System.out.println("Its NOT encrypted");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Decrypt the message
        MailMessage dMsg = null;
        try {
            dMsg = eMsg.decrypt(Files.readAllBytes(privateCertFilePath), "password");

            if (dMsg.isEncrypted() == true)
                System.out.println("Its encrypted");
            else
                System.out.println("Its NOT encrypted");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // ExEnd:EncryptAndDecryptMessage
    }
}
