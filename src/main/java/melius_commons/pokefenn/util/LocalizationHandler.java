package melius_commons.pokefenn.util;

import cpw.mods.fml.common.registry.LanguageRegistry;
import melius_commons.pokefenn.lib.Localizations;

/**
 * Created with IntelliJ IDEA.
 * User: Pokefenn
 * Date: 14/12/13
 * Time: 13:12
 */
public class LocalizationHandler {

    public static void loadLanguages(){


        // For every file specified in the Localization library class, load them into the Language Registry
        for (String localizationFile : Localizations.localeFiles) {
            LanguageRegistry.instance().loadLocalization(localizationFile, LocalizationUtil.getLocaleFromFileName(localizationFile), LocalizationUtil.isXMLLanguageFile(localizationFile));
        }
    }

}
