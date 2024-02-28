package me.dragonl.survivalwars.game.domain;

import me.dragonl.survivalwars.clans.Clan;
import org.bukkit.Location;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.Player;

import java.util.List;

public class Domain {
    private List<BaseBlock> baseBlocks;
    private Clan clan;
    private Player owner;
    private Blaze core;

    public Blaze getCore() {
        return core;
    }

    public void setCore(Blaze core) {
        this.core = core;
    }

    public List<BaseBlock> getBaseBlocks() {
        return baseBlocks;
    }

    public void setBaseBlocks(List<BaseBlock> baseBlocks) {
        this.baseBlocks = baseBlocks;
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
