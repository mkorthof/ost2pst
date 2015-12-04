package com.aspose.email.examples.asposefeatures.msgfiles.readwriteoutlookcontacts;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import com.aspose.email.ContactSaveFormat;
import com.aspose.email.MapiContact;
import com.aspose.email.MapiContactElectronicAddress;
import com.aspose.email.MapiContactNamePropertySet;
import com.aspose.email.MapiContactPhoto;
import com.aspose.email.MapiContactPhotoImageFormat;
import com.aspose.email.MapiContactProfessionalPropertySet;
import com.aspose.email.MapiContactTelephonePropertySet;
import com.aspose.email.MapiMessage;
import com.aspose.email.examples.Utils;

public class AsposeReadWriteOutlookContact
{
    public static void main(String[] args) throws IOException
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(AsposeReadWriteOutlookContact.class);

        MapiContact contact = new MapiContact("Sebastian Wright", "SebastianWright@dayrep.com");
        contact.setNameInfo(new MapiContactNamePropertySet("Bertha", "A.", "Buell"));
        contact.setProfessionalInfo(new MapiContactProfessionalPropertySet("Awthentikz", "Social work assistant"));
        contact.getPersonalInfo().setPersonalHomePage("B2BTies.com");
        contact.getPhysicalAddresses().getWorkAddress().setAddress("Im Astenfeld 59 8580 EDELSCHROTT");
        contact.getElectronicAddresses().setEmail1(new MapiContactElectronicAddress("Experwas", "SMTP", "BerthaABuell@armyspy.com"));
        contact.setTelephones(new MapiContactTelephonePropertySet("06605045265"));

        // Set Photo Data
        File fi = new File(dataDir + "Aspose.jpg");
        byte[] fileContent = Files.readAllBytes(fi.toPath());
        MapiContactPhoto photo = new MapiContactPhoto(fileContent, MapiContactPhotoImageFormat.Jpeg);
        contact.setPhoto(photo);

        // Save as MSG
        contact.save(dataDir + "contact.msg", ContactSaveFormat.Msg);

        // Loading MSG
        MapiMessage msg = MapiMessage.fromFile(dataDir + "contact.msg");

        MapiContact mapiContact = (MapiContact)msg.toMapiMessageItem();

        System.out.println("Done.");
    }
}
