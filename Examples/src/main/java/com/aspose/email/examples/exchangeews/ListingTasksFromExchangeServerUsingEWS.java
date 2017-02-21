package com.aspose.email.examples.exchangeews;

import com.aspose.email.*;
import com.aspose.email.system.NetworkCredential;

import java.util.Arrays;

/**
 * Created by hp on 1/27/2017.
 */
public class ListingTasksFromExchangeServerUsingEWS {
    public static void main(String[] args) {

        //Initilialize license first

        ListTasksFromExchangeServerUsingEWS();
    }

    public static void ListTasksFromExchangeServerUsingEWS()
    {
        //ExStart: ListTasksFromExchangeServerUsingEWS
        String mailboxUri = "https://ex2010/exchangeews/exchange.asmx";
        String username = "test.exchange";
        String password = "pwd";
        String domain = "ex2010.local";
        NetworkCredential credentials = new NetworkCredential(username, password, domain);
        IEWSClient client = EWSClient.getEWSClient(mailboxUri, credentials);

        //Listing Tasks from Server
        client.setTimezoneId("Central Europe Standard Time");
        TaskCollection taskCollection = client.listTasks(client.getMailboxInfo().getTasksUri());

        //print retrieved tasks' details
        int iTasksCount = taskCollection.size();
        for (int i = 0; i < iTasksCount; i++) {
            ExchangeTask task = (ExchangeTask) taskCollection.get_Item(i);
            System.out.println(task.getTimezoneId());
            System.out.println(task.getSubject());
            System.out.println(task.getStartDate());
            System.out.println(task.getDueDate());
        }

        //Listing Tasks from server based on Query - Completed and In-Progress
        Integer[] selectedStatuses = new Integer[]
                {
                        ExchangeTaskStatus.Completed,
                        ExchangeTaskStatus.InProgress
                };
        ExchangeQueryBuilder queryBuilder = new ExchangeQueryBuilder();
        queryBuilder.getTaskStatus().in(Arrays.asList(selectedStatuses));
        MailQuery query = queryBuilder.getQuery();

        taskCollection = client.listTasks(client.getMailboxInfo().getTasksUri(), query);

        //print retrieved tasks' details
        iTasksCount = taskCollection.size();
        for (int i = 0; i < iTasksCount; i++) {
            ExchangeTask task = (ExchangeTask) taskCollection.get_Item(i);
            System.out.println(task.getTimezoneId());
            System.out.println(task.getSubject());
            System.out.println(task.getStartDate());
            System.out.println(task.getDueDate());
        }
        //ExEnd: ListTasksFromExchangeServerUsingEWS
    }
}
