package de.simonsator.partyandfriends.friendrequestlist;

import de.simonsator.partyandfriends.api.friends.abstractcommands.FriendSubCommand;
import de.simonsator.partyandfriends.api.pafplayers.OnlinePAFPlayer;
import de.simonsator.partyandfriends.api.pafplayers.PAFPlayer;
import de.simonsator.partyandfriends.friends.commands.Friends;
import de.simonsator.partyandfriends.main.Main;
import de.simonsator.partyandfriends.utilities.PatterCollection;

import java.util.List;
import java.util.regex.Matcher;

/**
 * @author Simonsator
 * @version 1.0.0 on 03.09.16.
 */
public class FRLCommand extends FriendSubCommand {
	private final int PLAYER_SPLIT_LENGTH = Main.getInstance().getMessages().getString("Friends.Command.List.PlayerSplit").length();

	public FRLCommand(String[] pCommands, int pPriority, String pHelp) {
		super(pCommands, pPriority, pHelp);
	}

	@Override
	public void onCommand(OnlinePAFPlayer pPlayer, String[] args) {
		List<PAFPlayer> friendRequests = pPlayer.getRequests();
		if (friendRequests.isEmpty()) {
			pPlayer.sendMessage(PREFIX +
					FRL.getInstance().getConfig().getString("Messages.NoFriendRequests"));
			return;
		}
		StringBuilder content = new StringBuilder();
		for (PAFPlayer player : friendRequests) {
			content.append(Main.getInstance().getMessages().getString("Friends.General.RequestInfoOnJoinColor"));
			content.append(player.getDisplayName());
			content.append(Main.getInstance().getMessages().getString("Friends.General.RequestInfoOnJoinColorComma"));
			content.append(Main.getInstance().getMessages().getString("Friends.Command.List.PlayerSplit"));
		}
		pPlayer.sendMessage(PatterCollection.FRIEND_REQUEST_COUNT_PATTERN.matcher(PatterCollection.FRIEND_REQUEST_PATTERN.matcher(Friends.getInstance().getPrefix() + Main.getInstance()
				.getMessages().getString("Friends.General.RequestInfoOnJoin")).replaceAll(Matcher.quoteReplacement(content.substring(0, content.length() - PLAYER_SPLIT_LENGTH)))).
				replaceAll(Matcher.quoteReplacement(friendRequests.size() + "")));
	}
}
