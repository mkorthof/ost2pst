package com.aspose.email.examples.exchange.ews;

import com.aspose.email.*;

public class SendCalendarInvitation {
    public  static  void main(String[] args)
    {
        // ExStart:SendCalendarInvitation
        IEWSClient client = EWSClient.getEWSClient("https://outlook.office365.com/ews/exchange.asmx", "testUser", "pwd", "domain");

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
