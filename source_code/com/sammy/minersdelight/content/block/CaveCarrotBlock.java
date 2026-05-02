/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.CropBlock
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.StateDefinition$Builder
 *  net.minecraft.world.level.block.state.properties.BlockStateProperties
 *  net.minecraft.world.level.block.state.properties.IntegerProperty
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  vectorwing.farmersdelight.common.registry.ModBlocks
 */
package com.sammy.minersdelight.content.block;

import com.sammy.minersdelight.setup.MDItems;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.VoxelShape;
import vectorwing.farmersdelight.common.registry.ModBlocks;

public class CaveCarrotBlock
extends CropBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{Block.box((double)0.0, (double)0.0, (double)0.0, (double)16.0, (double)2.0, (double)16.0), Block.box((double)0.0, (double)0.0, (double)0.0, (double)16.0, (double)4.0, (double)16.0), Block.box((double)0.0, (double)0.0, (double)0.0, (double)16.0, (double)6.0, (double)16.0), Block.box((double)0.0, (double)0.0, (double)0.0, (double)16.0, (double)8.0, (double)16.0)};

    public CaveCarrotBlock(BlockBehaviour.Properties pProperties) {
        super(pProperties);
    }

    protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return pState.is((Block)ModBlocks.RICH_SOIL.get());
    }

    protected ItemLike getBaseSeedId() {
        return (ItemLike)MDItems.CAVE_CARROT.get();
    }

    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    public int getMaxAge() {
        return 3;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(new Property[]{AGE});
    }

    protected int getBonemealAgeIncrease(Level pLevel) {
        return Mth.nextInt((RandomSource)pLevel.random, (int)1, (int)2);
    }
}

