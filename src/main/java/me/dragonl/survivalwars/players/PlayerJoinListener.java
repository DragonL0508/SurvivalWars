package me.dragonl.survivalwars.players;

import io.fairyproject.bukkit.listener.RegisterAsListener;
import io.fairyproject.bukkit.util.LegacyAdventureUtil;
import io.fairyproject.container.InjectableComponent;
import io.fairyproject.mc.MCPlayer;
import io.fairyproject.mc.nametag.NameTagService;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

@InjectableComponent
@RegisterAsListener
public class PlayerJoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        if(event.getPlayer().hasPlayedBefore())
            event.setJoinMessage(null);
        else
            event.setJoinMessage(ChatColor.GREEN + "[First Join] " + ChatColor.YELLOW + event.getPlayer().getName() + ChatColor.GREEN + " Join Survival Wars!");

        //PlayerListText
        Component header = LegacyAdventureUtil.decode("&aSurvival &fWars\n&7&m-----------------------------------");
        Component footer = LegacyAdventureUtil.decode("&7&m-----------------------------------\n&r&7A Hardcore Pvp Survival Game");
        Player player = event.getPlayer();
        MCPlayer mcPlayer = MCPlayer.from(player);
        mcPlayer.sendPlayerListHeader(header);
        mcPlayer.sendPlayerListFooter(footer);
    }
}
