/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  javax.annotation.Nullable
 *  net.minecraft.core.Direction
 *  net.minecraft.world.item.ItemStack
 *  net.neoforged.neoforge.items.IItemHandler
 */
package com.sammy.minersdelight.content.block.copper_pot;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandler;

public class CopperPotItemHandler
implements IItemHandler {
    private static final int SLOTS_INPUT = 4;
    private static final int SLOT_CONTAINER_INPUT = 5;
    private static final int SLOT_MEAL_OUTPUT = 6;
    private final IItemHandler itemHandler;
    private final Direction side;

    public CopperPotItemHandler(IItemHandler itemHandler, @Nullable Direction side) {
        this.itemHandler = itemHandler;
        this.side = side;
    }

    public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
        return this.itemHandler.isItemValid(slot, stack);
    }

    public int getSlots() {
        return this.itemHandler.getSlots();
    }

    @Nonnull
    public ItemStack getStackInSlot(int slot) {
        return this.itemHandler.getStackInSlot(slot);
    }

    @Nonnull
    public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
        if (this.side == null || this.side.equals((Object)Direction.UP)) {
            return slot < 4 ? this.itemHandler.insertItem(slot, stack, simulate) : stack;
        }
        return slot == 5 ? this.itemHandler.insertItem(slot, stack, simulate) : stack;
    }

    @Nonnull
    public ItemStack extractItem(int slot, int amount, boolean simulate) {
        if (this.side == null || this.side.equals((Object)Direction.UP)) {
            return slot < 4 ? this.itemHandler.extractItem(slot, amount, simulate) : ItemStack.EMPTY;
        }
        return slot == 6 ? this.itemHandler.extractItem(slot, amount, simulate) : ItemStack.EMPTY;
    }

    public int getSlotLimit(int slot) {
        return this.itemHandler.getSlotLimit(slot);
    }
}

