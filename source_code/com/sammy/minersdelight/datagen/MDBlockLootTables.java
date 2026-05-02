/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.advancements.critereon.StatePropertiesPredicate$Builder
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.data.PackOutput
 *  net.minecraft.data.loot.BlockLootSubProvider
 *  net.minecraft.data.loot.LootTableProvider
 *  net.minecraft.data.loot.LootTableProvider$SubProviderEntry
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.world.flag.FeatureFlags
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.FlowerPotBlock
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.storage.loot.BuiltInLootTables
 *  net.minecraft.world.level.storage.loot.LootPool
 *  net.minecraft.world.level.storage.loot.LootPool$Builder
 *  net.minecraft.world.level.storage.loot.LootTable
 *  net.minecraft.world.level.storage.loot.LootTable$Builder
 *  net.minecraft.world.level.storage.loot.entries.LootItem
 *  net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer$Builder
 *  net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer$Builder
 *  net.minecraft.world.level.storage.loot.functions.LootItemFunction$Builder
 *  net.minecraft.world.level.storage.loot.functions.SetItemCountFunction
 *  net.minecraft.world.level.storage.loot.parameters.LootContextParamSets
 *  net.minecraft.world.level.storage.loot.predicates.ExplosionCondition
 *  net.minecraft.world.level.storage.loot.predicates.InvertedLootItemCondition
 *  net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition
 *  net.minecraft.world.level.storage.loot.predicates.LootItemCondition$Builder
 *  net.minecraft.world.level.storage.loot.providers.number.ConstantValue
 *  net.minecraft.world.level.storage.loot.providers.number.NumberProvider
 *  net.minecraft.world.level.storage.loot.providers.number.UniformGenerator
 *  team.lodestar.lodestone.helpers.DataHelper
 *  vectorwing.farmersdelight.common.block.FeastBlock
 */
package com.sammy.minersdelight.datagen;

import com.sammy.minersdelight.content.block.CaveCarrotBlock;
import com.sammy.minersdelight.content.block.StuffedSquidFeastBlock;
import com.sammy.minersdelight.setup.MDBlocks;
import com.sammy.minersdelight.setup.MDItems;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.ExplosionCondition;
import net.minecraft.world.level.storage.loot.predicates.InvertedLootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import team.lodestar.lodestone.helpers.DataHelper;
import vectorwing.farmersdelight.common.block.FeastBlock;

public class MDBlockLootTables
extends LootTableProvider {
    public MDBlockLootTables(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> provider) {
        super(pOutput, Set.of(), List.of(new LootTableProvider.SubProviderEntry(BlocksLoot::new, LootContextParamSets.BLOCK)), provider);
    }

    public static class BlocksLoot
    extends BlockLootSubProvider {
        protected BlocksLoot(HolderLookup.Provider provider) {
            super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
        }

        protected Iterable<Block> getKnownBlocks() {
            return MDBlocks.BLOCKS.getEntries().stream().map(Supplier::get).collect(Collectors.toList());
        }

        protected void generate() {
            HashSet blocks = new HashSet(MDBlocks.BLOCKS.getEntries());
            DataHelper.take(blocks, MDBlocks.COPPER_POT);
            DataHelper.take(blocks, MDBlocks.STICKY_BASKET);
            DataHelper.take(blocks, MDBlocks.WILD_CAVE_CARROTS);
            this.createFeastTable((Block)((Supplier)DataHelper.take(blocks, MDBlocks.FAKE_MEATLOAF)).get());
            this.createFeastTable((Block)((Supplier)DataHelper.take(blocks, MDBlocks.GLAZED_ARACHNID_LIMBS)).get());
            this.createStuffedSquidTable((Block)((Supplier)DataHelper.take(blocks, MDBlocks.STUFFED_SQUID)).get());
            this.createCaveCarrotCropTable((Block)((Supplier)DataHelper.take(blocks, MDBlocks.CAVE_CARROTS)).get());
            DataHelper.takeAll(blocks, b -> b.get() instanceof FlowerPotBlock).forEach(b -> this.add((Block)b.get(), this.createPotFlowerItemTable((ItemLike)((FlowerPotBlock)b.get()).getPotted())));
            DataHelper.takeAll(blocks, b -> true).forEach(b -> this.add((Block)b.get(), this.createSingleItemTable((ItemLike)((Block)b.get()).asItem())));
        }

        protected void createStuffedSquidTable(Block block) {
            LootTable.Builder builder = LootTable.lootTable();
            LootPool.Builder fullBlock = LootPool.lootPool().when(ExplosionCondition.survivesExplosion()).add((LootPoolEntryContainer.Builder)((LootPoolSingletonContainer.Builder)LootItem.lootTableItem((ItemLike)MDBlocks.STUFFED_SQUID.get().asItem()).when((LootItemCondition.Builder)LootItemBlockStatePropertyCondition.hasBlockStateProperties((Block)block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty((Property)StuffedSquidFeastBlock.SERVINGS, 5)))).apply((LootItemFunction.Builder)SetItemCountFunction.setCount((NumberProvider)ConstantValue.exactly((float)1.0f))));
            LootPool.Builder bowl = LootPool.lootPool().when(ExplosionCondition.survivesExplosion()).add((LootPoolEntryContainer.Builder)((LootPoolSingletonContainer.Builder)LootItem.lootTableItem((ItemLike)Items.BOWL).when(InvertedLootItemCondition.invert((LootItemCondition.Builder)LootItemBlockStatePropertyCondition.hasBlockStateProperties((Block)block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty((Property)StuffedSquidFeastBlock.SERVINGS, 5))))).apply((LootItemFunction.Builder)SetItemCountFunction.setCount((NumberProvider)ConstantValue.exactly((float)1.0f))));
            this.add(block, builder.withPool(fullBlock).withPool(bowl));
        }

        protected void createFeastTable(Block block) {
            LootTable.Builder builder = LootTable.lootTable();
            LootPool.Builder fullBlock = LootPool.lootPool().when(ExplosionCondition.survivesExplosion()).add((LootPoolEntryContainer.Builder)((LootPoolSingletonContainer.Builder)LootItem.lootTableItem((ItemLike)block.asItem()).when((LootItemCondition.Builder)LootItemBlockStatePropertyCondition.hasBlockStateProperties((Block)block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty((Property)FeastBlock.SERVINGS, 4)))).apply((LootItemFunction.Builder)SetItemCountFunction.setCount((NumberProvider)ConstantValue.exactly((float)1.0f))));
            LootPool.Builder bowl = LootPool.lootPool().when(ExplosionCondition.survivesExplosion()).add((LootPoolEntryContainer.Builder)((LootPoolSingletonContainer.Builder)LootItem.lootTableItem((ItemLike)Items.BOWL).when(InvertedLootItemCondition.invert((LootItemCondition.Builder)LootItemBlockStatePropertyCondition.hasBlockStateProperties((Block)block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty((Property)FeastBlock.SERVINGS, 4))))).apply((LootItemFunction.Builder)SetItemCountFunction.setCount((NumberProvider)ConstantValue.exactly((float)1.0f))));
            this.add(block, builder.withPool(fullBlock).withPool(bowl));
        }

        protected void createCaveCarrotCropTable(Block block) {
            LootTable.Builder builder = LootTable.lootTable();
            LootPool.Builder fullyGrown = LootPool.lootPool().when(ExplosionCondition.survivesExplosion()).add((LootPoolEntryContainer.Builder)((LootPoolSingletonContainer.Builder)LootItem.lootTableItem((ItemLike)((ItemLike)MDItems.CAVE_CARROT.get())).when((LootItemCondition.Builder)LootItemBlockStatePropertyCondition.hasBlockStateProperties((Block)block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty((Property)CaveCarrotBlock.AGE, 3)))).apply((LootItemFunction.Builder)SetItemCountFunction.setCount((NumberProvider)UniformGenerator.between((float)2.0f, (float)4.0f))));
            LootPool.Builder notFullyGrown = LootPool.lootPool().when(ExplosionCondition.survivesExplosion()).add((LootPoolEntryContainer.Builder)((LootPoolSingletonContainer.Builder)LootItem.lootTableItem((ItemLike)((ItemLike)MDItems.CAVE_CARROT.get())).when(InvertedLootItemCondition.invert((LootItemCondition.Builder)LootItemBlockStatePropertyCondition.hasBlockStateProperties((Block)block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty((Property)CaveCarrotBlock.AGE, 3))))).apply((LootItemFunction.Builder)SetItemCountFunction.setCount((NumberProvider)ConstantValue.exactly((float)1.0f))));
            this.add(block, builder.withPool(fullyGrown).withPool(notFullyGrown));
        }

        public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> output) {
            this.generate();
            HashSet<ResourceKey> set = new HashSet<ResourceKey>();
            for (Block block : this.getKnownBlocks()) {
                LootTable.Builder loottable$builder;
                ResourceKey resourcekey;
                if (!block.isEnabled(this.enabledFeatures) || (resourcekey = block.getLootTable()) == BuiltInLootTables.EMPTY || !set.add(resourcekey) || (loottable$builder = (LootTable.Builder)this.map.remove(resourcekey)) == null) continue;
                output.accept((ResourceKey<LootTable>)resourcekey, loottable$builder);
            }
            if (!this.map.isEmpty()) {
                throw new IllegalStateException("Created block loot tables for non-blocks: " + String.valueOf(this.map.keySet()));
            }
        }
    }
}

