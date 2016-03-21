from asposeemail import Settings
from com.aspose.email import MapiContact
from com.aspose.email import MapiContactNamePropertySet
from com.aspose.email import MapiContactProfessionalPropertySet
from com.aspose.email import MapiContactTelephonePropertySet
from com.aspose.email import MapiContactPhysicalAddress
from com.aspose.email import MapiContactPhysicalAddressPropertySet
from com.aspose.email import MapiContactElectronicAddress
from com.aspose.email import MapiContactElectronicAddressPropertySet
from com.aspose.email import ContactSaveFormat

class CreateOutlookContact:

    def __init__(self):
                        
        dataDir = Settings.dataDir + 'ProgrammingOutlook/WorkingWithOutlookMessageFiles/CreateOutlookContact/'
        
        contact = MapiContact()

        # Set different properties of this Contact Item.

        # Set Name properties using MapiContactNamePropertySet
        name_prop_set = MapiContactNamePropertySet()
        name_prop_set.setSurname("Mellissa")
        name_prop_set.setGivenName("MacBeth")
        contact.setNameInfo(name_prop_set)

        # Set professional properties using MapiContactProfessionalPropertySet
        prof_prop_set = MapiContactProfessionalPropertySet()
        prof_prop_set.setTitle("Account Representative")
        prof_prop_set.setCompanyName("Contoso Ltd.")
        prof_prop_set.setOfficeLocation("36/2529")
        contact.setProfessionalInfo(prof_prop_set)

        # Telephones
        telephone = MapiContactTelephonePropertySet()
        telephone.setAssistantTelephoneNumber("(831) 758-7214")
        telephone.setBusiness2TelephoneNumber("(831) 759-2518")
        telephone.setBusinessTelephoneNumber("(831) 758-7285")
        telephone.setCallbackTelephoneNumber("(831) 758-7321 (After hours")
        telephone.setCarTelephoneNumber("(831) 758-7201")
        telephone.setCompanyMainTelephoneNumber("(831) 758-7368")
        telephone.setHome2TelephoneNumber("(831) 758-7256")
        telephone.setHomeTelephoneNumber("(831) 758-7257")
        telephone.setIsdnNumber("(831) 758-7381")
        telephone.setMobileTelephoneNumber("(831) 758-7368")
        telephone.setOtherTelephoneNumber("(831) 758-7201")
        telephone.setPagerTelephoneNumber("(831) 758-7368")
        telephone.setPrimaryTelephoneNumber("(831) 758-7334")
        telephone.setRadioTelephoneNumber("(831) 758-7234")
        telephone.setTelexNumber("(831) 758-7408")
        telephone.setTtyTddPhoneNumber("(800) 806-4474")
        contact.setTelephones(telephone)

        # Set Physical Address using MapiContactPhysicalAddress and MapiContactPhysicalAddressPropertySet
        phys_addrss = MapiContactPhysicalAddress()
        phys_addrss.setPostOfficeBox("144 Hitchcock Rd, Salinas, CA 93908")

        phys_addr_prop_set = MapiContactPhysicalAddressPropertySet()
        phys_addr_prop_set.setWorkAddress(phys_addrss)
        contact.setPhysicalAddresses(phys_addr_prop_set)

        # Set email information using MapiContactElectronicAddress and MapiContactElectronicAddressPropertySet
        email = MapiContactElectronicAddress()
        email.setAddressType("SMTP")
        email.setDisplayName("Melissa MacBeth (mellissa@contoso.com)")
        email.setEmailAddress("melissa@contoso.com")

        elec_addr_prop_set = MapiContactElectronicAddressPropertySet()
        elec_addr_prop_set.setEmail1(email)
        contact.setElectronicAddresses(elec_addr_prop_set)

        contactSaveFormat=ContactSaveFormat
        contact.save(dataDir + "OutlookContact.vcf", contactSaveFormat.VCard)

        print "Created outlook contact successfully."
        
 
if __name__ == '__main__':        
    CreateOutlookContact()