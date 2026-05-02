/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.Direction
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.minecraft.world.level.block.entity.BlockEntityType$Builder
 *  net.neoforged.neoforge.capabilities.Capabilities$ItemHandler
 *  net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent
 *  net.neoforged.neoforge.registries.DeferredHolder
 *  net.neoforged.neoforge.registries.DeferredRegister
 *  vectorwing.farmersdelight.common.block.entity.Basket
 *  vectorwing.farmersdelight.common.block.entity.inventory.BasketInvWrapper
 */
package com.sammy.minersdelight.setup;

import com.sammy.minersdelight.content.block.copper_pot.CopperPotBlockEntity;
import com.sammy.minersdelight.content.block.sticky_basket.StickyBasketBlockEntity;
import com.sammy.minersdelight.setup.MDBlocks;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.farmersdelight.common.block.entity.Basket;
import vectorwing.farmersdelight.common.block.entity.inventory.BasketInvWrapper;

public class MDBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create((ResourceKey)Registries.BLOCK_ENTITY_TYPE, (String)"minersdelight");
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CopperPotBlockEntity>> COPPER_POT = BLOCK_ENTITIES.register("copper_pot", () -> BlockEntityType.Builder.of(CopperPotBlockEntity::new, (Block[])new Block[]{MDBlocks.COPPER_POT.get()}).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<StickyBasketBlockEntity>> STICKY_BASKET = BLOCK_ENTITIES.register("sticky_basket", () -> BlockEntityType.Builder.of(StickyBasketBlockEntity::new, (Block[])new Block[]{MDBlocks.STICKY_BASKET.get()}).build(null));

    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)STICKY_BASKET.get(), (be, context) -> new BasketInvWrapper((Basket)be));
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)COPPER_POT.get(), (be, context) -> {
            if (context == Direction.UP) {
                return be.inputHandler;
            }
            return be.outputHandler;
        });
    }
}

