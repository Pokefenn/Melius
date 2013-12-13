package melius_commons.pokefenn.block

import cpw.mods.fml.common.registry.GameRegistry
import melius_commons.pokefenn.lib.{BlockIds, Strings}
import net.minecraft.block.Block


/**
 * Created with IntelliJ IDEA.
 * User: Pokefenn
 * Date: 13/12/13
 * Time: 11:25

 */
object ModBlocks {

  var multiFurnace: Block = null
  var chestOre: Block = null


  def init(){


    multiFurnace = new BlockMultiFurnace(BlockIds.MULTI_FURNACE)
    chestOre = new BlockChestOre(BlockIds.CHEST_ORE)

    GameRegistry.registerBlock(multiFurnace, Strings.MULTI_FURNACE_NAME)
    GameRegistry.registerBlock(chestOre, Strings.CHEST_ORE_NAME)

}




}
