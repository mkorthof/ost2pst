package com.aspose.email.examples.exchange.webdav;

import com.aspose.email.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SendMeetingRequestsUsingExchangeServer {
    public static void main(String[] args) throws ParseException {
        sendingMeetingRequestsUsingAnExchangeServerWebDav();
    }

    public static void sendingMeetingRequestsUsingAnExchangeServerWebDav() throws ParseException {
        try {
            String domain = "litwareinc.com";
            ExchangeClient client = new ExchangeClient("http://MachineName/exchange/Username", "username", "password", "domain");

            // Create the meeting request
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date startDate = sdf.parse("10/05/2015 10:00:00");
            Date endDate = sdf.parse("10/05/2015 10:30:00");

            MailAddressCollection coll = new MailAddressCollection();
            coll.add("bob@" + domain);

            Appointment app = new Appointment("meeting request", startDate, endDate, new MailAddress("administrator@" + domain), coll);
            app.setSummary("meeting request summary");
            app.setDescription("description");

            // Create the message and set the meeting request
            MailMessage msg = new MailMessage();
            msg.setFrom(new MailAddress("administrator@" + domain));
            msg.setTo(coll);
            msg.isBodyHtml(true);
            msg.setHtmlBody("<h3>HTML Heading</h3><p>Email Message detail</p>");
            msg.setSubject("meeting request");
            msg.addAlternateView(app.requestApointment(0));

            // Send the appointment
            client.send(msg);
            System.out.println("Appointment request sent");
        } catch (ExchangeException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
