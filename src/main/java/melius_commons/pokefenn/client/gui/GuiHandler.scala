package melius_commons.pokefenn.client.gui

import cpw.mods.fml.common.network.IGuiHandler
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.world.World
import melius_commons.pokefenn.lib.GuiIds

/**
 * Created with IntelliJ IDEA.
 * User: Pokefenn
 * Date: 13/12/13
 * Time: 18:22

 */
class GuiHandler extends IGuiHandler {


  def getServerGuiElement(ID: Int, player: EntityPlayer, world: World, x: Int, y: Int, z: Int): AnyRef = {

    return null;

  }

  def getClientGuiElement(ID: Int, player: EntityPlayer, world: World, x: Int, y: Int, z: Int): AnyRef = {

    if(ID == GuiIds.CHEST_ORE_GUI_ID){

      return new GuiChestOre
    }

    return null;



  }


}
