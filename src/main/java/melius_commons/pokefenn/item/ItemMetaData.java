package melius_commons.pokefenn.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import melius_commons.pokefenn.lib.Strings;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Pokefenn
 * Date: 13/12/13
 * Time: 16:15
 */
public class ItemMetaData extends Item {

    private static final String[] ITEMS_NAMES = new String[] { "ChlorophyllicIngot", "TotemicWood" };

    @SideOnly(Side.CLIENT)
    private Icon[] icons;

    public ItemMetaData(int id){

        super(id - 256);
        this.setHasSubtypes(true);

    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {

        StringBuilder unlocalizedName = new StringBuilder();
        int meta = MathHelper.clamp_int(itemStack.getItemDamage(), 0, ITEMS_NAMES.length - 1);

        unlocalizedName.append("item.");
        unlocalizedName.append(Strings.RESOURCE_PREFIX);
        unlocalizedName.append(Strings.META_DATA_NAME);
        unlocalizedName.append(ITEMS_NAMES[meta]);

        return unlocalizedName.toString();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIconFromDamage(int meta) {

        int j = MathHelper.clamp_int(meta, 0, ITEMS_NAMES.length - 1);
        return icons[j];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {

        icons = new Icon[ITEMS_NAMES.length];

        for (int i = 0; i < ITEMS_NAMES.length; ++i) {
            icons[i] = iconRegister.registerIcon(Strings.RESOURCE_PREFIX + Strings.META_DATA_NAME + ITEMS_NAMES[i]);
        }
    }





    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(int id, CreativeTabs creativeTab, List list) {

        for (int meta = 0; meta < ITEMS_NAMES.length; ++meta) {
            list.add(new ItemStack(id, 1, meta));
        }




    }






}
