package melius_commons.pokefenn.render

import codechicken.lib.render.{CCRenderState, CCModel, MultiIconTransformation}
import net.minecraft.util.ResourceLocation
import codechicken.lib.vec.SwapYZ
import codechicken.lib.vec.Translation
import codechicken.lib.vec.Rotation
import net.minecraft.util.Icon
import net.minecraft.client.renderer.texture.IconRegister
import codechicken.lib.lighting.PlanarLightModel
import codechicken.lib.vec.Cuboid6
import net.minecraft.tileentity.TileEntity
import melius_commons.pokefenn.tileentity.{MultiFurnace, TileMultiblock, TileMultiFurnace, TileFurnaceIO}
import melius_commons.pokefenn.render.RenderHelper.RenderInstance
import net.minecraft.world.IBlockAccess
import net.minecraft.client.renderer.RenderBlocks

object RenderMultiFurnace extends RenderInstance[TileFurnaceIO]
{
    var io_inside:CCModel = _
    var io_shell:CCModel = _
    
	var sideIcon:Icon = _
	var plainIcon:Icon = _
	var iconT:MultiIconTransformation = _
	
	{
        io_inside = CCModel.parseObjModels(new ResourceLocation("melius", "models/model.obj"), 7, new SwapYZ).get("io_inside")
        io_shell = CCModel.quadModel(20).generateBlock(0, Cuboid6.full, 1).computeNormals.apply(new Translation(-0.5, -0.5, -0.5))
        MultiIconTransformation.setIconIndex(io_shell, 4, 20, 1)
    }

    def wallType(side:Int, tile:TileEntity) = tile match {
        case t:TileFurnaceIO if t.orient == side => 1
        case _ => 0
    }

	def loadIcons(r:IconRegister) {
	    sideIcon = r.registerIcon("furnace_side")
	    plainIcon = r.registerIcon("furnace_top")
	    
	    iconT = new MultiIconTransformation(plainIcon, sideIcon)
	}

    def renderStatic(tile:TileFurnaceIO, world:IBlockAccess, r:RenderBlocks) {
        renderStandardIO(tile.xCoord, tile.yCoord, tile.zCoord, tile.orient)
    }

    def renderInventory(r:RenderBlocks) {
        CCRenderState.startDrawing(7)
        renderStandardIO(0, 0, 0, 3)
        CCRenderState.draw()
    }

	def renderStandardIO(x:Int, y:Int, z:Int, side:Int) {
	    val t = Rotation.sideRotations(side) ++ new Translation(x+0.5, y+0.5, z+0.5)
	    io_inside.render(t, iconT, PlanarLightModel.standardLightModel)
	    io_shell.render(t, iconT, PlanarLightModel.standardLightModel)
	}
}