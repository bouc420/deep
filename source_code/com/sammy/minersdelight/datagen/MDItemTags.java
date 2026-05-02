/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.data.PackOutput
 *  net.minecraft.data.tags.ItemTagsProvider
 *  net.minecraft.data.tags.TagsProvider$TagLookup
 *  net.minecraft.tags.ItemTags
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.level.block.Block
 *  net.neoforged.neoforge.common.Tags$Items
 *  net.neoforged.neoforge.common.data.ExistingFileHelper
 *  vectorwing.farmersdelight.common.tag.CommonTags$Items
 *  vectorwing.farmersdelight.common.tag.ModTags$Items
 */
package com.sammy.minersdelight.datagen;

import com.sammy.minersdelight.setup.MDItems;
import com.sammy.minersdelight.setup.MDTags;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.common.tag.ModTags;

public class MDItemTags
extends ItemTagsProvider {
    public MDItemTags(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagsProvider.TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, "minersdelight", existingFileHelper);
    }

    public String getName() {
        return "MD Item Tags";
    }

    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(MDTags.MOSS).add((Object[])new Item[]{Items.MOSS_BLOCK, (Item)MDItems.MOSS.get()});
        this.tag(Tags.Items.BUCKETS_MILK).add((Object)((Item)MDItems.MILK_CUP.get()));
        this.tag(Tags.Items.DRINKS_MILK).add((Object)((Item)MDItems.MILK_CUP.get()));
        this.tag(ItemTags.WOLF_FOOD).addTag(MDTags.CAVE_CARROTS_CROP_ITEM).add((Object[])new Item[]{(Item)MDItems.BAT_WING.get(), (Item)MDItems.SMOKED_BAT_WING.get(), (Item)MDItems.BAT_COOKIE.get(), (Item)MDItems.SPIDER_LEG.get(), (Item)MDItems.BAKED_SPIDER_LEG.get()});
        this.tag(ItemTags.CAT_FOOD).addTag(MDTags.RAW_FISHES_SQUID);
        this.tag(Tags.Items.CROPS).add((Object)((Item)MDItems.CAVE_CARROT.get()));
        this.tag(ModTags.Items.WILD_CROPS).add((Object)((Item)MDItems.GOSSYPIUM.get()));
        this.tag(MDTags.CAVE_CARROTS_CROP_ITEM).add((Object)((Item)MDItems.CAVE_CARROT.get()));
        this.tag(MDTags.CAVE_CARROTS_VEGETABLE_ITEM).add((Object)((Item)MDItems.CAVE_CARROT.get()));
        this.tag(MDTags.BAKED_CAVE_CARROT).add((Object[])new Item[]{(Item)MDItems.BAKED_CAVE_CARROT.get(), (Item)MDItems.VEGAN_PATTY.get()});
        this.tag(MDTags.BAT_WING).add((Object[])new Item[]{(Item)MDItems.BAT_WING.get(), (Item)MDItems.SMOKED_BAT_WING.get()});
        this.tag(MDTags.RAW_INSECT_MEAT).add((Object[])new Item[]{(Item)MDItems.SPIDER_LEG.get(), (Item)MDItems.ARTHROPOD.get()});
        this.tag(MDTags.BC_RAW_MEATS).add((Object[])new Item[]{(Item)MDItems.SPIDER_LEG.get(), (Item)MDItems.ARTHROPOD.get(), (Item)MDItems.CRUNCHY_BAR.get()});
        this.tag(MDTags.COOKED_INSECT_MEAT).add((Object[])new Item[]{(Item)MDItems.BAKED_SPIDER_LEG.get(), (Item)MDItems.COOKED_ARTHROPOD.get(), (Item)MDItems.CRUNCHY_BAR.get()});
        this.tag(ItemTags.FISHES).add((Object[])new Item[]{(Item)MDItems.SQUID.get(), (Item)MDItems.GLOW_SQUID.get(), (Item)MDItems.BAKED_SQUID.get()});
        this.tag(MDTags.SQUID).add((Object[])new Item[]{(Item)MDItems.SQUID.get(), (Item)MDItems.GLOW_SQUID.get(), (Item)MDItems.BAKED_SQUID.get()});
        this.tag(MDTags.RAW_FISHES_SQUID).add((Object[])new Item[]{(Item)MDItems.SQUID.get(), (Item)MDItems.GLOW_SQUID.get(), (Item)MDItems.TENTACLES.get()});
        this.tag(MDTags.GLOW_SQUID).add((Object)((Item)MDItems.GLOW_SQUID.get()));
        this.tag(MDTags.COOKED_FISHES_SQUID).add((Object)((Item)MDItems.BAKED_SQUID.get()));
        this.tag(MDTags.TENTACLES).add((Object[])new Item[]{(Item)MDItems.TENTACLES.get(), (Item)MDItems.BAKED_TENTACLES.get()});
        this.tag(CommonTags.Items.FOODS_SAFE_RAW_FISH).addTag(MDTags.RAW_FISHES_SQUID);
        this.tag(ModTags.Items.FEASTS).add((Object[])new Item[]{(Item)MDItems.STUFFED_SQUID.get(), (Item)MDItems.FAKE_MEATLOAF.get(), (Item)MDItems.GLAZED_ARACHNID_LIMBS.get()});
        this.tag(Tags.Items.FOODS_RAW_MEAT).addTag(MDTags.RAW_INSECT_MEAT);
        this.tag(Tags.Items.FOODS_SOUP).add((Object[])new Item[]{(Item)MDItems.CAVE_SOUP.get(), (Item)MDItems.BAT_SOUP.get(), (Item)MDItems.INSECT_STEW.get()});
        this.tag(Tags.Items.FOODS).add((Object[])new Item[]{(Item)MDItems.CAVE_CARROT.get(), (Item)MDItems.BAKED_CAVE_CARROT.get(), (Item)MDItems.COPPER_CARROT.get(), (Item)MDItems.PASTA_WITH_VEGGIEBALLS.get(), (Item)MDItems.CAVE_SOUP.get(), (Item)MDItems.VEGAN_PATTY.get(), (Item)MDItems.VEGAN_HAMBURGER.get(), (Item)MDItems.VEGAN_WRAP.get(), (Item)MDItems.VEGAN_STEAK_AND_POTATOES.get(), (Item)MDItems.BAT_WING.get(), (Item)MDItems.SMOKED_BAT_WING.get(), (Item)MDItems.BAT_ROLLS.get(), (Item)MDItems.CAVE_HAMBURGER.get(), (Item)MDItems.BAT_SOUP.get(), (Item)MDItems.IMPROVISED_BARBECUE_STICK.get(), (Item)MDItems.BAT_COOKIE.get(), (Item)MDItems.SPIDER_LEG.get(), (Item)MDItems.BAKED_SPIDER_LEG.get(), (Item)MDItems.SILVERFISH_EGGS.get(), (Item)MDItems.WEIRD_CAVIAR.get(), (Item)MDItems.ARTHROPOD.get(), (Item)MDItems.COOKED_ARTHROPOD.get(), (Item)MDItems.INSECT_SANDWICH.get(), (Item)MDItems.INSECT_WRAP.get(), (Item)MDItems.INSECT_STEW.get(), (Item)MDItems.SEASONED_ARTHROPODS.get(), (Item)MDItems.CRUNCHY_BAR.get(), (Item)MDItems.NUTRITIONAL_BAR.get(), (Item)MDItems.GOLDEN_NUTRITIONAL_BAR.get(), (Item)MDItems.GLOW_INK_PASTA.get(), (Item)MDItems.GLOW_SQUID.get(), (Item)MDItems.SQUID.get(), (Item)MDItems.BAKED_SQUID.get(), (Item)MDItems.TENTACLES.get(), (Item)MDItems.BAKED_TENTACLES.get(), (Item)MDItems.SQUID_SANDWICH.get(), (Item)MDItems.TAKOYAKI.get(), (Item)MDItems.TENTACLES_ON_A_STICK.get(), (Item)MDItems.BOWL_OF_STUFFED_SQUID.get(), (Item)MDItems.MOSS.get()});
        this.tag(ModTags.Items.MEALS).add((Object[])new Item[]{(Item)MDItems.CAVE_SOUP.get(), (Item)MDItems.BAT_SOUP.get(), (Item)MDItems.INSECT_STEW.get(), (Item)MDItems.GLOW_INK_PASTA.get(), (Item)MDItems.PASTA_WITH_VEGGIEBALLS.get(), (Item)MDItems.VEGAN_STEAK_AND_POTATOES.get(), (Item)MDItems.PLATE_OF_FAKE_MEATLOAF.get(), (Item)MDItems.SEASONED_ARTHROPODS.get(), (Item)MDItems.PLATE_OF_GLAZED_ARACHNID_LIMBS.get(), (Item)MDItems.BOWL_OF_STUFFED_SQUID.get()});
        this.tag(Tags.Items.FOODS_GOLDEN).add((Object)((Item)MDItems.GOLDEN_NUTRITIONAL_BAR.get()));
        this.tag(Tags.Items.FOODS_COOKED_MEAT).addTag(MDTags.COOKED_INSECT_MEAT).add((Object)((Item)MDItems.VEGAN_PATTY.get()));
        this.tag(Tags.Items.FOODS_COOKIE).add((Object)((Item)MDItems.BAT_COOKIE.get()));
        this.tag(Tags.Items.FOODS_VEGETABLE).add((Object)((Item)MDItems.CAVE_CARROT.get()));
        this.tag(ItemTags.PIGLIN_LOVED).add((Object)((Item)MDItems.GOLDEN_NUTRITIONAL_BAR.get()));
    }
}

