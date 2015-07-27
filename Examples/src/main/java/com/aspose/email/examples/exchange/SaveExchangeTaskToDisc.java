/* 
 * Copyright 2001-2015 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Email. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package com.aspose.email.examples.exchange;

import com.aspose.email.EWSClient;
import com.aspose.email.ExchangeTask;
import com.aspose.email.ExchangeTaskStatus;
import com.aspose.email.IEWSClient;
import com.aspose.email.examples.Utils;

public class SaveExchangeTaskToDisc
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(SaveExchangeTaskToDisc.class);

        ExchangeTask task = new ExchangeTask();
        task.setSubject("TASK-34759");
        task.setStatus(ExchangeTaskStatus.InProgress);

        task.save(dataDir + "task.msg");

        // Display Status.
        System.out.println("Task created successfully.");
    }
}
