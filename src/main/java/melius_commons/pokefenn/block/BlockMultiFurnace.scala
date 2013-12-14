package melius_commons.pokefenn.block

import net.minecraft.block.material.Material
import melius_commons.pokefenn.lib.Strings
import net.minecraft.world.World
import net.minecraft.tileentity.TileEntity
import net.minecraft.block.Block
import melius_commons.pokefenn.Melius
import melius_commons.pokefenn.tileentity.{TileMultiFurnace, TileChestOre}
import net.minecraft.client.renderer.texture.IconRegister
import melius_commons.pokefenn.render.RenderMultiFurnace
import melius_commons.pokefenn.tileentity.TileFurnaceIO

/**
 * Created with IntelliJ IDEA.
 * User: Pokefenn
 * Date: 13/12/13
 * Time: 11:31

 */
class BlockMultiFurnace(id:Int) extends Block(id:Int, Material.rock)
{
	setUnlocalizedName(Strings.MULTI_FURNACE_NAME)
	setHardness(5)
	setCreativeTab(Melius.tabsMelius)

	override def hasTileEntity(meta:Int) = meta == 0 || meta == 1
	
	override def createTileEntity(world:World, meta:Int) = meta match {
	    case 0 => new TileFurnaceIO
	    case 1 => new TileMultiFurnace
	}
	
	override def getRenderType() = BlockMultiFurnace.renderID
	
	override def registerIcons(r:IconRegister) {
	    blockIcon = RenderMultiFurnace.loadIcons(r)
	}
	
	override def isOpaqueCube() = false
}

object BlockMultiFurnace
{
	var renderID = 0
}