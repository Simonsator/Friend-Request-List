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
	protected FRLConfigLoader(File file) {
		super(file);
		loadDefaultValues();
		process(getCreatedConfiguration());
	}

	private void loadDefaultValues() {
		set("Names", "requestlist", "listrequests", "friendrequestlist");
		set("Priority", 100);
		set("Messages.Help", "&7Lists your friend requests");
		set("Messages.NoFriends", "&8/&5friend listrequests &8- &7Lists your friend requests");
	}

	@Override
	public void reloadConfiguration() throws IOException {
		configuration = (new FRLConfigLoader(FILE)).getCreatedConfiguration();
	}
}
