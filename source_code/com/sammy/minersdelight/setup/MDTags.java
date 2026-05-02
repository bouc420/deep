/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.tags.BlockTags
 *  net.minecraft.tags.ItemTags
 *  net.minecraft.tags.TagKey
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.level.biome.Biome
 *  net.minecraft.world.level.block.Block
 */
package com.sammy.minersdelight.setup;

import com.sammy.minersdelight.MinersDelightMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class MDTags {
    public static final TagKey<Biome> HAS_CAVE_CARROTS = MDTags.modBiome("has_cave_carrots");
    public static final TagKey<Block> INFESTED_BLOCKS = MDTags.modBlock("infested_blocks");
    public static final TagKey<Block> CAVE_CARROTS_CROP_BLOCK = MDTags.commonBlock("crops/cave_carrot");
    public static final TagKey<Item> CAVE_CARROTS_VEGETABLE_ITEM = MDTags.commonItem("vegetables/cave_carrot");
    public static final TagKey<Item> CAVE_CARROTS_CROP_ITEM = MDTags.commonItem("crops/cave_carrot");
    public static final TagKey<Item> BAKED_CAVE_CARROT = MDTags.modItem("baked_cave_carrot");
    public static final TagKey<Item> MOSS = MDTags.commonItem("moss");
    public static final TagKey<Item> RAW_INSECT_MEAT = MDTags.modItem("raw_insect_meat");
    public static final TagKey<Item> COOKED_INSECT_MEAT = MDTags.modItem("cooked_insect_meat");
    public static final TagKey<Item> BAT_WING = MDTags.commonItem("foods/bat_wing");
    public static final TagKey<Item> SQUID = MDTags.commonItem("foods/squid");
    public static final TagKey<Item> GLOW_SQUID = MDTags.commonItem("foods/glow_squid");
    public static final TagKey<Item> RAW_FISHES_SQUID = MDTags.commonItem("foods/raw_squid");
    public static final TagKey<Item> COOKED_FISHES_SQUID = MDTags.commonItem("foods/cooked_squid");
    public static final TagKey<Item> TENTACLES = MDTags.commonItem("foods/tentacles");
    public static final TagKey<Item> BC_RAW_MEATS = MDTags.modItem("brewinandchewin:raw_meats");

    private static TagKey<Item> modItem(String path) {
        return ItemTags.create((ResourceLocation)(path.contains(":") ? ResourceLocation.parse((String)path) : MinersDelightMod.path(path)));
    }

    private static TagKey<Block> modBlock(String path) {
        return BlockTags.create((ResourceLocation)(path.contains(":") ? ResourceLocation.parse((String)path) : MinersDelightMod.path(path)));
    }

    private static TagKey<Biome> modBiome(String path) {
        return TagKey.create((ResourceKey)Registries.BIOME, (ResourceLocation)(path.contains(":") ? ResourceLocation.parse((String)path) : MinersDelightMod.path(path)));
    }

    private static TagKey<Item> commonItem(String path) {
        return ItemTags.create((ResourceLocation)ResourceLocation.fromNamespaceAndPath((String)"c", (String)path));
    }

    private static TagKey<Block> commonBlock(String path) {
        return BlockTags.create((ResourceLocation)ResourceLocation.fromNamespaceAndPath((String)"forge", (String)path));
    }
}

