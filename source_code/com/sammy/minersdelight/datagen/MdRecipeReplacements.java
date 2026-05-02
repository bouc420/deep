/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.advancements.Advancement$Builder
 *  net.minecraft.advancements.AdvancementHolder
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.core.NonNullList
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.data.CachedOutput
 *  net.minecraft.data.PackOutput
 *  net.minecraft.data.recipes.RecipeOutput
 *  net.minecraft.data.recipes.packs.VanillaRecipeProvider
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.tags.TagKey
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.item.crafting.Ingredient$ItemValue
 *  net.minecraft.world.item.crafting.Ingredient$TagValue
 *  net.minecraft.world.item.crafting.Ingredient$Value
 *  net.minecraft.world.item.crafting.Recipe
 *  net.minecraft.world.item.crafting.ShapedRecipe
 *  net.minecraft.world.item.crafting.ShapedRecipePattern
 *  net.minecraft.world.item.crafting.ShapedRecipePattern$Data
 *  net.minecraft.world.item.crafting.ShapelessRecipe
 *  net.minecraft.world.level.ItemLike
 *  net.neoforged.fml.util.ObfuscationReflectionHelper
 *  net.neoforged.neoforge.common.conditions.ICondition
 */
package com.sammy.minersdelight.datagen;

import com.sammy.minersdelight.setup.MDTags;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.packs.VanillaRecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.item.crafting.ShapedRecipePattern;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import net.minecraft.world.level.ItemLike;
import net.neoforged.fml.util.ObfuscationReflectionHelper;
import net.neoforged.neoforge.common.conditions.ICondition;

public class MdRecipeReplacements
extends VanillaRecipeProvider {
    private final Map<Item, TagKey<Item>> replacements = new HashMap<Item, TagKey<Item>>();
    private final Map<Item, Ingredient> specialReplacements = new HashMap<Item, Ingredient>();
    private final Set<ResourceLocation> excludes = new HashSet<ResourceLocation>();

    public MdRecipeReplacements(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> provider) {
        super(packOutput, provider);
    }

    private void exclude(ItemLike item) {
        this.excludes.add(BuiltInRegistries.ITEM.getKey((Object)item.asItem()));
    }

    private void exclude(String name) {
        this.excludes.add(ResourceLocation.parse((String)name));
    }

    private void replace(ItemLike item, TagKey<Item> tag) {
        this.replacements.put(item.asItem(), tag);
    }

    protected void buildRecipes(final RecipeOutput recipeOutput) {
        this.replace((ItemLike)Items.MOSS_BLOCK, MDTags.MOSS);
        super.buildRecipes(new RecipeOutput(){

            public void accept(ResourceLocation id, Recipe<?> recipe, @Nullable AdvancementHolder advancement, ICondition ... conditions) {
                Recipe<?> modified = MdRecipeReplacements.this.enhance(id, recipe);
                if (modified != null) {
                    recipeOutput.accept(id, modified, null, conditions);
                }
            }

            public Advancement.Builder advancement() {
                return recipeOutput.advancement();
            }
        });
    }

    @Nullable
    private Recipe<?> enhance(ResourceLocation id, Recipe<?> vanilla) {
        if (vanilla instanceof ShapelessRecipe) {
            ShapelessRecipe shapeless = (ShapelessRecipe)vanilla;
            return this.enhance(id, shapeless);
        }
        if (vanilla instanceof ShapedRecipe) {
            ShapedRecipe shaped = (ShapedRecipe)vanilla;
            return this.enhance(id, shaped);
        }
        return null;
    }

    @Nullable
    private ShapelessRecipe enhance(ResourceLocation id, ShapelessRecipe vanilla) {
        NonNullList ingredients = vanilla.getIngredients();
        boolean modified = false;
        for (int x = 0; x < ingredients.size(); ++x) {
            Ingredient ing = this.enhance(id, (Ingredient)ingredients.get(x));
            if (ing == null) continue;
            ingredients.set(x, ing);
            modified = true;
        }
        return modified ? vanilla : null;
    }

    protected CompletableFuture<?> buildAdvancement(CachedOutput p_253674_, HolderLookup.Provider p_323646_, AdvancementHolder p_301116_) {
        return CompletableFuture.allOf(new CompletableFuture[0]);
    }

    @Nullable
    private ShapedRecipe enhance(ResourceLocation id, ShapedRecipe vanilla) {
        ShapedRecipePattern pattern = (ShapedRecipePattern)ObfuscationReflectionHelper.getPrivateValue(ShapedRecipe.class, (Object)vanilla, (String)"pattern");
        if (pattern == null) {
            throw new IllegalStateException(ShapedRecipe.class.getName() + " has no field pattern");
        }
        ShapedRecipePattern.Data data = (ShapedRecipePattern.Data)((Optional)ObfuscationReflectionHelper.getPrivateValue(ShapedRecipePattern.class, (Object)pattern, (String)"data")).orElseThrow(() -> new IllegalArgumentException("recipe " + String.valueOf(id) + " does not have pattern data"));
        Map ingredients = data.key();
        boolean modified = false;
        for (Character x : ingredients.keySet()) {
            Ingredient ing = this.enhance(id, (Ingredient)ingredients.get(x));
            if (ing == null) continue;
            ingredients.put(x, ing);
            modified = true;
        }
        return modified ? vanilla : null;
    }

    @Nullable
    private Ingredient enhance(ResourceLocation name, Ingredient vanilla) {
        Ingredient.ItemValue itemValue;
        Item item;
        Ingredient replacement;
        Ingredient.Value value;
        if (this.excludes.contains(name)) {
            return null;
        }
        boolean modified = false;
        ArrayList<Object> items = new ArrayList<Object>();
        Ingredient.Value[] vanillaItems = vanilla.getValues();
        if (vanillaItems.length == 1 && (value = vanillaItems[0]) instanceof Ingredient.ItemValue && (replacement = this.specialReplacements.get(item = (itemValue = (Ingredient.ItemValue)value).item().getItem())) != null) {
            return replacement;
        }
        for (Ingredient.Value entry : vanillaItems) {
            if (entry instanceof Ingredient.ItemValue) {
                ItemStack stack = entry.getItems().stream().findFirst().orElse(ItemStack.EMPTY);
                TagKey<Item> replacement2 = this.replacements.get(stack.getItem());
                if (replacement2 != null) {
                    items.add(new Ingredient.TagValue(replacement2));
                    modified = true;
                    continue;
                }
                items.add(entry);
                continue;
            }
            items.add(entry);
        }
        return modified ? Ingredient.fromValues(items.stream()) : null;
    }
}

