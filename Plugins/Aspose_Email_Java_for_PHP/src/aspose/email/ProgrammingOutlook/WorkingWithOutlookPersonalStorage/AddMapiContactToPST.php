<?php
namespace Aspose\Email\ProgrammingOutlook\WorkingWithOutlookPersonalStorage;

use com\aspose\email\MapiContact as MapiContact;
use com\aspose\email\MapiContactNamePropertySet as MapiContactNamePropertySet;
use com\aspose\email\MapiContactGender as MapiContactGender;
use com\aspose\email\MapiContactProfessionalPropertySet as MapiContactProfessionalPropertySet;
use com\aspose\email\MapiContactElectronicAddress as MapiContactElectronicAddress;
use com\aspose\email\MapiContactTelephonePropertySet as MapiContactTelephonePropertySet;
use com\aspose\email\PersonalStorage as PersonalStorage;
use com\aspose\email\FileFormatVersion as FileFormatVersion;
use com\aspose\email\StandardIpmFolder as StandardIpmFolder;

class AddMapiContactToPST{

    public static function run($dataDir=null){

        # Create an instance of MapiContact
        $mapi_contact = new MapiContact();

        # Contact #1
        $contact1 = new MapiContact("Sebastian Wright", "SebastianWright@dayrep.com");

        # Contact #2
        $contact2 = new MapiContact("Wichert Kroos", "WichertKroos@teleworm.us", "Grade A Investment");

        # Contact #3
        $contact3 = new MapiContact("Christoffer van de Meeberg", "ChristoffervandeMeeberg@teleworm.us", "Krauses Sofa Factory", "046-630-4614");

        # Contact #4
        $contact4 = new MapiContact();
        $contact4->setNameInfo(new MapiContactNamePropertySet("Margaret", "J.", "Tolle"));

        $mapiContactGender=new MapiContactGender();

        $contact4->getPersonalInfo()->setGender($mapiContactGender->Female);
        $contact4->setProfessionalInfo(new MapiContactProfessionalPropertySet("Adaptaz", "Recording engineer"));
        $contact4->getPhysicalAddresses()->getWorkAddress()->setAddress("4 Darwinia Loop EIGHTY MILE BEACH WA 6725");
        $contact4->getElectronicAddresses()->setEmail1(new MapiContactElectronicAddress("Hisen1988", "SMTP", "MargaretJTolle@dayrep.com"));
        $contact4->getTelephones()->setBusinessTelephoneNumber("(08)9080-1183");
        $contact4->getTelephones()->setMobileTelephoneNumber("(925)599-3355");

        # Contact #5
        $contact5 = new MapiContact();
        $contact5->setNameInfo(new MapiContactNamePropertySet("Matthew", "R.", "Wilcox"));
        $contact5->getPersonalInfo()->setGender($mapiContactGender->Male);
        $contact5->setProfessionalInfo(new MapiContactProfessionalPropertySet("Briazz", "Psychiatric aide"));
        $contact5->getPhysicalAddresses()->getWorkAddress()->setAddress("Horner Strasse 12 4421 SAASS");
        $contact5->getTelephones()->setBusinessTelephoneNumber("0650 675 73 30");
        $contact5->getTelephones()->setHomeTelephoneNumber("(661)387-5382");

        # Contact #6
        $contact6 = new MapiContact();
        $contact6->setNameInfo(new MapiContactNamePropertySet("Bertha", "A.", "Buell"));
        $contact6->setProfessionalInfo(new MapiContactProfessionalPropertySet("Awthentikz", "Social work assistant"));
        $contact6->getPersonalInfo()->setPersonalHomePage("B2BTies.com");
        $contact6->getPhysicalAddresses()->getWorkAddress()->setAddress("Im Astenfeld 59 8580 EDELSCHROTT");
        $contact6->getElectronicAddresses()->setEmail1(new MapiContactElectronicAddress("Experwas", "SMTP", "BerthaABuell@armyspy.com"));
        $contact6->setTelephones(new MapiContactTelephonePropertySet("06605045265"));

        $personalStorage=new PersonalStorage();
        $fileFormatVersion=new FileFormatVersion();
        $standardIpmFolder=new StandardIpmFolder();

        $pst = $personalStorage->create($dataDir . "MapiContactToPST1.pst", $fileFormatVersion->Unicode);
        $contactFolder = $pst->createPredefinedFolder("Contacts", $standardIpmFolder->Contacts);
        $contactFolder->addMapiMessageItem($contact1);
        $contactFolder->addMapiMessageItem($contact2);
        $contactFolder->addMapiMessageItem($contact3);
        $contactFolder->addMapiMessageItem($contact4);
        $contactFolder->addMapiMessageItem($contact5);
        $contactFolder->addMapiMessageItem($contact6);

        print "Added MapiContacts Successfully.".PHP_EOL;
    }
}
?>