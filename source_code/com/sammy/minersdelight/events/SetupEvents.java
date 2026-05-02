/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.neoforged.bus.api.SubscribeEvent
 *  net.neoforged.fml.common.EventBusSubscriber
 *  net.neoforged.fml.common.EventBusSubscriber$Bus
 *  net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent
 *  net.neoforged.neoforge.registries.datamaps.RegisterDataMapTypesEvent
 */
package com.sammy.minersdelight.events;

import com.sammy.minersdelight.setup.MDBlocks;
import com.sammy.minersdelight.setup.MDDataMaps;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.registries.datamaps.RegisterDataMapTypesEvent;

@EventBusSubscriber(bus=EventBusSubscriber.Bus.MOD)
public class SetupEvents {
    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        MDBlocks.addPottedBlocks(event);
    }

    @SubscribeEvent
    public static void registerDataMaps(RegisterDataMapTypesEvent event) {
        MDDataMaps.registerDataMapTypes(event);
    }
}

