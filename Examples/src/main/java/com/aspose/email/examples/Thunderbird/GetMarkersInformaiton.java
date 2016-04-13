/* 
 * Copyright 2001-2016 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Email. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package com.aspose.email.examples.exchange;


public class GetMarkersInformation
{
    public static void main(String[] args) throws Exception
    {
		//ExStart: GetMarkersInformation
		FileInputStream stream = new FileInputStream("file");
		try
		{
		    MboxrdStorageReader reader = new MboxrdStorageReader(stream, false);
		    try
		    {
		        MailMessage msg;
		        String[] fromMarker = { null };
		        while ((msg = reader.readNextMessage(/*out*/fromMarker)) != null)
		        {
		            System.out.println(fromMarker[0]);
		        
		            msg.dispose();
		        }
		    }
		    finally { 
		    	if (reader != null) 
		    		reader.dispose(); 
		    	}
		}
		finally { 
			if (stream != null) 
				((IDisposable) stream).dispose(); 
			}

		FileOutputStream writeStream = new FileOutputStream("file");
		try
		{
		    MboxrdStorageWriter writer = new MboxrdStorageWriter(writeStream, false);
		    try
		    {
		        MailMessage msg = MailMessage.load("msgFile");
		        String[] fromMarker = { null };
		        writer.writeMessage(msg, /*out*/fromMarker);
		        System.out.println(fromMarker[0]);
		    }
		    finally { 
		    	if (writer != null) ((IDisposable)writer).dispose(); }
		}
		finally { 
			if (writeStream != null) 
				((IDisposable)writeStream).dispose(); 
			}


        // Display Status.
        System.out.println("Execution completed.");
		//ExEnd: GetMarkersInformation
    }
}