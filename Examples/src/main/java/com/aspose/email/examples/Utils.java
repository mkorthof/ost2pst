package com.aspose.email.examples;

import java.io.File;

import com.aspose.email.EWSClient;
import com.aspose.email.IEWSClient;

public class Utils {

    public static String getDataDir(Class c) {
        File dir = new File(System.getProperty("user.dir"));
        dir = new File(dir, "src");
        dir = new File(dir, "main");
        dir = new File(dir, "resources");

        for (String s : c.getName().split("\\.")) {
            dir = new File(dir, s);
            if (dir.isDirectory() == false)
                dir.mkdir();
        }

        System.out.println("Using data directory: " + dir.toString());
        return dir.toString() + File.separator;
    }
    
    public static String getSharedDataDir(Class c) {
        File dir = new File(System.getProperty("user.dir"));
        dir = new File(dir, "src");
        dir = new File(dir, "main");
        dir = new File(dir, "resources");
        
        return dir.toString() + File.separator;
    }
    
    public static IEWSClient getAsposeEWSClient() {
		// Create instance of IEWSClient class by giving credentials
		IEWSClient client = EWSClient.getEWSClient("https://outlook.office365.com/ews/exchange.asmx", "testUser", "pwd", "domain");

		// Return the instance of IEWSClient class
		return client;
	}
}
