/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.data.PackOutput
 *  net.minecraft.world.item.BlockItem
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemNameBlockItem
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.WallSignBlock
 *  net.minecraft.world.level.block.WallTorchBlock
 *  net.neoforged.neoforge.common.data.LanguageProvider
 *  team.lodestar.lodestone.helpers.DataHelper
 */
package com.sammy.minersdelight.datagen;

import com.sammy.minersdelight.content.item.SolidCupItem;
import com.sammy.minersdelight.setup.MDBlocks;
import com.sammy.minersdelight.setup.MDItems;
import java.util.HashSet;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.WallTorchBlock;
import net.neoforged.neoforge.common.data.LanguageProvider;
import team.lodestar.lodestone.helpers.DataHelper;

public class MDLangDatagen
extends LanguageProvider {
    public static MDLangDatagen lang;

    public MDLangDatagen(PackOutput gen) {
        super(gen, "minersdelight", "en_us");
        lang = this;
    }

    protected void addTranslations() {
        HashSet blocks = new HashSet(MDBlocks.BLOCKS.getEntries());
        HashSet items = new HashSet(MDItems.ITEMS.getEntries());
        DataHelper.takeAll(blocks, i -> i.get() instanceof WallTorchBlock);
        DataHelper.takeAll(blocks, i -> i.get() instanceof WallSignBlock);
        blocks.forEach(b -> {
            String name = ((Block)b.get()).getDescriptionId().replaceFirst("block\\.minersdelight\\.", "");
            name = this.makeProper(DataHelper.toTitleCase((String)this.correctItemName(name), (String)"_"));
            this.add(((Block)b.get()).getDescriptionId(), name);
        });
        DataHelper.takeAll(items, i -> i.get() instanceof BlockItem && !(i.get() instanceof ItemNameBlockItem) && !(i.get() instanceof SolidCupItem));
        items.forEach(i -> {
            String name = ((Item)i.get()).getDescriptionId().replaceFirst("item\\.minersdelight\\.", "");
            name = this.makeProper(DataHelper.toTitleCase((String)this.correctItemName(name), (String)"_"));
            this.add(((Item)i.get()).getDescriptionId(), name);
        });
        this.add("itemGroup.minersdelight", "Miner's Delight");
        this.add("minersdelight.container.cooking_pot", "Copper Pot");
        this.add("minersdelight.container.sticky_basket", "Sticky Basket");
        this.add("farmersdelight.tooltip.honey_bar", "Soothing honey center!");
        this.add("item.minecraft.potion.effect.haste", "Potion of the Haste");
        this.add("item.minecraft.potion.effect.long_haste", "Potion of the Haste");
        this.add("item.minecraft.potion.effect.strong_haste", "Potion of the Haste");
        this.add("item.minecraft.splash_potion.effect.haste", "Splash Potion of the Haste");
        this.add("item.minecraft.splash_potion.effect.long_haste", "Splash Potion of the Haste");
        this.add("item.minecraft.splash_potion.effect.strong_haste", "Splash Potion of the Haste");
        this.add("item.minecraft.lingering_potion.effect.haste", "Lingering Potion of the Haste");
        this.add("item.minecraft.lingering_potion.effect.long_haste", "Lingering Potion of the Haste");
        this.add("item.minecraft.lingering_potion.effect.strong_haste", "Lingering Potion of the Haste");
        this.add("item.minecraft.tipped_arrow.effect.haste", "Arrow of the Haste");
        this.add("item.minecraft.tipped_arrow.effect.long_haste", "Arrow of the Haste");
        this.add("item.minecraft.tipped_arrow.effect.strong_haste", "Arrow of the Haste");
        this.add("item.minecraft.potion.effect.mining_fatigue", "Potion of the Mining Fatigue");
        this.add("item.minecraft.potion.effect.long_mining_fatigue", "Potion of the Mining Fatigue");
        this.add("item.minecraft.potion.effect.strong_mining_fatigue", "Potion of the Mining Fatigue");
        this.add("item.minecraft.splash_potion.effect.mining_fatigue", "Splash Potion of the Mining Fatigue");
        this.add("item.minecraft.splash_potion.effect.long_mining_fatigue", "Splash Potion of the Mining Fatigue");
        this.add("item.minecraft.splash_potion.effect.strong_mining_fatigue", "Splash Potion of the Mining Fatigue");
        this.add("item.minecraft.lingering_potion.effect.mining_fatigue", "Lingering Potion of the Mining Fatigue");
        this.add("item.minecraft.lingering_potion.effect.long_mining_fatigue", "Lingering Potion of the Mining Fatigue");
        this.add("item.minecraft.lingering_potion.effect.strong_mining_fatigue", "Lingering Potion of the Mining Fatigue");
        this.add("item.minecraft.tipped_arrow.effect.mining_fatigue", "Arrow of the Mining Fatigue");
        this.add("item.minecraft.tipped_arrow.effect.long_mining_fatigue", "Arrow of the Mining Fatigue");
        this.add("item.minecraft.tipped_arrow.effect.strong_mining_fatigue", "Arrow of the Mining Fatigue");
    }

    public String getName() {
        return "Miners Delight Lang Datagen";
    }

    public String makeProper(String s) {
        s = s.replaceAll("Of", "of").replaceAll("The", "the");
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }

    public String correctSoundName(String name) {
        if (name.endsWith("_step")) {
            return "footsteps";
        }
        if (name.endsWith("_place")) {
            return "block_placed";
        }
        if (name.endsWith("_break")) {
            return "block_broken";
        }
        if (name.endsWith("_hit")) {
            return "block_breaking";
        }
        return name;
    }

    public String correctItemName(String name) {
        if (name.contains("music_disc")) {
            return "music_disc";
        }
        if (!name.endsWith("_bricks") && name.contains("bricks")) {
            name = name.replaceFirst("bricks", "brick");
        }
        if (!name.endsWith("_boards") && name.contains("boards")) {
            name = name.replaceFirst("boards", "board");
        }
        if ((name.contains("_fence") || name.contains("_button")) && name.contains("planks")) {
            name = name.replaceFirst("_planks", "");
        }
        return this.makeProperEnglish(name);
    }

    public String makeProperEnglish(String name) {
        String[] replacements = new String[]{"ns_", "rs_", "ts_"};
        String properName = name;
        for (String replacement : replacements) {
            int index = properName.indexOf(replacement);
            if (index == -1) continue;
            properName = properName.replaceFirst("s_", "'s_");
            break;
        }
        return properName;
    }
}

