module Asposeemailjava
  module AddMapiTaskToPST
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        task = Rjb::import('com.aspose.email.MapiTask').new("To Do", "Just click and type to add new task", Rjb::import('java.util.Date').new, Rjb::import('java.util.Date').new)
        task.setPercentComplete(20)
        task.setEstimatedEffort(2000)
        task.setActualEffort(20)
        task.setHistory(Rjb::import('com.aspose.email.MapiTaskHistory').Assigned)
        task.setLastUpdate(Rjb::import('java.util.Date').new)
        task.getUsers().setOwner("Darius")
        task.getUsers().setLastAssigner("Harkness")
        task.getUsers().setLastDelegate("Harkness")
        task.getUsers().setOwnership(Rjb::import('com.aspose.email.MapiTaskOwnership').AssignersCopy)

        pst = Rjb::import('com.aspose.email.PersonalStorage').create(data_dir + "TaskPST.pst", Rjb::import('com.aspose.email.FileFormatVersion').Unicode)
        task_folder = pst.createPredefinedFolder("Tasks", Rjb::import('com.aspose.email.StandardIpmFolder').Tasks)
        task_folder.addMapiMessageItem(task)

        puts "Added MapiTask Successfully."
    end
  end
end
