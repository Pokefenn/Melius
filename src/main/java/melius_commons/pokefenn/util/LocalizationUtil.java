package melius_commons.pokefenn.util;

import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * Created with IntelliJ IDEA.
 * User: Pokefenn
 * Date: 14/12/13
 * Time: 13:14
 */
public class LocalizationUtil {

    public static boolean isXMLLanguageFile(String fileName) {

        return fileName.endsWith(".xml");
    }
    public static String getLocaleFromFileName(String fileName) {

        return fileName.substring(fileName.lastIndexOf('/') + 1, fileName.lastIndexOf('.'));
    }

    public static String getLocalizedString(String key) {

        return LanguageRegistry.instance().getStringLocalization(key);
    }



}
