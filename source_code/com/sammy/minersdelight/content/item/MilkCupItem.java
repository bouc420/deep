/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.ChatFormatting
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.Item$TooltipContext
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.TooltipFlag
 *  vectorwing.farmersdelight.common.Configuration
 *  vectorwing.farmersdelight.common.item.MilkBottleItem
 */
package com.sammy.minersdelight.content.item;

import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import vectorwing.farmersdelight.common.Configuration;
import vectorwing.farmersdelight.common.item.MilkBottleItem;

public class MilkCupItem
extends MilkBottleItem {
    public MilkCupItem(Item.Properties pProperties) {
        super(pProperties);
    }

    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag isAdvanced) {
        if (((Boolean)Configuration.ENABLE_COOKING_POT_RECIPE_BOOK.get()).booleanValue()) {
            MutableComponent text = Component.translatable((String)"tooltip.farmersdelight.milk_bottle");
            tooltip.add((Component)text.withStyle(ChatFormatting.BLUE));
        }
    }
}

