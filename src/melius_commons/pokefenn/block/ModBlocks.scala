package melius_commons.pokefenn.block

import cpw.mods.fml.common.registry.GameRegistry
import melius_commons.pokefenn.lib.Strings
import net.minecraft.block.Block

/**
 * Created with IntelliJ IDEA.
 * User: Pokefenn
 * Date: 13/12/13
 * Time: 11:25

 */
class ModBlocks {

  var multiFurnace: Block = null


  def init(){



  GameRegistry.registerBlock(multiFurnace, Strings.MULTI_FURNACE_NAME)
}




}
