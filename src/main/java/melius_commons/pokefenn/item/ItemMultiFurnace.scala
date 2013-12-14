package melius_commons.pokefenn.item

import net.minecraft.item.ItemBlock
import net.minecraft.item.ItemStack
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.world.World
import melius_commons.pokefenn.tileentity.TileFurnaceIO
import melius_commons.pokefenn.Melius

class ItemMultiFurnace(id:Int) extends ItemBlock(id)
{
	setHasSubtypes(true)
	setCreativeTab(Melius.tabsMelius)
    
    override def placeBlockAt(stack:ItemStack, player:EntityPlayer, world:World, 
            x:Int, y:Int, z:Int, side:Int, hitX:Float, hitY:Float, hitZ:Float, metadata:Int):Boolean = {
        if(super.placeBlockAt(stack, player, world, x, y, z, side, hitX, hitY, hitZ, metadata))
        {
            val tile = world.getBlockTileEntity(x, y, z).asInstanceOf[TileFurnaceIO]
            tile.orient = (side^1).toByte
            
            return true
        }
        return false
    }
}