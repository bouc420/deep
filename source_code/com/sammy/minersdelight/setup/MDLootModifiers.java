/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.core.Registry
 *  net.neoforged.neoforge.common.loot.IGlobalLootModifier
 *  net.neoforged.neoforge.registries.DeferredRegister
 *  net.neoforged.neoforge.registries.NeoForgeRegistries
 */
package com.sammy.minersdelight.setup;

import com.mojang.serialization.MapCodec;
import com.sammy.minersdelight.content.loot.ModifyDroppedItemsModifier;
import java.util.function.Supplier;
import net.minecraft.core.Registry;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class MDLootModifiers {
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create((Registry)NeoForgeRegistries.GLOBAL_LOOT_MODIFIER_SERIALIZERS, (String)"minersdelight");
    public static final Supplier<MapCodec<? extends IGlobalLootModifier>> MODIFY_DROPS = LOOT_MODIFIERS.register("modify_drops", ModifyDroppedItemsModifier.CODEC);
}

