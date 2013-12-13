package melius_commons.pokefenn.block

import net.minecraft.block.material.Material
import net.minecraft.block.{BlockContainer, Block}
import melius_commons.pokefenn.lib.Strings
import melius_commons.pokefenn.Melius
import net.minecraft.world.World
import net.minecraft.tileentity.TileEntity
import melius_commons.pokefenn.tileentity.TileChestOre

/**
 * Created with IntelliJ IDEA.
 * User: Pokefenn
 * Date: 13/12/13
 * Time: 15:53

 */
class BlockChestOre(id:Int) extends BlockContainer(id:Int, Material.rock) {

  this.setUnlocalizedName(Strings.CHEST_ORE_NAME)
  this.setHardness(1)
  this.setCreativeTab(Melius.tabsMelius)

  def createNewTileEntity(world: World): TileEntity = {

    return new TileChestOre()

  }

}
