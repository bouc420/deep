/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList
 *  net.minecraft.core.Holder
 *  net.minecraft.core.HolderGetter
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.data.worldgen.BootstrapContext
 *  net.minecraft.world.level.levelgen.VerticalAnchor
 *  net.minecraft.world.level.levelgen.placement.BiomeFilter
 *  net.minecraft.world.level.levelgen.placement.CountOnEveryLayerPlacement
 *  net.minecraft.world.level.levelgen.placement.HeightRangePlacement
 *  net.minecraft.world.level.levelgen.placement.PlacedFeature
 *  net.minecraft.world.level.levelgen.placement.PlacementModifier
 *  net.minecraft.world.level.levelgen.placement.RarityFilter
 */
package com.sammy.minersdelight.datagen;

import com.google.common.collect.ImmutableList;
import com.sammy.minersdelight.setup.MDWorldgen;
import java.util.List;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountOnEveryLayerPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

public class MDPlacedFeatureDatagen {
    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter features = context.lookup(Registries.CONFIGURED_FEATURE);
        context.register(MDWorldgen.PlacedFeatures.WILD_CAVE_CARROT, (Object)new PlacedFeature((Holder)features.getOrThrow(MDWorldgen.ConfiguredFeatures.CONFIGURED_WILD_CAVE_CARROT), (List)ImmutableList.builder().add((Object[])new PlacementModifier[]{RarityFilter.onAverageOnceEvery((int)24), HeightRangePlacement.uniform((VerticalAnchor)VerticalAnchor.aboveBottom((int)12), (VerticalAnchor)VerticalAnchor.absolute((int)48)), CountOnEveryLayerPlacement.of((int)5), BiomeFilter.biome()}).build()));
    }
}

