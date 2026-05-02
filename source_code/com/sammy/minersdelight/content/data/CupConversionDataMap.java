/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  net.minecraft.core.Holder
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 */
package com.sammy.minersdelight.content.data;

import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.sammy.minersdelight.setup.MDDataMaps;
import java.util.Optional;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public record CupConversionDataMap(Holder<Item> cupVariant) {
    public static final Codec<CupConversionDataMap> CODEC = RecordCodecBuilder.create(instance -> instance.group((App)ItemStack.ITEM_NON_AIR_CODEC.fieldOf("cup_variant").forGetter(CupConversionDataMap::cupVariant)).apply((Applicative)instance, CupConversionDataMap::new));

    public static Optional<ItemStack> getCupVariant(ItemStack stack) {
        CupConversionDataMap data = (CupConversionDataMap)stack.getItem().builtInRegistryHolder().getData(MDDataMaps.CUP_VARIANT);
        if (data != null) {
            ItemStack inCup = new ItemStack(data.cupVariant(), stack.getCount());
            return Optional.of(inCup);
        }
        return Optional.empty();
    }
}

