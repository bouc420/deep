/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.world.level.storage.loot.predicates.LootItemConditionType
 *  net.neoforged.neoforge.registries.DeferredHolder
 *  net.neoforged.neoforge.registries.DeferredRegister
 */
package com.sammy.minersdelight.setup;

import com.sammy.minersdelight.content.loot.LootItemBlockTagCondition;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MDLootConditions {
    public static final DeferredRegister<LootItemConditionType> LOOT_CONDITIONS = DeferredRegister.create((ResourceKey)BuiltInRegistries.LOOT_CONDITION_TYPE.key(), (String)"minersdelight");
    public static final DeferredHolder<LootItemConditionType, LootItemConditionType> BLOCK_TAG_CONDITION = LOOT_CONDITIONS.register("block_tag", () -> new LootItemConditionType(LootItemBlockTagCondition.CODEC));
}

