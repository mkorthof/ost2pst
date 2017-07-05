package com.aspose.email.examples.outlook.pst;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.CRC32;

import com.aspose.email.FileFormatVersion;
import com.aspose.email.MapiProperty;
import com.aspose.email.MapiPropertyTag;
import com.aspose.email.PersonalStorage;
import com.aspose.email.examples.Utils;

public class PSTPasswordProtectionProperties {

	public static String dataDir = Utils.getSharedDataDir(ChangeAFoldersContainerClass.class) + "outlook/";

	public static void main(String[] args) {
		// Load the Outlook PST file
		PersonalStorage pst = PersonalStorage.fromFile(dataDir + "Outlook.pst");
		
		// Check for Password protection
		isPasswordProtected(pst);
		isPasswordValid("password", pst);
		
		//Removing/Reseting the PR_PST_PASSWORD Property
		resetThe_PR_PST_PASSWORD_Property();
		
		//Setting/Changing PST Password
		setPSTPassword();
	}

	private static boolean isPasswordProtected(PersonalStorage pst) {

		// If the property exists and is nonzero, then the PST file is password protected.
		if (pst.getStore().getProperties().containsKey(MapiPropertyTag.PR_PST_PASSWORD)) {
			long passwordHash = pst.getStore().getProperties().get_Item(MapiPropertyTag.PR_PST_PASSWORD).getLong();
			return passwordHash != 0;
		}
		return false;
	}

	private static boolean isPasswordValid(String password, PersonalStorage pst) {

		// If the property exists and is nonzero, then the PST file is password protected.
		if (pst.getStore().getProperties().containsKey(MapiPropertyTag.PR_PST_PASSWORD)) {
			// The property value contains the CRC-32 hash of the password string of PST.
			long passwordHash = pst.getStore().getProperties().get_Item(MapiPropertyTag.PR_PST_PASSWORD).getLong();

			CRC32 crc = new CRC32();
			crc.update(password.getBytes());

			return passwordHash != 0 && passwordHash == crc.getValue();
		}
		return false;
	}

	public static void resetThe_PR_PST_PASSWORD_Property() {
		PersonalStorage pst = PersonalStorage.fromFile(dataDir + "PersonalStorage.pst");

		if (pst.getStore().getProperties().containsKey(MapiPropertyTag.PR_PST_PASSWORD)) {
			MapiProperty property = new MapiProperty(MapiPropertyTag.PR_PST_PASSWORD, getBytes(0));
			pst.getStore().setProperty(property);
		}
	}

	//Helper method
	public static byte[] getBytes(int value) {
		ByteBuffer buffer = ByteBuffer.allocate(4).order(ByteOrder.nativeOrder());
		buffer.putInt(value);
		return buffer.array();
	}
	
	public static void setPSTPassword() {
		PersonalStorage pst = PersonalStorage.create(dataDir + "PersonalStorage_out.pst", FileFormatVersion.Unicode);
		{
		  // Set the password
		  String password = "Password1";
		  pst.getStore().changePassword(password);

		  // Remove the password
		  pst.getStore().changePassword(null);
		}
	}

}
