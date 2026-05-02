/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.tags.BlockTags
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.WorldGenLevel
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.levelgen.feature.Feature
 *  net.minecraft.world.level.levelgen.feature.FeaturePlaceContext
 */
package com.sammy.minersdelight.content.worldgen;

import com.sammy.minersdelight.content.block.WildCaveCarrotBlock;
import com.sammy.minersdelight.content.worldgen.WildCaveCropFeatureConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class WildCaveCropFeature
extends Feature<WildCaveCropFeatureConfiguration> {
    public WildCaveCropFeature() {
        super(WildCaveCropFeatureConfiguration.CODEC);
    }

    public boolean place(FeaturePlaceContext<WildCaveCropFeatureConfiguration> context) {
        WorldGenLevel worldgenlevel = context.level();
        BlockPos blockpos = context.origin();
        BlockState blockstate = worldgenlevel.getBlockState(blockpos.below());
        WildCaveCropFeatureConfiguration config = (WildCaveCropFeatureConfiguration)context.config();
        RandomSource randomsource = context.random();
        if (worldgenlevel.canSeeSky(blockpos) || blockpos.getY() > 60) {
            return false;
        }
        if (blockstate.is(BlockTags.BASE_STONE_OVERWORLD) || blockstate.is(BlockTags.DIRT) || blockstate.is(BlockTags.SAND)) {
            int i = blockpos.getY();
            if (i >= worldgenlevel.getMinBuildHeight() + 1 && i + 1 < worldgenlevel.getMaxBuildHeight()) {
                int j = 0;
                for (int k = 0; k < config.spreadWidth * config.spreadWidth; ++k) {
                    BlockPos offsetPos = blockpos.offset(randomsource.nextInt(config.spreadWidth) - randomsource.nextInt(config.spreadWidth), randomsource.nextInt(config.spreadHeight) - randomsource.nextInt(config.spreadHeight), randomsource.nextInt(config.spreadWidth) - randomsource.nextInt(config.spreadWidth));
                    BlockState plantState = config.stateProvider.getState(randomsource, offsetPos);
                    if (!worldgenlevel.isEmptyBlock(offsetPos) || offsetPos.getY() <= worldgenlevel.getMinBuildHeight() || !plantState.canSurvive((LevelReader)worldgenlevel, offsetPos)) continue;
                    plantState = WildCaveCarrotBlock.modifyState((LevelAccessor)worldgenlevel, plantState, offsetPos);
                    worldgenlevel.setBlock(offsetPos, plantState, 2);
                    ++j;
                }
                return j > 0;
            }
            return false;
        }
        return false;
    }
}

