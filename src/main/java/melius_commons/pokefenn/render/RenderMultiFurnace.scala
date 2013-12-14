package melius_commons.pokefenn.render

import codechicken.lib.render.CCModel
import net.minecraft.util.ResourceLocation
import codechicken.lib.vec.SwapYZ
import codechicken.lib.vec.Translation
import codechicken.lib.vec.Rotation
import net.minecraft.util.Icon
import net.minecraft.client.renderer.texture.IconRegister
import codechicken.lib.render.IconTransformation

object RenderMultiFurnace
{
    val models = CCModel.parseObjModels(new ResourceLocation("melius", "models/io.obj"), 7, new SwapYZ)
    val sides = models.get("io_sides")
    val plain = models.get("io_plain")
    
	var sideIcon:Icon = _
	var plainIcon:Icon = _
	
	def loadIcons(r:IconRegister) = {
	    sideIcon = r.registerIcon("furnace_side")
	    plainIcon = r.registerIcon("furnace_top")
	    plainIcon
	}
	
	def renderWorld(x:Int, y:Int, z:Int, side:Int) {
	    val t = Rotation.sideRotations(side).`with`(new Translation(x+0.5, y+0.5, z+0.5))
	    sides.render(t, new IconTransformation(sideIcon))
	    plain.render(t, new IconTransformation(plainIcon))
	}
}