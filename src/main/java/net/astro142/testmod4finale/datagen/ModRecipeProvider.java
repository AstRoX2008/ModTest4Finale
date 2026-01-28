package net.astro142.testmod4finale.datagen;

import net.astro142.testmod4finale.TestMod4Finale;
import net.astro142.testmod4finale.block.ModBlocks;
import net.astro142.testmod4finale.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        super(provider, recipeOutput);
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> provider) {
            super(packOutput, provider);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
            return new ModRecipeProvider(provider, recipeOutput);
        }

        @Override
        public String getName() {
            return "My Recipes";
        }
    }


    @Override
    protected void buildRecipes() {
        List<ItemLike> TO_ARTFUL_WAND = List.of(ModBlocks.ARTFUL_CUBE);

        shaped(RecipeCategory.MISC, ModBlocks.ARTFUL_CUBE.get())
                .pattern("X#X")
                .pattern("#W#")
                .pattern("X#X")
                .define('#', ModItems.BLACKPOWDER.get())
                .define('W', ModItems.ARTFUL_WAND.get())
                .define('X', Items.GUNPOWDER)
                .unlockedBy("has_artful_wand", has(ModItems.ARTFUL_WAND)).save(output);

        shaped(RecipeCategory.MISC, ModBlocks.ARTFUL_MUSIC_BOX.get())
                .pattern("X#X")
                .pattern("#W#")
                .pattern("X#X")
                .define('#', ModItems.BLACKPOWDER.get())
                .define('W', Blocks.JUKEBOX)
                .define('X', Items.WHITE_DYE)
                .unlockedBy("has_blackpowder", has(ModItems.BLACKPOWDER)).save(output);

        shaped(RecipeCategory.MISC, ModItems.BLACKPOWDER.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', Items.GUNPOWDER)
                .unlockedBy("has_gunpowder", has(Items.GUNPOWDER)).save(output);

        oreSmelting(output, TO_ARTFUL_WAND, RecipeCategory.MISC, ModItems.ARTFUL_WAND.get(), 0.25f, 200, "artful_wand");

        stairBuilder(ModBlocks.ARTFUL_STAIRS.get(), Ingredient.of(ModBlocks.ARTFUL_CUBE)).group("artful_cube")
                .unlockedBy("has_artful_cube", has(ModBlocks.ARTFUL_CUBE)).save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ARTFUL_SLAB.get(), ModBlocks.ARTFUL_CUBE.get());

        buttonBuilder(ModBlocks.ARTFUL_BUTTON.get(), Ingredient.of(ModBlocks.ARTFUL_CUBE.get())).group("artful_cube")
                .unlockedBy("has_artful_cube", has(ModBlocks.ARTFUL_CUBE.get())).save(output);
        pressurePlate(ModBlocks.ARTFUL_PRESSURE_PLATE.get(), ModBlocks.ARTFUL_CUBE.get());

        fenceBuilder(ModBlocks.ARTFUL_FENCE.get(), Ingredient.of(ModBlocks.ARTFUL_CUBE.get())).group("artful_cube")
                .unlockedBy("has_artful_cube", has(ModBlocks.ARTFUL_CUBE.get())).save(output);
        fenceGateBuilder(ModBlocks.ARTFUL_FENCE_GATE.get(), Ingredient.of(ModBlocks.ARTFUL_CUBE.get())).group("artful_cube")
                .unlockedBy("has_artful_cube", has(ModBlocks.ARTFUL_CUBE.get())).save(output);
        wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ARTFUL_WALL.get(), ModBlocks.ARTFUL_CUBE.get());
    }

    protected void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, TestMod4Finale.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
