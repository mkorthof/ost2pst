package com.aspose.email.examples.outlook.msg;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import com.aspose.email.MapiMessage;
import com.aspose.email.MapiSensitivity;
import com.aspose.email.MapiTask;
import com.aspose.email.MapiTaskHistory;
import com.aspose.email.MapiTaskOwnership;
import com.aspose.email.MapiTaskStatus;
import com.aspose.email.TaskSaveFormat;
import com.aspose.email.examples.Utils;
import com.aspose.email.system.exceptions.IOException;

public class OutlookTasks {
	public static void main(String[] args) throws java.io.IOException {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(OutlookTasks.class) + "outlook/";
		
		//Creating and Saving a MapiTask
		createAndSaveMapiTask(dataDir);
		
		//Reading a MapiTask
		readingAMapiTask(dataDir);
		
		//Reading a VToDo Task
		readingAVToDoTask(dataDir);
		
		//Adding Reminder Information to a MapiTask
		addReminderInformationToAMapiTask(dataDir);
		
		//Adding Attachment to a MapiTask
		addingAttachmentToAMapiTask(dataDir);
	}

	public static void createAndSaveMapiTask(String dataDir) {
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		calendar.set(2016, Calendar.NOVEMBER, 1, 0, 0, 0);
		Date startDate = calendar.getTime();
		calendar.set(2016, Calendar.DECEMBER, 1);
		Date endDate = calendar.getTime();
		MapiTask task = new MapiTask("To Do", "Just click and type to add new task", startDate, endDate);
		task.setPercentComplete(20);
		task.setEstimatedEffort(2000);
		task.setActualEffort(20);
		task.setHistory(MapiTaskHistory.Assigned);
		task.getUsers().setOwner("Darius");
		task.getUsers().setLastAssigner("Harkness");
		task.getUsers().setLastDelegate("Harkness");
		task.getUsers().setOwnership(MapiTaskOwnership.AssignersCopy);
		String[] companies = { "company1", "company2", "company3" };
		task.setCompanies(companies);
		String[] categories = { "category1", "category2", "category3" };
		task.setCategories(categories);
		task.setMileage("Some test mileage");
		task.setBilling("Test billing information");
		task.getUsers().setDelegator("Test Delegator");
		task.setSensitivity(MapiSensitivity.Personal);
		task.setStatus(MapiTaskStatus.Complete);
		task.save(dataDir + "MapiTask_out.msg", TaskSaveFormat.Msg);
	}

	public static void readingAMapiTask(String dataDir) {
		MapiMessage msg = MapiMessage.fromFile(dataDir + "MapiTask_out.msg");
		MapiTask task2 = (MapiTask) msg.toMapiMessageItem();
	}
	
	public static void readingAVToDoTask(String dataDir) {
		MapiTask task = MapiTask.fromVTodo(dataDir + "sample.ics");
		task.save(dataDir + "Test_out.msg", TaskSaveFormat.Msg);
	}
	
	public static void addReminderInformationToAMapiTask(String dataDir) {
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		calendar.set(2012, Calendar.NOVEMBER, 1, 0, 0, 0);
		Date date = calendar.getTime();
		MapiTask testTask = new MapiTask("task with reminder", "this is a body", date, date);
		testTask.setReminderSet(true);
		testTask.setReminderTime(date);
		testTask.setReminderFileParameter(dataDir + "Alarm01.wav");
		testTask.save(dataDir + "OutputTask_out.msg", TaskSaveFormat.Msg);
	}
	
	public static void addingAttachmentToAMapiTask(String dataDir) throws java.io.IOException {
		MapiTask task = new MapiTask("To Do", "Just click and type to add new tasks", new Date(), new Date());
		Path p = FileSystems.getDefault().getPath("", dataDir + "Attach.txt");
		try
		{
		    task.getAttachments().add(dataDir + "TestAtt.txt", Files.readAllBytes(p));
		}
		catch (IOException e)
		{
		    e.printStackTrace();
		}
		task.save(dataDir + "MapiTask_out.msg", TaskSaveFormat.Msg);
	}
}
