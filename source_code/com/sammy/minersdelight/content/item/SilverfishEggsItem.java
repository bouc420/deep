/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.context.UseOnContext
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.InfestedBlock
 *  net.minecraft.world.level.block.state.BlockState
 */
package com.sammy.minersdelight.content.item;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.InfestedBlock;
import net.minecraft.world.level.block.state.BlockState;

public class SilverfishEggsItem
extends Item {
    public SilverfishEggsItem(Item.Properties pProperties) {
        super(pProperties);
    }

    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Player player = pContext.getPlayer();
        InteractionHand hand = pContext.getHand();
        BlockPos pos = pContext.getClickedPos();
        BlockState state = level.getBlockState(pos);
        if (InfestedBlock.isCompatibleHostBlock((BlockState)state)) {
            if (level.isClientSide) {
                return InteractionResult.SUCCESS;
            }
            BlockState infestedState = InfestedBlock.infestedStateByHost((BlockState)state);
            level.setBlock(pos, infestedState, 3);
            level.levelEvent(2001, pos, Block.getId((BlockState)infestedState));
            if (player != null) {
                player.swing(hand, true);
                if (!player.isCreative()) {
                    player.getItemInHand(hand).shrink(1);
                }
            }
            return InteractionResult.SUCCESS;
        }
        return super.useOn(pContext);
    }
}

