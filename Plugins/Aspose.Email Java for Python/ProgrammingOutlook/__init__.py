__author__ = "nhp09"
__date__ = "Feb 22, 2016 12:11:58 PM"
import jpype

class AddFileToPST:

    def __init__(self,dataDir):
        
        self.dataDir = dataDir
        self.MailMessage = jpype.JClass("com.aspose.email.PersonalStorage")
        self.FileFormatVersion = jpype.JClass("com.aspose.email.FileFormatVersion")
        self.StandardIpmFolder = jpype.JClass("com.aspose.email.StandardIpmFolder")
        self.PersonalStorage = jpype.JClass("com.aspose.email.PersonalStorage")
        
    
    def main(self):
                                
        personalStorage = self.PersonalStorage
        fileFormatVersion = self.FileFormatVersion
        pst = personalStorage.create(self.dataDir + "AddFile1.pst", fileFormatVersion.Unicode)

        standardIpmFolder = self.StandardIpmFolder
        fi = pst.createPredefinedFolder("Inbox", standardIpmFolder.Inbox)

        fi.addFile(self.dataDir + "Report.xlsx", "IPM.Document.Excel.Sheet.8")

        pst.dispose()

        print "Added file to PST"
        
class AddMapiContactToPST:

    def __init__(self,dataDir):
        
        self.dataDir = dataDir
        self.MapiContact = jpype.JClass("com.aspose.email.MapiContact")
        self.MapiContactNamePropertySet = jpype.JClass("com.aspose.email.MapiContactNamePropertySet")
        self.MapiContactGender = jpype.JClass("com.aspose.email.MapiContactGender")
        self.MapiContactProfessionalPropertySet = jpype.JClass("com.aspose.email.MapiContactProfessionalPropertySet")
        self.MapiContactElectronicAddress = jpype.JClass("com.aspose.email.MapiContactElectronicAddress")
        self.MapiContactTelephonePropertySet = jpype.JClass("com.aspose.email.MapiContactTelephonePropertySet")
        self.FileFormatVersion = jpype.JClass("com.aspose.email.FileFormatVersion")
        self.PersonalStorage = jpype.JClass("com.aspose.email.PersonalStorage")
        self.StandardIpmFolder = jpype.JClass("com.aspose.email.StandardIpmFolder")
        
    def main(self):
                                
        # Create an instance of MapiContact
        mapi_contact = self.MapiContact()

        # Contact #1
        contact1 = self.MapiContact("Sebastian Wright", "SebastianWright@dayrep.com")

        # Contact #2
        contact2 = self.MapiContact("Wichert Kroos", "WichertKroos@teleworm.us", "Grade A Investment")

        # Contact #3
        contact3 = self.MapiContact("Christoffer van de Meeberg", "ChristoffervandeMeeberg@teleworm.us", "Krauses Sofa Factory", "046-630-4614")

        # Contact #4
        contact4 = self.MapiContact()
        contact4.setNameInfo(self.MapiContactNamePropertySet("Margaret", "J.", "Tolle"))

        mapiContactGender = self.MapiContactGender

        contact4.getPersonalInfo().setGender(mapiContactGender.Female)
        contact4.setProfessionalInfo(self.MapiContactProfessionalPropertySet("Adaptaz", "Recording engineer"))
        contact4.getPhysicalAddresses().getWorkAddress().setAddress("4 Darwinia Loop EIGHTY MILE BEACH WA 6725")
        contact4.getElectronicAddresses().setEmail1(self.MapiContactElectronicAddress("Hisen1988", "SMTP", "MargaretJTolle@dayrep.com"))
        contact4.getTelephones().setBusinessTelephoneNumber("(08)9080-1183")
        contact4.getTelephones().setMobileTelephoneNumber("(925)599-3355")

        # Contact #5
        contact5 = self.MapiContact()
        contact5.setNameInfo(self.MapiContactNamePropertySet("Matthew", "R.", "Wilcox"))
        contact5.getPersonalInfo().setGender(mapiContactGender.Male)
        contact5.setProfessionalInfo(self.MapiContactProfessionalPropertySet("Briazz", "Psychiatric aide"))
        contact5.getPhysicalAddresses().getWorkAddress().setAddress("Horner Strasse 12 4421 SAASS")
        contact5.getTelephones().setBusinessTelephoneNumber("0650 675 73 30")
        contact5.getTelephones().setHomeTelephoneNumber("(661)387-5382")

        # Contact #6
        contact6 = self.MapiContact()
        contact6.setNameInfo(self.MapiContactNamePropertySet("Bertha", "A.", "Buell"))
        contact6.setProfessionalInfo(self.MapiContactProfessionalPropertySet("Awthentikz", "Social work assistant"))
        contact6.getPersonalInfo().setPersonalHomePage("B2BTies.com")
        contact6.getPhysicalAddresses().getWorkAddress().setAddress("Im Astenfeld 59 8580 EDELSCHROTT")
        contact6.getElectronicAddresses().setEmail1(self.MapiContactElectronicAddress("Experwas", "SMTP", "BerthaABuell@armyspy.com"))
        contact6.setTelephones(self.MapiContactTelephonePropertySet("06605045265"))

        personalStorage = self.PersonalStorage
        fileFormatVersion = self.FileFormatVersion
        standardIpmFolder = self.StandardIpmFolder

        pst = personalStorage.create(self.dataDir + "MapiContactToPST1.pst", fileFormatVersion.Unicode)
        contactFolder = pst.createPredefinedFolder("Contacts", standardIpmFolder.Contacts)
        contactFolder.addMapiMessageItem(contact1)
        contactFolder.addMapiMessageItem(contact2)
        contactFolder.addMapiMessageItem(contact3)
        contactFolder.addMapiMessageItem(contact4)
        contactFolder.addMapiMessageItem(contact5)
        contactFolder.addMapiMessageItem(contact6)

        print "Added MapiContacts Successfully."
        

class AddMapiJournalToPST:

    def __init__(self,dataDir):
        
        self.dataDir = dataDir
        self.MapiJournal = jpype.JClass("com.aspose.email.MapiJournal")
        self.PersonalStorage = jpype.JClass("com.aspose.email.PersonalStorage")
        self.FileFormatVersion = jpype.JClass("com.aspose.email.FileFormatVersion")
        self.StandardIpmFolder = jpype.JClass("com.aspose.email.StandardIpmFolder")
        
        self.Date = jpype.JClass("java.util.Date")
        self.Calendar = jpype.JClass("java.util.Calendar")
        
    def main(self):
                                
        d1 = self.Date()
        calendar = self.Calendar
        cl = calendar.getInstance()
        cl.setTime(d1)
        cl.add(calendar.HOUR, 1)
        d2 = cl.getTime()

        journal = self.MapiJournal("daily record", "called out in the dark", "Phone call", "Phone call")
        journal.setStartTime(d1)
        journal.setEndTime(d2)

        personalStorage = self.PersonalStorage
        fileFormatVersion = self.FileFormatVersion
        pst = personalStorage.create(self.dataDir + "JournalPST.pst", fileFormatVersion.Unicode)

        standardIpmFolder = self.StandardIpmFolder

        journal_folder = pst.createPredefinedFolder("Journal", standardIpmFolder.Journal)
        journal_folder.addMapiMessageItem(journal)

        print "Added MapiJournal Successfully."
        
class AddMapiNoteToPST:

    def __init__(self,dataDir):
        
        self.dataDir = dataDir
        self.MapiMessage = jpype.JClass("com.aspose.email.MapiMessage")
        self.NoteColor = jpype.JClass("com.aspose.email.NoteColor")
        self.PersonalStorage = jpype.JClass("com.aspose.email.PersonalStorage")
        self.FileFormatVersion = jpype.JClass("com.aspose.email.FileFormatVersion")
        self.StandardIpmFolder = jpype.JClass("com.aspose.email.StandardIpmFolder")
        
    def main(self):
                                
        mapiMessage = self.MapiMessage
        mess = mapiMessage.fromFile(self.dataDir + "MapiNote.msg")

        # Note #1
        note1 = mess.toMapiMessageItem()
        note1.setSubject("Yellow color note")
        note1.setBody("This is a yellow color note")

        # Note #2
        note2 = mess.toMapiMessageItem()
        note2.setSubject("Pink color note")
        note2.setBody("This is a pink color note")

        noteColor = self.NoteColor

        note2.setColor(noteColor.Pink)
        noteColor
        

        # Note #3
        note3 = mess.toMapiMessageItem()
        note2.setSubject("Blue color note")
        note2.setBody("This is a blue color note")
        note2.setColor(noteColor.Blue)
        note3.setHeight(500)
        note3.setWidth(500)

        personalStorage = self.PersonalStorage()
        fileFormatVersion = self.FileFormatVersion()

        pst = personalStorage.create(self.dataDir + "MapiNoteToPST.pst", fileFormatVersion.Unicode)

        standardIpmFolder = self.StandardIpmFolder()

        notes_folder = pst.createPredefinedFolder("Notes", standardIpmFolder.Notes)
        notes_folder.addMapiMessageItem(note1)
        notes_folder.addMapiMessageItem(note2)
        notes_folder.addMapiMessageItem(note3)

        print "Added MapiNote Successfully."

class AddMapiTaskToPST:

    def __init__(self,dataDir):
        
        self.dataDir = dataDir
        self.MapiTask = jpype.JClass("com.aspose.email.MapiTask")
        self.MapiTaskHistory = jpype.JClass("com.aspose.email.MapiTaskHistory")
        self.MapiTaskOwnership = jpype.JClass("com.aspose.email.MapiTaskOwnership")
        self.PersonalStorage = jpype.JClass("com.aspose.email.PersonalStorage")
        self.FileFormatVersion = jpype.JClass("com.aspose.email.FileFormatVersion")
        self.StandardIpmFolder = jpype.JClass("com.aspose.email.StandardIpmFolder")
        
        self.Date = jpype.JClass("java.util.Date")
        self.Calendar = jpype.JClass("java.util.Calendar")
        
                                
    def main(self):
        
        task = self.MapiTask("To Do", "Just click and type to add task", self.Date(), self.Date())
        task.setPercentComplete(20)
        task.setEstimatedEffort(2000)
        task.setActualEffort(20)

        mapiTaskHistory = self.MapiTaskHistory()

        task.setHistory(mapiTaskHistory.Assigned)
        task.setLastUpdate(self.Date())
        task.getUsers().setOwner("Darius")
        task.getUsers().setLastAssigner("Harkness")
        task.getUsers().setLastDelegate("Harkness")

        mapiTaskOwnership = self.MapiTaskOwnership()
        task.getUsers().setOwnership(mapiTaskOwnership.AssignersCopy)

        personalStorage = self.PersonalStorage
        fileFormatVersion = self.FileFormatVersion
        pst = personalStorage.create(self.dataDir + "TaskPST.pst", fileFormatVersion.Unicode)
        standardIpmFolder = self.StandardIpmFolder
        task_folder = pst.createPredefinedFolder("Tasks",standardIpmFolder.Tasks)
        task_folder.addMapiMessageItem(task)

        print "Added MapiTask Successfully."
        
class CreateOutlookContact:

    def __init__(self,dataDir):
        
        self.dataDir = dataDir
        self.MapiContact = jpype.JClass("com.aspose.email.MapiContact")
        self.MapiContactNamePropertySet = jpype.JClass("com.aspose.email.MapiContactNamePropertySet")
        self.MapiContactProfessionalPropertySet = jpype.JClass("com.aspose.email.MapiContactProfessionalPropertySet")
        self.MapiContactTelephonePropertySet = jpype.JClass("com.aspose.email.MapiContactTelephonePropertySet")
        self.MapiContactPhysicalAddress = jpype.JClass("com.aspose.email.MapiContactPhysicalAddress")
        self.MapiContactPhysicalAddressPropertySet = jpype.JClass("com.aspose.email.MapiContactPhysicalAddressPropertySet")
        self.MapiContactElectronicAddress = jpype.JClass("com.aspose.email.MapiContactElectronicAddress")
        self.MapiContactElectronicAddressPropertySet = jpype.JClass("com.aspose.email.MapiContactElectronicAddressPropertySet")
        self.ContactSaveFormat = jpype.JClass("com.aspose.email.ContactSaveFormat")
        
        
    def main(self):
                                
        contact = self.MapiContact()

        # Set different properties of this Contact Item.

        # Set Name properties using MapiContactNamePropertySet
        name_prop_set = self.MapiContactNamePropertySet()
        name_prop_set.setSurname("Mellissa")
        name_prop_set.setGivenName("MacBeth")
        contact.setNameInfo(name_prop_set)

        # Set professional properties using MapiContactProfessionalPropertySet
        prof_prop_set = self.MapiContactProfessionalPropertySet()
        prof_prop_set.setTitle("Account Representative")
        prof_prop_set.setCompanyName("Contoso Ltd.")
        prof_prop_set.setOfficeLocation("36/2529")
        contact.setProfessionalInfo(prof_prop_set)

        # Telephones
        telephone = self.MapiContactTelephonePropertySet()
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
        phys_addrss = self.MapiContactPhysicalAddress()
        phys_addrss.setPostOfficeBox("144 Hitchcock Rd, Salinas, CA 93908")

        phys_addr_prop_set = self.MapiContactPhysicalAddressPropertySet()
        phys_addr_prop_set.setWorkAddress(phys_addrss)
        contact.setPhysicalAddresses(phys_addr_prop_set)

        # Set email information using MapiContactElectronicAddress and MapiContactElectronicAddressPropertySet
        email = self.MapiContactElectronicAddress()
        email.setAddressType("SMTP")
        email.setDisplayName("Melissa MacBeth (mellissa@contoso.com)")
        email.setEmailAddress("melissa@contoso.com")

        elec_addr_prop_set = self.MapiContactElectronicAddressPropertySet()
        elec_addr_prop_set.setEmail1(email)
        contact.setElectronicAddresses(elec_addr_prop_set)

        contactSaveFormat = self.ContactSaveFormat
        contact.save(self.dataDir + "OutlookContact.vcf", contactSaveFormat.VCard)

        print "Created outlook contact successfully."
        
        
class CreateOutlookNote:

    def __init__(self,dataDir):
        
        self.dataDir = dataDir
        self.MapiNote = jpype.JClass("com.aspose.email.MapiNote")
        self.NoteColor = jpype.JClass("com.aspose.email.NoteColor")
        self.NoteSaveFormat = jpype.JClass("com.aspose.email.NoteSaveFormat")        
        
    def main(self):
                                
        note = self.MapiNote()
        note.setSubject("Blue color note")
        note.setBody("This is a blue color note")
        noteColor = self.NoteColor
        note.setColor(noteColor.Blue)
        note.setHeight(500)
        note.setWidth(500)

        noteSaveFormat = self.NoteSaveFormat

        note.save(self.dataDir + "MapiNote.msg", noteSaveFormat.Msg)

        print "Created outlook note successfully."
        
class CreateOutlookTask:

    def __init__(self,dataDir):
        
        self.dataDir = dataDir
        self.MapiNote = jpype.JClass("com.aspose.email.MapiNote")
        self.MapiContact = jpype.JClass("com.aspose.email.MapiContact")
        self.MapiTask = jpype.JClass("com.aspose.email.MapiTask")
        self.MapiTaskHistory = jpype.JClass("com.aspose.email.MapiTaskHistory")           
        self.MapiTaskOwnership = jpype.JClass("com.aspose.email.MapiTaskOwnership")           
        self.MapiSensitivity = jpype.JClass("com.aspose.email.MapiSensitivity")           
        self.MapiTaskStatus = jpype.JClass("com.aspose.email.MapiTaskStatus")           
        self.TaskSaveFormat = jpype.JClass("com.aspose.email.TaskSaveFormat")       
        
        self.Calendar = jpype.JClass("java.util.Calendar")           
        self.TimeZone = jpype.JClass("java.util.TimeZone")              
                        
                                
    def main(self):
        contact = self.MapiContact()

        calendar = self.Calendar
        timeZone = self.TimeZone
        calendar = calendar.getInstance(timeZone.getTimeZone("GMT"))
        calendar.set(2012, calendar.NOVEMBER, 1, 0, 0, 0)
        startDate = calendar.getTime()
        calendar.set(2012, calendar.DECEMBER, 1)
        endDate = calendar.getTime()

        task = self.MapiTask("To Do", "Just click and type to add task", startDate, endDate)
        task.setPercentComplete(20)
        task.setEstimatedEffort(2000)
        task.setActualEffort(20)

        mapiTaskHistory = self.MapiTaskHistory()
        task.setHistory(mapiTaskHistory.Assigned)
        task.getUsers().setOwner("Darius")
        task.getUsers().setLastAssigner("Harkness")
        task.getUsers().setLastDelegate("Harkness")

        mapiTaskOwnership = self.MapiTaskOwnership()

        task.getUsers().setOwnership(mapiTaskOwnership.AssignersCopy)
        companies = ["company1", "company2", "company3"]
        task.setCompanies(companies)
        categories = ["category1", "category2", "category3"]
        task.setCategories(categories)
        task.setMileage("Some test mileage")
        task.setBilling("Test billing information")
        task.getUsers().setDelegator("Test Delegator")

        mapiSensitivity = self.MapiSensitivity
        task.setSensitivity(mapiSensitivity.Personal)
        mapiTaskStatus = self.MapiTaskStatus()
        task.setStatus(mapiTaskStatus.Complete)

        taskSaveFormat = self.TaskSaveFormat

        task.save(self.dataDir + "MapiTask.msg", taskSaveFormat.Msg)

        print "Created outlook task successfully."
        
class CreatePST:

    def __init__(self,dataDir):
        
        self.dataDir = dataDir
        self.MapiMessage = jpype.JClass("com.aspose.email.MapiMessage")
        self.NoteColor = jpype.JClass("com.aspose.email.NoteColor")
        self.PersonalStorage = jpype.JClass("com.aspose.email.PersonalStorage")           
        self.FileFormatVersion = jpype.JClass("com.aspose.email.FileFormatVersion")           
        self.StandardIpmFolder = jpype.JClass("com.aspose.email.StandardIpmFolder")           
        
    def main(self):
                                
        # Create an instance of PersonalStorage
        personalStorage = self.PersonalStorage
        pst = personalStorage.create(self.dataDir + "sample1.pst", 0)

        # Create a folder at root of pst
        pst.getRootFolder().addSubFolder("myInbox")

        # Add message to newly created folder
        mapi_message = self.MapiMessage
        pst.getRootFolder().getSubFolder("myInbox").addMessage(mapi_message.fromFile(self.dataDir + "Message.msg"))

        print "Created PST successfully."
        
        
class DistributionList:

    def __init__(self,dataDir):
        
        self.dataDir = dataDir
        self.MapiDistributionListMemberCollection = jpype.JClass("com.aspose.email.MapiDistributionListMemberCollection")                        
                                
    def main(self):
        oneOffmembers = self.MapiDistributionListMemberCollection()
        oneOffmembers.addItem(self.MapiDistributionListMemberCollection("John R. Patrick", "JohnRPatrick@armyspy.com"))
        oneOffmembers.addItem(self.MapiDistributionListMemberCollection("Tilly Bates", "TillyBates@armyspy.com"))

        dlist = self.MapiDistributionListMemberCollection("Simple list", oneOffmembers)
        dlist.setBody("Test body")
        dlist.setSubject("Test subject")
        dlist.setMileage("Test mileage")
        dlist.setBilling("Test billing")

        dlist.save(self.dataDir + "distlist.msg")

        print "Saved distribution list successfully."
        
class ParseOutlookMessageFile:

    def __init__(self,dataDir):
        
        self.dataDir = dataDir        
        self.MapiMessage = jpype.JClass("com.aspose.email.MapiMessage")                        
        self.MapiDistributionListMemberCollection = jpype.JClass("com.aspose.email.MapiDistributionListMemberCollection")                        
        
    def main(self):
                                
        mapiMessage = self.MapiMessage
        outlook_message_file = mapiMessage.fromFile(self.dataDir + "Message.msg")

        # Display sender's name
        print "Sender Name : " 
        print outlook_message_file.getSenderName()

        #Display Subject
        print "Subject : " 
        print outlook_message_file.getSubject()

        # Display Body
        print "Body : " 
        print outlook_message_file.getBody()
        
        
class SearchMessagesAndFoldersInPST:

    def __init__(self,dataDir):
        
        self.dataDir = dataDir
        self.PersonalStorage = jpype.JClass("com.aspose.email.PersonalStorage")
        self.PersonalStorageQueryBuilder = jpype.JClass("com.aspose.email.PersonalStorageQueryBuilder")
        self.MapiImportance = jpype.JClass("com.aspose.email.MapiImportance")           
        self.MapiMessageFlags = jpype.JClass("com.aspose.email.MapiMessageFlags")        
                        
                                
    def main(self):
        # Load the Outlook PST file
        personalStorage = self.PersonalStorage
        pst = personalStorage.fromFile(self.dataDir + "sample1.pst")

        folder = pst.getRootFolder().getSubFolder("myInbox")
        builder = self.PersonalStorageQueryBuilder()

            # High importance messages
        mapiImportance = self.MapiImportance
        builder.getImportance().equals(mapiImportance.High)
        messages = folder.getContents(builder.getQuery())
        print "Messages with High Imp:" 
        print messages.size()

        #builder = PersonalStorageQueryBuilder()
        builder.getMessageClass().equals("IPM.Note")
        messages = folder.getContents(builder.getQuery())
        print "Messages with IPM.Note:" 
        print messages.size()

        # Messages with attachments AND high importance
        builder.getImportance().equals(mapiImportance.High)

        mapiMessageFlags = self.MapiMessageFlags

        builder.hasFlags(mapiMessageFlags.MSGFLAG_HASATTACH)
        messages = folder.getContents(builder.getQuery())
        print "Messages with atts: " 
        print messages.size()

        # Messages with size > 15 KB
        builder.getMessageSize().greater(15000)
        messages = folder.getContents(builder.getQuery())
        print "messags size > 15Kb:" 
        print messages.size()

        # Unread messages
        builder.hasNoFlags(mapiMessageFlags.MSGFLAG_READ)
        messages = folder.getContents(builder.getQuery())
        print "Unread:" 
        print messages.size()

        # Unread messages with attachments
        builder.hasNoFlags(mapiMessageFlags.MSGFLAG_READ)
        builder.hasFlags(mapiMessageFlags.MSGFLAG_HASATTACH)
        messages = folder.getContents(builder.getQuery())
        print "Unread msgs with atts: " 
        print messages.size()
        
class StringSearchInPST:

    def __init__(self,dataDir):
        
        self.dataDir = dataDir
        self.MapiMessage = jpype.JClass("com.aspose.email.MapiMessage")
        self.MailMessage = jpype.JClass("com.aspose.email.MailMessage")
        self.NoteColor = jpype.JClass("com.aspose.email.NoteColor")
        self.PersonalStorage = jpype.JClass("com.aspose.email.PersonalStorage")           
        self.FileFormatVersion = jpype.JClass("com.aspose.email.FileFormatVersion")     
        self.StandardIpmFolder = jpype.JClass("com.aspose.email.StandardIpmFolder")    
        self.MailQueryBuilder = jpype.JClass("com.aspose.email.MailQueryBuilder")    
        
    def main(self):
        personalStorage = self.PersonalStorage
        fileFormatVersion = self.FileFormatVersion
        pst = personalStorage.create(self.dataDir + "search.pst", fileFormatVersion.Unicode)

        standardIpmFolder = self.StandardIpmFolder
        fi = pst.createPredefinedFolder("Inbox", standardIpmFolder.Inbox)

        mapiMessage = self.MapiMessage
        mailMessage = self.MailMessage
        fi.addMessage(mapiMessage.fromMailMessage(mailMessage.load(self.dataDir + "search.pst")))

        builder = self.MailQueryBuilder()
        builder.getFrom().contains("automated", True)

        query = builder.getQuery()
        coll = fi.getContents(query)

        print "Total Results:"
        print coll.size()
        
class AddMapiCalendarToPST:
    
    def _init_(self,dataDir):
        
        self.dataDir = dataDir
        self.MapiCalendar = jpype.JClass("com.aspose.email.MapiCalendar")
        self.MapiRecipientCollection = jpype.JClass("com.aspose.email.MapiRecipientCollection")
        self.MapiRecipientType = jpype.JClass("com.aspose.email.MapiRecipientType")           
        self.PersonalStorage = jpype.JClass("com.aspose.email.PersonalStorage")     
        self.FileFormatVersion = jpype.JClass("com.aspose.email.FileFormatVersion") 
        self.FileFormatVersion = jpype.JClass("com.aspose.email.StandardIpmFolder")
        self.Date = jpype.JClass("java.util.Date") 
    def main(self):

        # Create the appointment
        mapiCalendar = self.MapiCalendar
        appointment = mapiCalendar("LAKE ARGYLE WA 6743","Appointment","This is a very important meeting :)",Date(2012, 10, 2),Date(2012, 10, 2, 14, 0, 0))

        # Create the meeting
        attendees = self.MapiRecipientCollection()

        mapiRecipientType = self.MapiRecipientType()

        attendees.add("ReneeAJones@armyspy.com", "Renee A. Jones", mapiRecipientType.MAPI_TO)
        attendees.add("SzllsyLiza@dayrep.com", "Szollosy Liza", mapiRecipientType.MAPI_TO)

        meeting = self.MapiCalendar(
                "Meeting Room 3 at Office Headquarters",
                "Meeting",
                "Please confirm your availability.",
                Date(2012, 10, 2, 13, 0, 0),
                Date(2012, 10, 2, 14, 0, 0),
                "CharlieKhan@dayrep.com",
                attendees
            )
        personalStorage = self.PersonalStorage()

        fileFormatVersion = self.FileFormatVersion()
        standardIpmFolder = self.StandardIpmFolder()

        pst = personalStorage.create(self.dataDir + "MapiCalendarToPST1.pst", fileFormatVersion.Unicode)
        calendar_folder = pst.createPredefinedFolder("Calendar", standardIpmFolder.Appointments)
        calendar_folder.addMapiMessageItem(appointment)
        calendar_folder.addMapiMessageItem(meeting)

        print "Added MapiCalendar Successfully."