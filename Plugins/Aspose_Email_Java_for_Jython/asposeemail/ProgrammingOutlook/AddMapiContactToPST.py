from asposeemail import Settings
from com.aspose.email import MapiContact
from com.aspose.email import MapiContactNamePropertySet
from com.aspose.email import MapiContactGender
from com.aspose.email import MapiContactProfessionalPropertySet
from com.aspose.email import MapiContactElectronicAddress
from com.aspose.email import MapiContactTelephonePropertySet
from com.aspose.email import PersonalStorage
from com.aspose.email import FileFormatVersion
from com.aspose.email import StandardIpmFolder

class AddMapiContactToPST:

    def __init__(self):
                        
        dataDir = Settings.dataDir + 'ProgrammingOutlook/WorkingWithOutlookPersonalStorage/AddMapiContactToPST/'
        
        # Create an instance of MapiContact
        mapi_contact = MapiContact()

        # Contact #1
        contact1 = MapiContact("Sebastian Wright", "SebastianWright@dayrep.com")

        # Contact #2
        contact2 = MapiContact("Wichert Kroos", "WichertKroos@teleworm.us", "Grade A Investment")

        # Contact #3
        contact3 = MapiContact("Christoffer van de Meeberg", "ChristoffervandeMeeberg@teleworm.us", "Krauses Sofa Factory", "046-630-4614")

        # Contact #4
        contact4 = MapiContact()
        contact4.setNameInfo(MapiContactNamePropertySet("Margaret", "J.", "Tolle"))

        mapiContactGender=MapiContactGender

        contact4.getPersonalInfo().setGender(mapiContactGender.Female)
        contact4.setProfessionalInfo(MapiContactProfessionalPropertySet("Adaptaz", "Recording engineer"))
        contact4.getPhysicalAddresses().getWorkAddress().setAddress("4 Darwinia Loop EIGHTY MILE BEACH WA 6725")
        contact4.getElectronicAddresses().setEmail1(MapiContactElectronicAddress("Hisen1988", "SMTP", "MargaretJTolle@dayrep.com"))
        contact4.getTelephones().setBusinessTelephoneNumber("(08)9080-1183")
        contact4.getTelephones().setMobileTelephoneNumber("(925)599-3355")

        # Contact #5
        contact5 = MapiContact()
        contact5.setNameInfo(MapiContactNamePropertySet("Matthew", "R.", "Wilcox"))
        contact5.getPersonalInfo().setGender(mapiContactGender.Male)
        contact5.setProfessionalInfo(MapiContactProfessionalPropertySet("Briazz", "Psychiatric aide"))
        contact5.getPhysicalAddresses().getWorkAddress().setAddress("Horner Strasse 12 4421 SAASS")
        contact5.getTelephones().setBusinessTelephoneNumber("0650 675 73 30")
        contact5.getTelephones().setHomeTelephoneNumber("(661)387-5382")

        # Contact #6
        contact6 = MapiContact()
        contact6.setNameInfo(MapiContactNamePropertySet("Bertha", "A.", "Buell"))
        contact6.setProfessionalInfo(MapiContactProfessionalPropertySet("Awthentikz", "Social work assistant"))
        contact6.getPersonalInfo().setPersonalHomePage("B2BTies.com")
        contact6.getPhysicalAddresses().getWorkAddress().setAddress("Im Astenfeld 59 8580 EDELSCHROTT")
        contact6.getElectronicAddresses().setEmail1(MapiContactElectronicAddress("Experwas", "SMTP", "BerthaABuell@armyspy.com"))
        contact6.setTelephones(MapiContactTelephonePropertySet("06605045265"))

        personalStorage=PersonalStorage()
        fileFormatVersion=FileFormatVersion
        standardIpmFolder=StandardIpmFolder

        pst = personalStorage.create(dataDir + "MapiContactToPST1.pst", fileFormatVersion.Unicode)
        contactFolder = pst.createPredefinedFolder("Contacts", standardIpmFolder.Contacts)
        contactFolder.addMapiMessageItem(contact1)
        contactFolder.addMapiMessageItem(contact2)
        contactFolder.addMapiMessageItem(contact3)
        contactFolder.addMapiMessageItem(contact4)
        contactFolder.addMapiMessageItem(contact5)
        contactFolder.addMapiMessageItem(contact6)

        print "Added MapiContacts Successfully."
        
 
if __name__ == '__main__':        
    AddMapiContactToPST()