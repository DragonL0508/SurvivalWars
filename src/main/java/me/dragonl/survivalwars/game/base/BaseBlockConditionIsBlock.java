package me.dragonl.survivalwars.game.base;

import org.bukkit.block.Block;

public class BaseBlockConditionIsBlock implements BaseBlockCondition{

    @Override
    public boolean isAbleToBeBaseBlock(Block block) {
        return block.getType().isBlock();
    }
}
