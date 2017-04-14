package com.aspose.email.examples.email;

import com.aspose.email.*;
import com.aspose.email.examples.Utils;

/**
 * Created by hp on 1/27/2017.
 */
public class RenderingCalendarEvents {

    public static void main(String[] args) {
        //ExStart: RenderingCalendarEvents
        String dataDir = Utils.getSharedDataDir(RenderingCalendarEvents.class) + "email/";
        
        MailMessage msg = MailMessage.load(dataDir + "Meeting with Recurring Occurrences.msg");
        
        MhtSaveOptions options = new MhtSaveOptions();
        {
            options.setMhtFormatOptions(MhtFormatOptions.WriteHeader | MhtFormatOptions.RenderCalendarEvent);

            //Format the output details if required - optional

            //Set the display for Start Property
            if (options.getFormatTemplates().containsKey(MhtTemplateName.START))
                options.getFormatTemplates().set_Item(MhtTemplateName.START,"<span class='headerLineTitle'>Start:</span><span class='headerLineText'>{0}</span><br/>");
            else
                options.getFormatTemplates().add(MhtTemplateName.START, "<span class='headerLineTitle'>Start:</span><span class='headerLineText'>{0}</span><br/>");

            //Set the display for End Property
            if (options.getFormatTemplates().containsKey(MhtTemplateName.END))
                options.getFormatTemplates().set_Item(MhtTemplateName.END, "<span class='headerLineTitle'>End:</span><span class='headerLineText'>{0}</span><br/>");
            else
                options.getFormatTemplates().add(MhtTemplateName.END, "<span class='headerLineTitle'>End:</span><span class='headerLineText'>{0}</span><br/>");

            //Set the display for Recurrence Property
            if (options.getFormatTemplates().containsKey(MhtTemplateName.RECURRENCE))
                options.getFormatTemplates().set_Item(MhtTemplateName.RECURRENCE,"<span class='headerLineTitle'>Recurrence:</span><span class='headerLineText'>{0}</span><br/>");
            else
                options.getFormatTemplates().add(MhtTemplateName.RECURRENCE, "<span class='headerLineTitle'>Recurrence:</span><span class='headerLineText'>{0}</span><br/>");

            //Set the display for RecurrencePattern Property
            if (options.getFormatTemplates().containsKey(MhtTemplateName.RECURRENCE_PATTERN))
                options.getFormatTemplates().set_Item(MhtTemplateName.RECURRENCE_PATTERN, "<span class='headerLineTitle'>RecurrencePattern:</span><span class='headerLineText'>{0}</span><br/>");
            else
                options.getFormatTemplates().add(MhtTemplateName.RECURRENCE_PATTERN, "<span class='headerLineTitle'>RecurrencePattern:</span><span class='headerLineText'>{0}</span><br/>");

            //Set the display for Organizer Property
            if (options.getFormatTemplates().containsKey(MhtTemplateName.ORGANIZER))
                options.getFormatTemplates().set_Item(MhtTemplateName.ORGANIZER, "<span class='headerLineTitle'>Organizer:</span><span class='headerLineText'>{0}</span><br/>");
            else
                options.getFormatTemplates().add(MhtTemplateName.ORGANIZER, "<span class='headerLineTitle'>Organizer:</span><span class='headerLineText'>{0}</span><br/>");

            //Set the display for RequiredAttendees Property
            if (options.getFormatTemplates().containsKey(MhtTemplateName.REQUIRED_ATTENDEES))
                options.getFormatTemplates().set_Item(MhtTemplateName.REQUIRED_ATTENDEES, "<span class='headerLineTitle'>RequiredAttendees:</span><span class='headerLineText'>{0}</span><br/>");
            else
                options.getFormatTemplates().add(MhtTemplateName.REQUIRED_ATTENDEES, "<span class='headerLineTitle'>RequiredAttendees:</span><span class='headerLineText'>{0}</span><br/>");
        };

        msg.save(dataDir + "Meeting with Recurring Occurrences_out.mhtml", options);
        //ExEnd: RenderingCalendarEvents
    }
}
