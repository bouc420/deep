/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Holder
 *  net.minecraft.core.cauldron.CauldronInteraction
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.stats.Stats
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.ItemInteractionResult
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.ItemUtils
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.LayeredCauldronBlock
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.gameevent.GameEvent
 *  net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent
 */
package com.sammy.minersdelight.setup;

import com.sammy.minersdelight.content.item.CopperCupItem;
import com.sammy.minersdelight.setup.MDItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LayeredCauldronBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

public class MDCauldronInteractions {
    public static void addCauldronInteractions(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            CauldronInteraction.WATER.map().put((Item)MDItems.COPPER_CUP.get(), (state, level, pos, player, hand, stack) -> CauldronInteraction.fillBucket((BlockState)state, (Level)level, (BlockPos)pos, (Player)player, (InteractionHand)hand, (ItemStack)stack, (ItemStack)new ItemStack((ItemLike)MDItems.WATER_CUP.get()), s -> (Integer)s.getValue((Property)LayeredCauldronBlock.LEVEL) == 3, (SoundEvent)SoundEvents.BUCKET_FILL));
            CauldronInteraction.POWDER_SNOW.map().put((Item)MDItems.COPPER_CUP.get(), (state, level, pos, player, hand, stack) -> CauldronInteraction.fillBucket((BlockState)state, (Level)level, (BlockPos)pos, (Player)player, (InteractionHand)hand, (ItemStack)stack, (ItemStack)new ItemStack((ItemLike)MDItems.POWDERED_SNOW_CUP.get()), s -> (Integer)s.getValue((Property)LayeredCauldronBlock.LEVEL) == 3, (SoundEvent)SoundEvents.BUCKET_FILL_POWDER_SNOW));
            CauldronInteraction.EMPTY.map().put((Item)MDItems.WATER_CUP.get(), (state, level, pos, player, hand, stack) -> MDCauldronInteractions.emptyCup(level, pos, player, hand, stack, (BlockState)Blocks.WATER_CAULDRON.defaultBlockState().setValue((Property)LayeredCauldronBlock.LEVEL, (Comparable)Integer.valueOf(3)), SoundEvents.BUCKET_EMPTY));
            CauldronInteraction.EMPTY.map().put((Item)MDItems.POWDERED_SNOW_CUP.get(), (state, level, pos, player, hand, stack) -> MDCauldronInteractions.emptyCup(level, pos, player, hand, stack, (BlockState)Blocks.POWDER_SNOW_CAULDRON.defaultBlockState().setValue((Property)LayeredCauldronBlock.LEVEL, (Comparable)Integer.valueOf(3)), SoundEvents.BUCKET_EMPTY_POWDER_SNOW));
        });
    }

    static ItemInteractionResult emptyCup(Level level, BlockPos pos, Player player, InteractionHand hand, ItemStack filledStack, BlockState state, SoundEvent emptySound) {
        if (!level.isClientSide) {
            Item item = filledStack.getItem();
            player.setItemInHand(hand, ItemUtils.createFilledResult((ItemStack)filledStack, (Player)player, (ItemStack)((CopperCupItem)((Object)MDItems.COPPER_CUP.get())).getDefaultInstance()));
            player.awardStat(Stats.FILL_CAULDRON);
            player.awardStat(Stats.ITEM_USED.get((Object)item));
            level.setBlockAndUpdate(pos, state);
            level.playSound(null, pos, emptySound, SoundSource.BLOCKS, 1.0f, 1.0f);
            level.gameEvent(null, (Holder)GameEvent.FLUID_PLACE, pos);
        }
        return ItemInteractionResult.sidedSuccess((boolean)level.isClientSide);
    }
}

