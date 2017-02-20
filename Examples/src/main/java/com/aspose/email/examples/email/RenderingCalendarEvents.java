package com.aspose.email.examples.email;

import com.aspose.email.*;

/**
 * Created by hp on 1/27/2017.
 */
public class RenderingCalendarEvents {

    public static void main(String[] args) {
        //ExStart: RenderingCalendarEvents
        String fileName = "Meeting with Recurring Occurrences.msg";
        MailMessage msg = MailMessage.load("Meeting with Recurring Occurrences.msg");
        MhtSaveOptions options = new MhtSaveOptions();
        {
            options.setMhtFormatOptions(MhtFormatOptions.WriteHeader | MhtFormatOptions.RenderCalendarEvent);

            //Format the output details if required - optional

            //Set the display for Start Property
            if (options.getFormatTemplates().containsKey("Start"))
                options.getFormatTemplates().set_Item("Start","<span class='headerLineTitle'>Start:</span><span class='headerLineText'>{0}</span><br/>");
            else
                options.getFormatTemplates().add("Start", "<span class='headerLineTitle'>Start:</span><span class='headerLineText'>{0}</span><br/>");

            //Set the display for End Property
            if (options.getFormatTemplates().containsKey("End"))
                options.getFormatTemplates().set_Item("End", "<span class='headerLineTitle'>End:</span><span class='headerLineText'>{0}</span><br/>");
            else
                options.getFormatTemplates().add("End", "<span class='headerLineTitle'>End:</span><span class='headerLineText'>{0}</span><br/>");

            //Set the display for Recurrence Property
            if (options.getFormatTemplates().containsKey("Recurrence"))
                options.getFormatTemplates().set_Item("Recurrence","<span class='headerLineTitle'>Recurrence:</span><span class='headerLineText'>{0}</span><br/>");
            else
                options.getFormatTemplates().add("Recurrence", "<span class='headerLineTitle'>Recurrence:</span><span class='headerLineText'>{0}</span><br/>");

            //Set the display for RecurrencePattern Property
            if (options.getFormatTemplates().containsKey("RecurrencePattern"))
                options.getFormatTemplates().set_Item("RecurrencePattern", "<span class='headerLineTitle'>RecurrencePattern:</span><span class='headerLineText'>{0}</span><br/>");
            else
                options.getFormatTemplates().add("RecurrencePattern", "<span class='headerLineTitle'>RecurrencePattern:</span><span class='headerLineText'>{0}</span><br/>");

            //Set the display for Organizer Property
            if (options.getFormatTemplates().containsKey("Organizer"))
                options.getFormatTemplates().set_Item("Organizer", "<span class='headerLineTitle'>Organizer:</span><span class='headerLineText'>{0}</span><br/>");
            else
                options.getFormatTemplates().add("Organizer", "<span class='headerLineTitle'>Organizer:</span><span class='headerLineText'>{0}</span><br/>");

            //Set the display for RequiredAttendees Property
            if (options.getFormatTemplates().containsKey("RequiredAttendees"))
                options.getFormatTemplates().set_Item("RequiredAttendees", "<span class='headerLineTitle'>RequiredAttendees:</span><span class='headerLineText'>{0}</span><br/>");
            else
                options.getFormatTemplates().add("RequiredAttendees", "<span class='headerLineTitle'>RequiredAttendees:</span><span class='headerLineText'>{0}</span><br/>");
        };

        msg.save("Meeting with Recurring Occurrences.mhtml", options);
        //ExEnd: RenderingCalendarEvents
    }
}
