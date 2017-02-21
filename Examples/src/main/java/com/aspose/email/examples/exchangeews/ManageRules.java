package com.aspose.email.examples.exchangeews;

import com.aspose.email.EWSClient;
import com.aspose.email.IEWSClient;
import com.aspose.email.InboxRule;
import com.aspose.email.MailAddress;
import com.aspose.email.RuleActions;
import com.aspose.email.RulePredicates;

public class ManageRules {

	public static void main(String[] args) {
		// Read Rules
		readRules();
		
		// Creating a New Rule
		createANewRule();
		
		// Updating a Rule
		updateARule();
	}

	private static IEWSClient getAsposeEWSClient() {
		// Create instance of IEWSClient class by giving credentials
		IEWSClient client = EWSClient.getEWSClient("https://outlook.office365.com/exchangeews/exchange.asmx", "testUser", "pwd", "domain");

		// Return the instance of IEWSClient class
		return client;
	}

	public static void readRules() {
		IEWSClient client = getAsposeEWSClient();
		System.out.println("Connected to Exchange server");

		// Get all Inbox Rules
		InboxRule[] inboxRules = client.getInboxRules();

		// Display information about each rule
		for (InboxRule inboxRule : inboxRules) {
			// Display name of the rule
			System.out.println("Display Name: " + inboxRule.getDisplayName());

			// Conditions included in this rule
			System.out.println("Conditions: ");

			// Check if there is a "From Address" condition
			if (inboxRule.getConditions().getFromAddresses().size() > 0) {
				for (MailAddress fromAddress : inboxRule.getConditions().getFromAddresses()) {
					System.out.println("From: " + fromAddress.getDisplayName() + " - " + fromAddress.getAddress());
				}
			}

			// Check if there is a "Subject Contains" condition
			if (inboxRule.getConditions().containsSubjectStrings().size() > 0) {
				for (String subject : inboxRule.getConditions().containsSubjectStrings()) {
					System.out.println("Subject contains: " + subject);
				}
			}

			// Actions included in this rule
			System.out.println("Actions: ");

			// Check if there is a "Move to Folder" action
			if (inboxRule.getActions().getMoveToFolder().length() > 0) {
				System.out.println("Move message to folder: " + inboxRule.getActions().getMoveToFolder());
			}
		}
	}

	public static void createANewRule() {
		IEWSClient client = getAsposeEWSClient();
		System.out.println("Connected to Exchange server");

		InboxRule rule = new InboxRule();
		rule.setDisplayName("Message from client ABC");

		// Add conditions
		RulePredicates newRules = new RulePredicates();
		// Subject contains string "ABC"
		newRules.containsSubjectStrings().addItem("ABC");
		// From address is administrator@ex2010.local
		newRules.getFromAddresses().add("administrator@ex2010.local");
		// Add the conditions
		rule.setConditions(newRules);

		// Add Actions
		RuleActions newActions = new RuleActions();
		// Move the message to a folder
		newActions.setMoveToFolder("120:AAMkADFjMjNjMmNjLWE3NzgtNGIzNC05OGIyLTAwNTgzNjRhN2EzNgAuAAAAAABbwP+Tkhs0TKx1GMf0D/cPAQD2lptUqri0QqRtJVHwOKJDAAACL5KNAAA=AQAAAA==");
		// Add the actions
		rule.setActions(newActions);

		client.createInboxRule(rule);
	}
	
	public static void updateARule() {
		IEWSClient client = getAsposeEWSClient();
		System.out.println("Connected to Exchange server");

		// Get all Inbox Rules
		InboxRule[] inboxRules = client.getInboxRules();

		// Loop through each rule
		for (InboxRule inboxRule : inboxRules) {
		    // Display name of the rule
		    System.out.println("Display Name: " + inboxRule.getDisplayName());
		    if (inboxRule.getDisplayName() == "Message from client ABC") {
		        System.out.println("Updating the rule....");
		        
		        // Add a new condition. From address
		        inboxRule.getConditions().getFromAddresses().set_Item(0, new MailAddress("administrator@ex2010.local", true));
		        client.updateInboxRule(inboxRule);
		    }
		}
	}
}