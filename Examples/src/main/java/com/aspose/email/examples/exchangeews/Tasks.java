package com.aspose.email.examples.exchangeews;

import java.util.Arrays;
import java.util.Calendar;

import com.aspose.email.DeleteTaskOptions;
import com.aspose.email.EWSClient;
import com.aspose.email.ExchangeMessageInfo;
import com.aspose.email.ExchangeMessageInfoCollection;
import com.aspose.email.ExchangeQueryBuilder;
import com.aspose.email.ExchangeTask;
import com.aspose.email.ExchangeTaskStatus;
import com.aspose.email.IEWSClient;
import com.aspose.email.MailAddress;
import com.aspose.email.MailMessage;
import com.aspose.email.MailQuery;
import com.aspose.email.MsgLoadOptions;
import com.aspose.email.examples.Utils;

public class Tasks {

	// The path to the resource directory.
	public static final String dataDir = Utils.getSharedDataDir(Tasks.class) + "exchange/";

	public static void main(String[] args) {
		// Create New Task on Exchange
		createNewTaskOnExchange();
		
		// Specifying Timezone for Exchange Task
		specifyTimezoneForExchangeTask();
		
		// Update Task on Exchange
		updateTaskOnExchange();
		
		// Delete Task on Exchange
		deleteTaskOnExchange();
		
		// Sending Task Request
		sendTaskRequest();
		
		// Saving Exchange Task to Disc
		saveExchangeTaskToDisc();

		//Filter Tasks from Exchange Server
		filterTasksFromExchangeServer();
	}

	public static void createNewTaskOnExchange() {
		// Create instance of EWSClient class by giving credentials
		IEWSClient client = EWSClient.getEWSClient("https://outlook.office365.com/exchangeews/exchange.asmx", "testUser", "pwd", "domain");

		// Create Exchange task object
		ExchangeTask task = new ExchangeTask();

		// Set task subject
		task.setSubject("Task 1 from Java");

		// Set task status to In progress
		task.setStatus(ExchangeTaskStatus.InProgress);
		// Create task on exchange
		client.createTask(client.getMailboxInfo().getTasksUri(), task);
	}

	public static void specifyTimezoneForExchangeTask() {
		// Create instance of EWSClient class by giving credentials
		IEWSClient client = EWSClient.getEWSClient("https://outlook.office365.com/exchangeews/exchange.asmx", "testUser", "pwd", "domain");
		client.setTimezoneId("Central Europe Standard Time");
	}

	public static void updateTaskOnExchange() {
		// Create instance of EWSClient class by giving credentials
		IEWSClient client = EWSClient.getEWSClient("https://outlook.office365.com/exchangeews/exchange.asmx", "testUser", "pwd", "domain");

		// Get all tasks info collection from exchange
		ExchangeMessageInfoCollection tasks = client.listMessages(client.getMailboxInfo().getTasksUri());

		// Parse all the tasks info in the list
		for (ExchangeMessageInfo info : tasks) {
			// Fetch task from exchange using current task info
			ExchangeTask task = client.fetchTask(info.getUniqueUri());

			// Update the task status to NotStarted
			task.setStatus(ExchangeTaskStatus.NotStarted);

			// Set the task due date
			Calendar cal = Calendar.getInstance();
			cal.set(2015, 6, 18, 20, 40);
			task.setDueDate(cal.getTime());

			// Update task on exchange
			client.updateTask(task);
		}
	}

	public static void deleteTaskOnExchange() {
		// Create instance of ExchangeClient class by giving credentials
		IEWSClient client = EWSClient.getEWSClient("https://outlook.office365.com/exchangeews/exchange.asmx", "testUser", "pwd", "domain");

		// Get all tasks info collection from exchange
		ExchangeMessageInfoCollection tasks = client.listMessages(client.getMailboxInfo().getTasksUri());

		// Parse all the tasks info in the list
		for (ExchangeMessageInfo info : tasks) {
			// Fetch task from exchange using current task info
			ExchangeTask task = client.fetchTask(info.getUniqueUri());

			// Check if the current task fulfills the search criteria
			if (task.getSubject().equals("test")) {
				//Delete task from exchange
				client.deleteTask(task.getUniqueUri(), DeleteTaskOptions.DeletePermanently);
			}
		}
	}

	public static void sendTaskRequest() {
		// Create instance of ExchangeClient class by giving credentials
		IEWSClient client = EWSClient.getEWSClient("https://outlook.office365.com/exchangeews/exchange.asmx", "testUser", "pwd", "domain");

		MsgLoadOptions msgLoadOptions = new MsgLoadOptions();
		msgLoadOptions.setPreserveTnefAttachments(true);

		// load task from .msg file
		MailMessage eml = MailMessage.load(dataDir + "task.msg", msgLoadOptions);
		eml.setFrom(new MailAddress("firstname.lastname@domain.com"));
		eml.getTo().clear();
		eml.getTo().addItem(new MailAddress("firstname.lastname@domain.com"));

		client.send(eml);
	}

	public static void saveExchangeTaskToDisc() {
		ExchangeTask task = new ExchangeTask();
		task.setSubject("EMAILNET-34759");
		task.setStatus(ExchangeTaskStatus.InProgress);
		task.save(dataDir + "task_out.msg");
	}

	public static void filterTasksFromExchangeServer(){
		ExchangeQueryBuilder queryBuilder = null;
		MailQuery query = null;
		ExchangeTask fetchedTask = null;
		ExchangeMessageInfoCollection messageInfoCol = null;

		// Create instance of ExchangeClient class by giving credentials
		IEWSClient client = EWSClient.getEWSClient("https://outlook.office365.com/exchangeews/exchange.asmx", "testUser", "pwd", "domain");

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
			queryBuilder.getTaskStatus().notEquals(status);
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

		queryBuilder = new ExchangeQueryBuilder();
		queryBuilder.getTaskStatus().notIn(Arrays.asList(selectedStatuses));
		query = queryBuilder.getQuery();
		messageInfoCol = client.listMessages(client.getMailboxInfo().getTasksUri(), query);

	}

}
