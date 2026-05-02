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
 *  net.minecraft.world.phys.shapes.BooleanOp
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
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import vectorwing.farmersdelight.common.BlockShapes;
import vectorwing.farmersdelight.common.block.FeastBlock;

public class FakeMeatloafFeastBlock
extends FeastBlock {
    protected static final VoxelShape FEAST_SHAPE = Shapes.joinUnoptimized((VoxelShape)BlockShapes.TRAY_SHAPE, (VoxelShape)Block.box((double)5.0, (double)2.0, (double)5.0, (double)11.0, (double)5.0, (double)11.0), (BooleanOp)BooleanOp.OR);

    public FakeMeatloafFeastBlock(BlockBehaviour.Properties properties) {
        super(properties, () -> MDItems.PLATE_OF_FAKE_MEATLOAF.get(), true);
    }

    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        int servings = (Integer)state.getValue((Property)SERVINGS);
        return servings == 0 ? BlockShapes.TRAY_SHAPE : FEAST_SHAPE;
    }
}

