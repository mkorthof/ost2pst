/*
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Email. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */

package programmersguide.programmingoutlook.workwithoutlookmsgfiles.createsaveoutlookfiles.java;

import com.aspose.email.*;

import java.io.File;

public class CreateSaveOutlookFiles
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/programmingoutlook/workwithoutlookmsgfiles/createsaveoutlookfiles/data/";
        new File(dataDir).mkdirs();

        // Create an instance of MailMessage class
        MailMessage mailMsg = new MailMessage();

        // Set FROM field of the message
        mailMsg.setFrom(new MailAddress("from@domain.com"));

        // Create an instance of MailAddressCollection
        MailAddressCollection addressCol = new MailAddressCollection();

        // Add an address to MailAddressCollection
        addressCol.addMailAddress(new MailAddress("to@domain.com"));

        // Set the MailAddressCollection as TO field of the message
        mailMsg.setTo(addressCol);

        // Set SUBJECT of the message
        mailMsg.setSubject("creating an outlook message file");

        // Set BODY of the message
        mailMsg.setBody("This message is created by Aspose.Email for Java");

        // Create an instance of MapiMessage class and pass MailMessage as argument
        MapiMessage outlookMsg = MapiMessage.fromMailMessage(mailMsg);

        // Path and file name where message file will be saved
        String strMsgFile = dataDir + "message.msg";

        // Save the message (msg) file
        outlookMsg.save(strMsgFile);

        // Display Status.
        System.out.println("MSG file created and saved successfully.");
    }
}




