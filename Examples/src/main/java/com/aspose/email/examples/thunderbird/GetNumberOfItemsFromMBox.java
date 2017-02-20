package com.aspose.email.examples.thunderbird;

import com.aspose.email.MboxrdStorageReader;

/**
 * Created by hp on 2/20/2017.
 */
public class GetNumberOfItemsFromMBox {

    public static void main(String[] args) {

        GetNumberOfItemsFromMBox();
    }
    public static void GetNumberOfItemsFromMBox()
    {
        //ExStart: GetNumberOfItemsFromMBox
        MboxrdStorageReader reader = new MboxrdStorageReader("inbox.dat", false);

        System.out.println("Total number of messages in Mbox file: " +  reader.getTotalItemsCount());
        //ExEnd: GetNumberOfItemsFromMBox
    }
}


