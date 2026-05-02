/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.network.chat.Component
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.item.BlockItem
 *  net.minecraft.world.item.CreativeModeTab
 *  net.neoforged.neoforge.registries.DeferredHolder
 *  net.neoforged.neoforge.registries.DeferredRegister
 */
package com.sammy.minersdelight.setup;

import com.sammy.minersdelight.setup.MDItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MDCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create((ResourceKey)Registries.CREATIVE_MODE_TAB, (String)"minersdelight");
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CONTENT = CREATIVE_MODE_TABS.register("minersdelight", () -> CreativeModeTab.builder().title((Component)Component.translatable((String)"itemGroup.minersdelight")).withTabsBefore(new ResourceLocation[]{ResourceLocation.parse((String)"farmersdelight:farmersdelight")}).icon(() -> ((BlockItem)MDItems.COPPER_POT.get()).getDefaultInstance()).build());
}

