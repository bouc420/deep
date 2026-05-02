/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.Registry
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.item.alchemy.Potion
 *  net.minecraft.world.item.alchemy.PotionBrewing$Builder
 *  net.minecraft.world.item.alchemy.Potions
 *  net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent
 *  net.neoforged.neoforge.registries.DeferredHolder
 *  net.neoforged.neoforge.registries.DeferredRegister
 */
package com.sammy.minersdelight.setup;

import com.sammy.minersdelight.setup.MDItems;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MDPotions {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create((Registry)BuiltInRegistries.POTION, (String)"minersdelight");
    public static final DeferredHolder<Potion, Potion> HASTE = POTIONS.register("haste", () -> new Potion("haste", new MobEffectInstance[]{new MobEffectInstance(MobEffects.DIG_SPEED, 3600)}));
    public static final DeferredHolder<Potion, Potion> LONG_HASTE = POTIONS.register("long_haste", () -> new Potion("long_haste", new MobEffectInstance[]{new MobEffectInstance(MobEffects.DIG_SPEED, 9600)}));
    public static final DeferredHolder<Potion, Potion> STRONG_HASTE = POTIONS.register("strong_haste", () -> new Potion("strong_haste", new MobEffectInstance[]{new MobEffectInstance(MobEffects.DIG_SPEED, 1800, 1)}));
    public static final DeferredHolder<Potion, Potion> MINING_FATIGUE = POTIONS.register("mining_fatigue", () -> new Potion("mining_fatigue", new MobEffectInstance[]{new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 3600)}));
    public static final DeferredHolder<Potion, Potion> LONG_MINING_FATIGUE = POTIONS.register("long_mining_fatigue", () -> new Potion("long_mining_fatigue", new MobEffectInstance[]{new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 9600)}));
    public static final DeferredHolder<Potion, Potion> STRONG_MINING_FATIGUE = POTIONS.register("strong_mining_fatigue", () -> new Potion("strong_mining_fatigue", new MobEffectInstance[]{new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 1800, 1)}));

    public static void registerPotionBrewing(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();
        builder.addMix(Potions.WATER, (Item)MDItems.COPPER_CARROT.get(), Potions.MUNDANE);
        builder.addMix(Potions.AWKWARD, (Item)MDItems.COPPER_CARROT.get(), HASTE);
        builder.addMix(HASTE, Items.REDSTONE, LONG_HASTE);
        builder.addMix(HASTE, Items.GLOWSTONE_DUST, STRONG_HASTE);
        builder.addMix(HASTE, Items.FERMENTED_SPIDER_EYE, MINING_FATIGUE);
        builder.addMix(LONG_HASTE, Items.FERMENTED_SPIDER_EYE, LONG_HASTE);
        builder.addMix(STRONG_HASTE, Items.FERMENTED_SPIDER_EYE, STRONG_HASTE);
        builder.addMix(MINING_FATIGUE, Items.REDSTONE, LONG_MINING_FATIGUE);
        builder.addMix(MINING_FATIGUE, Items.GLOWSTONE_DUST, STRONG_MINING_FATIGUE);
    }
}

