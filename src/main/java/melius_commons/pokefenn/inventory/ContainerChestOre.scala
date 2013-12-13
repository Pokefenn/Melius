package melius_commons.pokefenn.inventory

import net.minecraft.inventory.Container
import net.minecraft.entity.player.EntityPlayer

/**
 * Created with IntelliJ IDEA.
 * User: Pokefenn
 * Date: 13/12/13
 * Time: 15:57

 */
class ContainerChestOre extends Container {


  def canInteractWith(entityplayer: EntityPlayer): Boolean = {

    return true;

  }


}
