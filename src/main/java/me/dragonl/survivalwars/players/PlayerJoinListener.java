package me.dragonl.survivalwars.players;

import io.fairyproject.bukkit.listener.RegisterAsListener;
import io.fairyproject.bukkit.util.LegacyAdventureUtil;
import io.fairyproject.container.InjectableComponent;
import io.fairyproject.mc.MCPlayer;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.Bukkit;
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
        Player player = event.getPlayer();
        MCPlayer mcPlayer = MCPlayer.from(player);

        Component message = LegacyAdventureUtil.decode("&aHello &eWorld!");

        mcPlayer.sendMessage(message);

        if(event.getPlayer().hasPlayedBefore())
            event.setJoinMessage(null);
        else
            event.setJoinMessage(ChatColor.GREEN + "[First Join] " + ChatColor.YELLOW + event.getPlayer().getName() + ChatColor.GREEN + " Join Survival Wars!");
    }
}
