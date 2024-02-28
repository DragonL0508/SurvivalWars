package me.dragonl.survivalwars.game.domain;

import org.bukkit.block.Block;

public interface BaseBlockCondition {
    boolean isAbleToBeBaseBlock(Block block);
}
