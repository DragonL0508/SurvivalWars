package me.dragonl.survivalwars;

import io.fairyproject.FairyLaunch;
import io.fairyproject.bootstrap.bukkit.BukkitPlugin;
import io.fairyproject.log.Log;
import io.fairyproject.plugin.Plugin;
import me.dragonl.survivalwars.players.DisplayNameTask;
import me.dragonl.survivalwars.players.NameFormat;
import me.dragonl.survivalwars.worlds.WorldSetup;
import org.bukkit.Bukkit;
import org.bukkit.World;

@FairyLaunch
public class SurvivalWars extends Plugin {
    @Override
    public void onPluginEnable() {
        Log.info("Plugin Enabled.");
        runTasks();
        setupWorlds();
    }
    //load worlds
    public void setupWorlds(){
        for(World world : Bukkit.getWorlds()){
            new WorldSetup().gameRules(world);
        }
    }
    private void runTasks(){
        new MainTask().runTaskTimer(BukkitPlugin.INSTANCE, 0, 1);
    }
}