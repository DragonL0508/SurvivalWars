package me.dragonl.survivalwars.game.domain;

import org.bukkit.Location;

public class SelectorPointLocation {
    private Location corner1;
    private Location corner2;

    public Location getCorner1() {
        return corner1;
    }

    public void setCorner1(Location corner1) {
        this.corner1 = corner1;
    }

    public Location getCorner2() {
        return corner2;
    }

    public void setCorner2(Location corner2) {
        this.corner2 = corner2;
    }
}
