package me.dragonl.survivalwars.players;

import io.fairyproject.bukkit.listener.RegisterAsListener;
import io.fairyproject.bukkit.util.LegacyAdventureUtil;
import io.fairyproject.container.InjectableComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import java.nio.Buffer;

@InjectableComponent
@RegisterAsListener
public class PlayerChatListener implements Listener {
    private final NameFormat nameFormat;

    public PlayerChatListener(NameFormat nameFormat) {
        this.nameFormat = nameFormat;
    }

    @EventHandler
    public void onChat(PlayerChatEvent event){
        Bukkit.broadcastMessage(LegacyAdventureUtil.decodeAndLegacy(nameFormat.getMainNameFormat(event.getPlayer()) + " &8: &r" + event.getMessage()));
        event.setCancelled(true);
    }
}
