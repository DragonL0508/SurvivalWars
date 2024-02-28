package me.dragonl.survivalwars.players;

import io.fairyproject.container.InjectableComponent;
import me.dragonl.survivalwars.clans.Clan;
import me.dragonl.survivalwars.clans.ClanManager;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

@InjectableComponent
public class NameFormat {
    private final ClanManager clanManager;

    public NameFormat(ClanManager clanManager) {
        this.clanManager = clanManager;
    }

    public String getMainNameFormat(Player player){
        if(!clanManager.isInClan(player))
            return ChatColor.WHITE + player.getName();

        Clan clan = clanManager.getClan(player);
        return ChatColor.GRAY + "[" + clan.getColor() + clan.getName() + ChatColor.GRAY + "] " + clan.getColor() + player.getName();
    }

    public String getNamePrefix(Player player){
        if(!clanManager.isInClan(player))
            return "";

        Clan clan = clanManager.getClan(player);
        return ChatColor.GRAY + "[" + clan.getColor() + clan.getName() + ChatColor.GRAY + "] " + clan.getColor();
    }

    public TextColor getNameColor(Player player){
        if(!clanManager.isInClan(player))
            return LegacyComponentSerializer.parseChar(ChatColor.WHITE.getChar()).color();

        Clan clan = clanManager.getClan(player);
        return LegacyComponentSerializer.parseChar(clan.getColor().getChar()).color();
    }
}
