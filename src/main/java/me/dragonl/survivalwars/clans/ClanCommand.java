package me.dragonl.survivalwars.clans;

import io.fairyproject.bukkit.command.event.BukkitCommandContext;
import io.fairyproject.command.BaseCommand;
import io.fairyproject.command.annotation.Arg;
import io.fairyproject.command.annotation.Command;
import io.fairyproject.container.InjectableComponent;
import org.bukkit.entity.Player;

@Command(value = "clan")
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
        this.clanManager.createClan(ctx.getPlayer(), name);
        ctx.getPlayer().sendMessage("hey you create a clan!");
    }

    @Command("list")
    public void playersList(BukkitCommandContext ctx) {
        Player player = ctx.getPlayer();
        player.sendMessage("Clan " + clanManager.getClan(player).getName() + " Player List:");
        player.sendMessage(clanManager.getClanPlayers(player).toString());
    }

    @Command("invite")
    public void clanInvite(BukkitCommandContext ctx, @Arg("player") Player player){
        Player sender = ctx.getPlayer();
        clanInviteManager.invitePlayer(sender,player);
    }

    @Command("accept")
    public void acceptInvite(BukkitCommandContext ctx, @Arg("player") Player player){
        ctx.getPlayer().sendMessage("accept!");
    }

    @Command("reject")
    public void rejectInvite(BukkitCommandContext ctx, @Arg("player") Player player){
        ctx.getPlayer().sendMessage("reject!");
    }
}
