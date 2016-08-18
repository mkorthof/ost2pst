package com.aspose.email.examples.email;

import com.aspose.email.MailMessage;
import com.aspose.email.SpamAnalyzer;
import com.aspose.email.examples.Utils;

public class BayesianSpamAnalyzer {

	public static void main(String[] args) {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(SaveMessageAsDraft.class) + "email/";

		SpamFilterTest(dataDir);
	}

	public static void SpamFilterTest(String dataDir) {
		String hamFolder = dataDir + "ham";
		String spamFolder = dataDir + "spam";
		String testFolder = dataDir + "test";
		String dataBaseFile = dataDir + "SpamFilterDatabase.txt";

		teachAndCreateDatabase(hamFolder, spamFolder, dataBaseFile);

		java.io.File folder = new java.io.File(testFolder);
		java.io.File[] testFiles = folder.listFiles();

		SpamAnalyzer analyzer = new SpamAnalyzer(dataBaseFile);
		for (int i = 0; i < testFiles.length; i++) {
			MailMessage msg = MailMessage.load(testFiles[i].getAbsolutePath());
			System.out.println(msg.getSubject());
			double probability = analyzer.test(msg);
			printResult(probability);
		}
	}

	private static void teachAndCreateDatabase(String hamFolder, String spamFolder, String dataBaseFile) {
		java.io.File folder = new java.io.File(hamFolder);
		java.io.File[] hamFiles = folder.listFiles();

		folder = new java.io.File(spamFolder);
		java.io.File[] spamFiles = folder.listFiles();

		SpamAnalyzer analyzer = new SpamAnalyzer();

		for (int i = 0; i < hamFiles.length; i++) {
			MailMessage hamMailMessage;
			try {
				hamMailMessage = MailMessage.load(hamFiles[i].getAbsolutePath());
			} catch (Exception e) {
				continue;
			}

			System.out.println(i);
			analyzer.trainFilter(hamMailMessage, false);
		}

		for (int i = 0; i < spamFiles.length; i++) {
			MailMessage spamMailMessage;
			try {
				spamMailMessage = MailMessage.load(spamFiles[i].getAbsolutePath());
			} catch (Exception e) {
				continue;
			}

			System.out.println(i);
			analyzer.trainFilter(spamMailMessage, true);
		}

		analyzer.saveDatabase(dataBaseFile);
	}

	private static void printResult(double probability) {
		if (probability < 0.05)
			System.out.println("This is ham)");
		else if (probability > 0.95)
			System.out.println("This is spam)");
		else
			System.out.println("Maybe spam)");
	}
}
