/*
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Email. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */

package programmersguide.programmingemail.manageemailmessages.extractingemailheaders.java;

import com.aspose.email.MailMessage;
import com.aspose.email.MessageFormat;

public class ExtractingEmailHeaders
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/programmingemail/manageemailmessages/extractingemailheaders/data/";

        MailMessage message;

        //Create MailMessage instance by loading an EML file
        message = MailMessage.load(dataDir + "test.eml", MessageFormat.getEml());

        System.out.println("Printing all Headers:\n\n");

        //print out all the headers
        for (int i=0; i< message.getHeaders().getCount();i++)
        {
            System.out.println(message.getHeaders().get(i));
        }

        // Display status
        System.out.println("\nEmail message header printed successfully.");
    }
}




