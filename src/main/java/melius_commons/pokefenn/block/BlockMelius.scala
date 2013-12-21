package melius_commons.pokefenn.block

import net.minecraft.block.material.Material
import melius_commons.pokefenn.lib.Strings
import net.minecraft.block.Block
import melius_commons.pokefenn.Melius
import melius_commons.pokefenn.tileentity.{TileMelius, TileMultiFurnace, TileChestOre, TileFurnaceIO}
import net.minecraft.client.renderer.texture.IconRegister
import melius_commons.pokefenn.render.RenderHelper
import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.ItemStack
import net.minecraft.world.World
import net.minecraft.entity.player.EntityPlayer
import codechicken.lib.raytracer.RayTracer

object BlockMelius
{
    /**
     * Number of tile entities
     */
    val TILES = 2
    var renderID = -1

    /**
     * For multiple BlockMelius instances, more than 16 tiles etc
     */
    private var nextBlockIndex = -1

    def getNextBlockIndex() = {
        nextBlockIndex+=1
        nextBlockIndex
    }

    def newTile(index:Int) = index match {
        case 0 => new TileFurnaceIO
        case 1 => new TileMultiFurnace
    }

    def getTile(world:World, x:Int, y:Int, z:Int) = world.getBlockTileEntity(x, y, z).asInstanceOf[TileMelius]
}

/**
 * A general block class for holding tile entities, passes most calls to the tile
 */
class BlockMelius(id:Int) extends Block(id:Int, Material.rock)
{
    import BlockMelius._
    val meliusIndex = getNextBlockIndex()

	setUnlocalizedName(Strings.MELIUS_BLOCK_NAME)
	setHardness(5)
	setCreativeTab(Melius.tabsMelius)

	override def hasTileEntity(meta:Int) = meliusIndex*16+meta < TILES

    override def createTileEntity(world:World, meta:Int) = newTile(meliusIndex*16+meta)

	override def getRenderType = BlockMelius.renderID

    override def onBlockPlacedBy(world:World, x:Int, y:Int, z:Int, entity:EntityLivingBase, stack:ItemStack) {
        getTile(world, x, y, z).onPlaced(entity, stack)
    }

    override def onBlockActivated(world:World, x:Int, y:Int, z:Int, player:EntityPlayer, side:Int, hitX:Float, hitY:Float, hitZ:Float) =
        getTile(world, x, y, z).activate(player, side, player.getHeldItem)

    override def onBlockClicked(world:World, x:Int, y:Int, z:Int, player:EntityPlayer) {
        getTile(world, x, y, z).click(player, player.getHeldItem)
    }

	override def registerIcons(r:IconRegister) {
	    RenderHelper.loadIcons(r)
	}

    override def getIcon(side:Int, meta:Int) = {
        Block.furnaceBurning.getIcon(1, 0)
        //TODO: breaking icon
    }

    override def getLightOpacity(world:World, x:Int, y:Int, z:Int) =
        getTile(world, x, y, z).lightOpacity
	
	override def isOpaqueCube = false
}