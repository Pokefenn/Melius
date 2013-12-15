package melius_commons.pokefenn.tileentity

import net.minecraft.tileentity.TileEntity
import net.minecraft.nbt.NBTTagCompound
import codechicken.lib.packet.PacketCustom
import melius_commons.pokefenn.Melius
import codechicken.lib.packet.ICustomPacketTile

class TileFurnaceIO extends TileEntity with ICustomPacketTile
{
	var orient:Byte = _
	
	override def writeToNBT(tag:NBTTagCompound) {
	    super.writeToNBT(tag)
	    tag.setByte("orient", orient)
	}
	
	override def readFromNBT(tag:NBTTagCompound) {
	    super.readFromNBT(tag)
	    orient = tag.getByte("orient")
	}
	
	override def getDescriptionPacket() = {
	    new PacketCustom(Melius, 1)
		    .setChunkDataPacket()
		    .writeCoord(xCoord, yCoord, zCoord)
		    .writeByte(orient)
		    .toPacket()
	}
	
	def handleDescriptionPacket(packet:PacketCustom) {
	    orient = packet.readByte
	    worldObj.markBlockForUpdate(xCoord, yCoord, zCoord)
	}
}