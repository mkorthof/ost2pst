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

public class CreateExchangeTask
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(CreateExchangeTask.class);

        // Create instance of EWSClient class by giving credentials
        IEWSClient client = EWSClient.getEWSClient("https://outlook.office365.com/ews/exchange.asmx", "testUser", "pwd", "domain");

        // Create Exchange task object
        ExchangeTask task = new ExchangeTask();

        // Set task subject
        task.setSubject("Task 1 from Java");

        // Set task status to In progress
        task.setStatus(ExchangeTaskStatus.InProgress);
        // Create task on exchange
        client.createTask(client.getMailboxInfo().getTasksUri(), task);

        // Display Status.
        System.out.println("Task created successfully.");
    }
}
