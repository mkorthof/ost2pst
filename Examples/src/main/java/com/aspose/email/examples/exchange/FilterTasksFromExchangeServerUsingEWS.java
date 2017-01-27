package com.aspose.email.examples.exchange;

import com.aspose.email.*;

import java.util.Arrays;

/**
 * Created by hp on 1/27/2017.
 */
public class FilterTasksFromExchangeServerUsingEWS {
    public static void main(String[] args) {

        FilterTasksFromExchangeServerUsingEWS();
    }

    public static void FilterTasksFromExchangeServerUsingEWS()
    {
        //ExStart: FilterTasksFromExchangeServerUsingEWS
        ExchangeQueryBuilder queryBuilder = null;
        MailQuery query = null;
        ExchangeTask fetchedTask = null;
        ExchangeMessageInfoCollection messageInfoCol = null;

        // Create instance of ExchangeClient class by giving credentials
        IEWSClient client = EWSClient.getEWSClient("https://outlook.office365.com/ews/exchange.asmx", "testUser", "pwd", "domain");

        //Set timezone for tasks
        client.setTimezoneId("Central Europe Standard Time");

        //We use these status values for specifying in queries
        Integer[] values = new Integer[] {ExchangeTaskStatus.Completed, ExchangeTaskStatus.Deferred,
                ExchangeTaskStatus.InProgress, ExchangeTaskStatus.NotStarted, ExchangeTaskStatus.WaitingOnOthers};

        messageInfoCol = client.listMessages(client.getMailboxInfo().getTasksUri());

        //Now retrieve the tasks with specific statuses
        for (int status : values)
        {
            queryBuilder = new ExchangeQueryBuilder();
            queryBuilder.getTaskStatus().equals(status);
            query = queryBuilder.getQuery();
            messageInfoCol = client.listMessages(client.getMailboxInfo().getTasksUri(), query);
            fetchedTask = client.fetchTask(messageInfoCol.get_Item(0).getUniqueUri());
        }

        //retrieve all other than specified
        for (int status : values)
        {
            queryBuilder = new ExchangeQueryBuilder();
            queryBuilder.getTaskStatus().notEquals((int)status);
            query = queryBuilder.getQuery();
            messageInfoCol = client.listMessages(client.getMailboxInfo().getTasksUri(), query);
        }

        //specifying multiple criterion
        Integer[] selectedStatuses = new Integer[]
                {
                        ExchangeTaskStatus.Completed,
                        ExchangeTaskStatus.InProgress
                };

        queryBuilder = new ExchangeQueryBuilder();
        queryBuilder.getTaskStatus().in(Arrays.asList(selectedStatuses));
        query = queryBuilder.getQuery();
        messageInfoCol = client.listMessages(client.getMailboxInfo().getTasksUri(), query);

        //list all those which are not in our specified statuses
        queryBuilder = new ExchangeQueryBuilder();
        queryBuilder.getTaskStatus().notIn(Arrays.asList(selectedStatuses));
        query = queryBuilder.getQuery();
        messageInfoCol = client.listMessages(client.getMailboxInfo().getTasksUri(), query);
        //ExEnd: FilterTasksFromExchangeServerUsingEWS
    }
}

