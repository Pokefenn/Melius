package melius_commons.pokefenn.client.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import melius_commons.pokefenn.inventory.ContainerChestOre;
import melius_commons.pokefenn.lib.GuiIds;
import melius_commons.pokefenn.tileentity.TileChestOre;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created with IntelliJ IDEA.
 * User: Pokefenn
 * Date: 13/12/13
 * Time: 19:08
 */
public class GuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        if (ID == GuiIds.CHEST_ORE_GUI_ID) {
            TileChestOre tileChestOre = (TileChestOre) world.getBlockTileEntity(x, y, z);
            return new ContainerChestOre(player.inventory, tileChestOre);
        }

        return null;

    }


    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        if (ID == GuiIds.CHEST_ORE_GUI_ID) {
            TileChestOre tileChestOre = (TileChestOre) world.getBlockTileEntity(x, y, z);
            return new GuiChestOre(player.inventory, tileChestOre);
        }

        return null;

    }
}
