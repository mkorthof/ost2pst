package com.aspose.email.examples.outlook.msg;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import com.aspose.email.ContactSaveFormat;
import com.aspose.email.MapiContact;
import com.aspose.email.MapiContactElectronicAddress;
import com.aspose.email.MapiContactNamePropertySet;
import com.aspose.email.MapiContactPhoto;
import com.aspose.email.MapiContactPhotoImageFormat;
import com.aspose.email.MapiContactProfessionalPropertySet;
import com.aspose.email.MapiContactTelephonePropertySet;
import com.aspose.email.MapiMessage;
import com.aspose.email.examples.Utils;

public class CreateSaveAndReadOutlookContact {

	public static void main(String[] args) throws IOException {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(CreateSaveAndReadOutlookContact.class) + "outlook/";
		
		// Creating and Saving a MapiContact
		creatingAndSavingAMapiContact(dataDir);
		
		//Loading a Contact from MSG
		loadingAContactFromMSG(dataDir);
		
		//Loading a contact from VCard
		loadingAContactFromVCard(dataDir);
		
		//Loading VCard Contact with specified Encoding
		loadingVCardContactWithSpecifiedEncoding(dataDir);
	}

	public static void creatingAndSavingAMapiContact(String dataDir) throws IOException {
		MapiContact contact = new MapiContact("Sebastian Wright", "SebastianWright@dayrep.com");
		contact.setNameInfo(new MapiContactNamePropertySet("Bertha", "A.", "Buell"));
		contact.setProfessionalInfo(new MapiContactProfessionalPropertySet("Awthentikz", "Social work assistant"));
		contact.getPersonalInfo().setPersonalHomePage("B2BTies.com");
		contact.getPhysicalAddresses().getWorkAddress().setAddress("Im Astenfeld 59 8580 EDELSCHROTT");
		contact.getElectronicAddresses().setEmail1(new MapiContactElectronicAddress("Experwas", "SMTP", "BerthaABuell@armyspy.com"));
		contact.setTelephones(new MapiContactTelephonePropertySet("06605045265"));

		//Set Photo Data
		File fi = new File(dataDir + "Desert.jpg");
		byte[] fileContent = Files.readAllBytes(fi.toPath());
		MapiContactPhoto photo = new MapiContactPhoto(fileContent, MapiContactPhotoImageFormat.Jpeg);
		contact.setPhoto(photo);

		//Save as MSG
		contact.save(dataDir + "Contact_out.msg", ContactSaveFormat.Msg);
	}

	public static void loadingAContactFromMSG(String dataDir) {
		MapiMessage msg = MapiMessage.fromFile(dataDir + "messageMapi.msg");
		MapiContact mapiContact = (MapiContact) msg.toMapiMessageItem();
	}
	
	public static void loadingAContactFromVCard(String dataDir) {
		MapiContact mapiContact = MapiContact.fromVCard(dataDir + "microsoft.vcf");
	}
	
	public static void loadingVCardContactWithSpecifiedEncoding(String dataDir) {
		MapiContact contactReadFromFile = MapiContact.fromVCard( "microsoft.vcf", StandardCharsets.UTF_8);
	}
}
