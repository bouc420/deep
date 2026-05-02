/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableMap
 *  com.google.common.collect.Maps
 *  com.mojang.serialization.MapCodec
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.world.Container
 *  net.minecraft.world.Containers
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.MenuProvider
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.inventory.AbstractContainerMenu
 *  net.minecraft.world.item.context.BlockPlaceContext
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.BaseEntityBlock
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Mirror
 *  net.minecraft.world.level.block.RenderShape
 *  net.minecraft.world.level.block.Rotation
 *  net.minecraft.world.level.block.SimpleWaterloggedBlock
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.entity.BlockEntityTicker
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.StateDefinition$Builder
 *  net.minecraft.world.level.block.state.properties.BlockStateProperties
 *  net.minecraft.world.level.block.state.properties.BooleanProperty
 *  net.minecraft.world.level.block.state.properties.DirectionProperty
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.material.Fluid
 *  net.minecraft.world.level.material.FluidState
 *  net.minecraft.world.level.material.Fluids
 *  net.minecraft.world.level.pathfinder.PathComputationType
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.BooleanOp
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.Shapes
 *  net.minecraft.world.phys.shapes.VoxelShape
 */
package com.sammy.minersdelight.content.block.sticky_basket;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.mojang.serialization.MapCodec;
import com.sammy.minersdelight.content.block.sticky_basket.StickyBasketBlockEntity;
import com.sammy.minersdelight.setup.MDBlockEntities;
import java.util.Map;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class StickyBasketBlock
extends BaseEntityBlock
implements SimpleWaterloggedBlock {
    public static final MapCodec<StickyBasketBlock> CODEC = StickyBasketBlock.simpleCodec(StickyBasketBlock::new);
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    public static final BooleanProperty ENABLED = BlockStateProperties.ENABLED;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final VoxelShape OUT_SHAPE = Shapes.block();
    public static final VoxelShape RENDER_SHAPE = StickyBasketBlock.box((double)1.0, (double)1.0, (double)1.0, (double)15.0, (double)15.0, (double)15.0);
    public static final ImmutableMap<Direction, VoxelShape> COLLISION_SHAPE_FACING = Maps.immutableEnumMap((Map)ImmutableMap.builder().put((Object)Direction.DOWN, (Object)StickyBasketBlock.makeHollowCubeShape(StickyBasketBlock.box((double)2.0, (double)0.0, (double)2.0, (double)14.0, (double)14.0, (double)14.0))).put((Object)Direction.UP, (Object)StickyBasketBlock.makeHollowCubeShape(StickyBasketBlock.box((double)2.0, (double)2.0, (double)2.0, (double)14.0, (double)16.0, (double)14.0))).put((Object)Direction.NORTH, (Object)StickyBasketBlock.makeHollowCubeShape(StickyBasketBlock.box((double)2.0, (double)2.0, (double)0.0, (double)14.0, (double)14.0, (double)14.0))).put((Object)Direction.SOUTH, (Object)StickyBasketBlock.makeHollowCubeShape(StickyBasketBlock.box((double)2.0, (double)2.0, (double)2.0, (double)14.0, (double)14.0, (double)16.0))).put((Object)Direction.WEST, (Object)StickyBasketBlock.makeHollowCubeShape(StickyBasketBlock.box((double)0.0, (double)2.0, (double)2.0, (double)14.0, (double)14.0, (double)14.0))).put((Object)Direction.EAST, (Object)StickyBasketBlock.makeHollowCubeShape(StickyBasketBlock.box((double)2.0, (double)2.0, (double)2.0, (double)16.0, (double)14.0, (double)14.0))).build());

    private static VoxelShape makeHollowCubeShape(VoxelShape cutout) {
        return Shapes.joinUnoptimized((VoxelShape)OUT_SHAPE, (VoxelShape)cutout, (BooleanOp)BooleanOp.ONLY_FIRST).optimize();
    }

    public StickyBasketBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState((BlockState)((BlockState)((BlockState)this.getStateDefinition().any()).setValue((Property)FACING, (Comparable)Direction.UP)).setValue((Property)WATERLOGGED, (Comparable)Boolean.valueOf(false)));
    }

    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return (VoxelShape)COLLISION_SHAPE_FACING.get((Object)state.getValue((Property)FACING));
    }

    public VoxelShape getOcclusionShape(BlockState state, BlockGetter level, BlockPos pos) {
        return RENDER_SHAPE;
    }

    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING, ENABLED, WATERLOGGED});
    }

    public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
        BlockEntity tileEntity;
        if (!level.isClientSide && (tileEntity = level.getBlockEntity(pos)) instanceof StickyBasketBlockEntity) {
            player.openMenu((MenuProvider)((StickyBasketBlockEntity)tileEntity));
        }
        return InteractionResult.SUCCESS;
    }

    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity tileEntity = level.getBlockEntity(pos);
            if (tileEntity instanceof Container) {
                Containers.dropContents((Level)level, (BlockPos)pos, (Container)((Container)tileEntity));
                level.updateNeighbourForOutputSignal(pos, (Block)this);
            }
            super.onRemove(state, level, pos, newState, isMoving);
        }
    }

    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if (pEntity instanceof LivingEntity) {
            Player player;
            LivingEntity livingEntity = (LivingEntity)pEntity;
            if (livingEntity instanceof Player && (player = (Player)livingEntity).isCrouching()) {
                return;
            }
            if (!((Boolean)pState.getValue((Property)WATERLOGGED)).booleanValue()) {
                Vec3 friction = new Vec3(0.25, (double)0.05f, 0.25);
                if (livingEntity.hasEffect(MobEffects.WEAVING)) {
                    friction = new Vec3(0.5, 0.25, 0.5);
                }
                pEntity.makeStuckInBlock(pState, friction);
            }
        }
    }

    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        if (((Boolean)state.getValue((Property)WATERLOGGED)).booleanValue()) {
            level.scheduleTick(currentPos, (Fluid)Fluids.WATER, Fluids.WATER.getTickDelay((LevelReader)level));
        }
        return super.updateShape(state, facing, facingState, level, currentPos, facingPos);
    }

    public FluidState getFluidState(BlockState state) {
        return (Boolean)state.getValue((Property)WATERLOGGED) != false ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        boolean isPowered;
        boolean bl = isPowered = !level.hasNeighborSignal(pos);
        if (isPowered != (Boolean)state.getValue((Property)ENABLED)) {
            level.setBlock(pos, (BlockState)state.setValue((Property)ENABLED, (Comparable)Boolean.valueOf(isPowered)), 4);
        }
    }

    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    public int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos) {
        return AbstractContainerMenu.getRedstoneSignalFromBlockEntity((BlockEntity)level.getBlockEntity(pos));
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
        return (BlockState)((BlockState)this.defaultBlockState().setValue((Property)FACING, (Comparable)context.getNearestLookingDirection().getOpposite())).setValue((Property)WATERLOGGED, (Comparable)Boolean.valueOf(fluid.getType() == Fluids.WATER));
    }

    public BlockState rotate(BlockState state, Rotation rotation) {
        return (BlockState)state.setValue((Property)FACING, (Comparable)rotation.rotate((Direction)state.getValue((Property)FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation((Direction)state.getValue((Property)FACING)));
    }

    public boolean useShapeForLightOcclusion(BlockState state) {
        return true;
    }

    public VoxelShape getInteractionShape(BlockState state, BlockGetter level, BlockPos pos) {
        return OUT_SHAPE;
    }

    protected boolean isPathfindable(BlockState state, PathComputationType type) {
        return false;
    }

    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new StickyBasketBlockEntity(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return level.isClientSide ? null : StickyBasketBlock.createTickerHelper(blockEntityType, (BlockEntityType)((BlockEntityType)MDBlockEntities.STICKY_BASKET.get()), StickyBasketBlockEntity::pushItemsTick);
    }
}

