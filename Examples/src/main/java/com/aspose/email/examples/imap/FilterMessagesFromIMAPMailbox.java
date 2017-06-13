package com.aspose.email.examples.imap;

import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.Date;

import com.aspose.email.ImapClient;
import com.aspose.email.ImapFolderInfo;
import com.aspose.email.ImapMessageFlags;
import com.aspose.email.ImapMessageInfo;
import com.aspose.email.ImapMessageInfoCollection;
import com.aspose.email.ImapPageInfo;
import com.aspose.email.ImapQueryBuilder;
import com.aspose.email.MailQuery;
import com.aspose.email.MailQueryBuilder;
import com.aspose.email.SecurityOptions;
import com.aspose.email.system.collections.generic.List;

public class FilterMessagesFromIMAPMailbox {

	public static void main(String[] args) {
		// Filtering Messages from Mailbox
		filterMessagesFromMailbox();
		
		//  Filter emails on Today's Date
		filterEmailBasedOnTodayDate();
		
		// Filter emails on Date Range
		filterEmailBasedOnDateRange();
		
		// Filter emails on Specific Sender
		filterEmailBasedOnSpecificSender();
		
		// Filter emails on Specific Domain
		filterEmailBasedOnSpecificDomain();

		// Filter emails on Specific Recepient
		filterEmailBasedOnSpecificRecepient();

		// Filter and Display messages on Internal Date
		filterAndDisplayMessagesOnInternalDate();
		
		// Case Sensitive Email Filtering
		caseSensitiveEmailFiltering();
		
		// Specifying Encoding for Query Builder
		specifyEncodingForQueryBuilder();
		
		// Filter Messages and List with Paging Support
		filterMessagesAndListWithPagingSupport();
		
		//Filter Messages based on Custom Flag
		
	}

	public static void filterMessagesFromMailbox() {
		//Connect and log in to IMAP
		String host = "host";
		int port = 143;
		String username = "user@host.com";
		String password = "password";
		ImapClient client = new ImapClient(host, port, username, password);
		client.selectFolder("Inbox");

		//Set conditions
		ImapQueryBuilder builder = new ImapQueryBuilder();
		//Subject contains "Newsletter"
		builder.getSubject().contains("Newsletter");
		//Email that arrived today
		builder.getInternalDate().on(new Date());
		//Build the query
		MailQuery query = builder.getQuery();

		//Get list of messages
		ImapMessageInfoCollection messages = client.listMessages(query);
		System.out.println("Imap: " + messages.size() + " message(s) found.");
	}

	public static void filterEmailBasedOnTodayDate() {
		// Emails that arrived today
		Calendar c = Calendar.getInstance();
		c.set(2016, 04, 24, 14, 30, 0);
		MailQueryBuilder builder = new MailQueryBuilder();
		builder.getInternalDate().on(c.getTime());
	}

	public static void filterEmailBasedOnDateRange() {
		// Emails that arrived in last 7 days
		Calendar c1 = Calendar.getInstance();
		MailQueryBuilder builder = new MailQueryBuilder();
		builder.getInternalDate().before(c1.getTime());
		c1.set(2016, 04, 17, 14, 30, 0);
		builder.getInternalDate().since(c1.getTime());
	}

	public static void filterEmailBasedOnSpecificSender() {
		MailQueryBuilder builder = new MailQueryBuilder();
		// Get emails from specific sender
		builder.getFrom().contains("elon.musk@127.0.0.1");
	}

	public static void filterEmailBasedOnSpecificDomain() {
		MailQueryBuilder builder = new MailQueryBuilder();
		// Get emails from specific domain
		builder.getFrom().contains("SpecificHost.com");
	}

	public static void filterEmailBasedOnSpecificRecepient() {
		MailQueryBuilder builder = new MailQueryBuilder();
		// Get emails sent to specific recipient
		builder.getTo().contains("recipient");
	}

	public static void filterAndDisplayMessagesOnInternalDate() {
		// Connect and log in to IMAP
		String host = "host";
		int port = 143;
		String username = "user@host.com";
		String password = "password";
		ImapClient client = new ImapClient(host, port, username, password);
		client.selectFolder("Inbox");

		// Set conditions
		ImapQueryBuilder builder = new ImapQueryBuilder();
		// Subject contains "Newsletter"
		builder.getSubject().contains("Newsletter");
		// Emails that arrived today
		Calendar c2 = Calendar.getInstance();
		builder.getInternalDate().on(c2.getTime());
		// Build the query
		MailQuery query = builder.getQuery();

		// Get list of messages
		ImapMessageInfoCollection messages = client.listMessages(query);

		for (ImapMessageInfo info : messages) {
			System.out.println("Internal Date: " + info.getInternalDate().getTime());
		}
	}

	public static void caseSensitiveEmailFiltering() {
		// Set conditions
		ImapQueryBuilder builder = new ImapQueryBuilder();
		// Subject contains "Newsletter"
		builder.getSubject().contains("Newsletter", true);
		// Emails that arrived today
		Calendar c2 = Calendar.getInstance();
		builder.getInternalDate().on(c2.getTime());
		// Build the query
		MailQuery query = builder.getQuery();
	}

	public static void specifyEncodingForQueryBuilder() {
		ImapQueryBuilder builder = new ImapQueryBuilder(Charset.forName("UTF-8"));
		builder.getSubject().contains("ğüşıöç", true);
		MailQuery query = builder.getQuery();
	}

	public static void filterMessagesAndListWithPagingSupport() {

		ImapClient client = new ImapClient("host.domain.com", 889, "username", "password");
		client.setSecurityOptions(SecurityOptions.Auto);

		//Number of items per page
		int itemsPerPage = 5;

		//Search string
		String body = "2222222222222";

		//Define query builder
		ImapQueryBuilder iqb = new ImapQueryBuilder();

		iqb.getBody().contains(body);

		MailQuery query = iqb.getQuery();

		//Select the inbox folder where the messages with such body reside
		client.selectFolder(ImapFolderInfo.IN_BOX);

		//Search with normal list messages for reference - without paging
		ImapMessageInfoCollection totalMessageInfoCol = client.listMessages(query);

		List<ImapPageInfo> pages = new List<ImapPageInfo>();

		//search the messages with paging support
		ImapPageInfo pageInfo = client.listMessagesByPage(ImapFolderInfo.IN_BOX, query, itemsPerPage);

		pages.add(pageInfo);

		while (!pageInfo.getLastPage()) {
			pageInfo = client.listMessagesByPage(ImapFolderInfo.IN_BOX, query, pageInfo.getNextPage());

			pages.add(pageInfo);
		}

		int retrievedItems = 0;

		//verify  the number of items retrieved
		for (ImapPageInfo folderCol : (Iterable<ImapPageInfo>) pages)
			retrievedItems += folderCol.getItems().size();

		client.dispose();
	}
	
	public static void filterMessagesOnCustomFlag()
	{
		//ExStart: GetMessageWithCustomFlag
		ImapQueryBuilder queryBuilder = new ImapQueryBuilder();

		queryBuilder.hasFlags(ImapMessageFlags.keyword("custom1"));

		queryBuilder.hasNoFlags(ImapMessageFlags.keyword("custom2"));
		//ExEnd: GetMessageWithCustomFlag
	}
}
