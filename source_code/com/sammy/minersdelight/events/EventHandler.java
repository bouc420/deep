/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.neoforged.bus.api.SubscribeEvent
 *  net.neoforged.fml.common.EventBusSubscriber
 *  net.neoforged.fml.common.EventBusSubscriber$Bus
 *  net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent
 */
package com.sammy.minersdelight.events;

import com.sammy.minersdelight.setup.MDPotions;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;

@EventBusSubscriber(bus=EventBusSubscriber.Bus.GAME)
public class EventHandler {
    @SubscribeEvent
    public static void registerPotionBrewing(RegisterBrewingRecipesEvent event) {
        MDPotions.registerPotionBrewing(event);
    }
}

