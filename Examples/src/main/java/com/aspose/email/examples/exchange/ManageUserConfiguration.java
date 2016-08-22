package com.aspose.email.examples.exchange;

import com.aspose.email.IEWSClient;
import com.aspose.email.UserConfiguration;
import com.aspose.email.UserConfigurationName;
import com.aspose.email.examples.Utils;

public class ManageUserConfiguration {

	public static void main(String[] args) {
		readUserConfiguration();
		
		createUserConfigurations();
		
		updateUserConfiguration();
		
		deleteUserConfiguration();
	}

	public static void readUserConfiguration() {
		IEWSClient client = Utils.getAsposeEWSClient();
		System.out.println("Connected to Exchange 2010");

		// Get the User Configuration for Inbox folder
		UserConfigurationName userConfigName = new UserConfigurationName("inbox.config", client.getMailboxInfo().getInboxUri());
		UserConfiguration userConfig = client.getUserConfiguration(userConfigName);

		System.out.println("Configuration Id: " + userConfig.getId());
		System.out.println("Configuration Name: " + userConfig.getUserConfigurationName().getName());
		System.out.println("Key value pairs:");
		for (String key : (String[]) userConfig.getDictionary().values().toArray()) {
			System.out.println(key + ": " + userConfig.getDictionary().get(key).toString());
		}
	}

	@SuppressWarnings("unchecked")
	public static void createUserConfigurations() {
		IEWSClient client = Utils.getAsposeEWSClient();
		System.out.println("Connected to Exchange 2010");

		// Create the User Configuration for Inbox folder
		UserConfigurationName userConfigName = new UserConfigurationName("inbox.config", client.getMailboxInfo().getInboxUri());
		UserConfiguration userConfig = new UserConfiguration(userConfigName);
		userConfig.getDictionary().put("key1", "value1");
		userConfig.getDictionary().put("key2", "value2");
		userConfig.getDictionary().put("key3", "value3");
		client.createUserConfiguration(userConfig);
	}

	@SuppressWarnings("unchecked")
	public static void updateUserConfiguration() {
		IEWSClient client = Utils.getAsposeEWSClient();
		System.out.println("Connected to Exchange 2010");

		// Get the User Configuration for Inbox folder
		UserConfigurationName userConfigName = new UserConfigurationName("inbox.config", client.getMailboxInfo().getInboxUri());
		UserConfiguration userConfig = client.getUserConfiguration(userConfigName);
		userConfig.setId(null);

		// Update User Configuration
		userConfig.getDictionary().put("key1", "new-value1");
		client.updateUserConfiguration(userConfig);
	}
	
	public static void deleteUserConfiguration() {
		IEWSClient client = Utils.getAsposeEWSClient();
		System.out.println("Connected to Exchange 2010");

		// Delete User Configuration
		UserConfigurationName userConfigName = new UserConfigurationName("inbox.config", client.getMailboxInfo().getInboxUri());
		client.deleteUserConfiguration(userConfigName);
	}

}
