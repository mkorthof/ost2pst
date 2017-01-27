package com.aspose.email.examples.email;

import com.aspose.email.*;

/**
 * Created by hp on 1/27/2017.
 */
public class RenderingCalendarEvents {

    public static void main(String[] args) {
        //ExStart: RenderingCalendarEvents
        MailMessage msg = MailMessage.load("fileName");

        MhtSaveOptions options = SaveOptions.getDefaultMhtml();

        options.setMhtFormatOptions(MhtFormatOptions.WriteHeader | MhtFormatOptions.RenderCalendarEvent);

        MhtMessageFormatter messageformatter = new MhtMessageFormatter();

        messageformatter.setStartFormat("<span class='headerLineTitle'>Start:</span><span class='headerLineText'>{0}</span><br/>");

        messageformatter.setEndFormat("<span class='headerLineTitle'>End:</span><span class='headerLineText'>{0}</span><br/>");

        messageformatter.setRecurrenceFormat("<span class='headerLineTitle'>Recurrence:</span><span class='headerLineText'>{0}</span><br/>");

        messageformatter.setRecurrencePatternFormat("<span class='headerLineTitle'>RecurrencePattern:</span><span class='headerLineText'>{0}</span><br/>");

        messageformatter.setOrganizerFormat("<span class='headerLineTitle'>Organizer:</span><span class='headerLineText'>{0}</span><br/>");

        messageformatter.setRequiredAttendeesFormat("<span class='headerLineTitle'>RequiredAttendees:</span><span class='headerLineText'>{0}</span><br/>");

        messageformatter.format(msg, options.getMhtFormatOptions());
        //ExEnd: RenderingCalendarEvents
    }
}
