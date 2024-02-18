package me.dragonl.survivalwars.players;

import io.fairyproject.bukkit.listener.RegisterAsListener;
import io.fairyproject.container.InjectableComponent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.util.EulerAngle;

@InjectableComponent
@RegisterAsListener
public class PlayerDeathListener implements Listener {
    @EventHandler
    public void onDeath(PlayerDeathEvent event){

    }
}