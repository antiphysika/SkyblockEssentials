/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.sbe;

import net.minecraft.resources.ResourceLocation;

import static antiphysika.sbe.SkyblockEssentials.MOD_ID;

public class SkyblockEssentialsBase
{
  /**
   * Get {@link ResourceLocation} for mod resource
   *
   * @param path Path of resource
   *
   * @return Returns {@link ResourceLocation} instance for resource
   */
  public static ResourceLocation location (String path)
  {
    return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
  }

  /**
   * Get {@link ResourceLocation} for namespaced resource
   *
   * @param namespace  Resource namespace
   * @param path       Resource path
   *
   * @return Returns {@link ResourceLocation} instance for resource
   */
  public static ResourceLocation location (String namespace, String path)
  {
    return ResourceLocation.fromNamespaceAndPath(namespace, path);
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :