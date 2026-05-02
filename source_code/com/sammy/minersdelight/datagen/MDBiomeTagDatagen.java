/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.data.PackOutput
 *  net.minecraft.data.tags.BiomeTagsProvider
 *  net.minecraft.tags.TagKey
 *  net.neoforged.neoforge.common.Tags$Biomes
 *  net.neoforged.neoforge.common.data.ExistingFileHelper
 */
package com.sammy.minersdelight.datagen;

import com.sammy.minersdelight.setup.MDTags;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.TagKey;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class MDBiomeTagDatagen
extends BiomeTagsProvider {
    public MDBiomeTagDatagen(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pProvider, "minersdelight", existingFileHelper);
    }

    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(MDTags.HAS_CAVE_CARROTS).addTags(new TagKey[]{Tags.Biomes.IS_HOT, Tags.Biomes.IS_DRY, Tags.Biomes.IS_PLAINS, Tags.Biomes.IS_FOREST});
    }
}

