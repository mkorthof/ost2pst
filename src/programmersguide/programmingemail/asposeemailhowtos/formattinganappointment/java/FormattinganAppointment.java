/* 
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Email. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package programmersguide.programmingemail.asposeemailhowtos.formattinganappointment.java;

import com.aspose.email.*;

public class FormattinganAppointment
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/programmingemail/asposeemailhowtos/formattinganappointment/data/";
        
        Appointment appointment = Appointment.load(dataDir + "sampleAppointment.ics");
        AppointmentFormattingOptions formattingOptions = AppointmentFormattingOptions.createAsHtml();
        formattingOptions.setLocationFormat("<FONT SIZE=2 FACE=\"Arial\"><b>Where: {0}</b></FONT><BR>");
        formattingOptions.setTitleFormat("<FONT SIZE=2 FACE=\"Arial\"><b>Subject: {0}</b></FONT><BR>");
        formattingOptions.setDescriptionFormat("<P><FONT SIZE=2 FACE=\"Arial\">-----------<br><i>{0}</i></FONT></P>");
        
        System.out.println(appointment.getAppointmentText(formattingOptions));
    }
}




