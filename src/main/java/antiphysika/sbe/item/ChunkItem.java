/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.sbe.item;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

import antiphysika.sbe.registry.Registrar;

public class ChunkItem
{
  public static DeferredItem<Item> DIRT_CHUNK;
  public static DeferredItem<Item> STONE_CHUNK;
  public static DeferredItem<Item> ANDESITE_CHUNK;
  public static DeferredItem<Item> DIORITE_CHUNK;
  public static DeferredItem<Item> GRANITE_CHUNK;
  public static DeferredItem<Item> DEEPSLATE_CHUNK;
  public static DeferredItem<Item> TUFF_CHUNK;
  public static DeferredItem<Item> CALCITE_CHUNK;
  public static DeferredItem<Item> DRIPSTONE_CHUNK;
  public static DeferredItem<Item> NETHERRACK_CHUNK;
  public static DeferredItem<Item> BASALT_CHUNK;
  public static DeferredItem<Item> BLACKSTONE_CHUNK;
  public static DeferredItem<Item> END_STONE_CHUNK;

  /**
   * Initialise items
   */
  public static void init ()
  {
    DIRT_CHUNK = Registrar.registerItem("dirt_chunk");
    STONE_CHUNK = Registrar.registerItem("stone_chunk");
    ANDESITE_CHUNK = Registrar.registerItem("andesite_chunk");
    DIORITE_CHUNK = Registrar.registerItem("diorite_chunk");
    GRANITE_CHUNK = Registrar.registerItem("granite_chunk");
    DEEPSLATE_CHUNK = Registrar.registerItem("deepslate_chunk");
    TUFF_CHUNK = Registrar.registerItem("tuff_chunk");
    CALCITE_CHUNK = Registrar.registerItem("calcite_chunk");
    DRIPSTONE_CHUNK = Registrar.registerItem("dripstone_chunk");
    NETHERRACK_CHUNK = Registrar.registerItem("netherrack_chunk");
    BASALT_CHUNK = Registrar.registerItem("basalt_chunk");
    BLACKSTONE_CHUNK = Registrar.registerItem("blackstone_chunk");
    END_STONE_CHUNK = Registrar.registerItem("end_stone_chunk");
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :