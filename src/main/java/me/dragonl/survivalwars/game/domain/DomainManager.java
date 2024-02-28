package me.dragonl.survivalwars.game.domain;

import com.google.common.collect.Lists;
import io.fairyproject.container.InjectableComponent;
import me.dragonl.survivalwars.clans.ClanManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

@InjectableComponent
public class DomainManager {
    private final ClanManager clanManager;
    List<Domain> domainList = new ArrayList<>();
    List<BaseBlockCondition> baseBlockConditions = Lists.newArrayList(
            new BaseBlockConditionIsBlock()
//            new BaseBlockConditionBlackList(
//                    Lists.newArrayList(
//                            Material.DIAMOND_BLOCK
//                    )
//            )
    );

    public DomainManager(ClanManager clanManager) {
        this.clanManager = clanManager;
    }

    public void createDomain(Player player, Location corner1, Location corner2) {
        Domain domain = new Domain();
        domain.setOwner(player);
        domain.setClan(clanManager.getClan(player));
        domain.setCorner1(corner1);
        domain.setCorner2(corner2);
        domain.setBaseBlocks(getBaseBlocks(corner1, corner2));
        domainList.add(domain);
    }

    public List<BaseBlock> getBaseBlocks(Location corner1, Location corner2) {
        List<BaseBlock> baseBlocks = new ArrayList<>();
        World world = corner1.getWorld();

        int minX = Math.min(corner1.getBlockX(), corner2.getBlockX());
        int minY = Math.min(corner1.getBlockY(), corner2.getBlockY());
        int minZ = Math.min(corner1.getBlockZ(), corner2.getBlockZ());

        int maxX = Math.max(corner1.getBlockX(), corner2.getBlockX());
        int maxY = Math.max(corner1.getBlockY(), corner2.getBlockY());
        int maxZ = Math.max(corner1.getBlockZ(), corner2.getBlockZ());

        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                for (int z = minZ; z <= maxZ; z++) {
                    Location blockLoc = new Location(world, x, y, z);
                    if (isAbleToBeBaseBlock(blockLoc.getBlock())) {
                        BaseBlock baseBlock = new BaseBlock();
                        baseBlock.setMaxHealth(10);
                        baseBlock.setHealth(10);
                        baseBlock.setLocation(blockLoc);
                        baseBlocks.add(baseBlock);
                    }
                }
            }
        }
        return baseBlocks;
    }

    public boolean isBlockInDomain(Block block) {
        Location blockLoc = block.getLocation();
        for(Domain domain : domainList){
            Location corner1 = domain.getCorner1();
            Location corner2 = domain.getCorner2();
            World world = corner1.getWorld();

            int minX = Math.min(corner1.getBlockX(), corner2.getBlockX());
            int minY = Math.min(corner1.getBlockY(), corner2.getBlockY());
            int minZ = Math.min(corner1.getBlockZ(), corner2.getBlockZ());

            int maxX = Math.max(corner1.getBlockX(), corner2.getBlockX());
            int maxY = Math.max(corner1.getBlockY(), corner2.getBlockY());
            int maxZ = Math.max(corner1.getBlockZ(), corner2.getBlockZ());

            for (int x = minX; x <= maxX; x++) {
                for (int y = minY; y <= maxY; y++) {
                    for (int z = minZ; z <= maxZ; z++) {
                        if(blockLoc.equals(new Location(world, x, y, z)))
                            return true;
                    }
                }
            }
        }
        return false;
    }

    public Domain whatIsTheDomain(Block block) {
        Location blockLoc = block.getLocation();
        for(Domain domain : domainList){
            Location corner1 = domain.getCorner1();
            Location corner2 = domain.getCorner2();
            World world = corner1.getWorld();

            int minX = Math.min(corner1.getBlockX(), corner2.getBlockX());
            int minY = Math.min(corner1.getBlockY(), corner2.getBlockY());
            int minZ = Math.min(corner1.getBlockZ(), corner2.getBlockZ());

            int maxX = Math.max(corner1.getBlockX(), corner2.getBlockX());
            int maxY = Math.max(corner1.getBlockY(), corner2.getBlockY());
            int maxZ = Math.max(corner1.getBlockZ(), corner2.getBlockZ());

            for (int x = minX; x <= maxX; x++) {
                for (int y = minY; y <= maxY; y++) {
                    for (int z = minZ; z <= maxZ; z++) {
                        if(blockLoc.equals(new Location(world, x, y, z)))
                            return domain;
                    }
                }
            }
        }
        return null;
    }

    private boolean isAbleToBeBaseBlock(Block block) {
        for (BaseBlockCondition condition : baseBlockConditions) {
            if (!condition.isAbleToBeBaseBlock(block))
                return false;
        }
        return true;
    }
}
