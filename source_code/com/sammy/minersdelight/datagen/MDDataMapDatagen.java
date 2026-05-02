/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.Holder
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.data.PackOutput
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Items
 *  net.neoforged.neoforge.common.conditions.ICondition
 *  net.neoforged.neoforge.common.data.DataMapProvider
 *  net.neoforged.neoforge.registries.datamaps.builtin.Compostable
 *  net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps
 *  vectorwing.farmersdelight.common.item.ConsumableItem
 *  vectorwing.farmersdelight.common.registry.ModItems
 */
package com.sammy.minersdelight.datagen;

import com.sammy.minersdelight.content.data.CupConversionDataMap;
import com.sammy.minersdelight.setup.MDDataMaps;
import com.sammy.minersdelight.setup.MDItems;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.registry.ModItems;

public class MDDataMapDatagen
extends DataMapProvider {
    protected MDDataMapDatagen(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    protected void gather() {
        this.builder(MDDataMaps.CUP_VARIANT).add((Holder)Items.BUCKET.builtInRegistryHolder(), (Object)new CupConversionDataMap((Holder<Item>)MDItems.COPPER_CUP), false, new ICondition[0]).add((Holder)Items.WATER_BUCKET.builtInRegistryHolder(), (Object)new CupConversionDataMap((Holder<Item>)MDItems.WATER_CUP), false, new ICondition[0]).add((Holder)Items.MILK_BUCKET.builtInRegistryHolder(), (Object)new CupConversionDataMap((Holder<Item>)MDItems.MILK_CUP), false, new ICondition[0]).add((Holder)Items.POWDER_SNOW_BUCKET.builtInRegistryHolder(), (Object)new CupConversionDataMap((Holder<Item>)MDItems.POWDERED_SNOW_CUP), false, new ICondition[0]).add((Holder)Items.BEETROOT_SOUP.builtInRegistryHolder(), (Object)new CupConversionDataMap((Holder<Item>)MDItems.BEETROOT_SOUP_CUP), false, new ICondition[0]).add((Holder)Items.MUSHROOM_STEW.builtInRegistryHolder(), (Object)new CupConversionDataMap((Holder<Item>)MDItems.MUSHROOM_STEW_CUP), false, new ICondition[0]).add((Holder)Items.RABBIT_STEW.builtInRegistryHolder(), (Object)new CupConversionDataMap((Holder<Item>)MDItems.RABBIT_STEW_CUP), false, new ICondition[0]).add((Holder)((Item)ModItems.BAKED_COD_STEW.get()).builtInRegistryHolder(), (Object)new CupConversionDataMap((Holder<Item>)MDItems.BAKED_COD_STEW_CUP), false, new ICondition[0]).add((Holder)((Item)ModItems.NOODLE_SOUP.get()).builtInRegistryHolder(), (Object)new CupConversionDataMap((Holder<Item>)MDItems.NOODLE_SOUP_CUP), false, new ICondition[0]).add((Holder)((Item)ModItems.BEEF_STEW.get()).builtInRegistryHolder(), (Object)new CupConversionDataMap((Holder<Item>)MDItems.BEEF_STEW_CUP), false, new ICondition[0]).add((Holder)((Item)ModItems.CHICKEN_SOUP.get()).builtInRegistryHolder(), (Object)new CupConversionDataMap((Holder<Item>)MDItems.CHICKEN_SOUP_CUP), false, new ICondition[0]).add((Holder)((Item)ModItems.FISH_STEW.get()).builtInRegistryHolder(), (Object)new CupConversionDataMap((Holder<Item>)MDItems.FISH_STEW_CUP), false, new ICondition[0]).add((Holder)((Item)ModItems.PUMPKIN_SOUP.get()).builtInRegistryHolder(), (Object)new CupConversionDataMap((Holder<Item>)MDItems.PUMPKIN_SOUP_CUP), false, new ICondition[0]).add((Holder)((Item)ModItems.VEGETABLE_SOUP.get()).builtInRegistryHolder(), (Object)new CupConversionDataMap((Holder<Item>)MDItems.VEGETABLE_SOUP_CUP), false, new ICondition[0]).add((Holder)((Item)ModItems.ONION_SOUP.get()).builtInRegistryHolder(), (Object)new CupConversionDataMap((Holder<Item>)MDItems.ONION_SOUP_CUP), false, new ICondition[0]).add((Holder)((ConsumableItem)MDItems.CAVE_SOUP.get()).builtInRegistryHolder(), (Object)new CupConversionDataMap((Holder<Item>)MDItems.CAVE_SOUP_CUP), false, new ICondition[0]).add((Holder)((ConsumableItem)MDItems.BAT_SOUP.get()).builtInRegistryHolder(), (Object)new CupConversionDataMap((Holder<Item>)MDItems.BAT_SOUP_CUP), false, new ICondition[0]).add((Holder)((ConsumableItem)MDItems.INSECT_STEW.get()).builtInRegistryHolder(), (Object)new CupConversionDataMap((Holder<Item>)MDItems.INSECT_STEW_CUP), false, new ICondition[0]).add((Holder)((Item)ModItems.BONE_BROTH.get()).builtInRegistryHolder(), (Object)new CupConversionDataMap((Holder<Item>)MDItems.BONE_BROTH_CUP), false, new ICondition[0]);
        this.builder(NeoForgeDataMaps.COMPOSTABLES).add(MDItems.CAVE_CARROT, (Object)new Compostable(0.65f), false, new ICondition[0]).add(MDItems.BAKED_CAVE_CARROT, (Object)new Compostable(0.65f), false, new ICondition[0]).add(MDItems.GOSSYPIUM, (Object)new Compostable(0.3f), false, new ICondition[0]);
    }
}

