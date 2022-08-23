package de.simonsator.partyandfriends.velocity.friendrequestlist;

import de.simonsator.partyandfriends.api.PAFExtension;
import de.simonsator.partyandfriends.friends.commands.Friends;
import de.simonsator.partyandfriends.utilities.ConfigurationCreator;

import java.io.File;
import java.io.IOException;

public class FRL extends PAFExtension {
	private static FRL instance;
	private ConfigurationCreator config;

	public static FRL getInstance() {
		return instance;
	}

	@Override
	public void onEnable() {
		instance = this;
		try {
			config = new FRLConfigLoader(new File(getConfigFolder(), "config.yml"), this);
			Friends.getInstance().addCommand(
					new FRLCommand(config.getStringList("Names").toArray(new String[0]),
							config.getInt("Priority"), config.getString("Messages.Help")));
			registerAsExtension();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ConfigurationCreator getConfig() {
		return config;
	}
}
