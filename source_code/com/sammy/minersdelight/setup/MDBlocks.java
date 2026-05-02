/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.tags.BlockTags
 *  net.minecraft.tags.TagKey
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.FlowerPotBlock
 *  net.minecraft.world.level.block.SoundType
 *  net.minecraft.world.level.block.state.BlockBehaviour
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.material.PushReaction
 *  net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent
 *  net.neoforged.neoforge.registries.DeferredHolder
 *  net.neoforged.neoforge.registries.DeferredRegister
 *  team.lodestar.lodestone.systems.block.LodestoneBlockProperties
 *  vectorwing.farmersdelight.common.tag.ModTags$Blocks
 */
package com.sammy.minersdelight.setup;

import com.sammy.minersdelight.content.block.CaveCarrotBlock;
import com.sammy.minersdelight.content.block.FakeMeatloafFeastBlock;
import com.sammy.minersdelight.content.block.GlazedArachnidLimbsFeastBlock;
import com.sammy.minersdelight.content.block.GossypiumFlowerBlock;
import com.sammy.minersdelight.content.block.StuffedSquidFeastBlock;
import com.sammy.minersdelight.content.block.WildCaveCarrotBlock;
import com.sammy.minersdelight.content.block.copper_pot.CopperPotBlock;
import com.sammy.minersdelight.content.block.sticky_basket.StickyBasketBlock;
import com.sammy.minersdelight.setup.MDTags;
import java.util.function.Supplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import team.lodestar.lodestone.systems.block.LodestoneBlockProperties;
import vectorwing.farmersdelight.common.tag.ModTags;

public class MDBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create((ResourceKey)Registries.BLOCK, (String)"minersdelight");
    public static final Supplier<Block> COPPER_POT = BLOCKS.register("copper_pot", () -> new CopperPotBlock((BlockBehaviour.Properties)LodestoneBlockProperties.of().setCutoutRenderType().needsPickaxe().strength(2.25f).sound(SoundType.COPPER)));
    public static final Supplier<Block> STICKY_BASKET = BLOCKS.register("sticky_basket", () -> new StickyBasketBlock((BlockBehaviour.Properties)LodestoneBlockProperties.of().setCutoutRenderType().needsAxe().strength(1.5f).sound(SoundType.BAMBOO_WOOD)));
    public static final Supplier<Block> STUFFED_SQUID = BLOCKS.register("stuffed_squid", () -> new StuffedSquidFeastBlock((BlockBehaviour.Properties)LodestoneBlockProperties.copy((BlockBehaviour)Blocks.CAKE).needsAxe()));
    public static final Supplier<Block> FAKE_MEATLOAF = BLOCKS.register("fake_meatloaf", () -> new FakeMeatloafFeastBlock((BlockBehaviour.Properties)LodestoneBlockProperties.copy((BlockBehaviour)Blocks.CAKE).needsAxe()));
    public static final Supplier<Block> GLAZED_ARACHNID_LIMBS = BLOCKS.register("glazed_arachnid_limbs", () -> new GlazedArachnidLimbsFeastBlock((BlockBehaviour.Properties)LodestoneBlockProperties.copy((BlockBehaviour)Blocks.CAKE).needsAxe()));
    public static final Supplier<Block> WILD_CAVE_CARROTS = BLOCKS.register("wild_cave_carrots", () -> new WildCaveCarrotBlock((BlockBehaviour.Properties)LodestoneBlockProperties.copy((BlockBehaviour)Blocks.TALL_GRASS).addTags(new TagKey[]{BlockTags.SMALL_FLOWERS, ModTags.Blocks.WILD_CROPS, ModTags.Blocks.COMPOST_ACTIVATORS}).randomTicks().setCutoutRenderType()));
    public static final Supplier<Block> CAVE_CARROTS = BLOCKS.register("cave_carrots", () -> new CaveCarrotBlock((BlockBehaviour.Properties)LodestoneBlockProperties.copy((BlockBehaviour)Blocks.CARROTS).addTags(new TagKey[]{BlockTags.CROPS, MDTags.CAVE_CARROTS_CROP_BLOCK}).setCutoutRenderType()));
    public static final Supplier<Block> CAVE_CARROT_CRATE = BLOCKS.register("cave_carrot_crate", () -> new Block((BlockBehaviour.Properties)LodestoneBlockProperties.copy((BlockBehaviour)Blocks.OAK_PLANKS).strength(2.0f, 3.0f).sound(SoundType.WOOD).needsAxe()));
    public static final DeferredHolder<Block, Block> GOSSYPIUM = BLOCKS.register("gossypium", () -> new GossypiumFlowerBlock((BlockBehaviour.Properties)LodestoneBlockProperties.copy((BlockBehaviour)Blocks.TALL_GRASS).addTag(ModTags.Blocks.WILD_CROPS).setCutoutRenderType()));
    public static final DeferredHolder<Block, Block> POTTED_GOSSYPIUM = BLOCKS.register("potted_gossypium", () -> new FlowerPotBlock(() -> (FlowerPotBlock)Blocks.FLOWER_POT, GOSSYPIUM, (BlockBehaviour.Properties)new LodestoneBlockProperties().setCutoutRenderType().addTag(BlockTags.FLOWER_POTS).instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)));

    public static void addPottedBlocks(FMLCommonSetupEvent event) {
        FlowerPotBlock flowerPot = (FlowerPotBlock)Blocks.FLOWER_POT;
        flowerPot.addPlant(GOSSYPIUM.getId(), POTTED_GOSSYPIUM);
    }
}

