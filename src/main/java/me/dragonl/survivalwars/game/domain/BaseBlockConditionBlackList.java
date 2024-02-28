package me.dragonl.survivalwars.game.domain;

import org.bukkit.Material;
import org.bukkit.block.Block;

import java.util.List;

public class BaseBlockConditionBlackList implements BaseBlockCondition{
    private final List<Material> blackList;

    public BaseBlockConditionBlackList(List<Material> blackList) {
        this.blackList = blackList;
    }

    @Override
    public boolean isAbleToBeBaseBlock(Block block) {
        return !blackList.contains(block.getType());
    }
}
