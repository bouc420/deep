/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.ParametersAreNonnullByDefault
 *  mezz.jei.api.constants.VanillaTypes
 *  mezz.jei.api.gui.builder.IRecipeLayoutBuilder
 *  mezz.jei.api.gui.drawable.IDrawable
 *  mezz.jei.api.gui.drawable.IDrawableAnimated
 *  mezz.jei.api.gui.drawable.IDrawableAnimated$StartDirection
 *  mezz.jei.api.gui.ingredient.IRecipeSlotsView
 *  mezz.jei.api.helpers.IGuiHelper
 *  mezz.jei.api.ingredients.IIngredientType
 *  mezz.jei.api.recipe.IFocusGroup
 *  mezz.jei.api.recipe.RecipeIngredientRole
 *  mezz.jei.api.recipe.RecipeType
 *  mezz.jei.api.recipe.category.IRecipeCategory
 *  net.minecraft.MethodsReturnNonnullByDefault
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.core.NonNullList
 *  net.minecraft.network.chat.Component
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.item.crafting.Recipe
 *  net.minecraft.world.level.ItemLike
 *  vectorwing.farmersdelight.common.crafting.CookingPotRecipe
 *  vectorwing.farmersdelight.common.utility.ClientRenderUtils
 *  vectorwing.farmersdelight.common.utility.RecipeUtils
 *  vectorwing.farmersdelight.common.utility.TextUtils
 */
package com.sammy.minersdelight.jei;

import com.sammy.minersdelight.MinersDelightMod;
import com.sammy.minersdelight.content.data.CupConversionDataMap;
import com.sammy.minersdelight.jei.JEIPlugin;
import com.sammy.minersdelight.setup.MDItems;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.annotation.ParametersAreNonnullByDefault;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredientType;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import vectorwing.farmersdelight.common.crafting.CookingPotRecipe;
import vectorwing.farmersdelight.common.utility.ClientRenderUtils;
import vectorwing.farmersdelight.common.utility.RecipeUtils;
import vectorwing.farmersdelight.common.utility.TextUtils;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class CopperPotCookingRecipeCategory
implements IRecipeCategory<CookingPotRecipe> {
    public static final ResourceLocation UID = MinersDelightMod.path("copper_pot_cooking");
    protected final IDrawable heatIndicator;
    protected final IDrawable timeIcon;
    protected final IDrawable expIcon;
    protected final IDrawableAnimated arrow;
    private final Component title = TextUtils.getTranslation((String)"jei.cooking", (Object[])new Object[0]);
    private final IDrawable background;
    private final IDrawable icon;

    public CopperPotCookingRecipeCategory(IGuiHelper helper) {
        ResourceLocation backgroundImage = MinersDelightMod.path("textures/gui/copper_pot.png");
        ResourceLocation fdBackgroundImage = ResourceLocation.fromNamespaceAndPath((String)"farmersdelight", (String)"textures/gui/cooking_pot.png");
        this.background = helper.createDrawable(backgroundImage, 29, 16, 116, 56);
        this.icon = helper.createDrawableIngredient((IIngredientType)VanillaTypes.ITEM_STACK, (Object)new ItemStack((ItemLike)MDItems.COPPER_POT.get()));
        this.heatIndicator = helper.createDrawable(backgroundImage, 176, 0, 17, 15);
        this.timeIcon = helper.createDrawable(fdBackgroundImage, 176, 32, 8, 11);
        this.expIcon = helper.createDrawable(fdBackgroundImage, 176, 43, 9, 9);
        this.arrow = helper.drawableBuilder(backgroundImage, 176, 15, 24, 17).buildAnimated(200, IDrawableAnimated.StartDirection.LEFT, false);
    }

    public RecipeType<CookingPotRecipe> getRecipeType() {
        return JEIPlugin.COPPER_POT_COOKING;
    }

    public Component getTitle() {
        return this.title;
    }

    public IDrawable getBackground() {
        return this.background;
    }

    public IDrawable getIcon() {
        return this.icon;
    }

    public void setRecipe(IRecipeLayoutBuilder builder, CookingPotRecipe recipe, IFocusGroup focusGroup) {
        NonNullList recipeIngredients = recipe.getIngredients();
        ItemStack resultStack = RecipeUtils.getResultItem((Recipe)recipe);
        ItemStack containerStack = recipe.getOutputContainer();
        Optional<ItemStack> cupVariant = CupConversionDataMap.getCupVariant(resultStack);
        if (cupVariant.isPresent()) {
            resultStack = cupVariant.get();
            resultStack.grow(1);
            containerStack = resultStack.getCraftingRemainingItem();
        }
        int borderSlotSize = 18;
        for (int row = 0; row < 2; ++row) {
            for (int column = 0; column < 2; ++column) {
                int inputIndex = row * 2 + column;
                if (inputIndex >= recipeIngredients.size()) continue;
                builder.addSlot(RecipeIngredientRole.INPUT, 11 + column * borderSlotSize, 2 + row * borderSlotSize).addItemStacks(Arrays.asList(((Ingredient)recipeIngredients.get(inputIndex)).getItems()));
            }
        }
        builder.addSlot(RecipeIngredientRole.OUTPUT, 86, 12).addItemStack(resultStack);
        if (!containerStack.isEmpty()) {
            builder.addSlot(RecipeIngredientRole.CATALYST, 54, 40).addItemStack(containerStack);
        }
        builder.addSlot(RecipeIngredientRole.OUTPUT, 86, 40).addItemStack(resultStack);
    }

    public void draw(CookingPotRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        this.arrow.draw(guiGraphics, 48, 11);
        this.heatIndicator.draw(guiGraphics, 19, 40);
        this.timeIcon.draw(guiGraphics, 56, 4);
        if (recipe.getExperience() > 0.0f) {
            this.expIcon.draw(guiGraphics, 55, 23);
        }
    }

    public List<Component> getTooltipStrings(CookingPotRecipe recipe, IRecipeSlotsView recipeSlotsView, double mouseX, double mouseY) {
        if (ClientRenderUtils.isCursorInsideBounds((int)61, (int)2, (int)22, (int)28, (double)mouseX, (double)mouseY)) {
            float experience;
            ArrayList<Component> tooltipStrings = new ArrayList<Component>();
            int cookTime = recipe.getCookTime();
            if (cookTime > 0) {
                int cookTimeSeconds = cookTime / 20;
                tooltipStrings.add((Component)Component.translatable((String)"gui.jei.category.smelting.time.seconds", (Object[])new Object[]{cookTimeSeconds}));
            }
            if ((experience = recipe.getExperience()) > 0.0f) {
                tooltipStrings.add((Component)Component.translatable((String)"gui.jei.category.smelting.experience", (Object[])new Object[]{Float.valueOf(experience)}));
            }
            return tooltipStrings;
        }
        return Collections.emptyList();
    }
}

