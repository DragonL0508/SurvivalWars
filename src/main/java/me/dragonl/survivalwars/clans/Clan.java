package me.dragonl.survivalwars.clans;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import javax.swing.plaf.basic.BasicButtonUI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Clan {
    private String name;
    private List<UUID> players = new ArrayList<>();
    private UUID leader;

    public UUID getLeader() {
        return leader;
    }

    public void setLeader(UUID leader) {
        this.leader = leader;
    }

    private ChatColor color = ChatColor.WHITE;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getBukkitPlayers() {
        List<Player> playerList = new ArrayList<>();
        for(UUID uuid : players){
            playerList.add(Bukkit.getPlayer(uuid));
        }
        return playerList;
    }

    public List<UUID> getPlayersUUID() {
        return players;
    }

    public void addPlayer(Player player) {
        this.players.add(player.getUniqueId());
    }

    public void removePlayer(Player player){
        this.players.remove(player.getUniqueId());
    }

    public ChatColor getColor() {
        return color;
    }

    public void setColor(ChatColor color) {
        this.color = color;
    }
}
