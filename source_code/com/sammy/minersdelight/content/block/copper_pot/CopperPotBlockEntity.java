/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  it.unimi.dsi.fastutil.objects.Object2IntMap$Entry
 *  it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.core.NonNullList
 *  net.minecraft.core.component.DataComponentMap$Builder
 *  net.minecraft.core.component.DataComponents
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.nbt.Tag
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.Component$Serializer
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.MenuProvider
 *  net.minecraft.world.Nameable
 *  net.minecraft.world.entity.ExperienceOrb
 *  net.minecraft.world.entity.player.Inventory
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.inventory.AbstractContainerMenu
 *  net.minecraft.world.inventory.ContainerData
 *  net.minecraft.world.inventory.RecipeCraftingHolder
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.component.CustomData
 *  net.minecraft.world.item.crafting.RecipeHolder
 *  net.minecraft.world.item.crafting.RecipeInput
 *  net.minecraft.world.item.crafting.RecipeManager
 *  net.minecraft.world.item.crafting.RecipeManager$CachedCheck
 *  net.minecraft.world.item.crafting.RecipeType
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.entity.BlockEntity$DataComponentInput
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.neoforge.items.IItemHandler
 *  net.neoforged.neoforge.items.ItemStackHandler
 *  net.neoforged.neoforge.items.wrapper.RecipeWrapper
 *  vectorwing.farmersdelight.common.block.CookingPotBlock
 *  vectorwing.farmersdelight.common.block.entity.CookingPotBlockEntity
 *  vectorwing.farmersdelight.common.block.entity.HeatableBlockEntity
 *  vectorwing.farmersdelight.common.block.entity.SyncedBlockEntity
 *  vectorwing.farmersdelight.common.crafting.CookingPotRecipe
 *  vectorwing.farmersdelight.common.item.component.ItemStackWrapper
 *  vectorwing.farmersdelight.common.registry.ModDataComponents
 *  vectorwing.farmersdelight.common.registry.ModParticleTypes
 *  vectorwing.farmersdelight.common.registry.ModRecipeTypes
 *  vectorwing.farmersdelight.common.utility.ItemUtils
 */
package com.sammy.minersdelight.content.block.copper_pot;

import com.google.common.collect.Lists;
import com.sammy.minersdelight.content.block.copper_pot.CopperPotItemHandler;
import com.sammy.minersdelight.content.block.copper_pot.CopperPotMenu;
import com.sammy.minersdelight.content.data.CupConversionDataMap;
import com.sammy.minersdelight.setup.MDBlockEntities;
import com.sammy.minersdelight.setup.MDBlocks;
import com.sammy.minersdelight.setup.MDItems;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.Nameable;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeCraftingHolder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.items.wrapper.RecipeWrapper;
import vectorwing.farmersdelight.common.block.CookingPotBlock;
import vectorwing.farmersdelight.common.block.entity.CookingPotBlockEntity;
import vectorwing.farmersdelight.common.block.entity.HeatableBlockEntity;
import vectorwing.farmersdelight.common.block.entity.SyncedBlockEntity;
import vectorwing.farmersdelight.common.crafting.CookingPotRecipe;
import vectorwing.farmersdelight.common.item.component.ItemStackWrapper;
import vectorwing.farmersdelight.common.registry.ModDataComponents;
import vectorwing.farmersdelight.common.registry.ModParticleTypes;
import vectorwing.farmersdelight.common.registry.ModRecipeTypes;
import vectorwing.farmersdelight.common.utility.ItemUtils;

public class CopperPotBlockEntity
extends SyncedBlockEntity
implements MenuProvider,
HeatableBlockEntity,
Nameable,
RecipeCraftingHolder {
    public static final int MEAL_DISPLAY_SLOT = 4;
    public static final int CONTAINER_SLOT = 5;
    public static final int OUTPUT_SLOT = 6;
    public static final int INVENTORY_SIZE = 7;
    private final ItemStackHandler inventory = this.createHandler();
    public final IItemHandler inputHandler = new CopperPotItemHandler((IItemHandler)this.inventory, Direction.UP);
    public final IItemHandler outputHandler = new CopperPotItemHandler((IItemHandler)this.inventory, Direction.DOWN);
    private int cookTime;
    private int cookTimeTotal;
    private ItemStack mealContainerStack = ItemStack.EMPTY;
    private Component customName;
    protected final ContainerData cookingPotData = this.createIntArray();
    private final Object2IntOpenHashMap<ResourceLocation> usedRecipeTracker = new Object2IntOpenHashMap();
    private final RecipeManager.CachedCheck<RecipeWrapper, CookingPotRecipe> quickCheck = RecipeManager.createCheck((RecipeType)((RecipeType)ModRecipeTypes.COOKING.get()));

    public CopperPotBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public CopperPotBlockEntity(BlockPos pos, BlockState state) {
        this((BlockEntityType)MDBlockEntities.COPPER_POT.get(), pos, state);
    }

    public static ItemStack getMealFromItem(ItemStack cookingPotStack, HolderLookup.Provider registries) {
        CompoundTag compound;
        CompoundTag inventoryTag;
        if (!cookingPotStack.is(MDBlocks.COPPER_POT.get().asItem())) {
            return ItemStack.EMPTY;
        }
        CustomData blockEntityData = (CustomData)cookingPotStack.get(DataComponents.BLOCK_ENTITY_DATA);
        if (blockEntityData != null && (inventoryTag = (compound = blockEntityData.copyTag()).getCompound("Inventory")).contains("Items", 9)) {
            ItemStackHandler handler = new ItemStackHandler();
            handler.deserializeNBT(registries, inventoryTag);
            return handler.getStackInSlot(4);
        }
        return ItemStack.EMPTY;
    }

    public static void takeServingFromItem(ItemStack cookingPotStack, HolderLookup.Provider registries) {
        CompoundTag compound;
        CompoundTag inventoryTag;
        if (!cookingPotStack.is(MDBlocks.COPPER_POT.get().asItem())) {
            return;
        }
        CustomData blockEntityData = (CustomData)cookingPotStack.get(DataComponents.BLOCK_ENTITY_DATA);
        if (blockEntityData != null && (inventoryTag = (compound = blockEntityData.copyTag()).getCompound("Inventory")).contains("Items", 9)) {
            ItemStackHandler handler = new ItemStackHandler();
            handler.deserializeNBT(registries, inventoryTag);
            ItemStack newMealStack = handler.getStackInSlot(4);
            newMealStack.shrink(1);
            compound.remove("Inventory");
            compound.put("Inventory", (Tag)handler.serializeNBT(registries));
        }
    }

    public static ItemStack getContainerFromItem(ItemStack cookingPotStack, HolderLookup.Provider registries) {
        if (!cookingPotStack.is(MDBlocks.COPPER_POT.get().asItem())) {
            return ItemStack.EMPTY;
        }
        CustomData blockEntityData = (CustomData)cookingPotStack.get(DataComponents.BLOCK_ENTITY_DATA);
        if (blockEntityData != null) {
            CompoundTag compound = blockEntityData.copyTag();
            return ItemStack.parseOptional((HolderLookup.Provider)registries, (CompoundTag)compound.getCompound("Container"));
        }
        return ItemStack.EMPTY;
    }

    public void loadAdditional(CompoundTag compound, HolderLookup.Provider registries) {
        super.loadAdditional(compound, registries);
        this.inventory.deserializeNBT(registries, compound.getCompound("Inventory"));
        this.cookTime = compound.getInt("CookTime");
        this.cookTimeTotal = compound.getInt("CookTimeTotal");
        this.mealContainerStack = ItemStack.parseOptional((HolderLookup.Provider)registries, (CompoundTag)compound.getCompound("Container"));
        if (compound.contains("CustomName", 8)) {
            this.customName = Component.Serializer.fromJson((String)compound.getString("CustomName"), (HolderLookup.Provider)registries);
        }
        CompoundTag compoundRecipes = compound.getCompound("RecipesUsed");
        for (String key : compoundRecipes.getAllKeys()) {
            this.usedRecipeTracker.put((Object)ResourceLocation.parse((String)key), compoundRecipes.getInt(key));
        }
    }

    public void saveAdditional(CompoundTag compound, HolderLookup.Provider registries) {
        super.saveAdditional(compound, registries);
        compound.putInt("CookTime", this.cookTime);
        compound.putInt("CookTimeTotal", this.cookTimeTotal);
        compound.put("Container", this.mealContainerStack.saveOptional(registries));
        if (this.customName != null) {
            compound.putString("CustomName", Component.Serializer.toJson((Component)this.customName, (HolderLookup.Provider)registries));
        }
        compound.put("Inventory", (Tag)this.inventory.serializeNBT(registries));
        CompoundTag compoundRecipes = new CompoundTag();
        this.usedRecipeTracker.forEach((recipeId, craftedAmount) -> compoundRecipes.putInt(recipeId.toString(), craftedAmount.intValue()));
        compound.put("RecipesUsed", (Tag)compoundRecipes);
    }

    private CompoundTag writeItems(CompoundTag compound, HolderLookup.Provider registries) {
        super.saveAdditional(compound, registries);
        compound.put("Container", this.mealContainerStack.saveOptional(registries));
        compound.put("Inventory", (Tag)this.inventory.serializeNBT(registries));
        return compound;
    }

    public ItemStack getAsItem() {
        ItemStack stack = new ItemStack((ItemLike)MDItems.COPPER_POT.get());
        stack.applyComponents(this.collectComponents());
        return stack;
    }

    public static void cookingTick(Level level, BlockPos pos, BlockState state, CopperPotBlockEntity cookingPot) {
        boolean isHeated = cookingPot.isHeated(level, pos);
        boolean didInventoryChange = false;
        if (isHeated && cookingPot.hasInput()) {
            Optional<RecipeHolder<CookingPotRecipe>> optionalRecipeHolder = cookingPot.getMatchingRecipe(cookingPot.createFakeRecipeWrapper());
            if (optionalRecipeHolder.isPresent() && cookingPot.canCook((CookingPotRecipe)optionalRecipeHolder.get().value())) {
                didInventoryChange = cookingPot.processCooking(optionalRecipeHolder.get(), cookingPot);
            } else {
                cookingPot.cookTime = 0;
            }
        } else if (cookingPot.cookTime > 0) {
            cookingPot.cookTime = Mth.clamp((int)(cookingPot.cookTime - 2), (int)0, (int)cookingPot.cookTimeTotal);
        }
        ItemStack mealStack = cookingPot.getMeal();
        if (!mealStack.isEmpty()) {
            if (!cookingPot.doesMealHaveContainer(mealStack)) {
                cookingPot.moveMealToOutput();
                didInventoryChange = true;
            } else if (!cookingPot.inventory.getStackInSlot(5).isEmpty()) {
                cookingPot.useStoredContainersOnMeal();
                didInventoryChange = true;
            }
        }
        if (didInventoryChange) {
            cookingPot.inventoryChanged();
        }
    }

    public static void animationTick(Level level, BlockPos pos, BlockState state, CopperPotBlockEntity cookingPot) {
        if (cookingPot.isHeated(level, pos)) {
            double z;
            double y;
            double x;
            RandomSource random = level.random;
            if (random.nextFloat() < 0.2f) {
                x = (double)pos.getX() + 0.5 + (random.nextDouble() * 0.6 - 0.3);
                y = (double)pos.getY() + 0.7;
                z = (double)pos.getZ() + 0.5 + (random.nextDouble() * 0.6 - 0.3);
                level.addParticle((ParticleOptions)ParticleTypes.BUBBLE_POP, x, y, z, 0.0, 0.0, 0.0);
            }
            if (random.nextFloat() < 0.05f) {
                x = (double)pos.getX() + 0.5 + (random.nextDouble() * 0.4 - 0.2);
                y = (double)pos.getY() + 0.5;
                z = (double)pos.getZ() + 0.5 + (random.nextDouble() * 0.4 - 0.2);
                double motionY = random.nextBoolean() ? 0.015 : 0.005;
                level.addParticle((ParticleOptions)ModParticleTypes.STEAM.get(), x, y, z, 0.0, motionY, 0.0);
            }
        }
    }

    public RecipeWrapper createFakeRecipeWrapper() {
        ItemStackHandler handler = new ItemStackHandler(9);
        for (int i = 0; i < 7; ++i) {
            int slot = i;
            if (i >= 4) {
                slot += 2;
            }
            handler.setStackInSlot(slot, this.inventory.getStackInSlot(i));
        }
        return new RecipeWrapper((IItemHandler)handler);
    }

    private Optional<RecipeHolder<CookingPotRecipe>> getMatchingRecipe(RecipeWrapper inventoryWrapper) {
        if (this.level == null) {
            return Optional.empty();
        }
        return this.hasInput() ? this.quickCheck.getRecipeFor((RecipeInput)inventoryWrapper, this.level) : Optional.empty();
    }

    public ItemStack getContainer() {
        ItemStack mealStack = this.getMeal();
        if (mealStack.isEmpty() || this.mealContainerStack.isEmpty()) {
            return mealStack.getCraftingRemainingItem();
        }
        return this.mealContainerStack;
    }

    private boolean hasInput() {
        for (int i = 0; i < 4; ++i) {
            if (this.inventory.getStackInSlot(i).isEmpty()) continue;
            return true;
        }
        return false;
    }

    protected boolean canCook(CookingPotRecipe recipe) {
        if (this.hasInput()) {
            ItemStack storedMealStack;
            ItemStack resultStack = recipe.assemble(new RecipeWrapper((IItemHandler)this.inventory), (HolderLookup.Provider)this.level.registryAccess());
            if (resultStack.isEmpty()) {
                return false;
            }
            Optional<ItemStack> cupVariant = CupConversionDataMap.getCupVariant(resultStack);
            if (cupVariant.isPresent()) {
                resultStack = cupVariant.get();
                resultStack.grow(1);
            }
            if ((storedMealStack = this.inventory.getStackInSlot(4)).isEmpty()) {
                return true;
            }
            if (!ItemStack.isSameItem((ItemStack)storedMealStack, (ItemStack)resultStack)) {
                return false;
            }
            if (storedMealStack.getCount() + resultStack.getCount() <= this.inventory.getSlotLimit(4)) {
                return true;
            }
            return storedMealStack.getCount() + resultStack.getCount() <= resultStack.getMaxStackSize();
        }
        return false;
    }

    private boolean processCooking(RecipeHolder<CookingPotRecipe> recipe, CopperPotBlockEntity cookingPot) {
        ItemStack storedMealStack;
        if (this.level == null) {
            return false;
        }
        ++this.cookTime;
        this.cookTimeTotal = ((CookingPotRecipe)recipe.value()).getCookTime();
        if (this.cookTime < this.cookTimeTotal) {
            return false;
        }
        this.cookTime = 0;
        ItemStack resultStack = ((CookingPotRecipe)recipe.value()).assemble(new RecipeWrapper((IItemHandler)this.inventory), (HolderLookup.Provider)this.level.registryAccess());
        Optional<ItemStack> cupVariant = CupConversionDataMap.getCupVariant(resultStack);
        this.mealContainerStack = ((CookingPotRecipe)recipe.value()).getOutputContainer();
        if (cupVariant.isPresent()) {
            resultStack = cupVariant.get();
            resultStack.grow(1);
            this.mealContainerStack = resultStack.getCraftingRemainingItem();
        }
        if ((storedMealStack = this.inventory.getStackInSlot(4)).isEmpty()) {
            this.inventory.setStackInSlot(4, resultStack.copy());
        } else if (ItemStack.isSameItem((ItemStack)storedMealStack, (ItemStack)resultStack)) {
            storedMealStack.grow(resultStack.getCount());
        }
        cookingPot.setRecipeUsed(recipe);
        for (int i = 0; i < 4; ++i) {
            ItemStack slotStack = this.inventory.getStackInSlot(i);
            if (slotStack.hasCraftingRemainingItem()) {
                this.ejectIngredientRemainder(slotStack.getCraftingRemainingItem());
            } else if (CookingPotBlockEntity.INGREDIENT_REMAINDER_OVERRIDES.containsKey(slotStack.getItem())) {
                this.ejectIngredientRemainder(((Item)CookingPotBlockEntity.INGREDIENT_REMAINDER_OVERRIDES.get(slotStack.getItem())).getDefaultInstance());
            }
            if (slotStack.isEmpty()) continue;
            slotStack.shrink(1);
        }
        return true;
    }

    protected void ejectIngredientRemainder(ItemStack remainderStack) {
        Direction direction = ((Direction)this.getBlockState().getValue((Property)CookingPotBlock.FACING)).getCounterClockWise();
        double x = (double)this.worldPosition.getX() + 0.5 + (double)direction.getStepX() * 0.25;
        double y = (double)this.worldPosition.getY() + 0.7;
        double z = (double)this.worldPosition.getZ() + 0.5 + (double)direction.getStepZ() * 0.25;
        ItemUtils.spawnItemEntity((Level)this.level, (ItemStack)remainderStack, (double)x, (double)y, (double)z, (double)((float)direction.getStepX() * 0.08f), (double)0.25, (double)((float)direction.getStepZ() * 0.08f));
    }

    public void setRecipeUsed(@Nullable RecipeHolder<?> recipe) {
        if (recipe != null) {
            ResourceLocation recipeID = recipe.id();
            this.usedRecipeTracker.addTo((Object)recipeID, 1);
        }
    }

    @Nullable
    public RecipeHolder<?> getRecipeUsed() {
        return null;
    }

    public void awardUsedRecipes(Player player, List<ItemStack> items) {
        List<RecipeHolder<?>> usedRecipes = this.getUsedRecipesAndPopExperience(player.level(), player.position());
        player.awardRecipes(usedRecipes);
        this.usedRecipeTracker.clear();
    }

    public List<RecipeHolder<?>> getUsedRecipesAndPopExperience(Level level, Vec3 pos) {
        ArrayList list = Lists.newArrayList();
        for (Object2IntMap.Entry entry : this.usedRecipeTracker.object2IntEntrySet()) {
            level.getRecipeManager().byKey((ResourceLocation)entry.getKey()).ifPresent(recipe -> {
                list.add(recipe);
                CopperPotBlockEntity.splitAndSpawnExperience((ServerLevel)level, pos, entry.getIntValue(), ((CookingPotRecipe)recipe.value()).getExperience());
            });
        }
        return list;
    }

    private static void splitAndSpawnExperience(ServerLevel level, Vec3 pos, int craftedAmount, float experience) {
        int expTotal = Mth.floor((float)((float)craftedAmount * experience));
        float expFraction = Mth.frac((float)((float)craftedAmount * experience));
        if (expFraction != 0.0f && Math.random() < (double)expFraction) {
            ++expTotal;
        }
        ExperienceOrb.award((ServerLevel)level, (Vec3)pos, (int)expTotal);
    }

    public boolean isHeated() {
        if (this.level == null) {
            return false;
        }
        return this.isHeated(this.level, this.worldPosition);
    }

    public ItemStackHandler getInventory() {
        return this.inventory;
    }

    public ItemStack getMeal() {
        return this.inventory.getStackInSlot(4);
    }

    public NonNullList<ItemStack> getDroppableInventory() {
        NonNullList drops = NonNullList.create();
        for (int i = 0; i < 7; ++i) {
            if (i == 4) continue;
            drops.add((Object)this.inventory.getStackInSlot(i));
        }
        return drops;
    }

    private void moveMealToOutput() {
        ItemStack mealStack = this.inventory.getStackInSlot(4);
        ItemStack outputStack = this.inventory.getStackInSlot(6);
        int mealCount = Math.min(mealStack.getCount(), mealStack.getMaxStackSize() - outputStack.getCount());
        if (outputStack.isEmpty()) {
            this.inventory.setStackInSlot(6, mealStack.split(mealCount));
        } else if (outputStack.getItem() == mealStack.getItem()) {
            mealStack.shrink(mealCount);
            outputStack.grow(mealCount);
        }
    }

    private void useStoredContainersOnMeal() {
        ItemStack mealStack = this.inventory.getStackInSlot(4);
        ItemStack containerInputStack = this.inventory.getStackInSlot(5);
        ItemStack outputStack = this.inventory.getStackInSlot(6);
        if (this.isContainerValid(containerInputStack) && outputStack.getCount() < outputStack.getMaxStackSize()) {
            int smallerStackCount = Math.min(mealStack.getCount(), containerInputStack.getCount());
            int mealCount = Math.min(smallerStackCount, mealStack.getMaxStackSize() - outputStack.getCount());
            if (outputStack.isEmpty()) {
                containerInputStack.shrink(mealCount);
                this.inventory.setStackInSlot(6, mealStack.split(mealCount));
            } else if (outputStack.getItem() == mealStack.getItem()) {
                mealStack.shrink(mealCount);
                containerInputStack.shrink(mealCount);
                outputStack.grow(mealCount);
            }
        }
    }

    public ItemStack useHeldItemOnMeal(ItemStack container) {
        if (this.isContainerValid(container) && !this.getMeal().isEmpty()) {
            container.shrink(1);
            this.inventoryChanged();
            return this.getMeal().split(1);
        }
        return ItemStack.EMPTY;
    }

    private boolean doesMealHaveContainer(ItemStack meal) {
        return !this.mealContainerStack.isEmpty() || meal.hasCraftingRemainingItem();
    }

    public boolean isContainerValid(ItemStack containerItem) {
        if (containerItem.isEmpty()) {
            return false;
        }
        if (!this.mealContainerStack.isEmpty()) {
            return ItemStack.isSameItem((ItemStack)this.mealContainerStack, (ItemStack)containerItem);
        }
        return ItemStack.isSameItem((ItemStack)this.getMeal(), (ItemStack)containerItem);
    }

    public Component getName() {
        return this.customName != null ? this.customName : Component.translatable((String)"minersdelight.container.cooking_pot");
    }

    public Component getDisplayName() {
        return this.getName();
    }

    @Nullable
    public Component getCustomName() {
        return this.customName;
    }

    public AbstractContainerMenu createMenu(int id, Inventory player, Player entity) {
        return new CopperPotMenu(id, player, this, this.cookingPotData);
    }

    public void setRemoved() {
        super.setRemoved();
    }

    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return this.writeItems(new CompoundTag(), registries);
    }

    protected void applyImplicitComponents(BlockEntity.DataComponentInput componentInput) {
        super.applyImplicitComponents(componentInput);
        this.customName = (Component)componentInput.get(DataComponents.CUSTOM_NAME);
        this.getInventory().setStackInSlot(4, ((ItemStackWrapper)componentInput.getOrDefault((Supplier)ModDataComponents.MEAL, (Object)ItemStackWrapper.EMPTY)).getStack());
        this.mealContainerStack = ((ItemStackWrapper)componentInput.getOrDefault((Supplier)ModDataComponents.CONTAINER, (Object)ItemStackWrapper.EMPTY)).getStack();
    }

    protected void collectImplicitComponents(DataComponentMap.Builder components) {
        super.collectImplicitComponents(components);
        components.set(DataComponents.CUSTOM_NAME, (Object)this.customName);
        if (!this.getMeal().isEmpty()) {
            components.set((Supplier)ModDataComponents.MEAL, (Object)new ItemStackWrapper(this.getMeal()));
        }
        if (!this.getContainer().isEmpty()) {
            components.set((Supplier)ModDataComponents.CONTAINER, (Object)new ItemStackWrapper(this.getContainer()));
        }
    }

    public void removeComponentsFromTag(CompoundTag tag) {
        tag.remove("CustomName");
        tag.remove("meal");
        tag.remove("container");
    }

    private ItemStackHandler createHandler() {
        return new ItemStackHandler(7){

            protected void onContentsChanged(int slot) {
                CopperPotBlockEntity.this.inventoryChanged();
            }
        };
    }

    private ContainerData createIntArray() {
        return new ContainerData(){

            public int get(int index) {
                return switch (index) {
                    case 0 -> CopperPotBlockEntity.this.cookTime;
                    case 1 -> CopperPotBlockEntity.this.cookTimeTotal;
                    default -> 0;
                };
            }

            public void set(int index, int value) {
                switch (index) {
                    case 0: {
                        CopperPotBlockEntity.this.cookTime = value;
                        break;
                    }
                    case 1: {
                        CopperPotBlockEntity.this.cookTimeTotal = value;
                    }
                }
            }

            public int getCount() {
                return 2;
            }
        };
    }
}

