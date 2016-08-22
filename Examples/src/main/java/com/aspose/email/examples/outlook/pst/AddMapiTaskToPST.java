package com.aspose.email.examples.outlook.pst;

import java.util.Date;

import com.aspose.email.FileFormatVersion;
import com.aspose.email.FolderInfo;
import com.aspose.email.MapiTask;
import com.aspose.email.MapiTaskHistory;
import com.aspose.email.MapiTaskOwnership;
import com.aspose.email.PersonalStorage;
import com.aspose.email.StandardIpmFolder;
import com.aspose.email.examples.Utils;

public class AddMapiTaskToPST {
	
	public static String dataDir = Utils.getSharedDataDir(AddMapiTaskToPST.class) + "outlook/";
	
	public static void main(String[] args) {
		MapiTask task = new MapiTask("To Do", "Just click and type to add new task", new Date(), new Date());
		task.setPercentComplete(20);
		task.setEstimatedEffort(2000);
		task.setActualEffort(20);
		task.setHistory(MapiTaskHistory.Assigned);
		task.setLastUpdate(new Date());
		task.getUsers().setOwner("Darius");
		task.getUsers().setLastAssigner("Harkness");
		task.getUsers().setLastDelegate("Harkness");
		task.getUsers().setOwnership(MapiTaskOwnership.AssignersCopy);

		PersonalStorage pst = PersonalStorage.create(dataDir + "TaskPST_out.pst", FileFormatVersion.Unicode);
		FolderInfo taskFolder = pst.createPredefinedFolder("Tasks", StandardIpmFolder.Tasks);
		taskFolder.addMapiMessageItem(task);
	}

}
