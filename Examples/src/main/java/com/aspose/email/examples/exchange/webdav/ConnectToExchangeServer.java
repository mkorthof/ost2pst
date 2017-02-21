package com.aspose.email.examples.exchange.webdav;

import com.aspose.email.ExchangeClient;

public class ConnectToExchangeServer {
    public static void main(String[] args)
    {
        // Connecting to Exchange using ExchangeClient
        getExchangeClient();
    }

    // ExStart:GetExchangeClient
    public static ExchangeClient getExchangeClient() {
        // Create instance of ExchangeClient class by giving credentials
        ExchangeClient client = new ExchangeClient("http://MachineName/exchange/Username", "Username", "password", "domain");
        return client;
    }
    // ExEnd:GetExchangeClient
}
