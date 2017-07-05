package com.aspose.email.examples.exchangewebdav;

import com.aspose.email.ExchangeClient;
import com.aspose.email.ExchangeMessageInfo;
import com.aspose.email.ExchangeMessageInfoCollection;

public class ListMessages {
    public static void main(String[] args) {
        // Connects to the Exchange mailbox and get list of messages from the Inbox folder
        listMessagesFromInboxFolderOnExchangeServer();

        // Get the list of messages from other folders
        listMessagesFromOtherFoldersOnExchangeServer();
    }

    public static void listMessagesFromInboxFolderOnExchangeServer() {
        // Create instance of ExchangeClient class by giving credentials
        ExchangeClient client = new ExchangeClient("http://MachineName/exchange/Username", "username", "password", "domain");
        // Call ListMessages method to list messages info from Inbox
        ExchangeMessageInfoCollection msgCollection = client.listMessages(client.getMailboxInfo().getInboxUri());
        // Loop through the collection to display the basic information
        for (ExchangeMessageInfo msgInfo : msgCollection) {
            System.out.println("Subject: " + msgInfo.getSubject());
            System.out.println("From: " + msgInfo.getFrom());
            System.out.println("To: " + msgInfo.getTo());
            System.out.println("Sent Date: " + msgInfo.getDate());
            System.out.println("Read?: " + msgInfo.isRead());
            System.out.println("Message ID: " + msgInfo.getMessageId());
            System.out.println("Unique URI: " + msgInfo.getUniqueUri());
            System.out.println("==================================");
        }
    }

    public static void listMessagesFromOtherFoldersOnExchangeServer() {
        // Create instance of ExchangeClient class by giving credentials
        ExchangeClient client = new ExchangeClient("http://MachineName/exchange/Username","username", "password", "domain");

        // Get folder URI
        String strFolderURI = "";
        strFolderURI = client.getMailboxInfo().getInboxUri();
        strFolderURI = client.getMailboxInfo().getDeletedItemsUri();
        strFolderURI = client.getMailboxInfo().getDraftsUri();
        strFolderURI = client.getMailboxInfo().getSentItemsUri();

        // Get list of messages from the specified folder
        ExchangeMessageInfoCollection msgCollection = client.listMessages(strFolderURI);
    }
}
