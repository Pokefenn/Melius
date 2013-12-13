package melius_commons.pokefenn.util;

import melius_commons.pokefenn.lib.Strings;
import net.minecraft.util.ResourceLocation;

/**
 * Created with IntelliJ IDEA.
 * User: Pokefenn
 * Date: 13/12/13
 * Time: 18:40
 */
public class ResourceLocationHelper {

    public static ResourceLocation getResourceLocation(String modId, String path) {

        return new ResourceLocation(modId, path);
    }

    public static ResourceLocation getResourceLocation(String path) {

        return getResourceLocation(Strings.name.toLowerCase(), path);
    }


}
