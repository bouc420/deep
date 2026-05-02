/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  net.minecraft.core.Direction
 *  net.minecraft.data.PackOutput
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.level.block.FlowerBlock
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.neoforged.neoforge.client.model.generators.BlockModelBuilder
 *  net.neoforged.neoforge.client.model.generators.ConfiguredModel
 *  net.neoforged.neoforge.client.model.generators.ModelBuilder
 *  net.neoforged.neoforge.client.model.generators.ModelFile
 *  net.neoforged.neoforge.common.data.ExistingFileHelper
 *  team.lodestar.lodestone.systems.datagen.BlockStateSmithTypes
 *  team.lodestar.lodestone.systems.datagen.ItemModelSmithTypes
 *  team.lodestar.lodestone.systems.datagen.providers.LodestoneBlockStateProvider
 *  team.lodestar.lodestone.systems.datagen.providers.LodestoneItemModelProvider
 *  team.lodestar.lodestone.systems.datagen.statesmith.AbstractBlockStateSmith$StateSmithData
 *  team.lodestar.lodestone.systems.datagen.statesmith.BlockStateSmith
 *  vectorwing.farmersdelight.common.block.FeastBlock
 */
package com.sammy.minersdelight.datagen;

import com.sammy.minersdelight.MinersDelightMod;
import com.sammy.minersdelight.content.block.CaveCarrotBlock;
import com.sammy.minersdelight.content.block.FakeMeatloafFeastBlock;
import com.sammy.minersdelight.content.block.GlazedArachnidLimbsFeastBlock;
import com.sammy.minersdelight.content.block.StuffedSquidFeastBlock;
import com.sammy.minersdelight.content.block.WildCaveCarrotBlock;
import com.sammy.minersdelight.setup.MDBlocks;
import java.util.HashSet;
import java.util.function.Function;
import java.util.function.Supplier;
import javax.annotation.Nonnull;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import team.lodestar.lodestone.systems.datagen.BlockStateSmithTypes;
import team.lodestar.lodestone.systems.datagen.ItemModelSmithTypes;
import team.lodestar.lodestone.systems.datagen.providers.LodestoneBlockStateProvider;
import team.lodestar.lodestone.systems.datagen.providers.LodestoneItemModelProvider;
import team.lodestar.lodestone.systems.datagen.statesmith.AbstractBlockStateSmith;
import team.lodestar.lodestone.systems.datagen.statesmith.BlockStateSmith;
import vectorwing.farmersdelight.common.block.FeastBlock;

public class MDBlockStateDatagen
extends LodestoneBlockStateProvider {
    public static BlockStateSmith<StuffedSquidFeastBlock> STUFFED_SQUID = new BlockStateSmith(StuffedSquidFeastBlock.class, ItemModelSmithTypes.GENERATED_ITEM, (block, provider) -> {
        Function<BlockState, ModelFile> modelFunc = s -> {
            int servings = (Integer)s.getValue((Property)StuffedSquidFeastBlock.SERVINGS);
            String path = servings == 0 ? "block/stuffed_squid_block_leftover" : "block/stuffed_squid_block_stage" + (5 - servings);
            return provider.models().getExistingFile(MinersDelightMod.path(path));
        };
        provider.getVariantBuilder(block).forAllStates(s -> ConfiguredModel.builder().modelFile((ModelFile)modelFunc.apply((BlockState)s)).rotationY((int)((Direction)s.getValue((Property)FeastBlock.FACING)).toYRot() + 180).build());
    });
    public static BlockStateSmith<GlazedArachnidLimbsFeastBlock> GLAZED_ARACHNID_LIMBS = new BlockStateSmith(GlazedArachnidLimbsFeastBlock.class, ItemModelSmithTypes.GENERATED_ITEM, (block, provider) -> {
        Function<BlockState, ModelFile> modelFunc = s -> {
            int servings = (Integer)s.getValue((Property)GlazedArachnidLimbsFeastBlock.SERVINGS);
            String path = servings == 0 ? "block/glazed_arachnid_limbs_block_leftover" : "block/glazed_arachnid_limbs_block_stage" + (4 - servings);
            return provider.models().getExistingFile(MinersDelightMod.path(path));
        };
        provider.getVariantBuilder(block).forAllStates(s -> ConfiguredModel.builder().modelFile((ModelFile)modelFunc.apply((BlockState)s)).rotationY((int)((Direction)s.getValue((Property)FeastBlock.FACING)).toYRot() + 180).build());
    });
    public static BlockStateSmith<FakeMeatloafFeastBlock> FAKE_MEATLOAF = new BlockStateSmith(FakeMeatloafFeastBlock.class, ItemModelSmithTypes.GENERATED_ITEM, (block, provider) -> {
        Function<BlockState, ModelFile> modelFunc = s -> {
            int servings = (Integer)s.getValue((Property)FakeMeatloafFeastBlock.SERVINGS);
            String path = servings == 0 ? "block/fake_meatloaf_block_leftover" : "block/fake_meatloaf_block_stage" + (4 - servings);
            return provider.models().getExistingFile(MinersDelightMod.path(path));
        };
        provider.getVariantBuilder(block).forAllStates(s -> ConfiguredModel.builder().modelFile((ModelFile)modelFunc.apply((BlockState)s)).rotationY((int)((Direction)s.getValue((Property)FeastBlock.FACING)).toYRot() + 180).build());
    });
    public static BlockStateSmith<FlowerBlock> WILD_CROP_BLOCK = new BlockStateSmith(FlowerBlock.class, ItemModelSmithTypes.BLOCK_TEXTURE_ITEM, (block, provider) -> provider.getVariantBuilder(block).forAllStates(s -> {
        Object name = provider.getBlockName(block);
        if (((Boolean)s.getValue((Property)WildCaveCarrotBlock.STONE)).booleanValue()) {
            name = "stone_" + (String)name;
        }
        ModelBuilder cross = ((BlockModelBuilder)provider.models().withExistingParent((String)name, ResourceLocation.parse((String)"block/cross"))).texture("cross", MinersDelightMod.path("block/" + (String)name));
        ConfiguredModel.builder().modelFile((ModelFile)cross).build();
        return ConfiguredModel.builder().modelFile((ModelFile)cross).build();
    }));
    public static BlockStateSmith<CaveCarrotBlock> CAVE_CARROTS = new BlockStateSmith(CaveCarrotBlock.class, ItemModelSmithTypes.GENERATED_ITEM, (block, provider) -> provider.getVariantBuilder(block).forAllStates(s -> {
        String name = provider.getBlockName(block) + "_" + String.valueOf(s.getValue((Property)CaveCarrotBlock.AGE));
        ModelBuilder crop = ((BlockModelBuilder)provider.models().withExistingParent(name, ResourceLocation.parse((String)"block/crop"))).texture("crop", MinersDelightMod.path("block/" + name));
        return ConfiguredModel.builder().modelFile((ModelFile)crop).build();
    }));

    public MDBlockStateDatagen(PackOutput output, ExistingFileHelper exFileHelper, LodestoneItemModelProvider itemModelProvider) {
        super(output, "minersdelight", exFileHelper, itemModelProvider);
    }

    @Nonnull
    public String getName() {
        return "Miner's Delight BlockStates";
    }

    protected void registerStatesAndModels() {
        HashSet blocks = new HashSet(MDBlocks.BLOCKS.getEntries());
        AbstractBlockStateSmith.StateSmithData data = new AbstractBlockStateSmith.StateSmithData((LodestoneBlockStateProvider)this, blocks::remove);
        STUFFED_SQUID.act(data, new Supplier[]{MDBlocks.STUFFED_SQUID});
        FAKE_MEATLOAF.act(data, new Supplier[]{MDBlocks.FAKE_MEATLOAF});
        GLAZED_ARACHNID_LIMBS.act(data, new Supplier[]{MDBlocks.GLAZED_ARACHNID_LIMBS});
        WILD_CROP_BLOCK.act(data, new Supplier[]{MDBlocks.WILD_CAVE_CARROTS, MDBlocks.GOSSYPIUM});
        CAVE_CARROTS.act(data, new Supplier[]{MDBlocks.CAVE_CARROTS});
        BlockStateSmithTypes.POTTED_PLANT.act(data, new Supplier[]{MDBlocks.POTTED_GOSSYPIUM});
        BlockStateSmithTypes.CUSTOM_MODEL.act(data, ItemModelSmithTypes.BLOCK_MODEL_ITEM, (arg_0, arg_1) -> ((MDBlockStateDatagen)this).simpleBlock(arg_0, arg_1), arg_0 -> ((MDBlockStateDatagen)this).predefinedModel(arg_0), new Supplier[]{MDBlocks.CAVE_CARROT_CRATE});
    }
}

