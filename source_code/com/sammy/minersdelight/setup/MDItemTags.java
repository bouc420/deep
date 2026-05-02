/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.tags.ItemTags
 *  net.minecraft.tags.TagKey
 *  net.minecraft.world.item.Item
 */
package com.sammy.minersdelight.setup;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class MDItemTags {
    public static final TagKey<Item> KNIVES_FD = MDItemTags.modTag("farmersdelight:tools/knives");
    public static final TagKey<Item> KNIVES = MDItemTags.commonTag("tools/knives");

    private static TagKey<Item> modTag(String path) {
        return TagKey.create((ResourceKey)Registries.ITEM, (ResourceLocation)ResourceLocation.parse((String)path));
    }

    private static TagKey<Item> commonTag(String name) {
        return ItemTags.create((ResourceLocation)ResourceLocation.fromNamespaceAndPath((String)"c", (String)name));
    }
}

