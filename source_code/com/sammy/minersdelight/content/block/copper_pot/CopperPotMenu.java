/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.util.Pair
 *  net.minecraft.core.BlockPos
 *  net.minecraft.network.FriendlyByteBuf
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.Container
 *  net.minecraft.world.entity.player.Inventory
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.entity.player.StackedContents
 *  net.minecraft.world.inventory.ContainerData
 *  net.minecraft.world.inventory.ContainerLevelAccess
 *  net.minecraft.world.inventory.InventoryMenu
 *  net.minecraft.world.inventory.MenuType
 *  net.minecraft.world.inventory.RecipeBookMenu
 *  net.minecraft.world.inventory.RecipeBookType
 *  net.minecraft.world.inventory.SimpleContainerData
 *  net.minecraft.world.inventory.Slot
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.item.crafting.RecipeHolder
 *  net.minecraft.world.item.crafting.RecipeInput
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 *  net.neoforged.neoforge.items.IItemHandler
 *  net.neoforged.neoforge.items.ItemStackHandler
 *  net.neoforged.neoforge.items.SlotItemHandler
 *  net.neoforged.neoforge.items.wrapper.RecipeWrapper
 *  vectorwing.farmersdelight.common.block.entity.container.CookingPotMealSlot
 *  vectorwing.farmersdelight.common.crafting.CookingPotRecipe
 */
package com.sammy.minersdelight.content.block.copper_pot;

import com.mojang.datafixers.util.Pair;
import com.sammy.minersdelight.content.block.copper_pot.CopperPotBlockEntity;
import com.sammy.minersdelight.content.block.copper_pot.CopperPotResultSlot;
import com.sammy.minersdelight.setup.MDBlocks;
import com.sammy.minersdelight.setup.MDItems;
import com.sammy.minersdelight.setup.MDMenuTypes;
import java.util.Objects;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.RecipeBookMenu;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.items.SlotItemHandler;
import net.neoforged.neoforge.items.wrapper.RecipeWrapper;
import vectorwing.farmersdelight.common.block.entity.container.CookingPotMealSlot;
import vectorwing.farmersdelight.common.crafting.CookingPotRecipe;

public class CopperPotMenu
extends RecipeBookMenu<RecipeWrapper, CookingPotRecipe> {
    public static final ResourceLocation EMPTY_CONTAINER_SLOT_CUP = ResourceLocation.fromNamespaceAndPath((String)"farmersdelight", (String)"item/empty_container_slot_bowl");
    public final CopperPotBlockEntity blockEntity;
    public final ItemStackHandler inventory;
    private final ContainerData cookingPotData;
    private final ContainerLevelAccess canInteractWithCallable;
    protected final Level level;

    public CopperPotMenu(int windowId, Inventory playerInventory, CopperPotBlockEntity blockEntity, ContainerData cookingPotDataIn) {
        super((MenuType)MDMenuTypes.COPPER_POT.get(), windowId);
        int column;
        this.blockEntity = blockEntity;
        this.inventory = blockEntity.getInventory();
        this.cookingPotData = cookingPotDataIn;
        this.level = playerInventory.player.level();
        this.canInteractWithCallable = ContainerLevelAccess.create((Level)blockEntity.getLevel(), (BlockPos)blockEntity.getBlockPos());
        int startX = 8;
        int startY = 18;
        int inputStartX = 40;
        int inputStartY = 18;
        int borderSlotSize = 18;
        for (int row = 0; row < 2; ++row) {
            for (column = 0; column < 2; ++column) {
                this.addSlot((Slot)new SlotItemHandler((IItemHandler)this.inventory, row * 2 + column, inputStartX + column * borderSlotSize, inputStartY + row * borderSlotSize));
            }
        }
        this.addSlot((Slot)new CookingPotMealSlot((IItemHandler)this.inventory, 4, 115, 28));
        this.addSlot((Slot)new SlotItemHandler(this, (IItemHandler)this.inventory, 5, 83, 56){

            @OnlyIn(value=Dist.CLIENT)
            public Pair<ResourceLocation, ResourceLocation> getNoItemIcon() {
                return Pair.of((Object)InventoryMenu.BLOCK_ATLAS, (Object)EMPTY_CONTAINER_SLOT_CUP);
            }
        });
        this.addSlot((Slot)new CopperPotResultSlot(playerInventory.player, blockEntity, (IItemHandler)this.inventory, 6, 115, 56));
        int startPlayerInvY = startY * 4 + 12;
        for (int row = 0; row < 3; ++row) {
            for (int column2 = 0; column2 < 9; ++column2) {
                this.addSlot(new Slot((Container)playerInventory, 9 + row * 9 + column2, startX + column2 * borderSlotSize, startPlayerInvY + row * borderSlotSize));
            }
        }
        for (column = 0; column < 9; ++column) {
            this.addSlot(new Slot((Container)playerInventory, column, startX + column * borderSlotSize, 142));
        }
        this.addDataSlots(cookingPotDataIn);
    }

    private static CopperPotBlockEntity getTileEntity(Inventory playerInventory, FriendlyByteBuf data) {
        Objects.requireNonNull(playerInventory, "playerInventory cannot be null");
        Objects.requireNonNull(data, "data cannot be null");
        BlockEntity tileAtPos = playerInventory.player.level().getBlockEntity(data.readBlockPos());
        if (tileAtPos instanceof CopperPotBlockEntity) {
            return (CopperPotBlockEntity)tileAtPos;
        }
        throw new IllegalStateException("Tile entity is not correct! " + String.valueOf(tileAtPos));
    }

    public CopperPotMenu(int windowId, Inventory playerInventory, FriendlyByteBuf data) {
        this(windowId, playerInventory, CopperPotMenu.getTileEntity(playerInventory, data), (ContainerData)new SimpleContainerData(4));
    }

    public boolean stillValid(Player playerIn) {
        return CopperPotMenu.stillValid((ContainerLevelAccess)this.canInteractWithCallable, (Player)playerIn, (Block)MDBlocks.COPPER_POT.get());
    }

    public ItemStack quickMoveStack(Player playerIn, int index) {
        int indexMealDisplay = 4;
        int indexContainerInput = 5;
        int indexOutput = 6;
        int startPlayerInv = indexOutput + 1;
        int endPlayerInv = startPlayerInv + 36;
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = (Slot)this.slots.get(index);
        if (slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (index == indexOutput) {
                if (!this.moveItemStackTo(itemstack1, startPlayerInv, endPlayerInv, true)) {
                    return ItemStack.EMPTY;
                }
            } else if (index > indexOutput) {
                if (!(itemstack1.getItem() != Items.BOWL && itemstack1.getItem() != MDItems.COPPER_CUP.get() || this.moveItemStackTo(itemstack1, indexContainerInput, indexContainerInput + 1, false))) {
                    return ItemStack.EMPTY;
                }
                if (!this.moveItemStackTo(itemstack1, 0, indexMealDisplay, false)) {
                    return ItemStack.EMPTY;
                }
                if (!this.moveItemStackTo(itemstack1, indexContainerInput, indexOutput, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, startPlayerInv, endPlayerInv, false)) {
                return ItemStack.EMPTY;
            }
            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }
            slot.onTake(playerIn, itemstack1);
        }
        return itemstack;
    }

    @OnlyIn(value=Dist.CLIENT)
    public int getCookProgressionScaled() {
        int i = this.cookingPotData.get(0);
        int j = this.cookingPotData.get(1);
        return j != 0 && i != 0 ? i * 29 / j : 0;
    }

    @OnlyIn(value=Dist.CLIENT)
    public boolean isHeated() {
        return this.blockEntity.isHeated();
    }

    public void fillCraftSlotsStackedContents(StackedContents helper) {
        for (int i = 0; i < this.inventory.getSlots(); ++i) {
            helper.accountSimpleStack(this.inventory.getStackInSlot(i));
        }
    }

    public void clearCraftingContent() {
        for (int i = 0; i < 4; ++i) {
            this.inventory.setStackInSlot(i, ItemStack.EMPTY);
        }
    }

    public boolean recipeMatches(RecipeHolder recipeHolder) {
        return recipeHolder.value().matches((RecipeInput)this.blockEntity.createFakeRecipeWrapper(), this.level);
    }

    public int getResultSlotIndex() {
        return 5;
    }

    public int getGridWidth() {
        return 2;
    }

    public int getGridHeight() {
        return 2;
    }

    public int getSize() {
        return 5;
    }

    public RecipeBookType getRecipeBookType() {
        return RecipeBookType.valueOf((String)"FARMERSDELIGHT_COOKING");
    }

    public boolean shouldMoveToInventory(int slot) {
        return slot < this.getGridWidth() * this.getGridHeight();
    }
}

