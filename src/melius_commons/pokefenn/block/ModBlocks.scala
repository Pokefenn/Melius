package melius_commons.pokefenn.block

import cpw.mods.fml.common.registry.GameRegistry
import melius_commons.pokefenn.lib.Strings
import net.minecraft.block.Block
import melius_commons.pokefenn.lib.BlockIds

/**
 * Created with IntelliJ IDEA.
 * User: Pokefenn
 * Date: 13/12/13
 * Time: 11:25

 */
object ModBlocks {

  var multiFurnace: Block = null


  def init(){


    multiFurnace = new BlockMultiFurnace(ItemIds.MULTI_FURNACE)

    GameRegistry.registerBlock(multiFurnace, Strings.MULTI_FURNACE_NAME)

}




}
