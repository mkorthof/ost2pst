/*
 * Copyright 2001-2015 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Email. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */

//This feature is available with Aspose.Email from Java 5.4.0 onwards
package programmersguide.programmingExchange.WorkingWithTask.java;

import com.aspose.email.*;

public class WorkingWithTask
{
    // The path to the documents directory.
    static String dataDir = "src/programmersguide/programmingExchange/WorkingWithTask/java";

    public static void main(String[] args) throws Exception
    {
        //license initialization

        //In order to try any of the examples in the following code samples, please provide valid Exchange account credentials
        //to the IEWSClient object

        // Display Status.
        System.out.println("Execution completed.");
    }

    public static void CreateTaskOnExchange()
    {
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
    }

    public static void UpdateTaskOnExchange()
    {
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
            Calendar cal = Calendar.getInstance();
            cal.set(2015, 6, 18, 20, 40);
            task.setDueDate(cal.getTime());

            // Set task priority
            //task.setPriority(MailPriority.Low);

            // Update task on exchange
            client.updateTask(task);
        }
    }
    public static void DeleteTaskOnExchange()
    {
        // Create instance of ExchangeClient class by giving credentials
        IEWSClient client = EWSClient.getEWSClient("https://outlook.office365.com/ews/exchange.asmx", "testUser", "pwd", "domain");

        // Get all tasks info collection from exchange
        ExchangeMessageInfoCollection tasks = client.listMessages(client.getMailboxInfo().getTasksUri());

        // Parse all the tasks info in the list
        for (ExchangeMessageInfo info:tasks)
        {
            // Fetch task from exchange using current task info
            ExchangeTask task = client.fetchTask(info.getUniqueUri());

            // Check if the current task fulfills the search criteria
            if (task.getSubject().equals("test"))
            {
                //Delete task from exchange
                client.deleteTask(task.getUniqueUri(), DeleteTaskOptions.DeletePermanently);
            }
        }
    }

    //Works from Aspose.Email for Java 5.3.0 onwards
    public static void SendTaskRequest()
    {
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
    }

    //Works from Aspose.Email for Java 5.4.0 onwards
    public static void SaveTaskToDisc()
    {
        ExchangeTask task = new ExchangeTask();
        task.setSubject("EMAILNET-34759");
        task.setStatus(ExchangeTaskStatus.InProgress);

        task.save("task.msg");
    }

}




