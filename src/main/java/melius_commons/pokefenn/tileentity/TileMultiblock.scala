package melius_commons.pokefenn.tileentity

import codechicken.lib.vec.BlockCoord
import net.minecraft.nbt.NBTTagCompound
import codechicken.lib.packet.PacketCustom

trait TileMultiblock[T <: Multiblock] extends TileMelius
{
    /**
     * If parent may point to this
     */
    private val parent = new BlockCoord
    private var mb:T = _

    def getParent() = worldObj.getBlockTileEntity(parent.x, parent.y, parent.z) match {
        case t:TileMultiblock[T] => t
        case _ =>
            parent.set(xCoord, yCoord, zCoord)
            this
    }

    def getMulti() = if(mb == null) getParent.mb else mb
    def createMulti:T

    override def save(tag:NBTTagCompound) {
        super.save(tag)
        if(parent != null)
            tag.setIntArray("parent", parent.intArray)
        if(mb != null) {            val mb_tag = new NBTTagCompound
            mb.save(mb_tag)
            tag.setCompoundTag("mb", mb_tag)
        }
    }

    override def load(tag:NBTTagCompound) {
        super.load(tag)
        if(tag.hasKey("parent"))
            parent.set(tag.getIntArray("parent"))
        if(tag.hasKey("mb")) {
            mb = createMulti
            mb.load(tag.getCompoundTag("mb"))
        }
    }

    override def writeDesc(packet:PacketCustom) {
        super.writeDesc(packet)
        packet.writeCoord(parent)
        packet.writeBoolean(mb != null)
        if(mb != null)
            mb.writeDesc(packet)
    }

    override def readDesc(packet:PacketCustom) {
        super.readDesc(packet)
        parent.set(packet.readCoord)
        if(packet.readBoolean) {
            if(mb == null) mb = createMulti
            mb.readDesc(packet)
        }
    }

    override def updateEntity() {
        super.updateEntity()
        if(mb != null)
            mb.update()
    }
}


