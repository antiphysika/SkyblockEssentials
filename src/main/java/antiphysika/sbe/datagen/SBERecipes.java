/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.sbe.datagen;

import antiphysika.sbe.SkyblockEssentials;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

import antiphysika.sbe.item.ChunkItem;

public class SBERecipes extends RecipeProvider
{
  public SBERecipes (PackOutput output, CompletableFuture<HolderLookup.Provider> registries)
  {
    super(output, registries);
  }

  private void chunkToBlockRecipe (@NotNull RecipeOutput output,
                                   ItemLike material,
                                   ItemLike result)
  {
    String materialRegName = material.asItem().toString();
    ResourceLocation recipeId = ResourceLocation.parse(materialRegName + "/compress");

    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result)
      .pattern("##")
      .pattern("##")
      .define('#', material)
      .unlockedBy("has_item", has(material))
      .save(output, recipeId);
  }

  @Override
  protected void buildRecipes (@NotNull RecipeOutput output)
  {
    chunkToBlockRecipe(output, ChunkItem.DIRT_CHUNK, Items.DIRT);
    chunkToBlockRecipe(output, ChunkItem.STONE_CHUNK, Items.COBBLESTONE);
    chunkToBlockRecipe(output, ChunkItem.ANDESITE_CHUNK, Items.ANDESITE);
    chunkToBlockRecipe(output, ChunkItem.DIORITE_CHUNK, Items.DIORITE);
    chunkToBlockRecipe(output, ChunkItem.GRANITE_CHUNK, Items.GRANITE);
    chunkToBlockRecipe(output, ChunkItem.DEEPSLATE_CHUNK, Items.COBBLED_DEEPSLATE);
    chunkToBlockRecipe(output, ChunkItem.TUFF_CHUNK, Items.TUFF);
    chunkToBlockRecipe(output, ChunkItem.CALCITE_CHUNK, Items.CALCITE);
    chunkToBlockRecipe(output, ChunkItem.DRIPSTONE_CHUNK, Items.DRIPSTONE_BLOCK);
    chunkToBlockRecipe(output, ChunkItem.NETHERRACK_CHUNK, Items.NETHERRACK);
    chunkToBlockRecipe(output, ChunkItem.BASALT_CHUNK, Items.BASALT);
    chunkToBlockRecipe(output, ChunkItem.BLACKSTONE_CHUNK, Items.BLACKSTONE);
    chunkToBlockRecipe(output, ChunkItem.END_STONE_CHUNK, Items.END_STONE);
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :