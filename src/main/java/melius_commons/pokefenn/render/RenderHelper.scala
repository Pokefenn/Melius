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

object RenderHelper extends TileEntitySpecialRenderer with ISimpleBlockRenderingHandler
{
    BlockMultiFurnace.renderID = RenderingRegistry.getNextAvailableRenderId
    
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
        	RenderMultiFurnace.renderWorld(x, y, z, tile.orient)
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
        RenderMultiFurnace.renderWorld(0, 0, 0, 4)
        CCRenderState.draw()
    }
    
    override def shouldRender3DInInventory = true
}