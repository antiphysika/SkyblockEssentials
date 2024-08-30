/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.sbe;

import antiphysika.sbe.registry.Registrar;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import org.slf4j.Logger;
import com.mojang.logging.LogUtils;

import antiphysika.sbe.event.ServerEvents;

@Mod(SkyblockEssentials.MOD_ID)
public class SkyblockEssentials extends SkyblockEssentialsBase
{
  public static final String MOD_ID = "skyblockessentials";
  private static final Logger LOGGER = LogUtils.getLogger();

  public SkyblockEssentials (IEventBus bus)
  {
    // Register items
    Registrar.register(bus);

    // Register ourselves on the game bus
    NeoForge.EVENT_BUS.register(this);
  }

  public static Logger getLogger ()
  {
    return LOGGER;
  }

  private void initCommon (final FMLCommonSetupEvent event)
  {
  }

  @SubscribeEvent
  public void onRightClickBlock (final PlayerInteractEvent.RightClickBlock event)
  {
    if (!event.getLevel().isClientSide())
      ServerEvents.onRightClickBlock(event);
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :