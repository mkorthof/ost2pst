<?php
namespace Aspose\Email\ProgrammingOutlook\WorkingWithOutlookMessageFiles;

use com\aspose\email\MapiContact as MapiContact;
use com\aspose\email\MapiTask as MapiTask;
use com\aspose\email\MapiTaskHistory as MapiTaskHistory;
use com\aspose\email\MapiTaskOwnership as MapiTaskOwnership;
use com\aspose\email\MapiSensitivity as MapiSensitivity;
use com\aspose\email\MapiTaskStatus as MapiTaskStatus;
use com\aspose\email\TaskSaveFormat as TaskSaveFormat;

use java\util\Calendar as Calendar;
use java\util\TimeZone as TimeZone;

class CreateOutlookTask{

    public static function run($dataDir=null){

        $contact = new MapiContact();

        $calendar=new Calendar();
        $timeZone=new TimeZone();
        $calendar = $calendar->getInstance($timeZone->getTimeZone("GMT"));
        $calendar->set(2012, $calendar->NOVEMBER, 1, 0, 0, 0);
        $startDate = $calendar->getTime();
        $calendar->set(2012, $calendar->DECEMBER, 1);
        $endDate = $calendar->getTime();

        $task = new MapiTask("To Do", "Just click and type to add new task", $startDate, $endDate);
        $task->setPercentComplete(20);
        $task->setEstimatedEffort(2000);
        $task->setActualEffort(20);

        $mapiTaskHistory=new MapiTaskHistory();
        $task->setHistory($mapiTaskHistory->Assigned);
        $task->getUsers()->setOwner("Darius");
        $task->getUsers()->setLastAssigner("Harkness");
        $task->getUsers()->setLastDelegate("Harkness");

        $mapiTaskOwnership=new MapiTaskOwnership();

        $task->getUsers()->setOwnership($mapiTaskOwnership->AssignersCopy);
        $companies = ["company1", "company2", "company3"];
        $task->setCompanies($companies);
        $categories = ["category1", "category2", "category3"];
        $task->setCategories($categories);
        $task->setMileage("Some test mileage");
        $task->setBilling("Test billing information");
        $task->getUsers()->setDelegator("Test Delegator");

        $mapiSensitivity=new MapiSensitivity();
        $task->setSensitivity($mapiSensitivity->Personal);
        $mapiTaskStatus=new MapiTaskStatus();
        $task->setStatus($mapiTaskStatus->Complete);

        $taskSaveFormat=new TaskSaveFormat();

        $task->save($dataDir . "MapiTask.msg", $taskSaveFormat->Msg);

        print "Created outlook task successfully.".PHP_EOL;
    }

}
?>