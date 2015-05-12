/*
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Email. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */

package programmersguide.programmingoutlook.workwithoutlookmsgfiles.accessingoutlookmapiproperties.java;

import com.aspose.email.*;

public class AccessingOutlookMAPIProperties
{
    public static void main(String[] args) throws Exception
    {
       // The path to the documents directory.
        String dataDir = "src/programmersguide/programmingoutlook/workwithoutlookmsgfiles/accessingoutlookmapiproperties/data/";

        try
        {
          //Instantiate an MSG file to load an MSG file from disk
          MapiMessage outlookMessageFile=MapiMessage.fromFile(dataDir + "message.msg");

          //get the MapiProperties collection
          MapiPropertyCollection coll = outlookMessageFile.getProperties();

          //Access the MapiPropertyTag.PR_SUBJECT property
          MapiProperty prop = (MapiProperty)coll.get_Item((Object)MapiPropertyTag.PR_SUBJECT);

          //if the MapiProperty is not found, check the MapiProperty.PR_SUBJECT_W
          //which is a unicode peer of MapiPropertyTag.PR_SUBJECT
          if (prop == null)
          {
            prop = (MapiProperty)coll.get_Item(MapiPropertyTag.PR_SUBJECT_W);
          }

           // if it cannot be found
           if (prop == null)
           {
              System.out.println("Mapi property could not be found.");
           }
           else
           {
             //get the property data as string
             String strSubject = prop.getString();
             System.out.println("Subject: " + strSubject);
           }

             //read internet code page property
             prop = (MapiProperty)coll.get_Item(MapiPropertyTag.PR_INTERNET_CPID);
             if (prop != null)
             {
           	System.out.println("Code page: " + prop.getLong());
             }
        }
        catch(Exception ex)
        {
        	System.out.println("Some error occurred while accessing outlook Mapi properties.");
        }
    }
}




