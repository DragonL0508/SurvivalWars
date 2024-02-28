package me.dragonl.survivalwars.game.domain;

import me.dragonl.survivalwars.clans.Clan;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;

public class Domain {
    private List<BaseBlock> baseBlocks;
    private Location corner1;
    private Location corner2;
    private Clan clan;
    private Player owner;

    public List<BaseBlock> getBaseBlocks() {
        return baseBlocks;
    }

    public void setBaseBlocks(List<BaseBlock> baseBlocks) {
        this.baseBlocks = baseBlocks;
    }

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

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }
}
