package com.aspose.email.examples.exchange.webdav;

import com.aspose.email.ExchangeClient;
import com.aspose.email.ExchangeMailboxInfo;

public class GetMailboxInformationFromExchangeServer {
    public static void main(String[] args) {
        // Getting Mailbox Information from an Exchange Server
        getMailboxInformationFromAnExchangeServer();
    }

    public static void getMailboxInformationFromAnExchangeServer() {
        // Create instance of ExchangeClient class by giving credentials
        ExchangeClient client = new ExchangeClient("https://MachineName/exchange/Username", "Username", "password", "domain");
        System.out.println("Mailbox size: " + client.getMailboxSize() + " bytes");

        ExchangeMailboxInfo mailboxInfo = client.getMailboxInfo();
        System.out.println("Mailbox URI: " + mailboxInfo.getMailboxUri());
        System.out.println("Inbox folder URI: " + mailboxInfo.getInboxUri());
        System.out.println("Sent Items URI: " + mailboxInfo.getSentItemsUri());
        System.out.println("Drafts folder URI: " + mailboxInfo.getDraftsUri());
    }


}
