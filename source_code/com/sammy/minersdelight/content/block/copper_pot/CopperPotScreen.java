/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  javax.annotation.Nonnull
 *  javax.annotation.ParametersAreNonnullByDefault
 *  net.minecraft.ChatFormatting
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.gui.components.ImageButton
 *  net.minecraft.client.gui.components.WidgetSprites
 *  net.minecraft.client.gui.components.events.GuiEventListener
 *  net.minecraft.client.gui.screens.inventory.AbstractContainerScreen
 *  net.minecraft.client.gui.screens.recipebook.RecipeBookComponent
 *  net.minecraft.client.gui.screens.recipebook.RecipeUpdateListener
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.player.Inventory
 *  net.minecraft.world.inventory.AbstractContainerMenu
 *  net.minecraft.world.inventory.ClickType
 *  net.minecraft.world.inventory.RecipeBookMenu
 *  net.minecraft.world.inventory.Slot
 *  net.minecraft.world.item.ItemStack
 *  vectorwing.farmersdelight.common.Configuration
 *  vectorwing.farmersdelight.common.utility.TextUtils
 */
package com.sammy.minersdelight.content.block.copper_pot;

import com.mojang.blaze3d.systems.RenderSystem;
import com.sammy.minersdelight.MinersDelightMod;
import com.sammy.minersdelight.content.block.copper_pot.CopperPotMenu;
import com.sammy.minersdelight.content.block.copper_pot.CopperPotRecipeBookComponent;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.client.gui.screens.recipebook.RecipeUpdateListener;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.RecipeBookMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import vectorwing.farmersdelight.common.Configuration;
import vectorwing.farmersdelight.common.utility.TextUtils;

@ParametersAreNonnullByDefault
public class CopperPotScreen
extends AbstractContainerScreen<CopperPotMenu>
implements RecipeUpdateListener {
    private static final WidgetSprites RECIPE_BUTTON = new WidgetSprites(ResourceLocation.withDefaultNamespace((String)"recipe_book/button"), ResourceLocation.withDefaultNamespace((String)"recipe_book/button"));
    private static final ResourceLocation BACKGROUND_TEXTURE = MinersDelightMod.path("textures/gui/copper_pot.png");
    private static final Rectangle HEAT_ICON = new Rectangle(49, 57, 17, 15);
    private static final Rectangle PROGRESS_ARROW = new Rectangle(78, 27, 0, 17);
    private final CopperPotRecipeBookComponent recipeBookComponent = new CopperPotRecipeBookComponent();
    private boolean widthTooNarrow;

    public CopperPotScreen(CopperPotMenu screenContainer, Inventory inv, Component titleIn) {
        super((AbstractContainerMenu)screenContainer, inv, titleIn);
    }

    public void init() {
        super.init();
        this.widthTooNarrow = this.width < 379;
        this.titleLabelX = 28;
        this.recipeBookComponent.init(this.width, this.height, this.minecraft, this.widthTooNarrow, (RecipeBookMenu)this.menu);
        this.leftPos = this.recipeBookComponent.updateScreenPosition(this.width, this.imageWidth);
        if (((Boolean)Configuration.ENABLE_COOKING_POT_RECIPE_BOOK.get()).booleanValue()) {
            this.addRenderableWidget((GuiEventListener)new ImageButton(this.leftPos + 5, this.height / 2 - 49, 20, 18, RECIPE_BUTTON, button -> {
                this.recipeBookComponent.toggleVisibility();
                this.leftPos = this.recipeBookComponent.updateScreenPosition(this.width, this.imageWidth);
                button.setPosition(this.leftPos + 5, this.height / 2 - 49);
            }));
        } else {
            this.recipeBookComponent.hide();
            this.leftPos = this.recipeBookComponent.updateScreenPosition(this.width, this.imageWidth);
        }
        this.addWidget((GuiEventListener)this.recipeBookComponent);
        this.setInitialFocus((GuiEventListener)this.recipeBookComponent);
    }

    protected void containerTick() {
        super.containerTick();
        this.recipeBookComponent.tick();
    }

    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(graphics, mouseX, mouseY, partialTicks);
        if (this.recipeBookComponent.isVisible() && this.widthTooNarrow) {
            this.renderBg(graphics, partialTicks, mouseX, mouseY);
            this.recipeBookComponent.render(graphics, mouseX, mouseY, partialTicks);
        } else {
            this.recipeBookComponent.render(graphics, mouseX, mouseY, partialTicks);
            super.render(graphics, mouseX, mouseY, partialTicks);
            this.recipeBookComponent.renderGhostRecipe(graphics, this.leftPos, this.topPos, false, partialTicks);
        }
        this.renderMealDisplayTooltip(graphics, mouseX, mouseY);
        this.renderHeatIndicatorTooltip(graphics, mouseX, mouseY);
        this.recipeBookComponent.renderTooltip(graphics, this.leftPos, this.topPos, mouseX, mouseY);
    }

    private void renderHeatIndicatorTooltip(GuiGraphics graphics, int mouseX, int mouseY) {
        if (this.isHovering(CopperPotScreen.HEAT_ICON.x, CopperPotScreen.HEAT_ICON.y, CopperPotScreen.HEAT_ICON.width, CopperPotScreen.HEAT_ICON.height, mouseX, mouseY)) {
            String key = "container.cooking_pot." + (((CopperPotMenu)this.menu).isHeated() ? "heated" : "not_heated");
            graphics.renderTooltip(this.font, (Component)TextUtils.getTranslation((String)key, (Object[])new Object[0]), mouseX, mouseY);
        }
    }

    protected void renderMealDisplayTooltip(GuiGraphics gui, int mouseX, int mouseY) {
        if (this.minecraft != null && this.minecraft.player != null && ((CopperPotMenu)this.menu).getCarried().isEmpty() && this.hoveredSlot != null && this.hoveredSlot.hasItem()) {
            if (this.hoveredSlot.index == 6) {
                ArrayList<MutableComponent> tooltip = new ArrayList<MutableComponent>();
                ItemStack mealStack = this.hoveredSlot.getItem();
                tooltip.add(((MutableComponent)mealStack.getItem().getDescription()).withStyle(mealStack.getRarity().getStyleModifier()));
                ItemStack containerStack = ((CopperPotMenu)this.menu).blockEntity.getContainer();
                String container = !containerStack.isEmpty() ? containerStack.getItem().getDescription().getString() : "";
                tooltip.add(TextUtils.getTranslation((String)"container.cooking_pot.served_on", (Object[])new Object[]{container}).withStyle(ChatFormatting.GRAY));
                gui.renderComponentTooltip(this.font, tooltip, mouseX, mouseY);
            } else {
                gui.renderTooltip(this.font, this.hoveredSlot.getItem(), mouseX, mouseY);
            }
        }
    }

    protected void renderLabels(GuiGraphics graphics, int mouseX, int mouseY) {
        super.renderLabels(graphics, mouseX, mouseY);
        graphics.drawString(this.font, this.playerInventoryTitle, 8, this.imageHeight - 96 + 2, 0x404040, false);
    }

    protected void renderBg(GuiGraphics graphics, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        if (this.minecraft == null) {
            return;
        }
        RenderSystem.setShaderTexture((int)0, (ResourceLocation)BACKGROUND_TEXTURE);
        graphics.blit(BACKGROUND_TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
        if (((CopperPotMenu)this.menu).isHeated()) {
            graphics.blit(BACKGROUND_TEXTURE, this.leftPos + CopperPotScreen.HEAT_ICON.x, this.topPos + CopperPotScreen.HEAT_ICON.y, 176, 0, CopperPotScreen.HEAT_ICON.width, CopperPotScreen.HEAT_ICON.height);
        }
        int l = ((CopperPotMenu)this.menu).getCookProgressionScaled();
        graphics.blit(BACKGROUND_TEXTURE, this.leftPos + CopperPotScreen.PROGRESS_ARROW.x, this.topPos + CopperPotScreen.PROGRESS_ARROW.y, 176, 15, l + 1, CopperPotScreen.PROGRESS_ARROW.height);
    }

    protected boolean isHovering(int x, int y, int width, int height, double mouseX, double mouseY) {
        return (!this.widthTooNarrow || !this.recipeBookComponent.isVisible()) && super.isHovering(x, y, width, height, mouseX, mouseY);
    }

    public boolean mouseClicked(double mouseX, double mouseY, int buttonId) {
        if (this.recipeBookComponent.mouseClicked(mouseX, mouseY, buttonId)) {
            this.setFocused((GuiEventListener)this.recipeBookComponent);
            return true;
        }
        return this.widthTooNarrow && this.recipeBookComponent.isVisible() || super.mouseClicked(mouseX, mouseY, buttonId);
    }

    protected boolean hasClickedOutside(double mouseX, double mouseY, int x, int y, int buttonIdx) {
        boolean flag = mouseX < (double)x || mouseY < (double)y || mouseX >= (double)(x + this.imageWidth) || mouseY >= (double)(y + this.imageHeight);
        return flag && this.recipeBookComponent.hasClickedOutside(mouseX, mouseY, this.leftPos, this.topPos, this.imageWidth, this.imageHeight, buttonIdx);
    }

    protected void slotClicked(Slot slot, int mouseX, int mouseY, ClickType clickType) {
        super.slotClicked(slot, mouseX, mouseY, clickType);
        this.recipeBookComponent.slotClicked(slot);
    }

    public void recipesUpdated() {
        this.recipeBookComponent.recipesUpdated();
    }

    @Nonnull
    public RecipeBookComponent getRecipeBookComponent() {
        return this.recipeBookComponent;
    }
}

