/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.tags.BlockTags
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.item.context.BlockPlaceContext
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.StateDefinition$Builder
 *  net.minecraft.world.level.block.state.properties.BooleanProperty
 *  net.minecraft.world.level.block.state.properties.Property
 *  vectorwing.farmersdelight.common.block.WildCropBlock
 *  vectorwing.farmersdelight.common.registry.ModBlocks
 */
package com.sammy.minersdelight.content.block;

import com.sammy.minersdelight.setup.MDBlocks;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import vectorwing.farmersdelight.common.block.WildCropBlock;
import vectorwing.farmersdelight.common.registry.ModBlocks;

public class WildCaveCarrotBlock
extends WildCropBlock {
    public static final BooleanProperty STONE = BooleanProperty.create((String)"stone");

    public WildCaveCarrotBlock(BlockBehaviour.Properties properties) {
        super(MobEffects.DIG_SPEED, 10, properties);
        this.registerDefaultState((BlockState)((BlockState)this.getStateDefinition().any()).setValue((Property)STONE, (Comparable)Boolean.valueOf(false)));
    }

    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        int random = pRandom.nextInt(20);
        if (random <= 3 && pLevel.getBlockState(pPos.below()).is((Block)ModBlocks.RICH_SOIL.get())) {
            BlockState state = random == 1 ? ((Block)MDBlocks.GOSSYPIUM.get()).defaultBlockState() : pState;
            int i = 5;
            for (BlockPos blockpos : BlockPos.betweenClosed((BlockPos)pPos.offset(-4, -1, -4), (BlockPos)pPos.offset(4, 1, 4))) {
                if (!pLevel.getBlockState(blockpos).is((Block)this) || --i > 0) continue;
                return;
            }
            BlockPos blockpos1 = pPos.offset(pRandom.nextInt(3) - 1, pRandom.nextInt(2) - pRandom.nextInt(2), pRandom.nextInt(3) - 1);
            for (int k = 0; k < 4; ++k) {
                if (pLevel.isEmptyBlock(blockpos1) && state.canSurvive((LevelReader)pLevel, blockpos1)) {
                    pPos = blockpos1;
                }
                blockpos1 = pPos.offset(pRandom.nextInt(3) - 1, pRandom.nextInt(2) - pRandom.nextInt(2), pRandom.nextInt(3) - 1);
            }
            if (pLevel.isEmptyBlock(blockpos1) && state.canSurvive((LevelReader)pLevel, blockpos1)) {
                if (pLevel.getBlockState(blockpos1.below()).is(BlockTags.BASE_STONE_OVERWORLD)) {
                    state = (BlockState)state.setValue((Property)STONE, (Comparable)Boolean.valueOf(true));
                }
                pLevel.setBlock(blockpos1, state, 2);
            }
        }
    }

    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.is(BlockTags.BASE_STONE_OVERWORLD) || state.is(BlockTags.DIRT) || state.is(BlockTags.SAND);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{STONE});
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockState stateForPlacement = super.getStateForPlacement(pContext);
        return stateForPlacement != null ? WildCaveCarrotBlock.modifyState((LevelAccessor)pContext.getLevel(), stateForPlacement, pContext.getClickedPos()) : null;
    }

    public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        BlockState state = super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
        if (state.is(Blocks.AIR)) {
            return state;
        }
        if (pFacing == Direction.DOWN && pFacingState.is(BlockTags.BASE_STONE_OVERWORLD)) {
            state.setValue((Property)STONE, (Comparable)Boolean.valueOf(true));
        } else {
            state.setValue((Property)STONE, (Comparable)Boolean.valueOf(false));
        }
        return state;
    }

    public static BlockState modifyState(LevelAccessor level, BlockState state, BlockPos pos) {
        if (state.hasProperty((Property)STONE) && level.getBlockState(pos.below()).is(BlockTags.BASE_STONE_OVERWORLD)) {
            return (BlockState)state.setValue((Property)STONE, (Comparable)Boolean.valueOf(true));
        }
        return state;
    }
}

