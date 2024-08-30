/*
 * SPDX-License-Identifier: LGPL-2.1
 */

package antiphysika.sbe.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

import static antiphysika.sbe.SkyblockEssentials.MOD_ID;
import static antiphysika.sbe.staticdata.StaticLangData.*;

import antiphysika.sbe.staticdata.StaticItemData;

public class SBETranslations extends LanguageProvider
{
  public SBETranslations (PackOutput output, String locale)
  {
    super(output, MOD_ID, locale);
  }

  private void creativeModeTabTranslations ()
  {
    add(CREATIVE_MOD_TAB_TITLE_KEY, CREATIVE_MOD_TAB_TITLE);
  }

  private void itemTranslations ()
  {
    for (var item : StaticItemData.getAllItems())
    {
      String transKey = String.format("item.%s.%s", MOD_ID, item.id);
      add(transKey, item.name);
    }
  }

  @Override
  protected void addTranslations ()
  {
    creativeModeTabTranslations();
    itemTranslations();
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :