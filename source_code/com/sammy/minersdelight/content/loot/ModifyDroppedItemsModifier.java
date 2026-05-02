/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Suppliers
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.MapCodec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  com.mojang.serialization.codecs.RecordCodecBuilder$Instance
 *  it.unimi.dsi.fastutil.objects.ObjectArrayList
 *  javax.annotation.Nonnull
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.storage.loot.LootContext
 *  net.minecraft.world.level.storage.loot.predicates.LootItemCondition
 *  net.neoforged.neoforge.common.loot.IGlobalLootModifier
 *  net.neoforged.neoforge.common.loot.LootModifier
 */
package com.sammy.minersdelight.content.loot;

import com.google.common.base.Suppliers;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.function.Supplier;
import javax.annotation.Nonnull;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

public class ModifyDroppedItemsModifier
extends LootModifier {
    public static final Supplier<MapCodec<ModifyDroppedItemsModifier>> CODEC = Suppliers.memoize(() -> RecordCodecBuilder.mapCodec(inst -> ModifyDroppedItemsModifier.codecStart((RecordCodecBuilder.Instance)inst).and(inst.group((App)Codec.BOOL.optionalFieldOf("replaceOriginal", (Object)false).forGetter(m -> m.replaceOriginal), (App)BuiltInRegistries.ITEM.byNameCodec().fieldOf("item").forGetter(m -> m.item), (App)Codec.INT.optionalFieldOf("min", (Object)0).forGetter(m -> m.min), (App)Codec.INT.optionalFieldOf("max", (Object)1).forGetter(m -> m.max))).apply((Applicative)inst, ModifyDroppedItemsModifier::new)));
    private final boolean replaceOriginal;
    private final Item item;
    private final int min;
    private final int max;

    protected ModifyDroppedItemsModifier(LootItemCondition[] conditionsIn, boolean replaceOriginal, Item item, int min, int max) {
        super(conditionsIn);
        this.replaceOriginal = replaceOriginal;
        this.item = item;
        this.min = min;
        this.max = max;
    }

    @Nonnull
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        ItemStack addedStack;
        if (this.replaceOriginal) {
            generatedLoot.clear();
        }
        if ((addedStack = new ItemStack((ItemLike)this.item, Mth.nextInt((RandomSource)context.getRandom(), (int)this.min, (int)this.max))).getCount() < addedStack.getMaxStackSize()) {
            generatedLoot.add((Object)addedStack);
        } else {
            ItemStack subStack;
            for (int i = addedStack.getCount(); i > 0; i -= subStack.getCount()) {
                subStack = addedStack.copy();
                subStack.setCount(Math.min(addedStack.getMaxStackSize(), i));
                generatedLoot.add((Object)subStack);
            }
        }
        return generatedLoot;
    }

    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}

