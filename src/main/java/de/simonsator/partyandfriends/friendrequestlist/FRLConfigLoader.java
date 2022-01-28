package de.simonsator.partyandfriends.friendrequestlist;

import de.simonsator.partyandfriends.api.PAFExtension;
import de.simonsator.partyandfriends.utilities.ConfigurationCreator;

import java.io.File;
import java.io.IOException;

public class FRLConfigLoader extends ConfigurationCreator {
	protected FRLConfigLoader(File file, PAFExtension pPlugin) throws IOException {
		super(file, pPlugin, true);
		readFile();
		loadDefaultValues();
		saveFile();
		process();
	}

	private void loadDefaultValues() {
		set("Names", "requestlist", "listrequests", "friendrequestlist");
		set("Priority", 100);
		set("Messages.Help", "&8/&5friend listrequests &8- &7Lists your friend requests");
		set("Messages.NoFriendRequests", " &7Until now you did not receive any friend requests");
		set("Messages.Output", " &7You &7have &7friend &7requests &7from: [FRIENDREQUESTS]");
	}
}
