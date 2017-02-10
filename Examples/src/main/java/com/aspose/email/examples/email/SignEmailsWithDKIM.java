package com.aspose.email.examples.email;

import com.aspose.email.DKIMSignatureInfo;
import com.aspose.email.MailMessage;
import com.aspose.email.PemReader;
import com.aspose.email.SmtpClient;
import com.aspose.email.system.security.RSACryptoServiceProvider;

/*
This project uses automatic dependency resolution feature of Maven to resolve Aspose.Email for Java API reference when the project is build. Please check https://maven.apache.org/what-is-maven.html for more information. If you do not wish to use Maven, you can manually download Aspose.Email for Java API from http://www.aspose.com/downloads, install it and then add its reference to this project. For any issues, questions or suggestions please feel free to contact us using http://www.aspose.com/community/forums/default.aspx
 */

public class SignEmailsWithDKIM {
    public  static  void main(String[] args)
    {
        // ExStart:SignEmailsWithDKIM
        String privateKeyFile = "key2.pem";
        RSACryptoServiceProvider rsa = PemReader.getPrivateKey(privateKeyFile);
        DKIMSignatureInfo signInfo = new DKIMSignatureInfo("test", "yandex.ru");
        signInfo.getHeaders().addItem("From");
        signInfo.getHeaders().addItem("Subject");
        MailMessage mailMessage = new MailMessage("sender@gmail.com", "test@gmail.com");
        mailMessage.setSubject("Signed DKIM message text body");
        mailMessage.setBody("This is a text body signed DKIM message");
        MailMessage signedMsg = mailMessage.dKIMSign(rsa, signInfo);

        try
        {
            SmtpClient client = new SmtpClient("smtp.domain.com",25, "username", "password");
            client.send(signedMsg);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {}
        // ExEnd:SignEmailsWithDKIM
    }
}
