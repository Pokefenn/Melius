package melius_commons.pokefenn.render

import cpw.mods.fml.client.registry.{ClientRegistry, ISimpleBlockRenderingHandler, RenderingRegistry}
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer
import net.minecraft.tileentity.TileEntity
import net.minecraft.client.renderer.RenderBlocks
import net.minecraft.world.IBlockAccess
import net.minecraft.block.Block
import melius_commons.pokefenn.block.BlockMelius
import melius_commons.pokefenn.tileentity.{TileMelius, TileFurnaceIO}
import codechicken.lib.render.CCRenderState
import codechicken.lib.render.CCModel
import codechicken.lib.vec.Cuboid6
import codechicken.lib.lighting.LightModel
import net.minecraft.util.Icon
import codechicken.lib.vec.Transformation
import codechicken.lib.render.IconTransformation
import net.minecraft.client.renderer.texture.IconRegister
import org.lwjgl.opengl.GL11
import scala.reflect.ClassTag

object RenderHelper extends TileEntitySpecialRenderer with ISimpleBlockRenderingHandler
{
    /**
     * Pass down class for rendering different block/tile types
     */
    abstract class RenderInstance[T <: TileMelius](implicit val tileClass: ClassTag[T])
    {
        def loadIcons(r:IconRegister)
        def renderStatic(tile:T, world:IBlockAccess, r:RenderBlocks)
        def renderInventory(r:RenderBlocks)
        def hasDynamicRender = false
        def renderDynamic(tile:T){}

        //casting forwarders
        final def _renderStatic(tile:TileMelius, world:IBlockAccess, r:RenderBlocks) =
            renderStatic(tile.asInstanceOf[T], world, r)
        final def _renderDynamic(tile:TileMelius) =
            renderDynamic(tile.asInstanceOf[T])
    }

    val standardBlock = CCModel.quadModel(24).generateBlock(0, Cuboid6.full).computeNormals.computeLighting(LightModel.standardLightModel)
    var renderers:Seq[RenderInstance[_]] = _

    def renderFaces(t:Transformation, sides:Iterable[Int], icon:Icon) = 
        sides.foreach(renderFace(t, _, icon))
    
    def renderFace(t:Transformation, side:Int, icon:Icon) =
        standardBlock.render(side*4, 4, t, new IconTransformation(icon), null)
    
	override def renderTileEntityAt(t:TileEntity, x:Double, y:Double, z:Double, f:Float)
    {
        val tile = t.asInstanceOf[TileMelius]
        val r = tile.getRenderInstance
        if(r.hasDynamicRender) {
            CCRenderState.reset()
            CCRenderState.pullLightmap()
            CCRenderState.useNormals(true)
            CCRenderState.setColour(-1)
            CCRenderState.useModelColours(true)

            GL11.glTranslated(x, y, z)
                r._renderDynamic(tile)
            GL11.glTranslated(-x, -y, -z)
        }
    }
    
    override def getRenderId = BlockMelius.renderID
    
    override def renderWorldBlock(world:IBlockAccess, x:Int, y:Int, z:Int, block:Block, modelId:Int, r:RenderBlocks):Boolean =
    {
        val tile = world.getBlockTileEntity(x, y, z).asInstanceOf[TileMelius]
        if(tile != null) {
            CCRenderState.reset()
            CCRenderState.setBrightness(world, x, y, z)
            CCRenderState.setColour(-1)
            CCRenderState.useModelColours(true)
            tile.getRenderInstance._renderStatic(tile, world, r)
        }
        return true
    }
    
    override def renderInventoryBlock(block:Block, meta:Int, modelId:Int, r:RenderBlocks)
    {
        CCRenderState.reset()
        CCRenderState.pullLightmap()
        CCRenderState.useNormals(true)
        CCRenderState.setColour(-1)
        CCRenderState.useModelColours(true)

        GL11.glTranslatef(-0.5F, -0.5F, -0.5F)
            renderers(block.asInstanceOf[BlockMelius].meliusIndex*16+meta).renderInventory(r)
        GL11.glTranslatef(0.5F, 0.5F, 0.5F)
    }
    
    override def shouldRender3DInInventory = true

    def loadIcons(r:IconRegister) {
        renderers.foreach(_.loadIcons(r))
    }

    def load() {
        BlockMelius.renderID = RenderingRegistry.getNextAvailableRenderId
        RenderingRegistry.registerBlockHandler(RenderHelper)

        renderers = (0 until BlockMelius.TILES).map(BlockMelius.newTile(_).getRenderInstance)
        renderers.filter(_.hasDynamicRender).foreach{r =>
            ClientRegistry.bindTileEntitySpecialRenderer(
                r.tileClass.runtimeClass.asInstanceOf[Class[TileEntity]], RenderHelper)}
    }
}