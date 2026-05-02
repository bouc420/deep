/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.advancements.CriteriaTriggers
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Holder
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.stats.Stats
 *  net.minecraft.tags.FluidTags
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResultHolder
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.DispensibleContainerItem
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.ItemUtils
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.ClipContext$Fluid
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.BucketPickup
 *  net.minecraft.world.level.block.LiquidBlockContainer
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.gameevent.GameEvent
 *  net.minecraft.world.level.material.FlowingFluid
 *  net.minecraft.world.level.material.Fluid
 *  net.minecraft.world.level.material.Fluids
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.HitResult$Type
 *  net.neoforged.neoforge.common.SoundActions
 *  net.neoforged.neoforge.fluids.FluidStack
 *  net.neoforged.neoforge.fluids.FluidUtil
 */
package com.sammy.minersdelight.content.item;

import com.sammy.minersdelight.content.data.CupConversionDataMap;
import com.sammy.minersdelight.setup.MDItems;
import java.util.Optional;
import javax.annotation.Nullable;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DispensibleContainerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BucketPickup;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidUtil;

public class CopperCupItem
extends Item
implements DispensibleContainerItem {
    private final Fluid content;

    public CopperCupItem(Fluid pContent, Item.Properties pProperties) {
        super(pProperties);
        this.content = pContent;
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        BlockPos blockpos2;
        ItemStack itemstack = player.getItemInHand(hand);
        BlockHitResult blockhitresult = CopperCupItem.getPlayerPOVHitResult((Level)level, (Player)player, (ClipContext.Fluid)(this.content == Fluids.EMPTY ? ClipContext.Fluid.SOURCE_ONLY : ClipContext.Fluid.NONE));
        if (blockhitresult.getType() == HitResult.Type.MISS) {
            return InteractionResultHolder.pass((Object)itemstack);
        }
        if (blockhitresult.getType() != HitResult.Type.BLOCK) {
            return InteractionResultHolder.pass((Object)itemstack);
        }
        BlockPos blockpos = blockhitresult.getBlockPos();
        Direction direction = blockhitresult.getDirection();
        BlockPos offsetPos = blockpos.relative(direction);
        if (!level.mayInteract(player, blockpos) || !player.mayUseItemAt(offsetPos, direction, itemstack)) {
            return InteractionResultHolder.fail((Object)itemstack);
        }
        if (this.content == Fluids.EMPTY) {
            BlockState fluidState = level.getBlockState(blockpos);
            Block block = fluidState.getBlock();
            if (block instanceof BucketPickup) {
                BucketPickup bucketpickup = (BucketPickup)block;
                ItemStack bucketStack = bucketpickup.pickupBlock(player, (LevelAccessor)level, blockpos, fluidState);
                Optional<ItemStack> data = CupConversionDataMap.getCupVariant(bucketStack);
                if (data.isEmpty()) {
                    return InteractionResultHolder.pass((Object)itemstack);
                }
                ItemStack cupStack = data.get();
                cupStack.applyComponents(bucketStack.getComponents());
                if (!cupStack.isEmpty()) {
                    player.awardStat(Stats.ITEM_USED.get((Object)this));
                    bucketpickup.getPickupSound(fluidState).ifPresent(p_150709_ -> player.playSound(p_150709_, 1.0f, 1.0f));
                    level.gameEvent((Entity)player, (Holder)GameEvent.FLUID_PICKUP, blockpos);
                    ItemStack itemstack2 = ItemUtils.createFilledResult((ItemStack)itemstack, (Player)player, (ItemStack)cupStack);
                    if (!level.isClientSide) {
                        CriteriaTriggers.FILLED_BUCKET.trigger((ServerPlayer)player, cupStack);
                    }
                    return InteractionResultHolder.sidedSuccess((Object)itemstack2, (boolean)level.isClientSide());
                }
            }
            return InteractionResultHolder.fail((Object)itemstack);
        }
        BlockState blockstate = level.getBlockState(blockpos);
        BlockPos blockPos = blockpos2 = this.canBlockContainFluid(player, level, blockpos, blockstate) ? blockpos : offsetPos;
        if (this.emptyContents(player, level, blockpos2, blockhitresult, itemstack)) {
            this.checkExtraContent(player, level, itemstack, blockpos2);
            if (player instanceof ServerPlayer) {
                CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer)player, blockpos2, itemstack);
            }
            player.awardStat(Stats.ITEM_USED.get((Object)this));
            ItemStack itemstack1 = ItemUtils.createFilledResult((ItemStack)itemstack, (Player)player, (ItemStack)CopperCupItem.getEmptySuccessItem(itemstack, player));
            return InteractionResultHolder.sidedSuccess((Object)itemstack1, (boolean)level.isClientSide());
        }
        return InteractionResultHolder.fail((Object)itemstack);
    }

    public static ItemStack getEmptySuccessItem(ItemStack bucketStack, Player player) {
        return !player.hasInfiniteMaterials() ? new ItemStack(MDItems.COPPER_CUP) : bucketStack;
    }

    public void checkExtraContent(@Nullable Player player, Level level, ItemStack containerStack, BlockPos pos) {
    }

    @Deprecated
    public boolean emptyContents(@Nullable Player player, Level level, BlockPos pos, @Nullable BlockHitResult result) {
        return this.emptyContents(player, level, pos, result, null);
    }

    public boolean emptyContents(@Nullable Player player, Level level, BlockPos pos, @Nullable BlockHitResult result, @Nullable ItemStack container) {
        LiquidBlockContainer liquidblockcontainer1;
        LiquidBlockContainer liquidblockcontainer;
        Fluid fluid = this.content;
        if (!(fluid instanceof FlowingFluid)) {
            return false;
        }
        FlowingFluid flowingfluid = (FlowingFluid)fluid;
        BlockState blockstate = level.getBlockState(pos);
        Block $$7 = blockstate.getBlock();
        boolean $$8 = blockstate.canBeReplaced(this.content);
        boolean flag2 = blockstate.isAir() || $$8 || $$7 instanceof LiquidBlockContainer && (liquidblockcontainer = (LiquidBlockContainer)$$7).canPlaceLiquid(player, (BlockGetter)level, pos, blockstate, this.content);
        boolean flag1 = flag2;
        Optional containedFluidStack = Optional.ofNullable(container).flatMap(FluidUtil::getFluidContained);
        if (!flag1) {
            return result != null && this.emptyContents(player, level, result.getBlockPos().relative(result.getDirection()), null, container);
        }
        if (containedFluidStack.isPresent() && this.content.getFluidType().isVaporizedOnPlacement(level, pos, (FluidStack)containedFluidStack.get())) {
            this.content.getFluidType().onVaporize(player, level, pos, (FluidStack)containedFluidStack.get());
            return true;
        }
        if (level.dimensionType().ultraWarm() && this.content.is(FluidTags.WATER)) {
            int l = pos.getX();
            int i = pos.getY();
            int j = pos.getZ();
            level.playSound(player, pos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 0.5f, 2.6f + (level.random.nextFloat() - level.random.nextFloat()) * 0.8f);
            for (int k = 0; k < 8; ++k) {
                level.addParticle((ParticleOptions)ParticleTypes.LARGE_SMOKE, (double)l + Math.random(), (double)i + Math.random(), (double)j + Math.random(), 0.0, 0.0, 0.0);
            }
            return true;
        }
        if ($$7 instanceof LiquidBlockContainer && (liquidblockcontainer1 = (LiquidBlockContainer)$$7).canPlaceLiquid(player, (BlockGetter)level, pos, blockstate, this.content)) {
            liquidblockcontainer1.placeLiquid((LevelAccessor)level, pos, blockstate, flowingfluid.getSource(false));
            this.playEmptySound(player, (LevelAccessor)level, pos);
            return true;
        }
        if (!level.isClientSide && $$8 && !blockstate.liquid()) {
            level.destroyBlock(pos, true);
        }
        if (!level.setBlock(pos, this.content.defaultFluidState().createLegacyBlock(), 11) && !blockstate.getFluidState().isSource()) {
            return false;
        }
        this.playEmptySound(player, (LevelAccessor)level, pos);
        return true;
    }

    protected void playEmptySound(@Nullable Player player, LevelAccessor level, BlockPos pos) {
        SoundEvent soundevent = this.content.getFluidType().getSound(player, (BlockGetter)level, pos, SoundActions.BUCKET_EMPTY);
        if (soundevent == null) {
            soundevent = this.content.is(FluidTags.LAVA) ? SoundEvents.BUCKET_EMPTY_LAVA : SoundEvents.BUCKET_EMPTY;
        }
        level.playSound(player, pos, soundevent, SoundSource.BLOCKS, 1.0f, 1.0f);
        level.gameEvent((Entity)player, (Holder)GameEvent.FLUID_PLACE, pos);
    }

    protected boolean canBlockContainFluid(@Nullable Player player, Level worldIn, BlockPos posIn, BlockState blockstate) {
        return blockstate.getBlock() instanceof LiquidBlockContainer && ((LiquidBlockContainer)blockstate.getBlock()).canPlaceLiquid(player, (BlockGetter)worldIn, posIn, blockstate, this.content);
    }
}

