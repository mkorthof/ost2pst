/*
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Email. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */

package programmersguide.programmingemail.manageemailmessages.displayemailinformation.java;

import com.aspose.email.*;

public class DisplayEmailInformation
{
    public static void main(String[] args) throws Exception
    {
       // The path to the documents directory.
        String dataDir = "src/programmersguide/programmingemail/manageemailmessages/displayemailinformation/data/";

        MailMessage message;

        //Create MailMessage instance by loading an Eml file
        message = MailMessage.load(dataDir + "test.eml", MailMessageLoadOptions.getDefaultEml());

        System.out.print("From: ");

        //Gets the sender info
        System.out.println(message.getFrom());
        System.out.print("To: ");

        //Gets the recipients info
        System.out.println(message.getTo());
        System.out.print("Subject: ");

        //Gets the subject
        System.out.println(message.getSubject());
        System.out.print("HtmlBody: ");

        //Gets the htmlbody
        System.out.println(message.getHtmlBody());
        System.out.print("TextBody: ");

        //Gets the textboby
        System.out.println(message.getHtmlBodyText());


    }
}




