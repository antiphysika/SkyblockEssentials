/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.sbe.staticdata;

import java.util.List;

public class StaticItemData
{
  public static class Item
  {
    public final String id;
    public final String name;

    public Item (String id, String name)
    {
      this.id = id;
      this.name = name;
    }
  }

  public static final Item DIRT_CHUNK =
    new Item("dirt_chunk", "Dirt Chunk");

  public static final Item STONE_CHUNK =
    new Item("stone_chunk", "Stone Chunk");

  public static final Item ANDESITE_CHUNK =
    new Item("andesite_chunk", "Andesite Chunk");

  public static final Item DIORITE_CHUNK =
    new Item("diorite_chunk", "Diorite Chunk");

  public static final Item GRANITE_CHUNK =
    new Item("granite_chunk", "Granite Chunk");

  public static final Item DEEPSLATE_CHUNK =
    new Item("deepslate_chunk", "Deepslate Chunk");

  public static final Item TUFF_CHUNK =
    new Item("tuff_chunk", "Tuff Chunk");

  public static final Item CALCITE_CHUNK =
    new Item("calcite_chunk", "Calcite Chunk");

  public static final Item DRIPSTONE_CHUNK =
    new Item("dripstone_chunk", "Dripstone Chunk");

  public static final Item NETHERRACK_CHUNK =
    new Item("netherrack_chunk", "Netherrack Chunk");

  public static final Item BASALT_CHUNK =
    new Item("basalt_chunk", "Basalt Chunk");

  public static final Item BLACKSTONE_CHUNK =
    new Item("blackstone_chunk", "Blackstone Chunk");

  public static final Item END_STONE_CHUNK =
    new Item("end_stone_chunk", "End Stone Chunk");

  public static List<Item> getAllItems ()
  {
    return List.of(
      DIRT_CHUNK,
      STONE_CHUNK,
      ANDESITE_CHUNK,
      DIORITE_CHUNK,
      GRANITE_CHUNK,
      DEEPSLATE_CHUNK,
      TUFF_CHUNK,
      CALCITE_CHUNK,
      DRIPSTONE_CHUNK,
      NETHERRACK_CHUNK,
      BASALT_CHUNK,
      BLACKSTONE_CHUNK,
      END_STONE_CHUNK
    );
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :