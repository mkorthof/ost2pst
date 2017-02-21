package com.aspose.email.examples.exchange.ews;

import com.aspose.email.ExchangeConversation;
import com.aspose.email.IEWSClient;
import com.aspose.email.examples.Utils;

public class ManageConversationItems {

	public static void main(String[] args) {
		findConversations();
		copyConversations();
		moveConversations();
		deleteConversations();
	}

	public static void findConversations() {
		IEWSClient client = Utils.getAsposeEWSClient();
		System.out.println("Connected to Exchange 2010");

		// Find Conversation Items in the Inbox folder
		ExchangeConversation[] conversations = client.findConversations(client.getMailboxInfo().getInboxUri());
		// Show all conversations
		for (ExchangeConversation conversation : conversations) {
			// Display conversation properties like Id and Topic
			System.out.println("Topic: " + conversation.getConversationTopic());
			System.out.println("Flag Status: " + conversation.getFlagStatus());
			System.out.println();
		}
	}
	
	public static void copyConversations() {
		IEWSClient client = Utils.getAsposeEWSClient();
		System.out.println("Connected to Exchange 2010");

		// Find those Conversation Items in the Inbox folder which we want to copy
		ExchangeConversation[] conversations = client.findConversations(client.getMailboxInfo().getInboxUri());

		for(ExchangeConversation conversation : conversations) {
		    // Display topic
		    System.out.println("Topic: " + conversation.getConversationTopic());
		    // Copy the conversation item based on some condition
		    if (conversation.getConversationTopic().contains("test email") == true) {
		        client.copyConversationItems(conversation.getConversationId(), client.getMailboxInfo().getDeletedItemsUri());
		        System.out.println("Copied the conversation item to another folder");
		    }
		}
	}
	
	public static void moveConversations() {
		IEWSClient client = Utils.getAsposeEWSClient();
		System.out.println("Connected to Exchange 2010");

		// Find those Conversation Items in the Inbox folder which we want to move
		ExchangeConversation[] conversations = client.findConversations(client.getMailboxInfo().getInboxUri());

		for (ExchangeConversation conversation : conversations) {
		    // Display topic
		    System.out.println("Topic: " + conversation.getConversationTopic());

		    // Move the conversation item based on some condition
		    if (conversation.getConversationTopic().contains("test email") == true)
		    {
		        client.moveConversationItems(conversation.getConversationId(), client.getMailboxInfo().getDeletedItemsUri());
		        System.out.println("Moved the conversation item to another folder");
		    }
		}
	}
	
	public static void deleteConversations() {
		IEWSClient client = Utils.getAsposeEWSClient();
		System.out.println("Connected to Exchange 2010");

		// Find those Conversation Items in the Inbox folder which we want to delete
		ExchangeConversation[] conversations = client.findConversations(client.getMailboxInfo().getInboxUri());

		for (ExchangeConversation conversation : conversations) {
		    // Display topic
		    System.out.println("Topic: " + conversation.getConversationTopic());

		    // Delete the conversation item based on some condition
		    if (conversation.getConversationTopic().contains("test email") == true)
		    {
		        client.deleteConversationItems(conversation.getConversationId());
		        System.out.println("Deleted the conversation item");
		    }
		}
	}
}
