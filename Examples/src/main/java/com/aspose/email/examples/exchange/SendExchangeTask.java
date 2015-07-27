/* 
 * Copyright 2001-2015 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Email. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package com.aspose.email.examples.exchange;

import com.aspose.email.*;
import com.aspose.email.examples.Utils;

public class SendExchangeTask
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(SendExchangeTask.class);

        // Create instance of ExchangeClient class by giving credentials
        IEWSClient client = EWSClient.getEWSClient("https://outlook.office365.com/ews/exchange.asmx", "testUser", "pwd", "domain");

        MailMessageLoadOptions loadOptions = new MailMessageLoadOptions();
        loadOptions.setMessageFormat(MessageFormat.getMsg());
        loadOptions.setFileCompatibilityMode(FileCompatibilityMode.PreserveTnefAttachments);

        // load task from .msg file
        MailMessage eml = MailMessage.load("task.msg", loadOptions);
        eml.setFrom(new MailAddress("firstname.lastname@domain.com"));
        eml.getTo().clear();
        eml.getTo().addItem(new MailAddress("firstname.lastname@domain.com"));

        client.send(eml);

        // Display Status.
        System.out.println("Task sent successfully.");
    }
}
