package melius_commons.pokefenn.lib;

import melius_commons.pokefenn.util.ResourceLocationHelper;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;

/**
 * Created with IntelliJ IDEA.
 * User: Pokefenn
 * Date: 13/12/13
 * Time: 11:38
 */
public class Textures {

    public static final String MODEL_SHEET_LOCATION = "textures/models/";
    public static final String ARMOR_SHEET_LOCATION = "textures/armor/";
    public static final String GUI_SHEET_LOCATION = "textures/gui/";
    public static final String EFFECTS_LOCATION = "textures/effects/";

    public static final ResourceLocation VANILLA_BLOCK_TEXTURE_SHEET = TextureMap.locationBlocksTexture;
    public static final ResourceLocation VANILLA_ITEM_TEXTURE_SHEET = TextureMap.locationItemsTexture;

    public static final ResourceLocation GUI_CHEST_ORE = ResourceLocationHelper.getResourceLocation(GUI_SHEET_LOCATION + "chestOre.png");







}
