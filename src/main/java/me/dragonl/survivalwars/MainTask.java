package me.dragonl.survivalwars;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class MainTask extends BukkitRunnable {
    @Override
    public void run() {
        itemNameDisplay();
    }

    //Item Name Display
    public void itemNameDisplay() {
        for (World world : Bukkit.getWorlds()) {
            for (Entity entity : world.getEntities()) {
                if (entity.getType().equals(EntityType.DROPPED_ITEM)) {
                    Item item = (Item) entity;
                    String customName = ChatColor.GRAY + item.getItemStack().getType().name();
                    if (item.getItemStack().getAmount() > 1) {
                        customName += ChatColor.YELLOW + " x" + item.getItemStack().getAmount();
                    }
                    customName = customName.toLowerCase();
                    customName = customName.replace("_"," ");
                    item.setCustomName(customName);
                    item.setCustomNameVisible(true);
                }
            }
        }
    }
}
