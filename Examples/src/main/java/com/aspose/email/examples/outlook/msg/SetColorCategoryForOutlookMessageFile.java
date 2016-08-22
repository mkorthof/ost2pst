package com.aspose.email.examples.outlook.msg;

import com.aspose.email.FollowUpManager;
import com.aspose.email.MapiMessage;
import com.aspose.email.examples.Utils;
import com.aspose.email.system.collections.IList;

public class SetColorCategoryForOutlookMessageFile {

	public static void main(String[] args) {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(SetColorCategoryForOutlookMessageFile.class) + "outlook/";
				
		MapiMessage msg = MapiMessage.fromFile(dataDir + "message.msg");
		// Add category
		FollowUpManager.addCategory(msg, "Purple Category");

		// Add another category
		FollowUpManager.addCategory(msg, "Red Category");

		// Retrieve the list of available categories
		IList categories = FollowUpManager.getCategories(msg);

		// Remove the specified category
		FollowUpManager.removeCategory(msg, "Red Category");

		// Clear all categories
		FollowUpManager.clearCategories(msg);
	}

}
