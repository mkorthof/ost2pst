package com.aspose.email.examples.asposefeatures.appointments.colorcategory;

import com.aspose.email.FollowUpManager;
import com.aspose.email.MailMessageSaveType;
import com.aspose.email.MapiMessage;
import com.aspose.email.system.collections.IList;
import com.aspose.email.examples.Utils;

public class AsposeCategory
{
    public static void main(String[] args)
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(AsposeCategory.class);

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
        //FollowUpManager.clearCategories(msg);

        msg.save(dataDir + "AsposeCategories.msg");

        System.out.println("Done");
    }
}
