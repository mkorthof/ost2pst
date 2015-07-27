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

public class UpdateExchangeTask
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(UpdateExchangeTask.class);

        // Create instance of EWSClient class by giving credentials
        IEWSClient client = EWSClient.getEWSClient("https://outlook.office365.com/ews/exchange.asmx", "testUser", "pwd", "domain");

        // Get all tasks info collection from exchange
        ExchangeMessageInfoCollection tasks = client.listMessages(client.getMailboxInfo().getTasksUri());

        // Parse all the tasks info in the list
        for (ExchangeMessageInfo info: tasks)
        {
            // Fetch task from exchange using current task info
            ExchangeTask task = client.fetchTask(info.getUniqueUri());

            // Update the task status to NotStarted
            task.setStatus(ExchangeTaskStatus.NotStarted);

            // Set the task due date
            task.setDueDate(new java.util.Date());

            // Set task priority
            //task.setPriority(MailPriority.Low);

            // Update task on exchange
            client.updateTask(task);
        }

        // Display Status.
        System.out.println("Task updated successfully.");
    }
}
