package me.dragonl.survivalwars.players;

import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerTeams;
import io.fairyproject.bukkit.util.LegacyAdventureUtil;
import io.fairyproject.container.InjectableComponent;
import io.fairyproject.mc.MCPlayer;
import io.fairyproject.mc.nametag.NameTag;
import io.fairyproject.mc.nametag.NameTagAdapter;
import me.dragonl.survivalwars.clans.ClanManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.entity.Player;

@InjectableComponent
public class PlayerNameTag extends NameTagAdapter {
    private final NameFormat nameFormat;

    public PlayerNameTag(NameFormat nameFormat) {
        super("nametag", 0);
        this.nameFormat = nameFormat;
    }

    @Override
    public NameTag fetch(MCPlayer player, MCPlayer target) {
        Player bukkitPlayer = target.as(Player.class);
        Component nameTagComponent = LegacyAdventureUtil.decode(nameFormat.getNamePrefix(bukkitPlayer));
        NameTag nameTag = new NameTag(nameTagComponent, Component.empty(), nameFormat.getNameColor(bukkitPlayer), WrapperPlayServerTeams.NameTagVisibility.ALWAYS);
        return nameTag;
    }
}
