package com.aspose.email.examples.exchangewebdav;

import com.aspose.email.ExchangeClient;
import com.aspose.email.ExchangeMailboxInfo;

public class ReadEmailsFromOtherUsersMailbox {
    public static void main(String[] args) {
        usingExchangeClient();
    }

    public static void usingExchangeClient() {
        // Create instance of ExchangeClient class by giving credentials
        ExchangeClient client = new ExchangeClient("http://MachineName/exchange/Username", "Username", "password", "domain");

        // Get Exchange mailbox info of other email account
        ExchangeMailboxInfo mailboxInfo = client.getMailboxInfo("otherUser@domain.com");
    }
}
