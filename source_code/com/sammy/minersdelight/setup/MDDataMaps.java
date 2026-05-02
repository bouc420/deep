/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.item.Item
 *  net.neoforged.neoforge.registries.datamaps.DataMapType
 *  net.neoforged.neoforge.registries.datamaps.RegisterDataMapTypesEvent
 */
package com.sammy.minersdelight.setup;

import com.sammy.minersdelight.MinersDelightMod;
import com.sammy.minersdelight.content.data.CupConversionDataMap;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.datamaps.DataMapType;
import net.neoforged.neoforge.registries.datamaps.RegisterDataMapTypesEvent;

public class MDDataMaps {
    public static final DataMapType<Item, CupConversionDataMap> CUP_VARIANT = DataMapType.builder((ResourceLocation)MinersDelightMod.path("cup_variant"), (ResourceKey)Registries.ITEM, CupConversionDataMap.CODEC).build();

    public static void registerDataMapTypes(RegisterDataMapTypesEvent event) {
        event.register(CUP_VARIANT);
    }
}

