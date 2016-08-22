package com.aspose.email.examples.outlook.pst;

import org.apache.commons.codec.binary.Base64;

import com.aspose.email.FileFormatVersion;
import com.aspose.email.FolderInfo;
import com.aspose.email.MapiContact;
import com.aspose.email.MapiDistributionList;
import com.aspose.email.MapiDistributionListEntryIdType;
import com.aspose.email.MapiDistributionListMember;
import com.aspose.email.MapiDistributionListMemberCollection;
import com.aspose.email.MapiMessage;
import com.aspose.email.PersonalStorage;
import com.aspose.email.StandardIpmFolder;
import com.aspose.email.examples.Utils;

public class AddMapiDistributionListToPST {
	
	public static String dataDir = Utils.getSharedDataDir(AddMapiDistributionListToPST.class) + "outlook/";
	
	public static void main(String[] args) {
		//Create a New MapiDistributionList and add it to the contacts subfolder
		addMapiDistributionListToPST();
		
		//Create a One-off Distribution List
		createAOneOffDistributionList();
	}

	public static void loadMapiDistributionList() {
		MapiMessage msg = MapiMessage.fromFile(dataDir + "DistList.msg");
		MapiDistributionList dlist = (MapiDistributionList) msg.toMapiMessageItem();
	}

	public static void addMapiDistributionListToPST() {
		String displayName1 = "Sebastian Wright";
		String email1 = "SebastianWright@dayrep.com";

		String displayName2 = "Wichert Kroos";
		String email2 = "WichertKroos@teleworm.us";

		String strEntryId1;
		String strEntryId2;

		// Create distribution list from contacts
		PersonalStorage pst = PersonalStorage.create(dataDir + "pstFileName1_out.pst", FileFormatVersion.Unicode);

		// Add the contact folder to the PST
		FolderInfo contactFolder = pst.createPredefinedFolder("Contacts", StandardIpmFolder.Contacts);

		// Create contacts
		strEntryId1 = contactFolder.addMapiMessageItem(new MapiContact(displayName1, email1));
		strEntryId2 = contactFolder.addMapiMessageItem(new MapiContact(displayName2, email2));

		// Create distribution list on the base of the created contacts
		MapiDistributionListMember member1 = new MapiDistributionListMember(displayName1, email1);
		member1.setEntryIdType(MapiDistributionListEntryIdType.Contact);
		byte[] decodedBytes = Base64.decodeBase64(strEntryId1);
		member1.setEntryId(decodedBytes);

		MapiDistributionListMember member2 = new MapiDistributionListMember(displayName2, email2);
		member2.setEntryIdType(MapiDistributionListEntryIdType.Contact);
		decodedBytes = Base64.decodeBase64(strEntryId2);
		member2.setEntryId(decodedBytes);

		MapiDistributionListMemberCollection members = new MapiDistributionListMemberCollection();
		members.addItem(member1);
		members.addItem(member2);

		MapiDistributionList distributionList = new MapiDistributionList("Contact list", members);
		distributionList.setBody("Distribution List Body!");
		distributionList.setSubject("Distribution List Subject!");

		// Add distribution list to PST
		contactFolder.addMapiMessageItem(distributionList);
	}
	
	public static void createAOneOffDistributionList() {
		PersonalStorage pst = PersonalStorage.create(dataDir + "pstFileName2_out.pst", FileFormatVersion.Unicode);

		// Add the contact folder to the PST
		FolderInfo contactFolder = pst.createPredefinedFolder("Contacts", StandardIpmFolder.Contacts);

		MapiDistributionListMemberCollection oneOffmembers = new MapiDistributionListMemberCollection();
		oneOffmembers.addItem(new MapiDistributionListMember("John R. Patrick", "JohnRPatrick@armyspy.com"));
		oneOffmembers.addItem(new MapiDistributionListMember("Tilly Bates", "TillyBates@armyspy.com"));

		MapiDistributionList oneOffMembersList = new MapiDistributionList("Simple list", oneOffmembers);
		contactFolder.addMapiMessageItem(oneOffMembersList);
	}
}
