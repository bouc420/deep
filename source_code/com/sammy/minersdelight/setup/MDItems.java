/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.Registry
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.world.food.FoodProperties
 *  net.minecraft.world.item.BlockItem
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.ItemNameBlockItem
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.material.Fluid
 *  net.minecraft.world.level.material.Fluids
 *  net.neoforged.neoforge.registries.DeferredHolder
 *  net.neoforged.neoforge.registries.DeferredRegister
 *  team.lodestar.lodestone.systems.item.LodestoneItemProperties
 *  vectorwing.farmersdelight.common.FoodValues
 *  vectorwing.farmersdelight.common.item.ConsumableItem
 *  vectorwing.farmersdelight.common.item.PlaceableItem
 */
package com.sammy.minersdelight.setup;

import com.sammy.minersdelight.MinersDelightMod;
import com.sammy.minersdelight.content.item.CopperCupFoodItem;
import com.sammy.minersdelight.content.item.CopperCupItem;
import com.sammy.minersdelight.content.item.HoneyBarItem;
import com.sammy.minersdelight.content.item.MilkCupItem;
import com.sammy.minersdelight.content.item.SilverfishEggsItem;
import com.sammy.minersdelight.content.item.SolidCupItem;
import com.sammy.minersdelight.setup.MDBlocks;
import com.sammy.minersdelight.setup.MDCreativeTabs;
import com.sammy.minersdelight.setup.MDFoodValues;
import java.util.function.Function;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import team.lodestar.lodestone.systems.item.LodestoneItemProperties;
import vectorwing.farmersdelight.common.FoodValues;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.PlaceableItem;

public class MDItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create((Registry)BuiltInRegistries.ITEM, (String)"minersdelight");
    public static final DeferredHolder<Item, BlockItem> COPPER_POT = MDItems.register("copper_pot", MDItems.DEFAULT_PROPERTIES(), (LodestoneItemProperties p) -> new BlockItem(MDBlocks.COPPER_POT.get(), (Item.Properties)p));
    public static final DeferredHolder<Item, BlockItem> STICKY_BASKET = MDItems.register("sticky_basket", MDItems.DEFAULT_PROPERTIES(), (LodestoneItemProperties p) -> new BlockItem(MDBlocks.STICKY_BASKET.get(), (Item.Properties)p));
    public static final DeferredHolder<Item, BlockItem> CAVE_CARROT_CRATE = MDItems.register("cave_carrot_crate", MDItems.DEFAULT_PROPERTIES(), (LodestoneItemProperties p) -> new BlockItem(MDBlocks.CAVE_CARROT_CRATE.get(), (Item.Properties)p));
    public static final DeferredHolder<Item, CopperCupItem> COPPER_CUP = MDItems.register("copper_cup", MDItems.CUP_PROPERTIES(), (LodestoneItemProperties p) -> new CopperCupItem(Fluids.EMPTY, (Item.Properties)p));
    public static final DeferredHolder<Item, CopperCupItem> WATER_CUP = MDItems.register("water_cup", MDItems.CUP_PROPERTIES().stacksTo(1), (LodestoneItemProperties p) -> new CopperCupItem((Fluid)Fluids.WATER, (Item.Properties)p.craftRemainder((Item)COPPER_CUP.get())));
    public static final DeferredHolder<Item, MilkCupItem> MILK_CUP = MDItems.register("milk_cup", MDItems.CUP_PROPERTIES().stacksTo(1), (LodestoneItemProperties p) -> new MilkCupItem((Item.Properties)p.craftRemainder((Item)COPPER_CUP.get())));
    public static final DeferredHolder<Item, SolidCupItem> POWDERED_SNOW_CUP = MDItems.register("powder_snow_cup", MDItems.CUP_PROPERTIES().stacksTo(1), (LodestoneItemProperties p) -> new SolidCupItem(Blocks.POWDER_SNOW, SoundEvents.BUCKET_EMPTY_POWDER_SNOW, (Item.Properties)p.craftRemainder((Item)COPPER_CUP.get())));
    public static final DeferredHolder<Item, BlockItem> WILD_CAVE_CARROTS = MDItems.register("wild_cave_carrots", (LodestoneItemProperties p) -> new BlockItem(MDBlocks.WILD_CAVE_CARROTS.get(), (Item.Properties)p));
    public static final DeferredHolder<Item, Item> GOSSYPIUM = MDItems.register("gossypium", (LodestoneItemProperties p) -> new BlockItem((Block)MDBlocks.GOSSYPIUM.get(), (Item.Properties)p));
    public static final DeferredHolder<Item, ItemNameBlockItem> CAVE_CARROT = MDItems.register("cave_carrot", MDFoodValues.CAVE_CARROT, (LodestoneItemProperties p) -> new ItemNameBlockItem(MDBlocks.CAVE_CARROTS.get(), (Item.Properties)p));
    public static final DeferredHolder<Item, Item> BAKED_CAVE_CARROT = MDItems.register("baked_cave_carrot", MDFoodValues.BAKED_CAVE_CARROT);
    public static final DeferredHolder<Item, Item> COPPER_CARROT = MDItems.register("copper_carrot", MDFoodValues.COPPER_CARROT);
    public static final DeferredHolder<Item, ConsumableItem> PASTA_WITH_VEGGIEBALLS = MDItems.registerBowlFood("pasta_with_veggieballs", MDFoodValues.PASTA_WITH_VEGGIEBALLS, true);
    public static final DeferredHolder<Item, ConsumableItem> CAVE_SOUP = MDItems.registerBowlFood("cave_soup", MDFoodValues.CAVE_SOUP, true);
    public static final DeferredHolder<Item, Item> VEGAN_PATTY = MDItems.register("vegan_patty", MDFoodValues.VEGAN_PATTY);
    public static final DeferredHolder<Item, Item> VEGAN_HAMBURGER = MDItems.register("vegan_hamburger", MDFoodValues.VEGAN_HAMBURGER);
    public static final DeferredHolder<Item, Item> VEGAN_WRAP = MDItems.register("vegan_wrap", MDFoodValues.VEGAN_WRAP);
    public static final DeferredHolder<Item, ConsumableItem> VEGAN_STEAK_AND_POTATOES = MDItems.registerBowlFood("vegan_steak_and_potatoes", MDFoodValues.VEGAN_STEAK_AND_POTATOES, true);
    public static final DeferredHolder<Item, Item> FAKE_MEATLOAF = MDItems.register("fake_meatloaf", MDItems.DEFAULT_PROPERTIES().stacksTo(1), (LodestoneItemProperties p) -> new PlaceableItem(MDBlocks.FAKE_MEATLOAF.get(), (Item.Properties)p));
    public static final DeferredHolder<Item, ConsumableItem> PLATE_OF_FAKE_MEATLOAF = MDItems.registerBowlFood("plate_of_fake_meatloaf", MDFoodValues.PLATE_OF_FAKE_MEATLOAF, true);
    public static final DeferredHolder<Item, Item> MOSS = MDItems.register("moss", MDFoodValues.MOSS);
    public static final DeferredHolder<Item, Item> BAT_WING = MDItems.register("bat_wing", MDFoodValues.BAT_WING);
    public static final DeferredHolder<Item, Item> SMOKED_BAT_WING = MDItems.register("smoked_bat_wing", MDFoodValues.SMOKED_BAT_WING);
    public static final DeferredHolder<Item, Item> BAT_ROLLS = MDItems.register("bat_rolls", MDFoodValues.BAT_ROLLS);
    public static final DeferredHolder<Item, Item> CAVE_HAMBURGER = MDItems.register("cave_hamburger", MDFoodValues.CAVE_HAMBURGER);
    public static final DeferredHolder<Item, ConsumableItem> BAT_SOUP = MDItems.registerBowlFood("bat_soup", MDFoodValues.BAT_SOUP, true);
    public static final DeferredHolder<Item, Item> IMPROVISED_BARBECUE_STICK = MDItems.register("improvised_barbecue_stick", MDFoodValues.IMPROVISED_BARBECUE_STICK);
    public static final DeferredHolder<Item, Item> BAT_COOKIE = MDItems.register("bat_cookie", MDFoodValues.BAT_COOKIE);
    public static final DeferredHolder<Item, Item> SPIDER_LEG = MDItems.register("spider_leg", MDFoodValues.SPIDER_LEG);
    public static final DeferredHolder<Item, Item> BAKED_SPIDER_LEG = MDItems.register("baked_spider_leg", MDFoodValues.BAKED_SPIDER_LEG);
    public static final DeferredHolder<Item, Item> GLAZED_ARACHNID_LIMBS = MDItems.register("glazed_arachnid_limbs", MDItems.DEFAULT_PROPERTIES().stacksTo(1), (LodestoneItemProperties p) -> new PlaceableItem(MDBlocks.GLAZED_ARACHNID_LIMBS.get(), (Item.Properties)p));
    public static final DeferredHolder<Item, ConsumableItem> PLATE_OF_GLAZED_ARACHNID_LIMBS = MDItems.registerBowlFood("plate_of_glazed_arachnid_limbs", MDFoodValues.PLATE_OF_GLAZED_ARACHNID_LIMBS, true);
    public static final DeferredHolder<Item, SilverfishEggsItem> SILVERFISH_EGGS = MDItems.register("silverfish_eggs", MDFoodValues.SILVERFISH_EGGS, SilverfishEggsItem::new);
    public static final DeferredHolder<Item, ConsumableItem> WEIRD_CAVIAR = MDItems.registerBowlFood("weird_caviar", MDFoodValues.WEIRD_CAVIAR, false);
    public static final DeferredHolder<Item, Item> ARTHROPOD = MDItems.register("arthropod", MDFoodValues.ARTHROPOD);
    public static final DeferredHolder<Item, Item> COOKED_ARTHROPOD = MDItems.register("cooked_arthropod", MDFoodValues.COOKED_ARTHROPOD);
    public static final DeferredHolder<Item, Item> INSECT_SANDWICH = MDItems.register("insect_sandwich", MDFoodValues.INSECT_SANDWICH);
    public static final DeferredHolder<Item, Item> INSECT_WRAP = MDItems.register("insect_wrap", MDFoodValues.INSECT_WRAP);
    public static final DeferredHolder<Item, ConsumableItem> INSECT_STEW = MDItems.registerBowlFood("insect_stew", MDFoodValues.INSECT_STEW, true);
    public static final DeferredHolder<Item, ConsumableItem> SEASONED_ARTHROPODS = MDItems.registerBowlFood("seasoned_arthropods", MDFoodValues.SEASONED_ARTHROPODS, true);
    public static final DeferredHolder<Item, Item> CRUNCHY_BAR = MDItems.register("crunchy_bar", MDFoodValues.CRUNCHY_BAR);
    public static final DeferredHolder<Item, HoneyBarItem> NUTRITIONAL_BAR = MDItems.register("nutritional_bar", MDFoodValues.NUTRITIONAL_BAR, HoneyBarItem::new);
    public static final DeferredHolder<Item, HoneyBarItem> GOLDEN_NUTRITIONAL_BAR = MDItems.register("golden_nutritional_bar", MDFoodValues.GOLDEN_NUTRITIONAL_BAR, HoneyBarItem::new);
    public static final DeferredHolder<Item, ConsumableItem> GLOW_INK_PASTA = MDItems.registerBowlFood("glow_ink_pasta", MDFoodValues.GLOW_INK_PASTA, true);
    public static final DeferredHolder<Item, Item> GLOW_SQUID = MDItems.register("glow_squid", MDFoodValues.GLOW_SQUID);
    public static final DeferredHolder<Item, Item> SQUID = MDItems.register("squid", MDFoodValues.SQUID);
    public static final DeferredHolder<Item, Item> BAKED_SQUID = MDItems.register("baked_squid", MDFoodValues.BAKED_SQUID);
    public static final DeferredHolder<Item, Item> TENTACLES = MDItems.register("tentacles", MDFoodValues.TENTACLES);
    public static final DeferredHolder<Item, Item> BAKED_TENTACLES = MDItems.register("baked_tentacles", MDFoodValues.BAKED_TENTACLES);
    public static final DeferredHolder<Item, Item> SQUID_SANDWICH = MDItems.register("squid_sandwich", MDFoodValues.SQUID_SANDWICH);
    public static final DeferredHolder<Item, ConsumableItem> TAKOYAKI = MDItems.registerBowlFood("takoyaki", MDFoodValues.TAKOYAKI, false);
    public static final DeferredHolder<Item, Item> TENTACLES_ON_A_STICK = MDItems.register("tentacles_on_a_stick", MDFoodValues.TENTACLES_ON_A_STICK);
    public static final DeferredHolder<Item, Item> STUFFED_SQUID = MDItems.register("stuffed_squid", MDItems.DEFAULT_PROPERTIES().stacksTo(1), (LodestoneItemProperties p) -> new PlaceableItem(MDBlocks.STUFFED_SQUID.get(), (Item.Properties)p));
    public static final DeferredHolder<Item, ConsumableItem> BOWL_OF_STUFFED_SQUID = MDItems.registerBowlFood("bowl_of_stuffed_squid", MDFoodValues.BOWL_OF_STUFFED_SQUID, true);
    public static final DeferredHolder<Item, CopperCupFoodItem> BEETROOT_SOUP_CUP = MDItems.registerCupFood("beetroot_soup_cup", MDFoodValues.BEETROOT_SOUP);
    public static final DeferredHolder<Item, CopperCupFoodItem> MUSHROOM_STEW_CUP = MDItems.registerCupFood("mushroom_stew_cup", MDFoodValues.MUSHROOM_STEW);
    public static final DeferredHolder<Item, CopperCupFoodItem> RABBIT_STEW_CUP = MDItems.registerCupFood("rabbit_stew_cup", MDFoodValues.RABBIT_STEW);
    public static final DeferredHolder<Item, CopperCupFoodItem> BAKED_COD_STEW_CUP = MDItems.registerCupFood("baked_cod_stew_cup", FoodValues.BAKED_COD_STEW);
    public static final DeferredHolder<Item, CopperCupFoodItem> NOODLE_SOUP_CUP = MDItems.registerCupFood("noodle_soup_cup", FoodValues.NOODLE_SOUP);
    public static final DeferredHolder<Item, CopperCupFoodItem> BEEF_STEW_CUP = MDItems.registerCupFood("beef_stew_cup", FoodValues.BEEF_STEW);
    public static final DeferredHolder<Item, CopperCupFoodItem> CHICKEN_SOUP_CUP = MDItems.registerCupFood("chicken_soup_cup", FoodValues.CHICKEN_SOUP);
    public static final DeferredHolder<Item, CopperCupFoodItem> FISH_STEW_CUP = MDItems.registerCupFood("fish_stew_cup", FoodValues.FISH_STEW);
    public static final DeferredHolder<Item, CopperCupFoodItem> PUMPKIN_SOUP_CUP = MDItems.registerCupFood("pumpkin_soup_cup", FoodValues.PUMPKIN_SOUP);
    public static final DeferredHolder<Item, CopperCupFoodItem> VEGETABLE_SOUP_CUP = MDItems.registerCupFood("vegetable_soup_cup", FoodValues.VEGETABLE_SOUP);
    public static final DeferredHolder<Item, CopperCupFoodItem> BONE_BROTH_CUP = MDItems.registerCupFood("bone_broth_cup", FoodValues.BONE_BROTH);
    public static final DeferredHolder<Item, CopperCupFoodItem> ONION_SOUP_CUP = MDItems.registerCupFood("onion_soup_cup", FoodValues.ONION_SOUP);
    public static final DeferredHolder<Item, CopperCupFoodItem> CAVE_SOUP_CUP = MDItems.registerCupFood("cave_soup_cup", MDFoodValues.CAVE_SOUP);
    public static final DeferredHolder<Item, CopperCupFoodItem> BAT_SOUP_CUP = MDItems.registerCupFood("bat_soup_cup", MDFoodValues.BAT_SOUP);
    public static final DeferredHolder<Item, CopperCupFoodItem> INSECT_STEW_CUP = MDItems.registerCupFood("insect_stew_cup", MDFoodValues.INSECT_STEW);

    public static LodestoneItemProperties DEFAULT_PROPERTIES() {
        return new LodestoneItemProperties(MDCreativeTabs.CONTENT);
    }

    public static LodestoneItemProperties BOWL_PROPERTIES() {
        return MDItems.DEFAULT_PROPERTIES().stacksTo(16).craftRemainder(Items.BOWL);
    }

    public static LodestoneItemProperties CUP_PROPERTIES() {
        return MDItems.DEFAULT_PROPERTIES().stacksTo(16);
    }

    public static DeferredHolder<Item, Item> register(String name, FoodProperties foodProperties) {
        return MDItems.register(name, foodProperties, Item::new);
    }

    public static DeferredHolder<Item, CopperCupFoodItem> registerCupFood(String name, FoodProperties foodProperties) {
        return MDItems.register(name, MDItems.CUP_PROPERTIES().food(MDFoodValues.createCupFoodProperties(foodProperties)), (LodestoneItemProperties p) -> new CopperCupFoodItem((Item.Properties)p.craftRemainder((Item)COPPER_CUP.get())));
    }

    public static DeferredHolder<Item, ConsumableItem> registerBowlFood(String name, FoodProperties foodProperties, boolean hasFoodEffectTooltip) {
        return MDItems.register(name, MDItems.BOWL_PROPERTIES().food(foodProperties), (LodestoneItemProperties p) -> new ConsumableItem((Item.Properties)p.stacksTo(16).craftRemainder(Items.BOWL), hasFoodEffectTooltip));
    }

    public static <T extends Item> DeferredHolder<Item, T> register(String name, FoodProperties foodProperties, Function<LodestoneItemProperties, T> function) {
        return MDItems.register(name, MDItems.DEFAULT_PROPERTIES().food(foodProperties), function);
    }

    public static <T extends Item> DeferredHolder<Item, T> register(String name, Function<LodestoneItemProperties, T> function) {
        return MDItems.register(name, MDItems.DEFAULT_PROPERTIES(), function);
    }

    public static <T extends Item> DeferredHolder<Item, T> register(String name, LodestoneItemProperties properties, Function<LodestoneItemProperties, T> function) {
        LodestoneItemProperties.addToTabSorting((ResourceLocation)MinersDelightMod.path(name), (Item.Properties)properties);
        return ITEMS.register(name, () -> (Item)function.apply(properties));
    }
}

