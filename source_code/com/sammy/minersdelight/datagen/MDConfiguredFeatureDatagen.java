/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.data.worldgen.BootstrapContext
 *  net.minecraft.util.random.SimpleWeightedRandomList
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.levelgen.feature.ConfiguredFeature
 *  net.minecraft.world.level.levelgen.feature.Feature
 *  net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration
 *  net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider
 *  net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider
 */
package com.sammy.minersdelight.datagen;

import com.sammy.minersdelight.content.worldgen.WildCaveCropFeature;
import com.sammy.minersdelight.content.worldgen.WildCaveCropFeatureConfiguration;
import com.sammy.minersdelight.setup.MDBlocks;
import com.sammy.minersdelight.setup.MDWorldgen;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;

public class MDConfiguredFeatureDatagen {
    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        WeightedStateProvider weightedstateprovider = new WeightedStateProvider(SimpleWeightedRandomList.builder().add((Object)Blocks.CAVE_AIR.defaultBlockState(), 4).add((Object)MDBlocks.WILD_CAVE_CARROTS.get().defaultBlockState(), 3).add((Object)((Block)MDBlocks.GOSSYPIUM.get()).defaultBlockState(), 1));
        context.register(MDWorldgen.ConfiguredFeatures.CONFIGURED_WILD_CAVE_CARROT, (Object)new ConfiguredFeature((Feature)((WildCaveCropFeature)((Object)MDWorldgen.WILD_CAVE_CROP.get())), (FeatureConfiguration)new WildCaveCropFeatureConfiguration((BlockStateProvider)weightedstateprovider, 6, 4)));
    }
}

