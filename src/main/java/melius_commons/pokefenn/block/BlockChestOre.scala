package melius_commons.pokefenn.block

import net.minecraft.block.material.Material
import net.minecraft.block.{BlockContainer, Block}
import melius_commons.pokefenn.lib.{GuiIds, Strings}
import melius_commons.pokefenn.Melius
import net.minecraft.world.World
import net.minecraft.tileentity.TileEntity
import net.minecraft.entity.player.EntityPlayer
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

  override def onBlockActivated(world: World, x: Int, y: Int, z: Int, player: EntityPlayer, side: Int, hitX: Float, hitY: Float, hitZ: Float): Boolean = {
    if (player.isSneaking) return false

    else {

      if (!world.isRemote) {

        val tileChestOre: TileChestOre = world.getBlockTileEntity(x, y, z).asInstanceOf[TileChestOre]
        if (tileChestOre != null) {

          //System.out.println("guithingy")
          player.openGui(Melius.instance, GuiIds.CHEST_ORE_GUI_ID, world, x, y, z)
        }
      }
      return true
    }
  }

}
