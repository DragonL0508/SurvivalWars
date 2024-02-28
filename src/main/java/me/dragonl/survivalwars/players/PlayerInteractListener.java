package me.dragonl.survivalwars.players;

import io.fairyproject.bukkit.listener.RegisterAsListener;
import io.fairyproject.container.InjectableComponent;
import me.dragonl.survivalwars.game.domain.DomainSelector;
import me.dragonl.survivalwars.game.domain.SelectorPoint;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

@InjectableComponent
@RegisterAsListener
public class PlayerInteractListener implements Listener {
    private final DomainSelector domainSelector;

    public PlayerInteractListener(DomainSelector domainSelector) {
        this.domainSelector = domainSelector;
    }

    @EventHandler
    public void woodenShovel(PlayerInteractEvent event) {
        if(!event.getHand().equals(EquipmentSlot.HAND)) return;
        Player player = event.getPlayer();
        if (event.getAction() == Action.LEFT_CLICK_BLOCK && player.getItemInHand().getType() == Material.STICK) {
            domainSelector.select(player, SelectorPoint.first, event.getClickedBlock().getLocation());
            event.setCancelled(true);
        } else if (event.getAction() == Action.RIGHT_CLICK_BLOCK && player.getItemInHand().getType() == Material.STICK) {
            domainSelector.select(player, SelectorPoint.second, event.getClickedBlock().getLocation());
            event.setCancelled(true);
        }
    }
}
