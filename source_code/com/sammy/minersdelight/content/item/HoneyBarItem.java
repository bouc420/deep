/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.ChatFormatting
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.Item$TooltipContext
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.TooltipFlag
 *  net.minecraft.world.level.Level
 *  net.neoforged.neoforge.common.EffectCures
 *  vectorwing.farmersdelight.common.Configuration
 *  vectorwing.farmersdelight.common.item.ConsumableItem
 */
package com.sammy.minersdelight.content.item;

import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.EffectCures;
import vectorwing.farmersdelight.common.Configuration;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class HoneyBarItem
extends ConsumableItem {
    public HoneyBarItem(Item.Properties properties) {
        super(properties, false, true);
    }

    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
        consumer.removeEffectsCuredBy(EffectCures.HONEY);
    }

    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag isAdvanced) {
        if (((Boolean)Configuration.ENABLE_FOOD_EFFECT_TOOLTIP.get()).booleanValue()) {
            MutableComponent text = Component.translatable((String)"farmersdelight.tooltip.honey_bar");
            tooltip.add((Component)text.withStyle(ChatFormatting.BLUE));
        }
    }
}

