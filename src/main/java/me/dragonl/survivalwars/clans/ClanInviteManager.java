package me.dragonl.survivalwars.clans;

import io.fairyproject.bukkit.util.LegacyAdventureUtil;
import io.fairyproject.container.InjectableComponent;
import io.fairyproject.mc.MCPlayer;
import net.kyori.adventure.Adventure;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@InjectableComponent
public class ClanInviteManager {
    Map<Player, List<Player>> playerInviteMap = new HashMap<>();
    public void invitePlayer(Player sender, Player player){
        List<Player> players = playerInviteMap.computeIfAbsent(sender, player1 -> new ArrayList<>());
        if(sender == player) {
            sender.sendMessage(ChatColor.RED + "You can not invite yourself!");
        } else if (playerInviteMap.get(sender).contains(player)) {
            sender.sendMessage(ChatColor.RED + "You have already invited this player!");
        } else {
            players.add(player);
            //messages
            sender.sendMessage(ChatColor.GREEN + "You invited " + player.getName() + " !");

            MCPlayer target = MCPlayer.from(player);
            Component message = LegacyAdventureUtil.decode("<yellow><name> has invited you to join their clan!</yellow>\n<click:run_command:'/clan accept'><green><hover:show_text:'click me!'>[accept]</hover></green></click>     <click:run_command:'/clan reject'><red><hover:show_text:'click me!'>[reject]</hover></red></click>", Placeholder.component("name",Component.text(sender.getName(), NamedTextColor.AQUA)));
            target.sendMessage(message);
        }
    }
    public void acceptPlayer(Player sender, Player player){

    }
    public void rejectPlayer(Player sender, Player player){
        
    }
}
