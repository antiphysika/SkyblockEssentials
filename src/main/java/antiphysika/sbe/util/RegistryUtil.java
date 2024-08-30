/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.sbe.util;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class RegistryUtil
{
  public static String getRegisteredName (Item item)
  {
    return BuiltInRegistries.ITEM
      .wrapAsHolder(item)
      .getRegisteredName();
  }

  public static String getRegisteredName (Block block)
  {
    return BuiltInRegistries.BLOCK
      .wrapAsHolder(block)
      .getRegisteredName();
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :