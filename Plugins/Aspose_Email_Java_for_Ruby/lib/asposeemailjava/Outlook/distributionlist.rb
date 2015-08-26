module Asposeemailjava
  module DistributionList
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        oneOffmembers = Rjb::import('com.aspose.email.MapiDistributionListMemberCollection').new
        oneOffmembers.addItem(Rjb::import('com.aspose.email.MapiDistributionListMember').new("John R. Patrick", "JohnRPatrick@armyspy.com"))
        oneOffmembers.addItem(Rjb::import('com.aspose.email.MapiDistributionListMember').new("Tilly Bates", "TillyBates@armyspy.com"))

        dlist = Rjb::import('com.aspose.email.MapiDistributionList').new("Simple list", oneOffmembers)
        dlist.setBody("Test body")
        dlist.setSubject("Test subject")
        dlist.setMileage("Test mileage")
        dlist.setBilling("Test billing")

        dlist.save(data_dir + "distlist.msg")

        puts "Saved distribution list successfully."
    end
  end
end
