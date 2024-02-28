package me.dragonl.survivalwars.players;

import io.fairyproject.bootstrap.bukkit.BukkitPlugin;
import io.fairyproject.bukkit.util.LegacyAdventureUtil;
import io.fairyproject.container.InjectableComponent;
import io.fairyproject.container.PostInitialize;
import io.fairyproject.mc.MCPlayer;
import io.fairyproject.mc.nametag.NameTagService;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

@InjectableComponent
public class DisplayNameTask extends BukkitRunnable{
    private final NameFormat nameFormat;
    private final NameTagService nameTagService;

    public DisplayNameTask(NameFormat nameFormat, NameTagService nameTagService) {
        this.nameFormat = nameFormat;
        this.nameTagService = nameTagService;
    }

    @PostInitialize
    public void init(){
        this.runTaskTimer(BukkitPlugin.INSTANCE,0,2);
    }

    public void run() {
        for(Player player : Bukkit.getOnlinePlayers()){
            MCPlayer mcPlayer = MCPlayer.from(player);
            mcPlayer.setDisplayName(LegacyAdventureUtil.decode(nameFormat.getMainNameFormat(player)));
            //player.setPlayerListName(nameFormat.getMainNameFormat(player));
            nameTagService.update(mcPlayer);
        }
    }
}
