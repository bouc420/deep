/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
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
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import vectorwing.farmersdelight.common.BlockShapes;
import vectorwing.farmersdelight.common.block.FeastBlock;

public class GlazedArachnidLimbsFeastBlock
extends FeastBlock {
    protected static final VoxelShape[] FEAST_SHAPE = new VoxelShape[]{Block.box((double)0.0, (double)0.0, (double)0.0, (double)0.0, (double)0.0, (double)0.0), Block.box((double)4.0, (double)2.0, (double)4.0, (double)12.0, (double)4.0, (double)12.0), Block.box((double)2.0, (double)2.0, (double)2.0, (double)14.0, (double)4.0, (double)14.0), Shapes.or((VoxelShape)Block.box((double)2.0, (double)2.0, (double)2.0, (double)14.0, (double)6.0, (double)14.0), (VoxelShape)Block.box((double)6.0, (double)6.0, (double)6.0, (double)10.0, (double)11.0, (double)10.0)), Shapes.or((VoxelShape)Block.box((double)2.0, (double)2.0, (double)2.0, (double)14.0, (double)7.0, (double)14.0), (VoxelShape)Block.box((double)6.0, (double)7.0, (double)6.0, (double)10.0, (double)13.0, (double)10.0))};

    public GlazedArachnidLimbsFeastBlock(BlockBehaviour.Properties properties) {
        super(properties, () -> MDItems.PLATE_OF_GLAZED_ARACHNID_LIMBS.get(), true);
    }

    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        int servings = (Integer)state.getValue((Property)SERVINGS);
        return Shapes.or((VoxelShape)BlockShapes.TRAY_SHAPE, (VoxelShape)FEAST_SHAPE[servings]);
    }
}

