/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.core.NonNullList
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.chat.Component
 *  net.minecraft.world.Container
 *  net.minecraft.world.ContainerHelper
 *  net.minecraft.world.entity.player.Inventory
 *  net.minecraft.world.inventory.AbstractContainerMenu
 *  net.minecraft.world.inventory.ChestMenu
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.BlockStateProperties
 *  net.minecraft.world.level.block.state.properties.Property
 *  vectorwing.farmersdelight.common.block.BasketBlock
 *  vectorwing.farmersdelight.common.block.entity.Basket
 */
package com.sammy.minersdelight.content.block.sticky_basket;

import com.sammy.minersdelight.setup.MDBlockEntities;
import java.util.function.BooleanSupplier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Property;
import vectorwing.farmersdelight.common.block.BasketBlock;
import vectorwing.farmersdelight.common.block.entity.Basket;

public class StickyBasketBlockEntity
extends RandomizableContainerBlockEntity
implements Basket {
    private NonNullList<ItemStack> items = NonNullList.withSize((int)27, (Object)ItemStack.EMPTY);
    private int transferCooldown = -1;

    public StickyBasketBlockEntity(BlockPos pos, BlockState state) {
        super((BlockEntityType)MDBlockEntities.STICKY_BASKET.get(), pos, state);
    }

    protected void loadAdditional(CompoundTag compound, HolderLookup.Provider registries) {
        super.loadAdditional(compound, registries);
        this.items = NonNullList.withSize((int)this.getContainerSize(), (Object)ItemStack.EMPTY);
        if (!this.tryLoadLootTable(compound)) {
            ContainerHelper.loadAllItems((CompoundTag)compound, this.items, (HolderLookup.Provider)registries);
        }
        this.transferCooldown = compound.getInt("TransferCooldown");
    }

    public void saveAdditional(CompoundTag compound, HolderLookup.Provider registries) {
        super.saveAdditional(compound, registries);
        if (!this.trySaveLootTable(compound)) {
            ContainerHelper.saveAllItems((CompoundTag)compound, this.items, (HolderLookup.Provider)registries);
        }
        compound.putInt("TransferCooldown", this.transferCooldown);
    }

    public int getContainerSize() {
        return this.items.size();
    }

    public ItemStack removeItem(int index, int count) {
        this.unpackLootTable(null);
        return ContainerHelper.removeItem(this.getItems(), (int)index, (int)count);
    }

    public void setItem(int index, ItemStack stack) {
        this.unpackLootTable(null);
        this.getItems().set(index, (Object)stack);
        if (stack.getCount() > this.getMaxStackSize()) {
            stack.setCount(this.getMaxStackSize());
        }
    }

    protected Component getDefaultName() {
        return Component.translatable((String)"minersdelight.container.sticky_basket");
    }

    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    protected void setItems(NonNullList<ItemStack> itemsIn) {
        this.items = itemsIn;
    }

    protected AbstractContainerMenu createMenu(int id, Inventory player) {
        return ChestMenu.threeRows((int)id, (Inventory)player, (Container)this);
    }

    public void setCooldown(int ticks) {
        this.transferCooldown = ticks;
    }

    public boolean isOnCooldown() {
        return this.transferCooldown > 0;
    }

    public boolean isOnCustomCooldown() {
        return this.transferCooldown > 8;
    }

    public void tryTransfer(BooleanSupplier transfer) {
        if (this.level != null && !this.level.isClientSide && !this.isOnCooldown() && ((Boolean)this.getBlockState().getValue((Property)BlockStateProperties.ENABLED)).booleanValue()) {
            boolean flag = false;
            if (!this.isFull()) {
                flag = transfer.getAsBoolean();
            }
            if (flag) {
                this.setCooldown(8);
                this.setChanged();
            }
        }
    }

    protected boolean isFull() {
        for (ItemStack itemstack : this.items) {
            if (!itemstack.isEmpty() && itemstack.getCount() == itemstack.getMaxStackSize()) continue;
            return false;
        }
        return true;
    }

    public double getLevelX() {
        return (double)this.worldPosition.getX() + 0.5;
    }

    public double getLevelY() {
        return (double)this.worldPosition.getY() + 0.5;
    }

    public double getLevelZ() {
        return (double)this.worldPosition.getZ() + 0.5;
    }

    public static void pushItemsTick(Level level, BlockPos pos, BlockState state, StickyBasketBlockEntity blockEntity) {
        --blockEntity.transferCooldown;
        if (!blockEntity.isOnCooldown()) {
            blockEntity.setCooldown(0);
            int facing = ((Direction)state.getValue((Property)BasketBlock.FACING)).get3DDataValue();
            blockEntity.tryTransfer(() -> blockEntity.collectItems(level, facing));
        }
    }
}

