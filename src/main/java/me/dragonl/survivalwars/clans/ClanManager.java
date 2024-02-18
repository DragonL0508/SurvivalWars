package me.dragonl.survivalwars.clans;

import io.fairyproject.container.InjectableComponent;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

@InjectableComponent
public class ClanManager {
    List<Clan> clanList = new ArrayList<>();
    public void createClan(Player leader, String name){
        Clan clan = new Clan();
        clan.addPlayer(leader);
        clan.setName(name);
        this.clanList.add(clan);
    }
    public Clan getClan(Player player){
        for(Clan clan : clanList){
            if(clan.getPlayers().contains(player)){
                return clan;
            }
        }
        return new Clan();
    }
    public List<Player> getClanPlayers(String name){
        for(Clan clan : clanList){
            if(clan.getName().equals(name))
                return clan.getPlayers();
        }
        return List.of();
    }
    public List<Player> getClanPlayers(Player player){
        for(Clan clan : clanList){
            if(clan.getPlayers().contains(player)){
                return clan.getPlayers();
            }
        }
        return List.of();
    }
}
