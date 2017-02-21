package com.aspose.email.examples.exchangewebdav;

import com.aspose.email.ExchangeClient;
import com.aspose.email.ExchangeMailboxInfo;
import com.aspose.email.ExchangeMessageInfo;
import com.aspose.email.ExchangeMessageInfoCollection;

public class MoveMessageFromOneFolderToAnother {
    public static void main(String[] args) {
        moveMessagesBetweenFolders();
    }

    public static void moveMessagesBetweenFolders() {
        String mailboxURI = "http://ex2003/exchange/administrator"; // WebDAV
        ExchangeClient client = new ExchangeClient(mailboxURI, "username", "password", "domain");
        ExchangeMailboxInfo mailboxInfo = client.getMailboxInfo();

        // List all messages from Inbox folder
        System.out.println("Listing all messages from Inbox....");
        ExchangeMessageInfoCollection msgInfoColl = client.listMessages(mailboxInfo.getInboxUri());
        for (ExchangeMessageInfo msgInfo : msgInfoColl) {
            // Move message to "Processed" folder, after processing certain messages based on some criteria
            if (msgInfo.getSubject() != null && msgInfo.getSubject().contains("process this message") == true) {
                // Move it
                client.moveMessage(msgInfo, client.getMailboxInfo().getRootUri() + "/Processed/" + msgInfo.getSubject());
                System.out.println("Message moved...." + msgInfo.getSubject());
            } else {
                // Do something else
            }
        }
    }


}
