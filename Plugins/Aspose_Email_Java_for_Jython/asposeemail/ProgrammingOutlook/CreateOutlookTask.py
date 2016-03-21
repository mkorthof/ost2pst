from asposeemail import Settings
from com.aspose.email import MapiContact
from com.aspose.email import MapiTask
from com.aspose.email import MapiTaskHistory
from com.aspose.email import MapiTaskOwnership
from com.aspose.email import MapiSensitivity
from com.aspose.email import MapiTaskStatus
from com.aspose.email import TaskSaveFormat

from java.util import Calendar
from java.util import TimeZone

class CreateOutlookTask:

    def __init__(self):
                        
        dataDir = Settings.dataDir + 'ProgrammingOutlook/WorkingWithOutlookMessageFiles/CreateOutlookTask/'
        
        contact = MapiContact()

        calendar = Calendar
        timeZone = TimeZone
        calendar = calendar.getInstance(timeZone.getTimeZone("GMT"))
        calendar.set(2012, calendar.NOVEMBER, 1, 0, 0, 0)
        startDate = calendar.getTime()
        calendar.set(2012, calendar.DECEMBER, 1)
        endDate = calendar.getTime()

        task = MapiTask("To Do", "Just click and type to add task", startDate, endDate)
        task.setPercentComplete(20)
        task.setEstimatedEffort(2000)
        task.setActualEffort(20)

        mapiTaskHistory=MapiTaskHistory()
        task.setHistory(mapiTaskHistory.Assigned)
        task.getUsers().setOwner("Darius")
        task.getUsers().setLastAssigner("Harkness")
        task.getUsers().setLastDelegate("Harkness")

        mapiTaskOwnership=MapiTaskOwnership()

        task.getUsers().setOwnership(mapiTaskOwnership.AssignersCopy)
        companies = ["company1", "company2", "company3"]
        task.setCompanies(companies)
        categories = ["category1", "category2", "category3"]
        task.setCategories(categories)
        task.setMileage("Some test mileage")
        task.setBilling("Test billing information")
        task.getUsers().setDelegator("Test Delegator")

        mapiSensitivity=MapiSensitivity
        task.setSensitivity(mapiSensitivity.Personal)
        mapiTaskStatus=MapiTaskStatus()
        task.setStatus(mapiTaskStatus.Complete)

        taskSaveFormat=TaskSaveFormat

        task.save(dataDir + "MapiTask.msg", taskSaveFormat.Msg)

        print "Created outlook task successfully."
        
 
if __name__ == '__main__':        
    CreateOutlookTask()