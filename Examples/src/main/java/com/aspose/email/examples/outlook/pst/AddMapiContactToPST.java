package com.aspose.email.examples.outlook.pst;

import com.aspose.email.FileFormatVersion;
import com.aspose.email.FolderInfo;
import com.aspose.email.MapiContact;
import com.aspose.email.MapiContactElectronicAddress;
import com.aspose.email.MapiContactGender;
import com.aspose.email.MapiContactNamePropertySet;
import com.aspose.email.MapiContactProfessionalPropertySet;
import com.aspose.email.MapiContactTelephonePropertySet;
import com.aspose.email.PersonalStorage;
import com.aspose.email.StandardIpmFolder;
import com.aspose.email.examples.Utils;

public class AddMapiContactToPST {
	
	public static String dataDir = Utils.getSharedDataDir(AddMapiContactToPST.class) + "outlook/";
	
	public static void main(String[] args) {
		// Contact #1
		MapiContact contact1 = new MapiContact("Sebastian Wright", "SebastianWright@dayrep.com");

		// Contact #2
		MapiContact contact2 = new MapiContact("Wichert Kroos", "WichertKroos@teleworm.us", "Grade A Investment");

		// Contact #3
		MapiContact contact3 = new MapiContact("Christoffer van de Meeberg", "ChristoffervandeMeeberg@teleworm.us", "Krauses Sofa Factory", "046-630-4614");

		// Contact #4
		MapiContact contact4 = new MapiContact();
		contact4.setNameInfo(new MapiContactNamePropertySet("Margaret", "J.", "Tolle"));
		contact4.getPersonalInfo().setGender(MapiContactGender.Female);
		contact4.setProfessionalInfo(new MapiContactProfessionalPropertySet("Adaptaz", "Recording engineer"));
		contact4.getPhysicalAddresses().getWorkAddress().setAddress("4 Darwinia Loop EIGHTY MILE BEACH WA 6725");
		contact4.getElectronicAddresses().setEmail1(new MapiContactElectronicAddress("Hisen1988", "SMTP", "MargaretJTolle@dayrep.com"));
		contact4.getTelephones().setBusinessTelephoneNumber("(08)9080-1183");
		contact4.getTelephones().setMobileTelephoneNumber("(925)599-3355");

		// Contact #5
		MapiContact contact5 = new MapiContact();
		contact5.setNameInfo(new MapiContactNamePropertySet("Matthew", "R.", "Wilcox"));
		contact5.getPersonalInfo().setGender(MapiContactGender.Male);
		contact5.setProfessionalInfo(new MapiContactProfessionalPropertySet("Briazz", "Psychiatric aide"));
		contact5.getPhysicalAddresses().getWorkAddress().setAddress("Horner Strasse 12 4421 SAASS");
		contact5.getTelephones().setBusinessTelephoneNumber("0650 675 73 30");
		contact5.getTelephones().setHomeTelephoneNumber("(661)387-5382");

		// Contact #6
		MapiContact contact6 = new MapiContact();
		contact6.setNameInfo(new MapiContactNamePropertySet("Bertha", "A.", "Buell"));
		contact6.setProfessionalInfo(new MapiContactProfessionalPropertySet("Awthentikz", "Social work assistant"));
		contact6.getPersonalInfo().setPersonalHomePage("B2BTies.com");
		contact6.getPhysicalAddresses().getWorkAddress().setAddress("Im Astenfeld 59 8580 EDELSCHROTT");
		contact6.getElectronicAddresses().setEmail1(new MapiContactElectronicAddress("Experwas", "SMTP", "BerthaABuell@armyspy.com"));
		contact6.setTelephones(new MapiContactTelephonePropertySet("06605045265"));

		PersonalStorage pst = PersonalStorage.create(dataDir + "MapiContactToPST_out.pst", FileFormatVersion.Unicode);
		FolderInfo contactFolder = pst.createPredefinedFolder("Contacts", StandardIpmFolder.Contacts);
		contactFolder.addMapiMessageItem(contact1);
		contactFolder.addMapiMessageItem(contact2);
		contactFolder.addMapiMessageItem(contact3);
		contactFolder.addMapiMessageItem(contact4);
		contactFolder.addMapiMessageItem(contact5);
		contactFolder.addMapiMessageItem(contact6);

	}

}
