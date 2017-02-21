package com.aspose.email.examples.exchange.webdav;

import com.aspose.email.*;
import com.aspose.email.examples.Utils;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class SaveMessagesFromExchangeServerMailbox {
    // The path to the resource directory.
    public static final String dataDir = Utils.getSharedDataDir(com.aspose.email.examples.exchange.ews.SaveMessagesFromExchangeServerMailbox.class) + "exchange/";

    public static void main(String[] args) {
        saveMessagesAsEML();

        saveMessagesToOutputStream();

        saveMessagesInMSGFormat();
    }

    public static void saveMessagesAsEML() {
        // Create instance of ExchangeClient class by giving credentials
        ExchangeClient client = new ExchangeClient("http://servername/exchange/username", "username", "password", "domain");

        // Call ListMessages method to list messages info from Inbox
        ExchangeMessageInfoCollection msgCollection = client.listMessages(client.getMailboxInfo().getInboxUri());

        for (ExchangeMessageInfo msgInfo : msgCollection) {
            String strMessageURI = msgInfo.getUniqueUri();

            // Now save the message in disk
            client.saveMessage(strMessageURI, dataDir + msgInfo.getMessageId() + ".eml");
        }
    }

    public static void saveMessagesToOutputStream() {
        // Create instance of ExchangeClient class by giving credentials
        ExchangeClient client = new ExchangeClient("http://ex07sp1/exchange/Administrator", "user", "pwd", "domain");

        // Call ListMessages method to list messages info from Inbox
        ExchangeMessageInfoCollection msgCollection = client.listMessages(client.getMailboxInfo().getInboxUri());

        // Loop through the collection to get Message URI
        for (ExchangeMessageInfo msgInfo : msgCollection) {
            String strMessageURI = msgInfo.getUniqueUri();

            try {
                OutputStream outputStream = new FileOutputStream(dataDir + msgInfo.getMessageId() + "_Out.eml");
                client.saveMessage(strMessageURI, outputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void saveMessagesInMSGFormat() {
        // Create instance of ExchangeClient class by giving credentials
        ExchangeClient client = new ExchangeClient("http://ex07sp1/exchange/Administrator", "user", "pwd", "domain");

        // Call ListMessages method to list messages info from Inbox
        ExchangeMessageInfoCollection msgCollection = client.listMessages(client.getMailboxInfo().getInboxUri());

        for (ExchangeMessageInfo msgInfo : msgCollection) {
            String strMessageURI = msgInfo.getUniqueUri();

            // Now get the message details using FetchMessage()
            MailMessage msg = client.fetchMessage(strMessageURI);

            // Save message as MSG
            msg.save(dataDir + msgInfo.getMessageId() + ".msg", SaveOptions.getDefaultMsg());
        }
    }

}
