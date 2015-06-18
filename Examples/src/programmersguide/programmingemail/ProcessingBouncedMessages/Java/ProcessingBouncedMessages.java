/*
 * Copyright 2001-2015 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Email. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */

//This example works with Aspose.Email for Java 5.4.0 and onwards
package programmersguide.programmingemail.ProcessingBouncedMessages.java;

import com.aspose.email.*;

public class ProcessingBouncedMessages
{
    // The path to the documents directory.
    static String dataDir = "src/programmersguide/programmingExchange/WorkingWithTask/java";

    public static void main(String[] args) throws Exception
    {
        //license initialization

        ProcessBouncedMessages();

        // Display Status.
        System.out.println("Execution completed.");
    }

    public static void ProcessBouncedMessages()
    {
        String fileName = "failed1.eml";
        MailMessage mail = MailMessage.load(fileName);
        BounceResult result = mail.checkBounced();
        System.out.println(fileName);
        System.out.println("IsBounced : " + result.isBounced());
        System.out.println("Action : " + result.getAction());
        System.out.println("Recipient : " + result.getRecipient());
        System.out.println();

        fileName = "failedReport2.eml";
        mail = MailMessage.load(fileName);
        result = mail.checkBounced();
        System.out.println(fileName);
        System.out.println("IsBounced : " + result.isBounced());
        System.out.println("Action : " + result.getAction());
        System.out.println("Recipient : " + result.getRecipient());
        System.out.println("Reason : " + result.getReason());
        System.out.println("Status : " + result.getStatus());
        System.out.println("OriginalMessage ToAddress 1: " + result.getOriginalMessage().getTo().get_Item(0).getAddress());
        System.out.println("OriginalMessage ToAddress 2: " + result.getOriginalMessage().getTo().get_Item(1).getAddress());
        System.out.println();

        fileName = "delayed.eml";
        mail = MailMessage.load(fileName);
        result = mail.checkBounced();
        System.out.println(fileName);
        System.out.println("IsBounced : " + result.isBounced());
        System.out.println("Action : " + result.getAction());
        System.out.println("Recipient : " + result.getRecipient());
    }

}




