package de.simonsator.partyandfriends.velocity.friendrequestlist;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Dependency;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import de.simonsator.partyandfriends.velocity.VelocityExtensionLoadingInfo;
import de.simonsator.partyandfriends.velocity.main.PAFPlugin;

import java.nio.file.Path;

@Plugin(id = "friend-request-list-command", name = "Friend-Request-List-Command", version = "1.0.4-RELEASE",
		url = "https://www.spigotmc.org/resources/30323/",
		description = "An add-on for party and friends extended to add a list all friend requests",
		authors = {"JT122406", "Simonsator"}, dependencies = {@Dependency(id = "partyandfriends")})
public class FRLLoader {

	private final Path folder;

	@Inject
	public FRLLoader(@DataDirectory final Path folder) {
		this.folder = folder;
	}

	@Subscribe
	public void onProxyInitialization(ProxyInitializeEvent event) {
		PAFPlugin.loadExtension(new VelocityExtensionLoadingInfo(new FRL(folder),
				"friend-request-list-command",
				"Friend-Request-List-Command",
				"1.0.4-RELEASE", "JT122406, Simonsator"));
	}

}
