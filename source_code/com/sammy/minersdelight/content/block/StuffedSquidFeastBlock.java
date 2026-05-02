/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.StateDefinition$Builder
 *  net.minecraft.world.level.block.state.properties.IntegerProperty
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.Shapes
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  vectorwing.farmersdelight.common.BlockShapes
 *  vectorwing.farmersdelight.common.block.FeastBlock
 */
package com.sammy.minersdelight.content.block;

import com.sammy.minersdelight.setup.MDItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import vectorwing.farmersdelight.common.BlockShapes;
import vectorwing.farmersdelight.common.block.FeastBlock;

public class StuffedSquidFeastBlock
extends FeastBlock {
    public static final IntegerProperty SERVINGS = IntegerProperty.create((String)"servings", (int)0, (int)5);
    protected static final VoxelShape[] FEAST_SHAPE = new VoxelShape[]{Block.box((double)0.0, (double)0.0, (double)0.0, (double)0.0, (double)0.0, (double)0.0), Block.box((double)2.0, (double)1.0, (double)2.0, (double)14.0, (double)6.0, (double)14.0), Block.box((double)2.0, (double)1.0, (double)2.0, (double)14.0, (double)7.0, (double)14.0), Block.box((double)2.0, (double)1.2, (double)2.0, (double)14.0, (double)8.2, (double)14.0), Block.box((double)2.0, (double)1.2, (double)2.0, (double)14.0, (double)11.2, (double)14.0), Block.box((double)2.0, (double)1.2, (double)2.0, (double)14.0, (double)12.2, (double)14.0)};

    public StuffedSquidFeastBlock(BlockBehaviour.Properties properties) {
        super(properties, () -> MDItems.BOWL_OF_STUFFED_SQUID.get(), true);
    }

    public int getMaxServings() {
        return 5;
    }

    public IntegerProperty getServingsProperty() {
        return SERVINGS;
    }

    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        int servings = (Integer)state.getValue((Property)SERVINGS);
        return Shapes.or((VoxelShape)BlockShapes.TRAY_SHAPE, (VoxelShape)FEAST_SHAPE[servings]);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING, SERVINGS});
    }
}

