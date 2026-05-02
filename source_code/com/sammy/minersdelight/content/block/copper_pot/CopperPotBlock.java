/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.core.Vec3i
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.Containers
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.ItemInteractionResult
 *  net.minecraft.world.MenuProvider
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.context.BlockPlaceContext
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.BaseEntityBlock
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.RenderShape
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
 *  net.minecraft.world.level.block.state.properties.EnumProperty
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.material.Fluid
 *  net.minecraft.world.level.material.FluidState
 *  net.minecraft.world.level.material.Fluids
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.Shapes
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  net.neoforged.neoforge.data.loading.DatagenModLoader
 *  net.neoforged.neoforge.items.IItemHandlerModifiable
 *  net.neoforged.neoforge.items.ItemStackHandler
 *  vectorwing.farmersdelight.common.block.state.CookingPotSupport
 *  vectorwing.farmersdelight.common.registry.ModSounds
 *  vectorwing.farmersdelight.common.tag.ModTags$Blocks
 *  vectorwing.farmersdelight.common.utility.MathUtils
 */
package com.sammy.minersdelight.content.block.copper_pot;

import com.mojang.serialization.MapCodec;
import com.sammy.minersdelight.content.block.copper_pot.CopperPotBlockEntity;
import com.sammy.minersdelight.setup.MDBlockEntities;
import java.util.Optional;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
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
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.data.loading.DatagenModLoader;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.ItemStackHandler;
import vectorwing.farmersdelight.common.block.state.CookingPotSupport;
import vectorwing.farmersdelight.common.registry.ModSounds;
import vectorwing.farmersdelight.common.tag.ModTags;
import vectorwing.farmersdelight.common.utility.MathUtils;

public class CopperPotBlock
extends BaseEntityBlock
implements SimpleWaterloggedBlock {
    public static final MapCodec<CopperPotBlock> CODEC = CopperPotBlock.simpleCodec(CopperPotBlock::new);
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final EnumProperty<CookingPotSupport> SUPPORT = EnumProperty.create((String)"support", CookingPotSupport.class);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    protected static final VoxelShape SHAPE = Block.box((double)3.0, (double)0.0, (double)3.0, (double)13.0, (double)8.0, (double)13.0);
    protected static final VoxelShape SHAPE_WITH_TRAY = Shapes.or((VoxelShape)SHAPE, (VoxelShape)Block.box((double)0.0, (double)-1.0, (double)0.0, (double)16.0, (double)0.0, (double)16.0));

    public CopperPotBlock(BlockBehaviour.Properties properties) {
        super(DatagenModLoader.isRunningDataGen() ? properties.noLootTable() : properties);
        this.registerDefaultState((BlockState)((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue((Property)FACING, (Comparable)Direction.NORTH)).setValue(SUPPORT, (Comparable)CookingPotSupport.NONE)).setValue((Property)WATERLOGGED, (Comparable)Boolean.valueOf(false)));
    }

    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    public ItemInteractionResult useItemOn(ItemStack heldStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if (heldStack.isEmpty() && player.isShiftKeyDown()) {
            level.setBlockAndUpdate(pos, (BlockState)state.setValue(SUPPORT, (Comparable)(((CookingPotSupport)state.getValue(SUPPORT)).equals((Object)CookingPotSupport.HANDLE) ? this.getTrayState((LevelAccessor)level, pos) : CookingPotSupport.HANDLE)));
            level.playSound(null, pos, SoundEvents.LANTERN_PLACE, SoundSource.BLOCKS, 0.7f, 1.0f);
        } else if (!level.isClientSide) {
            BlockEntity tileEntity = level.getBlockEntity(pos);
            if (tileEntity instanceof CopperPotBlockEntity) {
                CopperPotBlockEntity cookingPotEntity = (CopperPotBlockEntity)tileEntity;
                ItemStack servingStack = cookingPotEntity.useHeldItemOnMeal(heldStack);
                if (servingStack != ItemStack.EMPTY) {
                    if (!player.getInventory().add(servingStack)) {
                        player.drop(servingStack, false);
                    }
                    level.playSound(null, pos, (SoundEvent)SoundEvents.ARMOR_EQUIP_GENERIC.value(), SoundSource.BLOCKS, 1.0f, 1.0f);
                } else {
                    player.openMenu((MenuProvider)cookingPotEntity, pos);
                }
            }
            return ItemInteractionResult.SUCCESS;
        }
        return ItemInteractionResult.SUCCESS;
    }

    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return ((CookingPotSupport)state.getValue(SUPPORT)).equals((Object)CookingPotSupport.TRAY) ? SHAPE_WITH_TRAY : SHAPE;
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos pos = context.getClickedPos();
        Level level = context.getLevel();
        FluidState fluid = level.getFluidState(context.getClickedPos());
        BlockState state = (BlockState)((BlockState)this.defaultBlockState().setValue((Property)FACING, (Comparable)context.getHorizontalDirection().getOpposite())).setValue((Property)WATERLOGGED, (Comparable)Boolean.valueOf(fluid.getType() == Fluids.WATER));
        if (context.getClickedFace().equals((Object)Direction.DOWN)) {
            return (BlockState)state.setValue(SUPPORT, (Comparable)CookingPotSupport.HANDLE);
        }
        return (BlockState)state.setValue(SUPPORT, (Comparable)this.getTrayState((LevelAccessor)level, pos));
    }

    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        if (((Boolean)state.getValue((Property)WATERLOGGED)).booleanValue()) {
            level.scheduleTick(currentPos, (Fluid)Fluids.WATER, Fluids.WATER.getTickDelay((LevelReader)level));
        }
        if (facing.getAxis().equals((Object)Direction.Axis.Y) && !((CookingPotSupport)state.getValue(SUPPORT)).equals((Object)CookingPotSupport.HANDLE)) {
            return (BlockState)state.setValue(SUPPORT, (Comparable)this.getTrayState(level, currentPos));
        }
        return state;
    }

    private CookingPotSupport getTrayState(LevelAccessor level, BlockPos pos) {
        if (level.getBlockState(pos.below()).is(ModTags.Blocks.TRAY_HEAT_SOURCES)) {
            return CookingPotSupport.TRAY;
        }
        return CookingPotSupport.NONE;
    }

    public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state) {
        ItemStack stack = super.getCloneItemStack(level, pos, state);
        Optional cookingPot = level.getBlockEntity(pos, (BlockEntityType)MDBlockEntities.COPPER_POT.get());
        if (cookingPot.isPresent()) {
            stack = ((CopperPotBlockEntity)((Object)cookingPot.get())).getAsItem();
        }
        return stack;
    }

    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity tileEntity = level.getBlockEntity(pos);
            if (tileEntity instanceof CopperPotBlockEntity) {
                CopperPotBlockEntity cookingPotEntity = (CopperPotBlockEntity)tileEntity;
                Containers.dropContents((Level)level, (BlockPos)pos, cookingPotEntity.getDroppableInventory());
                cookingPotEntity.getUsedRecipesAndPopExperience(level, Vec3.atCenterOf((Vec3i)pos));
                level.updateNeighbourForOutputSignal(pos, (Block)this);
            }
            super.onRemove(state, level, pos, newState, isMoving);
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(new Property[]{FACING, SUPPORT, WATERLOGGED});
    }

    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        CopperPotBlockEntity cookingPotEntity;
        BlockEntity tileEntity = level.getBlockEntity(pos);
        if (tileEntity instanceof CopperPotBlockEntity && (cookingPotEntity = (CopperPotBlockEntity)tileEntity).isHeated()) {
            SoundEvent boilSound = !cookingPotEntity.getMeal().isEmpty() ? (SoundEvent)ModSounds.BLOCK_COOKING_POT_BOIL_SOUP.get() : (SoundEvent)ModSounds.BLOCK_COOKING_POT_BOIL.get();
            double x = (double)pos.getX() + 0.5;
            double y = pos.getY();
            double z = (double)pos.getZ() + 0.5;
            if (random.nextInt(10) == 0) {
                level.playLocalSound(x, y, z, boilSound, SoundSource.BLOCKS, 0.5f, random.nextFloat() * 0.2f + 0.9f, false);
            }
        }
    }

    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    public int getAnalogOutputSignal(BlockState blockState, Level level, BlockPos pos) {
        BlockEntity tileEntity = level.getBlockEntity(pos);
        if (tileEntity instanceof CopperPotBlockEntity) {
            ItemStackHandler inventory = ((CopperPotBlockEntity)tileEntity).getInventory();
            return MathUtils.calcRedstoneFromItemHandler((IItemHandlerModifiable)inventory);
        }
        return 0;
    }

    public FluidState getFluidState(BlockState state) {
        return (Boolean)state.getValue((Property)WATERLOGGED) != false ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return ((BlockEntityType)MDBlockEntities.COPPER_POT.get()).create(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntity) {
        if (level.isClientSide) {
            return CopperPotBlock.createTickerHelper(blockEntity, (BlockEntityType)((BlockEntityType)MDBlockEntities.COPPER_POT.get()), CopperPotBlockEntity::animationTick);
        }
        return CopperPotBlock.createTickerHelper(blockEntity, (BlockEntityType)((BlockEntityType)MDBlockEntities.COPPER_POT.get()), CopperPotBlockEntity::cookingTick);
    }
}

