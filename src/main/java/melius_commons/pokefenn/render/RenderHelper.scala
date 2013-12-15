package melius_commons.pokefenn.render

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer
import net.minecraft.tileentity.TileEntity
import net.minecraft.client.renderer.RenderBlocks
import net.minecraft.world.IBlockAccess
import net.minecraft.block.Block
import melius_commons.pokefenn.block.BlockMultiFurnace
import cpw.mods.fml.client.registry.RenderingRegistry
import melius_commons.pokefenn.tileentity.TileFurnaceIO
import codechicken.lib.render.CCRenderState
import codechicken.lib.render.CCModel
import codechicken.lib.vec.Cuboid6
import codechicken.lib.lighting.LightModel
import net.minecraft.util.Icon
import codechicken.lib.vec.Transformation
import codechicken.lib.render.IconTransformation

object RenderHelper extends TileEntitySpecialRenderer with ISimpleBlockRenderingHandler
{
    BlockMultiFurnace.renderID = RenderingRegistry.getNextAvailableRenderId
    
    val standardBlock = CCModel.quadModel(24).generateBlock(0, Cuboid6.full).computeNormals.computeLighting(LightModel.standardLightModel)
    
    def renderFaces(t:Transformation, sides:Iterable[Int], icon:Icon) = 
        sides.foreach(renderFace(t, _, icon))
    
    def renderFace(t:Transformation, side:Int, icon:Icon) =
        standardBlock.render(side*4, 4, t, new IconTransformation(icon), null)
    
	override def renderTileEntityAt(t:TileEntity, x:Double, y:Double, z:Double, f:Float)
    {
    }
    
    override def getRenderId = BlockMultiFurnace.renderID
    
    override def renderWorldBlock(world:IBlockAccess, x:Int, y:Int, z:Int, block:Block, modelId:Int, renderer:RenderBlocks):Boolean =
    {
        CCRenderState.reset()
        CCRenderState.setBrightness(world, x, y, z)
        CCRenderState.setColour(-1)
        CCRenderState.useModelColours(true)
        val tile = world.getBlockTileEntity(x, y, z).asInstanceOf[TileFurnaceIO]
        if(tile != null)
        	RenderMultiFurnace.renderStandardIO(x, y, z, tile.orient)
        return true
    }
    
    override def renderInventoryBlock(block:Block, meta:Int, modelId:Int, renderer:RenderBlocks)
    {
        CCRenderState.reset()
        CCRenderState.pullLightmap()
        CCRenderState.useNormals(true)
        CCRenderState.setColour(-1)
        CCRenderState.useModelColours(true)
        
        CCRenderState.startDrawing(7)
        RenderMultiFurnace.renderStandardIO(0, 0, 0, 4)
        CCRenderState.draw()
    }
    
    override def shouldRender3DInInventory = true
}