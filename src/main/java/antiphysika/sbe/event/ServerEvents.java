/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.sbe.event;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import antiphysika.sbe.staticdata.StaticData;
import antiphysika.sbe.util.LevelUtil;
import antiphysika.sbe.util.LootTableUtil;
import antiphysika.sbe.util.RegistryUtil;

import java.util.List;
import java.util.Objects;

public class ServerEvents
{
  // List of valid sneak right-click blocks
  private static final List<String> RIGHT_CLICK_BLOCKS = List.of(
    RegistryUtil.getRegisteredName(Blocks.DIRT),
    RegistryUtil.getRegisteredName(Blocks.COARSE_DIRT),
    RegistryUtil.getRegisteredName(Blocks.GRASS_BLOCK)
  );

  public static boolean onRightClickBlock (final PlayerInteractEvent.RightClickBlock event)
  {
    // Require player to be sneaking
    Player player = event.getEntity();
    if (!player.isShiftKeyDown())
      return false;

    // This event fires twice, once for each hand
    if (event.getHand() != InteractionHand.MAIN_HAND)
      return false;

    // Require the player's hand to be empty
    if (player.getMainHandItem() != ItemStack.EMPTY)
      return false;

    Level level = event.getLevel();
    if (Objects.requireNonNull(level.getServer()).getTickCount() % 10 != 0)
      return false;

    Block trgettedBlock = level.getBlockState(event.getPos()).getBlock();
    final String regName = RegistryUtil.getRegisteredName(trgettedBlock);

    if (!RIGHT_CLICK_BLOCKS.contains(regName))
      return false;

    List<ItemStack> loot = LootTableUtil.rollLootTable(level, StaticData.STONE_CHUNKS_LOOT_TABLE);
    int lootedItemStackCount = 0;
    for (ItemStack stack : loot)
    {
      LevelUtil.spawnItemStack(level, player, new ItemStack(stack.getItem(), stack.getCount()));
      ++lootedItemStackCount;
    }

    // Event handled, mark as cancelled
    event.setCanceled(true);

    // Only return true (to play sound) if loot table roll returned item stacks
    return lootedItemStackCount > 0;
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :