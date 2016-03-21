from asposeemail import Settings
from com.aspose.email import MapiDistributionListMemberCollection

class DistributionList:

    def __init__(self):
                        
        dataDir = Settings.dataDir + 'ProgrammingOutlook/WorkingWithOutlookMessageFiles/DistributionList/'
        
        oneOffmembers = MapiDistributionListMemberCollection()
        oneOffmembers.addItem(MapiDistributionListMemberCollection("John R. Patrick", "JohnRPatrick@armyspy.com"))
        oneOffmembers.addItem(MapiDistributionListMemberCollection("Tilly Bates", "TillyBates@armyspy.com"))



        dlist = MapiDistributionListMemberCollection("Simple list", oneOffmembers)
        dlist.setBody("Test body")
        dlist.setSubject("Test subject")
        dlist.setMileage("Test mileage")
        dlist.setBilling("Test billing")

        dlist.save(dataDir + "distlist.msg")

        print "Saved distribution list successfully."
        
 
if __name__ == '__main__':        
    DistributionList()