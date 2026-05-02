/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.MapCodec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.tags.TagKey
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.storage.loot.LootContext
 *  net.minecraft.world.level.storage.loot.parameters.LootContextParam
 *  net.minecraft.world.level.storage.loot.parameters.LootContextParams
 *  net.minecraft.world.level.storage.loot.predicates.LootItemCondition
 *  net.minecraft.world.level.storage.loot.predicates.LootItemCondition$Builder
 *  net.minecraft.world.level.storage.loot.predicates.LootItemConditionType
 */
package com.sammy.minersdelight.content.loot;

import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.sammy.minersdelight.setup.MDLootConditions;
import java.util.Set;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParam;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;

public final class LootItemBlockTagCondition
implements LootItemCondition {
    public static final MapCodec<LootItemBlockTagCondition> CODEC = RecordCodecBuilder.mapCodec(obj -> obj.group((App)ResourceLocation.CODEC.fieldOf("tag").forGetter(LootItemBlockTagCondition::tag)).apply((Applicative)obj, LootItemBlockTagCondition::new));
    private final TagKey<Block> tag;

    public LootItemBlockTagCondition(ResourceLocation tag) {
        this.tag = TagKey.create((ResourceKey)BuiltInRegistries.BLOCK.key(), (ResourceLocation)tag);
    }

    public LootItemConditionType getType() {
        return (LootItemConditionType)MDLootConditions.BLOCK_TAG_CONDITION.get();
    }

    public Set<LootContextParam<?>> getReferencedContextParams() {
        return Set.of(LootContextParams.BLOCK_STATE);
    }

    public boolean test(LootContext context) {
        BlockState blockstate = (BlockState)context.getParamOrNull(LootContextParams.BLOCK_STATE);
        return blockstate != null && blockstate.is(this.tag);
    }

    public static Builder hasBlockStateProperties(TagKey<Block> tag) {
        return new Builder(tag);
    }

    public ResourceLocation tag() {
        return this.tag.location();
    }

    public static class Builder
    implements LootItemCondition.Builder {
        private final TagKey<Block> tag;

        public Builder(TagKey<Block> tag) {
            this.tag = tag;
        }

        public LootItemCondition build() {
            return new LootItemBlockTagCondition(this.tag.location());
        }
    }
}

