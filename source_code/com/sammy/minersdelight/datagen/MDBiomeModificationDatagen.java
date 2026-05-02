/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.Holder$Reference
 *  net.minecraft.core.HolderSet
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.data.worldgen.BootstrapContext
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.tags.TagKey
 *  net.minecraft.world.level.biome.Biome
 *  net.minecraft.world.level.levelgen.GenerationStep$Decoration
 *  net.minecraft.world.level.levelgen.placement.PlacedFeature
 *  net.neoforged.neoforge.common.world.BiomeModifier
 *  net.neoforged.neoforge.common.world.BiomeModifiers$AddFeaturesBiomeModifier
 *  net.neoforged.neoforge.registries.NeoForgeRegistries$Keys
 */
package com.sammy.minersdelight.datagen;

import com.sammy.minersdelight.MinersDelightMod;
import com.sammy.minersdelight.setup.MDTags;
import com.sammy.minersdelight.setup.MDWorldgen;
import java.util.ArrayList;
import java.util.function.Supplier;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class MDBiomeModificationDatagen {
    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        MDBiomeModificationDatagen.register(context, "wild_cave_carrot", () -> MDBiomeModificationDatagen.addFeatureModifier(context, MDBiomeModificationDatagen.getPlacedHolderSet(context, MDWorldgen.PlacedFeatures.WILD_CAVE_CARROT), MDTags.HAS_CAVE_CARROTS, GenerationStep.Decoration.VEGETAL_DECORATION));
    }

    @SafeVarargs
    public static HolderSet<PlacedFeature> getPlacedHolderSet(BootstrapContext<?> context, ResourceKey<PlacedFeature> ... placedFeatures) {
        ArrayList<Holder.Reference> holders = new ArrayList<Holder.Reference>();
        for (ResourceKey<PlacedFeature> feature : placedFeatures) {
            holders.add(context.lookup(Registries.PLACED_FEATURE).getOrThrow(feature));
        }
        return HolderSet.direct(holders);
    }

    private static BiomeModifiers.AddFeaturesBiomeModifier addFeatureModifier(BootstrapContext<BiomeModifier> context, HolderSet<PlacedFeature> placedSet, TagKey<Biome> biomeTag, GenerationStep.Decoration decoration) {
        return new BiomeModifiers.AddFeaturesBiomeModifier((HolderSet)context.lookup(Registries.BIOME).getOrThrow(biomeTag), placedSet, decoration);
    }

    private static void register(BootstrapContext<BiomeModifier> context, String name, Supplier<? extends BiomeModifier> modifier) {
        context.register(ResourceKey.create((ResourceKey)NeoForgeRegistries.Keys.BIOME_MODIFIERS, (ResourceLocation)MinersDelightMod.path(name)), (Object)modifier.get());
    }
}

