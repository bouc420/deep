/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.data.DataGenerator
 *  net.minecraft.data.DataProvider
 *  net.minecraft.data.PackOutput
 *  net.neoforged.bus.api.SubscribeEvent
 *  net.neoforged.fml.common.EventBusSubscriber
 *  net.neoforged.fml.common.EventBusSubscriber$Bus
 *  net.neoforged.neoforge.common.data.ExistingFileHelper
 *  net.neoforged.neoforge.data.event.GatherDataEvent
 */
package com.sammy.minersdelight.datagen;

import com.sammy.minersdelight.datagen.MDBiomeTagDatagen;
import com.sammy.minersdelight.datagen.MDBlockLootTables;
import com.sammy.minersdelight.datagen.MDBlockStateDatagen;
import com.sammy.minersdelight.datagen.MDBlockTagDatagen;
import com.sammy.minersdelight.datagen.MDDataMapDatagen;
import com.sammy.minersdelight.datagen.MDItemModels;
import com.sammy.minersdelight.datagen.MDItemTags;
import com.sammy.minersdelight.datagen.MDLangDatagen;
import com.sammy.minersdelight.datagen.MDRecipeProvider;
import com.sammy.minersdelight.datagen.RegistryDataGenerator;
import java.util.concurrent.CompletableFuture;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid="minersdelight", bus=EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture provider = event.getLookupProvider();
        ExistingFileHelper helper = event.getExistingFileHelper();
        boolean includeClient = event.includeClient();
        boolean includeServer = event.includeServer();
        MDItemModels itemModels = new MDItemModels(output, helper);
        MDBlockStateDatagen blockStates = new MDBlockStateDatagen(output, helper, itemModels);
        MDLangDatagen langDatagen = new MDLangDatagen(output);
        RegistryDataGenerator registryDataDatagen = new RegistryDataGenerator(output, provider);
        CompletableFuture registryProvider = registryDataDatagen.getRegistryProvider();
        generator.addProvider(includeServer, (DataProvider)registryDataDatagen);
        MDDataMapDatagen dataMapsDatagen = new MDDataMapDatagen(output, registryProvider);
        MDBlockLootTables blockLootDatagen = new MDBlockLootTables(output, registryProvider);
        MDBlockTagDatagen blockTagDatagen = new MDBlockTagDatagen(output, registryProvider, helper);
        MDItemTags itemTagDatagen = new MDItemTags(output, registryProvider, blockTagDatagen.contentsGetter(), helper);
        MDBiomeTagDatagen biomeTagDatagen = new MDBiomeTagDatagen(output, registryProvider, helper);
        MDRecipeProvider recipeDatagen = new MDRecipeProvider(output, registryProvider);
        generator.addProvider(includeClient, (DataProvider)itemModels);
        generator.addProvider(includeClient, (DataProvider)blockStates);
        generator.addProvider(includeClient, (DataProvider)langDatagen);
        generator.addProvider(includeServer, (DataProvider)dataMapsDatagen);
        generator.addProvider(includeServer, (DataProvider)blockLootDatagen);
        generator.addProvider(includeServer, (DataProvider)blockTagDatagen);
        generator.addProvider(includeServer, (DataProvider)itemTagDatagen);
        generator.addProvider(includeServer, (DataProvider)biomeTagDatagen);
        generator.addProvider(includeServer, (DataProvider)recipeDatagen);
    }
}

