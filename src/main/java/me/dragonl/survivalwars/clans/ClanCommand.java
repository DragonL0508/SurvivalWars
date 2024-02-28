package me.dragonl.survivalwars.clans;

import io.fairyproject.bukkit.command.event.BukkitCommandContext;
import io.fairyproject.bukkit.util.LegacyAdventureUtil;
import io.fairyproject.command.BaseCommand;
import io.fairyproject.command.annotation.Arg;
import io.fairyproject.command.annotation.Command;
import io.fairyproject.container.InjectableComponent;
import io.fairyproject.mc.MCPlayer;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.checkerframework.checker.units.qual.C;

import java.awt.*;

@Command(value = {"clan","c"})
@InjectableComponent
public class ClanCommand extends BaseCommand {
    private final ClanManager clanManager;
    private final ClanInviteManager clanInviteManager;
    public ClanCommand(ClanManager clanManager, ClanInviteManager clanInviteManager) {
        this.clanManager = clanManager;
        this.clanInviteManager = clanInviteManager;
    }

    @Command("create")
    public void createClan(BukkitCommandContext ctx, @Arg("name") String name) {
        clanManager.createClan(ctx.getPlayer(), name);
    }

    @Command("list")
    public void playersList(BukkitCommandContext ctx) {
        Player player = ctx.getPlayer();
        MCPlayer mcPlayer = MCPlayer.from(player);
        mcPlayer.sendMessage(LegacyAdventureUtil.decode("&eClan " + clanManager.getClan(player).getName() + " &ePlayer List:"));

        for(Player p : clanManager.getClanPlayers(player)){
            if(clanManager.getClan(p).getLeader() == p.getUniqueId())
                player.sendMessage(ChatColor.GRAY + "- " + ChatColor.GREEN + p.getName() + ChatColor.GRAY + " (Leader)");
            else
                player.sendMessage(ChatColor.GRAY + "- " + ChatColor.GREEN + p.getName());
        }
    }

    @Command("invite")
    public void clanInvite(BukkitCommandContext ctx, @Arg("player") Player player){
        Player sender = ctx.getPlayer();
        clanInviteManager.invitePlayer(sender,player);
    }

    @Command("accept")
    public void acceptInvite(BukkitCommandContext ctx, @Arg("player") Player player){
        Player sender = ctx.getPlayer();
        clanInviteManager.acceptPlayer(sender,player);
    }

    @Command("reject")
    public void rejectInvite(BukkitCommandContext ctx, @Arg("player") Player player){
        Player sender = ctx.getPlayer();
        clanInviteManager.rejectPlayer(sender,player);
    }

    @Command("leave")
    public void leaveClan(BukkitCommandContext ctx){
        Player sender = ctx.getPlayer();
        clanManager.leaveClan(sender);
    }

    @Command("disband")
    public void disbandClan(BukkitCommandContext ctx){
        Player sender = ctx.getPlayer();
        clanManager.disbandClan(sender);
    }
}
