package melius_commons.pokefenn.tileentity

import net.minecraft.tileentity.TileEntity
import codechicken.lib.packet.{ICustomPacketTile, PacketCustom}
import melius_commons.pokefenn.Melius
import net.minecraft.nbt.NBTTagCompound
import melius_commons.pokefenn.render.RenderHelper.RenderInstance
import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.ItemStack
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.MovingObjectPosition

/**
 * Defines uniform method names and code paths
 */
abstract class TileMelius extends TileEntity with ICustomPacketTile
{
    def save(tag:NBTTagCompound){}
    def load(tag:NBTTagCompound){}
    def writeDesc(packet:PacketCustom){}
    def readDesc(packet:PacketCustom){}

    def onPlaced(entity:EntityLivingBase, stack:ItemStack){}
    def activate(player:EntityPlayer, side:Int, item:ItemStack) = false
    def click(player:EntityPlayer, item:ItemStack){}

    def lightOpacity = 0
    def getRenderInstance:RenderInstance[_]

    final override def writeToNBT(tag:NBTTagCompound) {
        super.writeToNBT(tag)
        save(tag)
    }
    final override def readFromNBT(tag:NBTTagCompound) {
        super.readFromNBT(tag)
        load(tag)
    }
    final override def getDescriptionPacket = {
        val p = new PacketCustom(Melius, 1)
        writeDesc(p)
        p.toPacket
    }
    final def handleDescriptionPacket(packet:PacketCustom) = readDesc(packet)
}
