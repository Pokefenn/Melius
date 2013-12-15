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

object RenderMultiFurnace
{
    val ioModel = buildIOModel()
    
	var sideIcon:Icon = _
	var plainIcon:Icon = _
	var iconT:MultiIconTransformation = _
	
	private def buildIOModel() = {
        val models = CCModel.parseObjModels(new ResourceLocation("melius", "models/io.obj"), 7, new SwapYZ)
	    MultiIconTransformation.setIconIndex(models.get("io_sides"), 1)
	    CCModel.combine(models.values)
    }
	
	def loadIcons(r:IconRegister) = {
	    sideIcon = r.registerIcon("furnace_side")
	    plainIcon = r.registerIcon("furnace_top")
	    
	    iconT = new MultiIconTransformation(plainIcon, sideIcon)
	    
	    plainIcon
	}
	
	def renderWorld(x:Int, y:Int, z:Int, side:Int) {
	    val t = Rotation.sideRotations(side).`with`(new Translation(x+0.5, y+0.5, z+0.5))
	    ioModel.render(t, iconT, PlanarLightModel.standardLightModel)
	}
}