package com.aspose.email.examples.exchange.ews;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.aspose.email.EWSClient;
import com.aspose.email.ExchangeMessageInfoCollection;
import com.aspose.email.ExchangeQueryBuilder;
import com.aspose.email.IEWSClient;
import com.aspose.email.MailQuery;
import com.aspose.email.MailQueryBuilder;

public class FilterMessagesFromExchangeMailbox {

	public static void main(String[] args) {
		filterMessagesUsingEWS();
		filterMessagesBasedOnTodayDate();
		filterMessagesBasedOnDateRange();
		filterMessagesBasedOnSpecificSender();
		filterMessagesBasedOnSpecificDomain();
		filterMessagesBasedOnSpecificRecipient();
		combineQueriesWithAND();
		combiningQueriesWithOR();
		filterMessagesBasedCaseSensitivity();
	}

	public static void filterMessagesUsingEWS() {
		// Create instance of IEWSClient class by giving credentials
		IEWSClient client = EWSClient.getEWSClient("https://outlook.office365.com/ews/exchange.asmx", "testUser", "pwd", "domain");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		// Query building by means of ExchangeQueryBuilder class
		ExchangeQueryBuilder builder = new ExchangeQueryBuilder();
		// Subject contains "Newsletter"
		builder.getSubject().contains("Newsletter");

		// Emails that arrived today
		try {
			builder.getInternalDate().on(sdf.parse("10/05/2016 10:00:00"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// Build the query
		MailQuery query = builder.getQuery();

		// Get list of messages
		ExchangeMessageInfoCollection messages = client.listMessages(client.getMailboxInfo().getInboxUri(), query, false);
		System.out.println("Imap: " + messages.size() + " message(s) found.");
	}

	public static void filterMessagesBasedOnTodayDate() {
		// Emails that arrived today
		MailQueryBuilder builder = new MailQueryBuilder();
		builder.getInternalDate().on(new Date());
	}

	public static void filterMessagesBasedOnDateRange() {
		MailQueryBuilder builder = new MailQueryBuilder();
		builder.getInternalDate().beforeOrEqual(new Date());
		builder.getInternalDate().since(new Date(new Date().getTime() + TimeUnit.DAYS.toDays(1)));
	}
	
	public static void filterMessagesBasedOnSpecificSender() {
		MailQueryBuilder builder = new MailQueryBuilder();
		// Get emails from specific sender
		builder.getFrom().contains("saqib.razzaq@127.0.0.1");
	}
	
	public static void filterMessagesBasedOnSpecificDomain() {
		MailQueryBuilder builder = new MailQueryBuilder();
		// Get emails from specific domain
		builder.getFrom().contains("SpecificHost.com");
	}
	
	public static void filterMessagesBasedOnSpecificRecipient() {
		MailQueryBuilder builder = new MailQueryBuilder();
		// Get emails sent to specific recipient
		builder.getTo().contains("recipient");
	}
	
	public static void combineQueriesWithAND() {
		MailQueryBuilder builder = new MailQueryBuilder();

		// Emails from specific host
		builder.getFrom().contains("SpecificHost.com");
		// AND all emails that arrived before today
		builder.getInternalDate().before(new Date());
		// AND all emails that arrived since 7 days ago
		builder.getInternalDate().since(new Date(new Date().getTime() + TimeUnit.DAYS.toDays(-7)));
	}

	public static void combiningQueriesWithOR() {
		MailQueryBuilder builder = new MailQueryBuilder();
		
		// Specify OR condition
		builder.or(builder.getSubject().contains("test"), builder.getFrom().contains("noreply@host.com"));
	}
	
	public static void filterMessagesBasedCaseSensitivity() {
		//IgnoreCase is True
		MailQueryBuilder builder1 = new MailQueryBuilder();
		builder1.getFrom().contains("tesT", true);
		MailQuery query1 = builder1.getQuery();
	}
}
