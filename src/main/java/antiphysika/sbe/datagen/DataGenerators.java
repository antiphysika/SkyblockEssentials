/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.sbe.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import static antiphysika.sbe.SkyblockEssentials.MOD_ID;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = MOD_ID)
public class DataGenerators
{
  public static void generateBlockStateData (GatherDataEvent event, PackOutput output,
                                             ExistingFileHelper exFileHelper)
  {
    event.getGenerator().addProvider(
      event.includeServer(),
      new SBEItemModels(output, exFileHelper)
    );
  }

  public static void generateTranslations (GatherDataEvent event, PackOutput output,
                                           ExistingFileHelper exFileHelper)
  {
    event.getGenerator().addProvider(
      event.includeClient(),
      new SBETranslations(output, "en_us")
    );
  }

  public static void generateRecipes (GatherDataEvent event, PackOutput output,
                                      ExistingFileHelper exFileHelper)
  {
    event.getGenerator().addProvider(
      event.includeServer(),
      new SBERecipes(output, event.getLookupProvider())
    );
  }

  @SubscribeEvent
  public static void gatherData (GatherDataEvent event)
  {
    DataGenerator generator = event.getGenerator();
    PackOutput output = generator.getPackOutput();
    ExistingFileHelper exFileHelper = event.getExistingFileHelper();

    // Block/item models
    generateBlockStateData(event, output, exFileHelper);

    // Recipes
    generateRecipes(event, output, exFileHelper);

    // Default en_us translations
    generateTranslations(event, output, exFileHelper);
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :