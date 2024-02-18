package me.dragonl.survivalwars.clans;

import org.bukkit.Color;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Clan {
    private String name;
    private List<Player> players = new ArrayList<>();
    private Color color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
