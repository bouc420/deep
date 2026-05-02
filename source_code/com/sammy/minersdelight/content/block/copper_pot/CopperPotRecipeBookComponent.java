/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  net.minecraft.client.gui.components.WidgetSprites
 *  net.minecraft.client.gui.screens.recipebook.RecipeBookComponent
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.network.chat.Component
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.inventory.Slot
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.item.crafting.Recipe
 *  net.minecraft.world.item.crafting.RecipeHolder
 *  vectorwing.farmersdelight.common.crafting.CookingPotRecipe
 *  vectorwing.farmersdelight.common.utility.TextUtils
 */
package com.sammy.minersdelight.content.block.copper_pot;

import com.sammy.minersdelight.content.data.CupConversionDataMap;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nonnull;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import vectorwing.farmersdelight.common.crafting.CookingPotRecipe;
import vectorwing.farmersdelight.common.utility.TextUtils;

public class CopperPotRecipeBookComponent
extends RecipeBookComponent {
    protected static final WidgetSprites RECIPE_BOOK_BUTTONS = new WidgetSprites(ResourceLocation.fromNamespaceAndPath((String)"farmersdelight", (String)"recipe_book/cooking_pot_enabled"), ResourceLocation.fromNamespaceAndPath((String)"farmersdelight", (String)"recipe_book/cooking_pot_disabled"), ResourceLocation.fromNamespaceAndPath((String)"farmersdelight", (String)"recipe_book/cooking_pot_enabled_highlighted"), ResourceLocation.fromNamespaceAndPath((String)"farmersdelight", (String)"recipe_book/cooking_pot_disabled_highlighted"));

    protected void initFilterButtonTextures() {
        this.filterButton.initTextureValues(RECIPE_BOOK_BUTTONS);
    }

    public void hide() {
        this.setVisible(false);
    }

    @Nonnull
    protected Component getRecipeFilterName() {
        return TextUtils.getTranslation((String)"container.recipe_book.cookable", (Object[])new Object[0]);
    }

    public void setupGhostRecipe(RecipeHolder<?> recipe, List<Slot> slots) {
        CookingPotRecipe cookingRecipe;
        ItemStack containerStack;
        Recipe recipe2;
        ItemStack resultStack = recipe.value().getResultItem((HolderLookup.Provider)this.minecraft.level.registryAccess());
        Optional<ItemStack> cupVariant = CupConversionDataMap.getCupVariant(resultStack);
        if (cupVariant.isPresent()) {
            resultStack = cupVariant.get();
            resultStack.grow(1);
        }
        this.ghostRecipe.setRecipe(recipe);
        if (slots.get(6).getItem().isEmpty()) {
            this.ghostRecipe.addIngredient(Ingredient.of((ItemStack[])new ItemStack[]{resultStack}), slots.get((int)6).x, slots.get((int)6).y);
        }
        if ((recipe2 = recipe.value()) instanceof CookingPotRecipe && !(containerStack = (cookingRecipe = (CookingPotRecipe)recipe2).getOutputContainer()).isEmpty()) {
            this.ghostRecipe.addIngredient(Ingredient.of((ItemStack[])new ItemStack[]{containerStack}), slots.get((int)7).x, slots.get((int)7).y);
        }
        this.placeRecipe(this.menu.getGridWidth(), this.menu.getGridHeight(), this.menu.getResultSlotIndex(), recipe, recipe.value().getIngredients().iterator(), 0);
    }
}

