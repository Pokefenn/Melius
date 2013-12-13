package melius_commons.pokefenn.block

import net.minecraft.block.material.Material
import melius_commons.pokefenn.lib.Strings
import net.minecraft.world.World
import net.minecraft.tileentity.TileEntity
import net.minecraft.block.BlockContainer

/**
 * Created with IntelliJ IDEA.
 * User: Pokefenn
 * Date: 13/12/13
 * Time: 11:31

 */
class BlockMultiFurnace(id:Int) extends BlockContainer(id:Int, Material.rock) {

  this.setUnlocalizedName(Strings.MULTI_FURNACE_NAME)
  this.setHardness(5)

  def createNewTileEntity(world: World): TileEntity = ???
}
