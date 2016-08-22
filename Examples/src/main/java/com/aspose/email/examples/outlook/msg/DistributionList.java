package com.aspose.email.examples.outlook.msg;

import com.aspose.email.MapiDistributionList;
import com.aspose.email.MapiDistributionListMember;
import com.aspose.email.MapiDistributionListMemberCollection;
import com.aspose.email.examples.Utils;

public class DistributionList {

	public static void main(String[] args) {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(DistributionList.class) + "outlook/";
				
		MapiDistributionListMemberCollection oneOffmembers = new MapiDistributionListMemberCollection();
		oneOffmembers.addItem(new MapiDistributionListMember("John R. Patrick", "JohnRPatrick@armyspy.com"));
		oneOffmembers.addItem(new MapiDistributionListMember("Tilly Bates", "TillyBates@armyspy.com"));

		MapiDistributionList dlist = new MapiDistributionList("Simple list", oneOffmembers);
		dlist.setBody("Test body");
		dlist.setSubject("Test subject");
		dlist.setMileage("Test mileage");
		dlist.setBilling("Test billing");

		dlist.save(dataDir + "distlist_out.msg");
	}

}
