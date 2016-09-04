package de.simonsator.partyandfriends.friendrequestlist;

import de.simonsator.partyandfriends.utilities.ConfigLoader;
import de.simonsator.partyandfriends.utilities.ConfigurationCreator;

import java.io.File;
import java.io.IOException;

/**
 * @author Simonsator
 * @version 1.0.0 on 03.09.16.
 */
public class FRLConfigLoader extends ConfigurationCreator {
	protected FRLConfigLoader(File file) throws IOException {
		super(file);
		readFile();
		loadDefaultValues();
		saveFile();
		process(getCreatedConfiguration());
	}

	private void loadDefaultValues() {
		set("Names", "requestlist", "listrequests", "friendrequestlist");
		set("Priority", 100);
		set("Messages.Help", "&8/&5friend listrequests &8- &7Lists your friend requests");
		set("Messages.NoFriendRequests", " &7Until now you did not receive any friend requests");
	}

	@Override
	public void reloadConfiguration() throws IOException {
		configuration = (new FRLConfigLoader(FILE)).getCreatedConfiguration();
	}
}
