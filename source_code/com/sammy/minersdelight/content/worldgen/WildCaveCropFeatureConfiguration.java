/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  net.minecraft.util.ExtraCodecs
 *  net.minecraft.world.level.levelgen.feature.configurations.BlockPileConfiguration
 *  net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider
 */
package com.sammy.minersdelight.content.worldgen;

import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.level.levelgen.feature.configurations.BlockPileConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class WildCaveCropFeatureConfiguration
extends BlockPileConfiguration {
    public static final Codec<WildCaveCropFeatureConfiguration> CODEC = RecordCodecBuilder.create(p_191267_ -> p_191267_.group((App)BlockStateProvider.CODEC.fieldOf("state_provider").forGetter(p_191273_ -> p_191273_.stateProvider), (App)ExtraCodecs.POSITIVE_INT.fieldOf("spread_width").forGetter(p_191271_ -> p_191271_.spreadWidth), (App)ExtraCodecs.POSITIVE_INT.fieldOf("spread_height").forGetter(p_191269_ -> p_191269_.spreadHeight)).apply((Applicative)p_191267_, WildCaveCropFeatureConfiguration::new));
    public final int spreadWidth;
    public final int spreadHeight;

    public WildCaveCropFeatureConfiguration(BlockStateProvider stateProvider, int spreadWidth, int spreadHeight) {
        super(stateProvider);
        this.spreadWidth = spreadWidth;
        this.spreadHeight = spreadHeight;
    }
}

