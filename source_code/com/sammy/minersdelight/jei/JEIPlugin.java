/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  mezz.jei.api.IModPlugin
 *  mezz.jei.api.JeiPlugin
 *  mezz.jei.api.helpers.IGuiHelper
 *  mezz.jei.api.recipe.RecipeType
 *  mezz.jei.api.recipe.category.IRecipeCategory
 *  mezz.jei.api.registration.IGuiHandlerRegistration
 *  mezz.jei.api.registration.IRecipeCatalystRegistration
 *  mezz.jei.api.registration.IRecipeCategoryRegistration
 *  mezz.jei.api.registration.IRecipeRegistration
 *  mezz.jei.api.registration.IRecipeTransferRegistration
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.inventory.MenuType
 *  net.minecraft.world.item.BlockItem
 *  net.minecraft.world.item.crafting.RecipeType
 *  net.minecraft.world.level.Level
 *  team.lodestar.lodestone.systems.recipe.LodestoneRecipeType
 *  vectorwing.farmersdelight.common.crafting.CookingPotRecipe
 *  vectorwing.farmersdelight.common.registry.ModRecipeTypes
 */
package com.sammy.minersdelight.jei;

import com.sammy.minersdelight.MinersDelightMod;
import com.sammy.minersdelight.content.block.copper_pot.CopperPotMenu;
import com.sammy.minersdelight.content.block.copper_pot.CopperPotScreen;
import com.sammy.minersdelight.jei.CopperPotCookingRecipeCategory;
import com.sammy.minersdelight.setup.MDItems;
import com.sammy.minersdelight.setup.MDMenuTypes;
import java.util.List;
import javax.annotation.Nonnull;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.Level;
import team.lodestar.lodestone.systems.recipe.LodestoneRecipeType;
import vectorwing.farmersdelight.common.crafting.CookingPotRecipe;
import vectorwing.farmersdelight.common.registry.ModRecipeTypes;

@JeiPlugin
public class JEIPlugin
implements IModPlugin {
    private static final ResourceLocation ID = MinersDelightMod.path("jei_plugin");
    private static final Minecraft MC = Minecraft.getInstance();
    public static final RecipeType<CookingPotRecipe> COPPER_POT_COOKING = new RecipeType(CopperPotCookingRecipeCategory.UID, CookingPotRecipe.class);

    public void registerCategories(IRecipeCategoryRegistration registry) {
        IGuiHelper guiHelper = registry.getJeiHelpers().getGuiHelper();
        registry.addRecipeCategories(new IRecipeCategory[]{new CopperPotCookingRecipeCategory(guiHelper)});
    }

    public void registerRecipes(@Nonnull IRecipeRegistration registry) {
        ClientLevel level = Minecraft.getInstance().level;
        if (level != null) {
            List cooking = LodestoneRecipeType.getRecipes((Level)level, (net.minecraft.world.item.crafting.RecipeType)((net.minecraft.world.item.crafting.RecipeType)ModRecipeTypes.COOKING.get()));
            cooking.removeIf(r -> r.getIngredients().stream().filter(i -> !i.isEmpty()).count() > 4L);
            registry.addRecipes(COPPER_POT_COOKING, cooking);
        }
    }

    public void registerRecipeCatalysts(IRecipeCatalystRegistration registry) {
        registry.addRecipeCatalyst(((BlockItem)MDItems.COPPER_POT.get()).getDefaultInstance(), new RecipeType[]{COPPER_POT_COOKING});
    }

    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(CopperPotScreen.class, 78, 28, 28, 15, new RecipeType[]{COPPER_POT_COOKING});
    }

    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        registration.addRecipeTransferHandler(CopperPotMenu.class, (MenuType)MDMenuTypes.COPPER_POT.get(), COPPER_POT_COOKING, 0, 4, 7, 36);
    }

    public ResourceLocation getPluginUid() {
        return ID;
    }
}

