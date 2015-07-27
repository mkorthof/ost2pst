/* 
 * Copyright 2001-2015 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Email. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package com.aspose.email.examples.email;

import com.aspose.email.BounceResult;
import com.aspose.email.MailMessage;
import com.aspose.email.MailMessageLoadOptions;
import com.aspose.email.examples.Utils;

public class ProcessBouncedMsgs
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(ProcessBouncedMsgs.class);

        String fileName = dataDir + "failed.msg";
        MailMessage mail = MailMessage.load(fileName);
        BounceResult result = mail.checkBounced();
        System.out.println(fileName);
        System.out.println("IsBounced : " + result.isBounced());
        System.out.println("Action : " + result.getAction());
        System.out.println("Recipient : " + result.getRecipient());
        System.out.println("Reason : " + result.getReason());
        System.out.println("Status : " + result.getStatus());
//        System.out.println("OriginalMessage ToAddress 1: " + result.getOriginalMessage().getTo().get_Item(0).getAddress());
//        System.out.println("OriginalMessage ToAddress 2: " + result.getOriginalMessage().getTo().get_Item(1).getAddress());
        System.out.println();
    }
}
