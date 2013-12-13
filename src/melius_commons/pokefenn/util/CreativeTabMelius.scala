package melius_commons.pokefenn.util

import net.minecraft.creativetab.CreativeTabs
import cpw.mods.fml.relauncher.{Side, SideOnly}
import scala.collection.immutable.Range
import melius_commons.pokefenn.block.ModBlocks

/**
 * Created with IntelliJ IDEA.
 * User: Pokefenn
 * Date: 13/12/13
 * Time: 13:01

 */
class CreativeTabMelius(par1:Int, par2Str:String) extends CreativeTabs(par1:Int, par2Str:String) {


   @SideOnly(Side.CLIENT) override def getTabIconItemIndex(): Int = {

    return ModBlocks.multiFurnace.blockID


  }
}
