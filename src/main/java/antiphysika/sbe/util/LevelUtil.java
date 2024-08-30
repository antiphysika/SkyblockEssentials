/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.sbe.util;

import antiphysika.sbe.SkyblockEssentials;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.slf4j.Logger;

public class LevelUtil
{
  private static final Logger LOGGER = SkyblockEssentials.getLogger();

  public static void spawnItemStack (Level level, Player player, ItemStack itemStack)
  {
    level.addFreshEntity(
      new ItemEntity(level, player.getX(), player.getY(), player.getZ(), itemStack)
    );
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :