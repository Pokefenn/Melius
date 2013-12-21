package melius_commons.pokefenn.tileentity

import net.minecraft.nbt.NBTTagCompound
import codechicken.lib.vec.CuboidCoord
import codechicken.lib.packet.PacketCustom

abstract class Multiblock(val host:TileMultiblock[_])
{
    val bounds:CuboidCoord = new CuboidCoord

    def world() = host.worldObj

    def save(tag:NBTTagCompound) {
        bounds.set(tag.getIntArray("bounds"))
    }

    def load(tag:NBTTagCompound) {
        tag.setIntArray("bounds", bounds.intArray)
    }

    def writeDesc(packet:PacketCustom) {
        packet.writeCoord(bounds.min)
        packet.writeCoord(bounds.max)
    }

    def readDesc(packet:PacketCustom) {
        bounds.set(packet.readCoord, packet.readCoord)
    }

    def update() {

    }
}
