package com.aspose.email.examples.exchangewebdav;

import com.aspose.email.ExchangeClient;
import com.aspose.email.ExchangeMailboxInfo;
import com.aspose.email.ExchangeMessageInfo;
import com.aspose.email.ExchangeMessageInfoCollection;

public class DeleteMessagesFromExchangeServer {
    public static void main(String[] args) {
        deleteMessagesFromExchangeServer();
    }

    public static void deleteMessagesFromExchangeServer() {
        ExchangeClient client = new ExchangeClient("http://ex2003/exchange/administrator", "username", "password", "domain");
        ExchangeMailboxInfo mailboxInfo = client.getMailboxInfo();

        // List all messages from Inbox folder
        System.out.println("Listing all messages from Inbox....");
        ExchangeMessageInfoCollection msgInfoColl = client.listMessages(mailboxInfo.getInboxUri());
        for (ExchangeMessageInfo msgInfo : msgInfoColl) {
            // Delete message based on some criteria
            if (msgInfo.getSubject() != null && msgInfo.getSubject().contains("delete") == true) {
                // Delete it
                client.deleteMessage(msgInfo.getUniqueUri());
                System.out.println("Message deleted...." + msgInfo.getSubject());
            } else {
                // Do something else
            }
        }
    }

}
