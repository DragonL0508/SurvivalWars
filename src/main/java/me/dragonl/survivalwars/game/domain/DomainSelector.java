package me.dragonl.survivalwars.game.domain;

import io.fairyproject.bukkit.util.LegacyAdventureUtil;
import io.fairyproject.container.InjectableComponent;
import io.fairyproject.mc.MCPlayer;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@InjectableComponent
public class DomainSelector {
    Map<Player, SelectorPointLocation> playerSelectorPointLocationMap = new HashMap<>();

    public void select(Player player, SelectorPoint selectorPoint, Location location) {
        MCPlayer mcPlayer = MCPlayer.from(player);
        int x = location.getBlockX(), y = location.getBlockY(), z = location.getBlockZ();
        mcPlayer.sendMessage(LegacyAdventureUtil.decode("&aYou selected the " + selectorPoint.toString() + " point! &e(" + x + ", " + y + ", " + z + ")"));

        //save point Location
        SelectorPointLocation selectorPointLocation = playerSelectorPointLocationMap.computeIfAbsent(player, player1 -> new SelectorPointLocation());
        if (selectorPoint == SelectorPoint.first) {
            selectorPointLocation.setCorner1(location);
            playerSelectorPointLocationMap.put(player, selectorPointLocation);
        } else {
            selectorPointLocation.setCorner2(location);
            playerSelectorPointLocationMap.put(player, selectorPointLocation);
        }
    }

    public Location getSelectedLocation(Player player, SelectorPoint selectorPoint) {
        if(selectorPoint == SelectorPoint.first)
            return playerSelectorPointLocationMap.get(player).getCorner1();
        else
            return playerSelectorPointLocationMap.get(player).getCorner2();
    }
}