/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.sbe.event;

import antiphysika.sbe.staticdata.StaticData;
import antiphysika.sbe.util.LevelUtil;
import antiphysika.sbe.util.LootTableUtil;
import antiphysika.sbe.util.RegistryUtil;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import java.util.List;

public class ServerEvents
{
  public static void onRightClickBlock (final PlayerInteractEvent.RightClickBlock event)
  {
    // Require player to be sneaking
    Player player = event.getEntity();
    if (!player.isShiftKeyDown())
      return;

    // This event fires twice, once for each hand
    if (event.getHand() != InteractionHand.MAIN_HAND)
      return;

    // Require the player's hand to be empty
    if (player.getMainHandItem() != ItemStack.EMPTY)
      return;

    Level level = event.getLevel();
    Block trgettedBlock = level.getBlockState(event.getPos()).getBlock();

    final String regName = RegistryUtil.getRegisteredName(trgettedBlock);
    if (!regName.equals("minecraft:grass_block"))
      return;

    List<ItemStack> loot = LootTableUtil.rollLootTable(level, StaticData.STONE_CHUNKS_LOOT_TABLE);
    for (ItemStack stack : loot)
    {
      LevelUtil.spawnItemStack(level, player, new ItemStack(stack.getItem(), stack.getCount()));
    }

    // Event handled, mark as cancelled
    event.setCanceled(true);
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :