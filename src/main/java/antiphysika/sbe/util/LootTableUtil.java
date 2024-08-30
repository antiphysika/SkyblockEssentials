/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.sbe.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Objects;

public class LootTableUtil
{
  public static ResourceKey<LootTable> getResourceKey (ResourceLocation location)
  {
    return ResourceKey.create(Registries.LOOT_TABLE, location);
  }

  public static ResourceKey<LootTable> getResourceKey (String location)
  {
    return ResourceKey.create(
      Registries.LOOT_TABLE,
      ResourceLocation.parse(location)
    );
  }

  private static LootParams emptyLootParams (ServerLevel level)
  {
    return new LootParams.Builder(level).create(LootContextParamSets.EMPTY);
  }

  public static LootTable getLootTable (Level level, ResourceKey<LootTable> key)
  {
    return Objects
      .requireNonNull(level.getServer())
      .reloadableRegistries()
      .getLootTable(key);
  }

  public static List<ItemStack> rollLootTable (Level level, ResourceLocation location)
  {
    ServerLevel serverLevel = (ServerLevel) level;

    ResourceKey<LootTable> lootTableKey = getResourceKey(location);
    LootTable lootTable = getLootTable(level, lootTableKey);
    LootParams lootParams = emptyLootParams(serverLevel);

    return lootTable.getRandomItems(lootParams, level.getRandom());
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :