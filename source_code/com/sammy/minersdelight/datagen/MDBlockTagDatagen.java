/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.data.PackOutput
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.neoforged.neoforge.common.Tags$Blocks
 *  net.neoforged.neoforge.common.data.ExistingFileHelper
 *  team.lodestar.lodestone.systems.datagen.providers.LodestoneBlockTagsProvider
 *  vectorwing.farmersdelight.common.tag.ModTags$Blocks
 */
package com.sammy.minersdelight.datagen;

import com.sammy.minersdelight.setup.MDBlocks;
import com.sammy.minersdelight.setup.MDTags;
import java.util.HashSet;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import team.lodestar.lodestone.systems.datagen.providers.LodestoneBlockTagsProvider;
import vectorwing.farmersdelight.common.tag.ModTags;

public class MDBlockTagDatagen
extends LodestoneBlockTagsProvider {
    public MDBlockTagDatagen(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, "minersdelight", existingFileHelper);
    }

    public String getName() {
        return "MD Block Tags";
    }

    protected void addTags(HolderLookup.Provider pProvider) {
        HashSet blocks = new HashSet(MDBlocks.BLOCKS.getEntries());
        this.tag(MDTags.INFESTED_BLOCKS).addTag(Tags.Blocks.COBBLESTONES_INFESTED).add((Object[])new Block[]{Blocks.INFESTED_STONE, Blocks.INFESTED_STONE_BRICKS, Blocks.INFESTED_CRACKED_STONE_BRICKS, Blocks.INFESTED_MOSSY_STONE_BRICKS, Blocks.INFESTED_CHISELED_STONE_BRICKS, Blocks.INFESTED_DEEPSLATE});
        this.tag(ModTags.Blocks.FEASTS).add((Object[])new Block[]{MDBlocks.STUFFED_SQUID.get(), MDBlocks.GLAZED_ARACHNID_LIMBS.get(), MDBlocks.FAKE_MEATLOAF.get()});
        this.tag(ModTags.Blocks.MINEABLE_WITH_KNIFE).add((Object[])new Block[]{MDBlocks.STUFFED_SQUID.get(), MDBlocks.GLAZED_ARACHNID_LIMBS.get(), MDBlocks.FAKE_MEATLOAF.get()});
        this.addTagsFromBlockProperties(blocks);
    }
}

