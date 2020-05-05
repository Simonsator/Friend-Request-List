package de.simonsator.partyandfriends.friendrequestlist;

import de.simonsator.partyandfriends.api.PAFExtension;
import de.simonsator.partyandfriends.friends.commands.Friends;
import de.simonsator.partyandfriends.utilities.ConfigurationCreator;

import java.io.File;
import java.io.IOException;

/**
 * @author Simonsator
 * @version 1.0.0 on 03.09.16.
 */
public class FRL extends PAFExtension {
	private ConfigurationCreator config;
	private static FRL instance;

	@Override
	public void onEnable() {
		instance = this;
		try {
			config = new FRLConfigLoader(new File(getConfigFolder(), "config.yml"), this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Friends.getInstance().addCommand(
				new FRLCommand(config.getStringList("Names").toArray(new String[0]),
						config.getInt("Priority"), config.getString("Messages.Help")));
	}

	public ConfigurationCreator getConfig() {
		return config;
	}

	public static FRL getInstance() {
		return instance;
	}
}
