<?php
namespace Aspose\Email\ProgrammingOutlook\WorkingWithOutlookMessageFiles;

use com\aspose\email\MapiDistributionListMemberCollection as MapiDistributionListMemberCollection;

class DistributionList{

    public static function run($dataDir=null){

        $oneOffmembers = new MapiDistributionListMemberCollection();
        $oneOffmembers->addItem(new MapiDistributionListMemberCollection("John R. Patrick", "JohnRPatrick@armyspy.com"));
        $oneOffmembers->addItem(new MapiDistributionListMemberCollection("Tilly Bates", "TillyBates@armyspy.com"));

        $dlist = new MapiDistributionListMemberCollection("Simple list", $oneOffmembers);
        $dlist->setBody("Test body");
        $dlist->setSubject("Test subject");
        $dlist->setMileage("Test mileage");
        $dlist->setBilling("Test billing");

        $dlist->save($dataDir . "distlist.msg");

        print "Saved distribution list successfully.".PHP_EOL;

    }

}
?>