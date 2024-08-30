/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.sbe.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static antiphysika.sbe.SkyblockEssentials.MOD_ID;

import antiphysika.sbe.item.ChunkItem;
import antiphysika.sbe.staticdata.StaticLangData;

public class Registrar
{
  public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MOD_ID);
  public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);

  public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
    DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

  public static final DeferredHolder<CreativeModeTab, CreativeModeTab> OMNICOMP_TAB =
    CREATIVE_MODE_TABS.register("skyblockessentials_tab", () -> CreativeModeTab.builder()
      .title(Component.translatable(StaticLangData.CREATIVE_MOD_TAB_TITLE_KEY))
      .withTabsBefore(CreativeModeTabs.COMBAT)
      .icon(Items.DIRT::getDefaultInstance)
      .displayItems((parameters, output) ->
      {
        BLOCKS.getEntries().forEach(e ->
        {
          Item item = e.get().asItem();
          output.accept(item);
        });
        ITEMS.getEntries().forEach(e ->
        {
          Item item = e.get();
          output.accept(item);
        });
      }).build()
    );

  /**
   * Register a simple item
   *
   * @param name Registry name for block
   * @return Returns {@link DeferredItem} for item to register
   */
  public static DeferredItem<Item> registerItem (String name)
  {
    return ITEMS.registerSimpleItem(name);
  }

  /**
   * Get an {@link Iterable<Item>} for all known mod items
   *
   * Helper to fetch a list of all blocks registered by the mod, primarily used
   * by the datagen code for block models, loot and tags.
   *
   * @return Returns an iterable list of blocks
   */
  public static Iterable<Item> getKnownItems ()
  {
    return ITEMS.getEntries()
      .stream()
      .map(entry -> (Item) entry.value())
      .toList();
  }

  /**
   * Register mod blocks, items and creative mode tab
   *
   * @param bus Mod event bus
   */
  public static void register (IEventBus bus)
  {
    // Initialise compressed block variants
    ChunkItem.init();

    // Register blocks and items
    BLOCKS.register(bus);
    ITEMS.register(bus);

    // Register creative mode tab
    CREATIVE_MODE_TABS.register(bus);
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :