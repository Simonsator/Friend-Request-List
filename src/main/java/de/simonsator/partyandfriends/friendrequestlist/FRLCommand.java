package de.simonsator.partyandfriends.friendrequestlist;

import de.simonsator.partyandfriends.api.friends.abstractcommands.FriendSubCommand;
import de.simonsator.partyandfriends.api.pafplayers.OnlinePAFPlayer;
import de.simonsator.partyandfriends.api.pafplayers.PAFPlayer;
import de.simonsator.partyandfriends.utilities.PatterCollection;

import java.util.List;
import java.util.regex.Matcher;

import static de.simonsator.partyandfriends.main.Main.getInstance;

/**
 * @author Simonsator
 * @version 1.0.0 on 03.09.16.
 */
public class FRLCommand extends FriendSubCommand {
	public FRLCommand(String[] pCommands, int pPriority, String pHelp) {
		super(pCommands, pPriority, pHelp);
	}

	@Override
	public void onCommand(OnlinePAFPlayer pPlayer, String[] args) {
		String content = "";
		List<PAFPlayer> friendRequests = pPlayer.getRequests();
		if (friendRequests.isEmpty()) {
			pPlayer.sendMessage(getInstance().getFriendsPrefix() +
					FRL.getInstance().getConfig().getCreatedConfiguration().getString("Messages.NoFriendRequests"));
			return;
		}
		for (PAFPlayer player : friendRequests)
			content = content + getInstance().getMessagesYml().getString("Friends.General.RequestInfoOnJoinColor")
					+ player.getDisplayName()
					+ getInstance().getMessagesYml().getString("Friends.General.RequestInfoOnJoinColorComma")
					+ getInstance().getMessagesYml().getString("Friends.Command.List.PlayerSplit");
		content = content.substring(0, content.length() - (getInstance().getMessagesYml().getString("Friends.Command.List.PlayerSplit").length()));
		pPlayer.sendMessage(PatterCollection.FRIEND_REQUEST_COUNT_PATTERN.matcher(PatterCollection.FRIEND_REQUEST_PATTERN.matcher(getInstance().getFriendsPrefix() + getInstance()
				.getMessagesYml().getString("Friends.General.RequestInfoOnJoin")).replaceAll(Matcher.quoteReplacement(content))).
				replaceAll(Matcher.quoteReplacement(friendRequests.size() + "")));
	}
}
