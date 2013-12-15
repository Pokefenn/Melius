package melius_commons.pokefenn.render

import codechicken.lib.render.CCModel
import net.minecraft.util.ResourceLocation
import codechicken.lib.vec.SwapYZ
import codechicken.lib.vec.Translation
import codechicken.lib.vec.Rotation
import net.minecraft.util.Icon
import net.minecraft.client.renderer.texture.IconRegister
import codechicken.lib.render.IconTransformation
import codechicken.lib.render.MultiIconTransformation
import codechicken.lib.lighting.PlanarLightModel
import codechicken.lib.vec.Cuboid6

object RenderMultiFurnace
{
    var io_inside:CCModel = _
    var io_shell:CCModel = _
    
	var sideIcon:Icon = _
	var plainIcon:Icon = _
	var iconT:MultiIconTransformation = _
	
	{
        io_inside = CCModel.parseObjModels(new ResourceLocation("melius", "models/io.obj"), 7, new SwapYZ).get("io_inside")
        io_shell = CCModel.quadModel(20).generateBlock(0, Cuboid6.full, 2).computeNormals.apply(new Translation(-0.5, -0.5, -0.5))
        MultiIconTransformation.setIconIndex(io_shell, 4, 20, 1)
    }
	
	def loadIcons(r:IconRegister) = {
	    sideIcon = r.registerIcon("furnace_side")
	    plainIcon = r.registerIcon("furnace_top")
	    
	    iconT = new MultiIconTransformation(plainIcon, sideIcon)
	    
	    plainIcon
	}
	
	def renderStandardIO(x:Int, y:Int, z:Int, side:Int) {
	    val t = Rotation.sideRotations(side).`with`(new Translation(x+0.5, y+0.5, z+0.5))
	    io_inside.render(t, iconT, PlanarLightModel.standardLightModel)
	    io_shell.render(t, iconT, PlanarLightModel.standardLightModel)
	}
}