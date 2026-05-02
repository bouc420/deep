/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.Registry
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.level.levelgen.feature.ConfiguredFeature
 *  net.minecraft.world.level.levelgen.feature.Feature
 *  net.minecraft.world.level.levelgen.placement.PlacedFeature
 *  net.neoforged.neoforge.registries.DeferredHolder
 *  net.neoforged.neoforge.registries.DeferredRegister
 */
package com.sammy.minersdelight.setup;

import com.sammy.minersdelight.MinersDelightMod;
import com.sammy.minersdelight.content.worldgen.WildCaveCropFeature;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MDWorldgen {
    public static final DeferredRegister<Feature<?>> FEATURE_TYPES = DeferredRegister.create((Registry)BuiltInRegistries.FEATURE, (String)"minersdelight");
    public static final DeferredHolder<Feature<?>, WildCaveCropFeature> WILD_CAVE_CROP = FEATURE_TYPES.register("wild_crop", WildCaveCropFeature::new);

    public static class PlacedFeatures {
        public static final ResourceKey<PlacedFeature> WILD_CAVE_CARROT = PlacedFeatures.registerKey("wild_cave_carrot");

        public static ResourceKey<PlacedFeature> registerKey(String name) {
            return ResourceKey.create((ResourceKey)Registries.PLACED_FEATURE, (ResourceLocation)MinersDelightMod.path(name));
        }
    }

    public static class ConfiguredFeatures {
        public static final ResourceKey<ConfiguredFeature<?, ?>> CONFIGURED_WILD_CAVE_CARROT = ConfiguredFeatures.registerKey("wild_cave_carrot");

        public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
            return ResourceKey.create((ResourceKey)Registries.CONFIGURED_FEATURE, (ResourceLocation)MinersDelightMod.path(name));
        }
    }
}

