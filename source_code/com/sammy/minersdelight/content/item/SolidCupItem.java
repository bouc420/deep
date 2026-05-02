/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.BlockItem
 *  net.minecraft.world.item.DispensibleContainerItem
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.context.UseOnContext
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.BlockHitResult
 *  org.jetbrains.annotations.Nullable
 */
package com.sammy.minersdelight.content.item;

import com.sammy.minersdelight.content.item.CopperCupItem;
import com.sammy.minersdelight.setup.MDItems;
import java.util.Map;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DispensibleContainerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class SolidCupItem
extends BlockItem
implements DispensibleContainerItem {
    private final SoundEvent placeSound;

    public SolidCupItem(Block pBlock, SoundEvent pPlaceSound, Item.Properties pProperties) {
        super(pBlock, pProperties);
        this.placeSound = pPlaceSound;
    }

    public InteractionResult useOn(UseOnContext pContext) {
        InteractionResult interactionresult = super.useOn(pContext);
        Player player = pContext.getPlayer();
        if (interactionresult.consumesAction() && player != null && !player.isCreative()) {
            InteractionHand interactionhand = pContext.getHand();
            player.setItemInHand(interactionhand, ((CopperCupItem)((Object)MDItems.COPPER_CUP.get())).getDefaultInstance());
        }
        return interactionresult;
    }

    public void registerBlocks(Map<Block, Item> pBlockToItemMap, Item pItem) {
    }

    public String getDescriptionId() {
        return this.getOrCreateDescriptionId();
    }

    protected SoundEvent getPlaceSound(BlockState pState) {
        return this.placeSound;
    }

    public boolean emptyContents(@Nullable Player pPlayer, Level pLevel, BlockPos pPos, @Nullable BlockHitResult pResult) {
        if (pLevel.isInWorldBounds(pPos) && pLevel.isEmptyBlock(pPos)) {
            if (!pLevel.isClientSide) {
                pLevel.setBlock(pPos, this.getBlock().defaultBlockState(), 3);
            }
            pLevel.playSound(pPlayer, pPos, this.placeSound, SoundSource.BLOCKS, 1.0f, 1.0f);
            return true;
        }
        return false;
    }
}

