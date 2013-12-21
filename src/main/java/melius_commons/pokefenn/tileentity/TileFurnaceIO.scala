package melius_commons.pokefenn.tileentity

import net.minecraft.nbt.NBTTagCompound
import codechicken.lib.packet.PacketCustom
import melius_commons.pokefenn.render.RenderMultiFurnace
import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.ItemStack
import codechicken.lib.vec.Rotation

class TileFurnaceIO extends TileMultiblock[MultiFurnace]
{
    var orient:Byte = _

    def createMulti = new MultiFurnace(this)
    def getRenderInstance = RenderMultiFurnace

    override def save(tag:NBTTagCompound) {
        super.save(tag)
        tag.setByte("orient", orient)
    }

    override def load(tag:NBTTagCompound) {
        super.load(tag)
        orient = tag.getByte("orient")
    }

    override def writeDesc(packet:PacketCustom) {
        super.writeDesc(packet)
        packet.writeByte(orient)
    }

    override def readDesc(packet:PacketCustom) {
        super.readDesc(packet)
        orient = packet.readByte
    }

    override def onPlaced(entity:EntityLivingBase, stack:ItemStack) {
        orient = (Rotation.getSideFromLookAngle(entity)^1).toByte
    }

    override def updateEntity() {
        super.updateEntity()
        //TODO validate
    }
}
