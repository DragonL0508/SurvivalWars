package me.dragonl.survivalwars.game.domain;

import io.fairyproject.bukkit.command.event.BukkitCommandContext;
import io.fairyproject.bukkit.util.LegacyAdventureUtil;
import io.fairyproject.command.BaseCommand;
import io.fairyproject.command.annotation.Command;
import io.fairyproject.container.InjectableComponent;
import io.fairyproject.mc.MCPlayer;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

@Command(value = {"domain", "d"})
@InjectableComponent
public class DomainCommand extends BaseCommand {
    private final DomainManager domainManager ;
    private final DomainSelector domainSelector;

    public DomainCommand(DomainManager domainManager, SelectorPoint selectorPoint, DomainSelector domainSelector) {
        this.domainManager = domainManager;
        this.domainSelector = domainSelector;
    }

    @Command("create")
    public void createDomain(BukkitCommandContext ctx) {
        Player player = ctx.getPlayer();
        player.sendMessage(ChatColor.GREEN + "You created a new domain!");
        domainManager.createDomain(player, domainSelector.getSelectedLocation(player,SelectorPoint.first), domainSelector.getSelectedLocation(player,SelectorPoint.second));
    }

    @Command("check")
    public void checkDomain(BukkitCommandContext ctx) {
        Player player = ctx.getPlayer();
        MCPlayer mcPlayer = MCPlayer.from(player);
        Block block = player.getWorld().getBlockAt(player.getLocation());
        if(domainManager.isBlockInDomain(block)){
            Domain domain = domainManager.whatIsTheDomain(block);
            mcPlayer.sendMessage(LegacyAdventureUtil.decode("&aDomain owner: &e" + domain.getOwner().getName()));
        }else{
            player.sendMessage(ChatColor.RED + "You are not in a domain!");
        }
    }
}
