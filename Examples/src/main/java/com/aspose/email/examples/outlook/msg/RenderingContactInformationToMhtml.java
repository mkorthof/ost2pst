package com.aspose.email.examples.outlook.msg;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import com.aspose.email.ContactSaveFormat;
import com.aspose.email.MailConversionOptions;
import com.aspose.email.MailMessage;
import com.aspose.email.MapiContact;
import com.aspose.email.MapiMessage;
import com.aspose.email.MhtFormatOptions;
import com.aspose.email.MhtSaveOptions;
import com.aspose.email.examples.Utils;

public class RenderingContactInformationToMhtml {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ExStart: RenderingContactInformationToMhtml
		
        String dataDir = Utils.getSharedDataDir(RenderingContactInformationToMhtml.class) + "outlook/";
        
        //Load VCF Contact and convert to MailMessage for rendering to MHTML
        MapiContact contact = MapiContact.fromVCard(dataDir + "ContactsSaqib Razzaq.vcf");

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        
        contact.save(os, ContactSaveFormat.Msg);
        
        MapiMessage msg = MapiMessage.fromStream(new ByteArrayInputStream(os.toByteArray()));
        MailConversionOptions op = new MailConversionOptions();
        MailMessage eml = msg.toMailMessage(op);

        //Prepare the MHT format options
        MhtSaveOptions mhtSaveOptions = new MhtSaveOptions();
        mhtSaveOptions.setCheckBodyContentEncoding(true);
        mhtSaveOptions.setPreserveOriginalBoundaries(true);
        int formatOp = (int)(MhtFormatOptions.WriteHeader | MhtFormatOptions.HideExtraPrintHeader | MhtFormatOptions.RenderVCardInfo);
        mhtSaveOptions.setMhtFormatOptions(formatOp);
        eml.save(dataDir + "ContactsSaqib Razzaq_out.mhtml", mhtSaveOptions);
        
        System.out.println("Execution Completed.");
        //ExEnd: RenderingContactInformationToMhtml
	}

}
