package me.dragonl.survivalwars.clans;

import io.fairyproject.bukkit.util.LegacyAdventureUtil;
import io.fairyproject.container.InjectableComponent;
import io.fairyproject.mc.MCPlayer;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@InjectableComponent
public class ClanManager {
    List<Clan> clanList = new ArrayList<>();

    public void createClan(Player leader, String name) {
        if (isInClan(leader)) {
            leader.getPlayer().sendMessage(ChatColor.RED + "You are in a team and cannot create a new team now!");
        } else if (isClanExists(name)) {
            leader.getPlayer().sendMessage(ChatColor.RED + "The name is already exists!");
        } else {
            Clan clan = new Clan();
            clan.addPlayer(leader);
            clan.setName(name);
            clan.setLeader(leader.getUniqueId());
            this.clanList.add(clan);
            leader.getPlayer().sendMessage(ChatColor.GREEN + "You created a clan!");
        }
    }

    public void joinClan(Player player, Clan clan) {
        clan.addPlayer(player);
        for (Player p : clan.getBukkitPlayers()) {
            p.sendMessage(ChatColor.YELLOW + player.getName() + " joined the clan!");
        }
    }

    public void leaveClan(Player player) {
        Clan clan = getClan(player);
        MCPlayer mcPlayer = MCPlayer.from(player);
        if (!isInClan(player)) {
            player.sendMessage(ChatColor.RED + "You are not in a clan!");
        } else {
            mcPlayer.sendMessage(LegacyAdventureUtil.decode("&cYou left the team : " + clan.getName()));
            clan.removePlayer(player);

            if (clan.getLeader() == player.getUniqueId() && !clan.getPlayersUUID().isEmpty())
                clan.setLeader(clan.getPlayersUUID().get(0));
        }
    }

    public void disbandClan(Player player) {
        Clan clan = getClan(player);
        if (!isInClan(player)) {
            player.sendMessage(ChatColor.RED + "You are not in a clan!");
        } else if (clan.getLeader() != player.getUniqueId()) {
            player.sendMessage(ChatColor.RED + "You are not clan leader!");
        } else {
            player.sendMessage(ChatColor.YELLOW + "You disbanded the clan!");
            for(Player p : clan.getBukkitPlayers()){
                p.sendMessage(ChatColor.YELLOW + "Team leader disbanded the clan!");
                leaveClan(p);
            }
            clanList.remove(clan);
        }
    }

    public Clan getClan(Player player) {
        for (Clan clan : clanList) {
            if (clan.getBukkitPlayers().contains(player)) {
                return clan;
            }
        }
        return new Clan();
    }

    public boolean isInClan(Player player) {
        for (Clan clan : clanList) {
            if (clan.getBukkitPlayers().contains(player)) {
                return true;
            }
        }
        return false;
    }

    public boolean isClanExists(String name) {
        for (Clan clan : clanList) {
            if (Objects.equals(clan.getName(), name))
                return true;
        }
        return false;
    }

    public List<Player> getClanPlayers(String name) {
        for (Clan clan : clanList) {
            if (clan.getName().equals(name))
                return clan.getBukkitPlayers();
        }
        return List.of();
    }

    public List<Player> getClanPlayers(Player player) {
        for (Clan clan : clanList) {
            if (clan.getBukkitPlayers().contains(player)) {
                return clan.getBukkitPlayers();
            }
        }
        return List.of();
    }
}
