package de.simonsator.partyandfriends.friendrequestlist;

import de.simonsator.partyandfriends.main.Main;
import net.md_5.bungee.api.plugin.Plugin;

import java.io.File;

/**
 * @author Simonsator
 * @version 1.0.0 on 03.09.16.
 */
public class FRL extends Plugin {
	private FRLConfigLoader config;
	private static FRL instance;

	@Override
	public void onEnable() {
		instance = this;
		config = new FRLConfigLoader(new File(Main.getInstance().getDataFolder(), "config.yml"));
		Main.getInstance().getFriendsCommand().addCommand(
				new FRLCommand(config.getCreatedConfiguration().getStringList("Names").toArray(new String[0]),
						config.getCreatedConfiguration().getInt("Priority"), config.getCreatedConfiguration().getString("Messages.Help")));
	}

	public FRLConfigLoader getConfig() {
		return config;
	}

	public static FRL getInstance() {
		return instance;
	}
}
