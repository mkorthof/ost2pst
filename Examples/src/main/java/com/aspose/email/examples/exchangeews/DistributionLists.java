package com.aspose.email.examples.exchangeews;

import com.aspose.email.EWSClient;
import com.aspose.email.ExchangeDistributionList;
import com.aspose.email.IEWSClient;
import com.aspose.email.MailAddress;
import com.aspose.email.MailAddressCollection;
import com.aspose.email.MailMessage;

public class DistributionLists {

	public static void main(String[] args) {
		// Create Private Distribution List
		createPrivateDistributionList();

		//Fetch Private Distribution List
		fetchPrivateDistributionList();
			
		//Add members to Private Distribution List
		addMembersToPrivateDistributionList();
		
		//Add members without listing
		addMembersWithoutListing();
		
		//Delete members from Private Distribution List
		deleteMembersFromPrivateDistributionList();
		
		//Delete members without listing
		deleteMembersWithoutListing();
		
		//Delete Private Distribution List
		deletePrivateDistributionList();
		
		//Delete without Listing
		deleteWithoutListing();
		
		//Send to Private Distribution List
		sendToPrivateDistributionList();
		
		//Create MailAddress from Distribution List Id
		createMailAddressFromDistributionListId();
		
		//Expand Public Distribution List
		expandPublicDistributionList();
		
	}

	public static void createPrivateDistributionList() {
		IEWSClient client = EWSClient.getEWSClient("https://exchange.domain.com/exchangeews/Exchange.asmx/", "user", "password", "");
		ExchangeDistributionList distributionList = new ExchangeDistributionList();
		distributionList.setDisplayName("test private list");
		MailAddressCollection members = new MailAddressCollection();
		members.add("address1@host.com");
		members.add("address2@host.com");
		members.add("address3@host.com");
		client.createDistributionList(distributionList, members);
	}

	public static void fetchPrivateDistributionList() {
		IEWSClient client = EWSClient.getEWSClient("https://exchange.domain.com/exchangeews/Exchange.asmx/", "user", "password", "");
		ExchangeDistributionList[] distributionLists = client.listDistributionLists();
		for (ExchangeDistributionList distributionList : distributionLists) {
			MailAddressCollection members = client.fetchDistributionList(distributionList);
			for (MailAddress member : members) {

			}
		}
	}

	public static void addMembersToPrivateDistributionList() {
		IEWSClient client = EWSClient.getEWSClient("https://exchange.domain.com/exchangeews/Exchange.asmx/", "user", "password", "");
		ExchangeDistributionList[] distributionLists = client.listDistributionLists();
		MailAddressCollection newMembers = new MailAddressCollection();
		newMembers.add("address4@host.com");
		newMembers.add("address5@host.com");
		client.addToDistributionList(distributionLists[0], newMembers);
	}

	public static void addMembersWithoutListing() {
		IEWSClient client = EWSClient.getEWSClient("https://exchange.domain.com/exchangeews/Exchange.asmx/", "user", "password", "");
		ExchangeDistributionList distributionList = new ExchangeDistributionList();
		distributionList.setId("list's id");
		distributionList.setChangeKey("list's change key");
		MailAddressCollection newMembers = new MailAddressCollection();
		newMembers.add("address6@host.com");
		client.addToDistributionList(distributionList, newMembers);
	}
	
	public static void deleteMembersFromPrivateDistributionList() {
		IEWSClient client = EWSClient.getEWSClient("https://exchange.domain.com/exchangeews/Exchange.asmx/", "user", "password", "");
		ExchangeDistributionList[] distributionLists = client.listDistributionLists();
		MailAddressCollection members = client.fetchDistributionList(distributionLists[0]);
		MailAddressCollection membersToDelete = new MailAddressCollection();
		membersToDelete.addItem(members.get_Item(0));
		membersToDelete.addItem(members.get_Item(1));
		client.deleteFromDistributionList(distributionLists[0], membersToDelete);
	}
	
	public static void deleteMembersWithoutListing() {
		IEWSClient client = EWSClient.getEWSClient("https://exchange.domain.com/exchangeews/Exchange.asmx/", "user", "password", "");
		ExchangeDistributionList distributionList = new ExchangeDistributionList();
		distributionList.setId("list's id");
		distributionList.setChangeKey("list's change key");
		MailAddressCollection membersToDelete = new MailAddressCollection();
		MailAddress addressToDelete = new MailAddress("address", true);
		membersToDelete.addItem(addressToDelete);
		client.addToDistributionList(distributionList, membersToDelete);
	}

	public static void deletePrivateDistributionList() {
		IEWSClient client = EWSClient.getEWSClient("https://exchange.domain.com/exchangeews/Exchange.asmx/", "user", "password", "");
		ExchangeDistributionList[] distributionLists = client.listDistributionLists();
		client.deleteDistributionList(distributionLists[0], true);
	}
	
	public static void deleteWithoutListing() {
		IEWSClient client = EWSClient.getEWSClient("https://exchange.domain.com/exchangeews/Exchange.asmx/", "user", "password", "");
		ExchangeDistributionList distributionList = new ExchangeDistributionList();
		distributionList.setId("list's id");
		client.deleteDistributionList(distributionList, true);
	}
	
	public static void sendToPrivateDistributionList() {
		IEWSClient client = EWSClient.getEWSClient("https://exchange.domain.com/exchangeews/Exchange.asmx/", "user", "password", "");
		ExchangeDistributionList[] distributionLists = client.listDistributionLists();
		MailAddress distributionListAddress = distributionLists[0].toMailAddress();

		MailMessage message = new MailMessage(new MailAddress("from@host.com"), distributionListAddress);
		message.setSubject("sendToPrivateDistributionList");
		client.send(message);
	}

	public static void createMailAddressFromDistributionListId() {
		IEWSClient client = EWSClient.getEWSClient("https://exchange.domain.com/exchangeews/Exchange.asmx/", "user", "password", "");
		ExchangeDistributionList[] distributionLists = client.listDistributionLists();
		String id = distributionLists[0].getId();

		MailAddress distributionListAddress = new MailAddress("privateDL", true);
	}
	
	public static void expandPublicDistributionList() {
		IEWSClient client = EWSClient.getEWSClient("https://exchange.domain.com/exchangeews/Exchange.asmx/", "user", "password", "");
		MailAddressCollection members = client.expandDistributionList(new MailAddress("public.distribution.list@host.com"));
		for (MailAddress member : members) {
			// ...
		}
	}
}
