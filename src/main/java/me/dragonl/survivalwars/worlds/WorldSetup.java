package me.dragonl.survivalwars.worlds;

import io.fairyproject.container.InjectableComponent;
import org.bukkit.GameRule;
import org.bukkit.World;

@InjectableComponent
public class WorldSetup {
    public void gameRules(World world){
        world.setGameRule(GameRule.DO_IMMEDIATE_RESPAWN,true);
        world.setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, false);
        world.setGameRule(GameRule.PLAYERS_SLEEPING_PERCENTAGE, 50);
    }
}
