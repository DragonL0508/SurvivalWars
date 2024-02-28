package me.dragonl.survivalwars.players;

import io.fairyproject.bukkit.events.player.PlayerDamageByPlayerEvent;
import io.fairyproject.bukkit.listener.RegisterAsListener;
import io.fairyproject.container.InjectableComponent;
import me.dragonl.survivalwars.clans.ClanManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

@InjectableComponent
@RegisterAsListener
public class PlayerFriendlyFireListener implements Listener {
    private final ClanManager clanManager;

    public PlayerFriendlyFireListener(ClanManager clanManager) {
        this.clanManager = clanManager;
    }

    @EventHandler
    public void playerAttack(PlayerDamageByPlayerEvent event){
        if(clanManager.getClan(event.getDamager()) == clanManager.getClan(event.getPlayer())){
            event.setCancelled(true);
        }
    }
}
