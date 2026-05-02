/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.core.RegistrySetBuilder
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.data.PackOutput
 *  net.minecraft.data.registries.RegistryPatchGenerator
 *  net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider
 *  net.neoforged.neoforge.registries.NeoForgeRegistries$Keys
 */
package com.sammy.minersdelight.datagen;

import com.sammy.minersdelight.datagen.MDBiomeModificationDatagen;
import com.sammy.minersdelight.datagen.MDConfiguredFeatureDatagen;
import com.sammy.minersdelight.datagen.MDPlacedFeatureDatagen;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.registries.RegistryPatchGenerator;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class RegistryDataGenerator
extends DatapackBuiltinEntriesProvider {
    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder().add(Registries.CONFIGURED_FEATURE, MDConfiguredFeatureDatagen::bootstrap).add(Registries.PLACED_FEATURE, MDPlacedFeatureDatagen::bootstrap).add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, MDBiomeModificationDatagen::bootstrap);

    public RegistryDataGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, RegistryPatchGenerator.createLookup(registries, (RegistrySetBuilder)BUILDER), Set.of("minecraft", "minersdelight"));
    }
}

