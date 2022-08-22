package de.simonsator.partyandfriends.friendrequestlist.velocity;



import de.simonsator.partyandfriends.velocity.api.PAFExtension;
import de.simonsator.partyandfriends.velocity.friends.commands.Friends;
import de.simonsator.partyandfriends.velocity.utilities.ConfigurationCreator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class FRL extends PAFExtension {
	private static FRL instance;
	private ConfigurationCreator config;

	public FRL(Path folder) {
		super(folder);
	}

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

	@Override
	public String getName() {
		return "Friend-Request-List";
	}

	public ConfigurationCreator getConfig() {
		return config;
	}
}
