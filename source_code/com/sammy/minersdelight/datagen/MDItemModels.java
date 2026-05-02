/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.data.PackOutput
 *  net.minecraft.world.item.BlockItem
 *  net.neoforged.neoforge.common.data.ExistingFileHelper
 *  team.lodestar.lodestone.systems.datagen.ItemModelSmithTypes
 *  team.lodestar.lodestone.systems.datagen.itemsmith.ItemModelSmithData
 *  team.lodestar.lodestone.systems.datagen.providers.LodestoneItemModelProvider
 */
package com.sammy.minersdelight.datagen;

import com.sammy.minersdelight.setup.MDItems;
import java.util.HashSet;
import java.util.function.Supplier;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import team.lodestar.lodestone.systems.datagen.ItemModelSmithTypes;
import team.lodestar.lodestone.systems.datagen.itemsmith.ItemModelSmithData;
import team.lodestar.lodestone.systems.datagen.providers.LodestoneItemModelProvider;

public class MDItemModels
extends LodestoneItemModelProvider {
    public MDItemModels(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, "minersdelight", existingFileHelper);
    }

    protected void registerModels() {
        HashSet<Supplier> items = new HashSet<Supplier>(MDItems.ITEMS.getEntries());
        items.removeIf(i -> i.get() instanceof BlockItem);
        ItemModelSmithData data = new ItemModelSmithData((LodestoneItemModelProvider)this, items::remove);
        ItemModelSmithTypes.BLOCK_MODEL_ITEM.act(data, new Supplier[]{MDItems.COPPER_POT, MDItems.STICKY_BASKET});
        ItemModelSmithTypes.GENERATED_ITEM.act(data, MDItems.POWDERED_SNOW_CUP);
        ItemModelSmithTypes.HANDHELD_ITEM.act(data, new Supplier[]{MDItems.IMPROVISED_BARBECUE_STICK, MDItems.TENTACLES_ON_A_STICK, MDItems.SPIDER_LEG, MDItems.BAKED_SPIDER_LEG});
        ItemModelSmithTypes.GENERATED_ITEM.act(data, items);
    }

    public String getName() {
        return "Miner's Delight Item Models";
    }
}

