package com.aspose.email.examples.exchangewebdav;

import com.aspose.email.ExchangeClient;
import com.aspose.email.MailAddress;
import com.aspose.email.MailAddressCollection;
import com.aspose.email.MailMessage;

public class SendEmailMessageUsingExchangeServer {
    public static void main(String[] args) {
        sendEmailMessageUsingExchangeServer();
    }

    public static void sendEmailMessageUsingExchangeServer() {
        // Create instance of ExchangeClient class by giving credentials
        ExchangeClient client = new ExchangeClient("http://MachineName/exchange/username", "username", "password", "domain");

        // Create instance of type MailMessage
        MailMessage msg = new MailMessage();
        msg.setFrom(new MailAddress("sender@domain.com"));
        MailAddressCollection collTo = new MailAddressCollection();
        collTo.add("recipient@domain.com");
        msg.setTo(collTo);
        msg.setSubject("Sending message from exchange server");
        msg.setHtmlBody("<h3>sending message from exchange server</h3>");

        // Send the message
        client.send(msg);
    }

}
