<?php
namespace Aspose\Email\ProgrammingOutlook\WorkingWithOutlookPersonalStorage;

use com\aspose\email\MapiTask as MapiTask;
use com\aspose\email\MapiTaskHistory as MapiTaskHistory;
use com\aspose\email\MapiTaskOwnership as MapiTaskOwnership;
use com\aspose\email\PersonalStorage as PersonalStorage;
use com\aspose\email\FileFormatVersion as FileFormatVersion;
use com\aspose\email\StandardIpmFolder as StandardIpmFolder;

use java\util\Date as Date;
class AddMapiTaskToPST{

    public static function run($dataDir=null){

        $task = new MapiTask("To Do", "Just click and type to add new task", new Date(), new Date());
        $task->setPercentComplete(20);
        $task->setEstimatedEffort(2000);
        $task->setActualEffort(20);

        $mapiTaskHistory=new MapiTaskHistory();

        $task->setHistory($mapiTaskHistory->Assigned);
        $task->setLastUpdate(new Date());
        $task->getUsers()->setOwner("Darius");
        $task->getUsers()->setLastAssigner("Harkness");
        $task->getUsers()->setLastDelegate("Harkness");

        $mapiTaskOwnership=new MapiTaskOwnership();
        $task->getUsers()->setOwnership($mapiTaskOwnership->AssignersCopy);

        $personalStorage=new PersonalStorage();
        $fileFormatVersion=new FileFormatVersion();
        $pst = $personalStorage->create($dataDir . "TaskPST.pst", $fileFormatVersion->Unicode);
        $standardIpmFolder=new StandardIpmFolder();
        $task_folder = $pst->createPredefinedFolder("Tasks",$standardIpmFolder->Tasks);
        $task_folder->addMapiMessageItem($task);

        print "Added MapiTask Successfully.".PHP_EOL;
    }
}
?>