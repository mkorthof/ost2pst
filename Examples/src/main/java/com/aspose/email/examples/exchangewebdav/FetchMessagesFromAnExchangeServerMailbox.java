package com.aspose.email.examples.exchangewebdav;

import com.aspose.email.Attachment;
import com.aspose.email.ExchangeClient;
import com.aspose.email.ExchangeMessageInfo;
import com.aspose.email.ExchangeMessageInfoCollection;
import com.aspose.email.MailMessage;

public class FetchMessagesFromAnExchangeServerMailbox {
    public static void main(String[] args) {
        // Fetching Messages from an Exchange Server Mailbox
        fetchMessagesFromAnExchangeServerMailbox();
    }

    public static void fetchMessagesFromAnExchangeServerMailbox() {
        // Create instance of ExchangeClient class by giving credentials
        ExchangeClient client = new ExchangeClient("http://ex07sp1/exchange/Administrator", "username", "password", "domain");

        // Call ListMessages method to list messages info from Inbox
        ExchangeMessageInfoCollection msgCollection = client.listMessages(client.getMailboxInfo().getInboxUri());

        // Loop through the collection to get Message URI
        for (ExchangeMessageInfo msgInfo : msgCollection) {
            String strMessageURI = msgInfo.getUniqueUri();

            // Now get the message details using FetchMessage()
            MailMessage msg = client.fetchMessage(strMessageURI);

            // Display message details
            System.out.println("Subject: " + msg.getSubject());
            System.out.println("HTML Body: " + msg.getHtmlBody());
            System.out.println("Number of attachments: " + msg.getAttachments().size());
            for (Attachment att : msg.getAttachments()) {
                System.out.println("Attachment Name: " + att.getName());
            }
        }
    }

}
