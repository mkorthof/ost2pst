package com.aspose.email.examples.exchangeews;

import com.aspose.email.EWSClient;
import com.aspose.email.ExchangeDelegateFolderPermissionLevel;
import com.aspose.email.ExchangeDelegateUser;
import com.aspose.email.IEWSClient;
import com.aspose.email.MailConversionOptions;
import com.aspose.email.MailMessage;
import com.aspose.email.MapiMessage;

public class SendCalendarInvitation {
    public  static  void main(String[] args)
    {
        // ExStart:SendCalendarInvitation
        IEWSClient client = EWSClient.getEWSClient("https://outlook.office365.com/exchangeews/exchange.asmx", "testUser", "pwd", "domain");

        // delegate calendar access permission
        ExchangeDelegateUser delegateUser = new ExchangeDelegateUser("sharingfrom@domain.com", ExchangeDelegateFolderPermissionLevel.NotSpecified);
        delegateUser.getFolderPermissions().setCalendarFolderPermissionLevel(ExchangeDelegateFolderPermissionLevel.Reviewer);
        client.delegateAccess(delegateUser, "sharingfrom@domain.com");

        // Create invitation
        MapiMessage mapiMessage = client.createCalendarSharingInvitationMessage("sharingfrom@domain.com");
        MailConversionOptions options = new MailConversionOptions();
        options.setConvertAsTnef(true);
        MailMessage mail = mapiMessage.toMailMessage(options);
        client.send(mail);
        // ExEnd:SendCalendarInvitation
    }
}
