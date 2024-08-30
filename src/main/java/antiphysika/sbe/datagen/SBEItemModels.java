/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.sbe.datagen;

import net.minecraft.data.PackOutput;

import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import static antiphysika.sbe.SkyblockEssentials.MOD_ID;

import antiphysika.sbe.item.ChunkItem;

public class SBEItemModels extends ItemModelProvider
{
  public SBEItemModels (PackOutput output, ExistingFileHelper exFileHelper)
  {
    super(output, MOD_ID, exFileHelper);
  }

  @Override
  protected void registerModels ()
  {
    basicItem(ChunkItem.DIRT_CHUNK.get());
    basicItem(ChunkItem.STONE_CHUNK.get());
    basicItem(ChunkItem.ANDESITE_CHUNK.get());
    basicItem(ChunkItem.DIORITE_CHUNK.get());
    basicItem(ChunkItem.GRANITE_CHUNK.get());
    basicItem(ChunkItem.DEEPSLATE_CHUNK.get());
    basicItem(ChunkItem.TUFF_CHUNK.get());
    basicItem(ChunkItem.CALCITE_CHUNK.get());
    basicItem(ChunkItem.DRIPSTONE_CHUNK.get());
    basicItem(ChunkItem.NETHERRACK_CHUNK.get());
    basicItem(ChunkItem.BASALT_CHUNK.get());
    basicItem(ChunkItem.BLACKSTONE_CHUNK.get());
    basicItem(ChunkItem.END_STONE_CHUNK.get());
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :