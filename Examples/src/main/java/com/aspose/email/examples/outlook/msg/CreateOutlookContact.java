package com.aspose.email.examples.outlook.msg;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import com.aspose.email.ContactSaveFormat;
import com.aspose.email.MapiContact;
import com.aspose.email.MapiContactElectronicAddress;
import com.aspose.email.MapiContactElectronicAddressPropertySet;
import com.aspose.email.MapiContactEventPropertySet;
import com.aspose.email.MapiContactNamePropertySet;
import com.aspose.email.MapiContactPhysicalAddress;
import com.aspose.email.MapiContactPhysicalAddressPropertySet;
import com.aspose.email.MapiContactProfessionalPropertySet;
import com.aspose.email.MapiContactTelephonePropertySet;
import com.aspose.email.examples.Utils;

public class CreateOutlookContact {

	public static void main(String[] args) {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(CreateOutlookContact.class) + "outlook/";
		
		//Create Outlook Contact
		createOutlookContact(dataDir);
		
		//Adding Contact Event Information to a MapiContact
		addingContactEventInformationToAMapiContact(dataDir);
	}

	public static void createOutlookContact(String dataDir) {
		MapiContact contact = new MapiContact();

		//Set different properties of this Contact Item.
		//Set Name properties using MapiContactNamePropertySet
		MapiContactNamePropertySet NamePropSet = new MapiContactNamePropertySet();
		NamePropSet.setSurname("Mellissa");
		NamePropSet.setGivenName("MacBeth");
		contact.setNameInfo(NamePropSet);

		//Set professional properties using MapiContactProfessionalPropertySet
		MapiContactProfessionalPropertySet ProfPropSet = new MapiContactProfessionalPropertySet();
		ProfPropSet.setTitle("Account Representative");
		ProfPropSet.setCompanyName("Contoso Ltd.");
		ProfPropSet.setOfficeLocation("36/2529");
		contact.setProfessionalInfo(ProfPropSet);

		//Telephones
		MapiContactTelephonePropertySet Telephone = new MapiContactTelephonePropertySet();
		Telephone.setAssistantTelephoneNumber("(831) 758-7214");
		Telephone.setBusiness2TelephoneNumber("(831) 759-2518");
		Telephone.setBusinessTelephoneNumber("(831) 758-7285");
		Telephone.setCallbackTelephoneNumber("(831) 758-7321 (After hours");
		Telephone.setCarTelephoneNumber("(831) 758-7201");
		Telephone.setCompanyMainTelephoneNumber("(831) 758-7368");
		Telephone.setHome2TelephoneNumber("(831) 758-7256");
		Telephone.setHomeTelephoneNumber("(831) 758-7257");
		Telephone.setIsdnNumber("(831) 758-7381");
		Telephone.setMobileTelephoneNumber("(831) 758-7368");
		Telephone.setOtherTelephoneNumber("(831) 758-7201");
		Telephone.setPagerTelephoneNumber("(831) 758-7368");
		Telephone.setPrimaryTelephoneNumber("(831) 758-7334");
		Telephone.setRadioTelephoneNumber("(831) 758-7234");
		Telephone.setTelexNumber("(831) 758-7408");
		Telephone.setTtyTddPhoneNumber("(800) 806-4474");
		contact.setTelephones(Telephone);

		//Set Physical Address using MapiContactPhysicalAddress and MapiContactPhysicalAddressPropertySet
		MapiContactPhysicalAddress PhysAddrss = new MapiContactPhysicalAddress();
		PhysAddrss.setPostOfficeBox("144 Hitchcock Rd, Salinas, CA 93908");
		MapiContactPhysicalAddressPropertySet PhysAddrPropSet = new MapiContactPhysicalAddressPropertySet();
		PhysAddrPropSet.setWorkAddress(PhysAddrss);
		contact.setPhysicalAddresses(PhysAddrPropSet);

		//Set email information using MapiContactElectronicAddress and MapiContactElectronicAddressPropertySet
		MapiContactElectronicAddress email = new MapiContactElectronicAddress();
		email.setAddressType("SMTP");
		email.setDisplayName("Melissa MacBeth (mellissa@contoso.com)");
		email.setEmailAddress("melissa@contoso.com");
		MapiContactElectronicAddressPropertySet ElecAddrPropSet = new MapiContactElectronicAddressPropertySet();
		ElecAddrPropSet.setEmail1(email);
		contact.setElectronicAddresses(ElecAddrPropSet);

		contact.save(dataDir + "OutlookContact_out.vcf", ContactSaveFormat.VCard);
	}

	public static void addingContactEventInformationToAMapiContact(String dataDir) {
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		calendar.set(1990, Calendar.NOVEMBER, 1, 0, 0, 0);
		Date birthday = calendar.getTime();

		calendar.set(2012, Calendar.NOVEMBER, 1, 0, 0, 0);
		Date weddingDay = calendar.getTime();

		MapiContactEventPropertySet contactEventSet = new MapiContactEventPropertySet();
		contactEventSet.setBirthday(birthday);

		contactEventSet.setWeddingAnniversary(weddingDay);

		MapiContact contact = new MapiContact();
		contact.setEvents(contactEventSet);
		contact.save(dataDir + "Contact_out.msg", ContactSaveFormat.Msg);
	}

}
