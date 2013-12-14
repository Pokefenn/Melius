package melius_commons.pokefenn

import codechicken.lib.packet.PacketCustom.IClientPacketHandler
import codechicken.lib.packet.PacketCustom
import net.minecraft.client.multiplayer.NetClientHandler
import net.minecraft.client.Minecraft
import codechicken.lib.packet.ICustomPacketTile

object MeliusCPH extends IClientPacketHandler
{
    def handlePacket(packet:PacketCustom, net:NetClientHandler, mc:Minecraft) = packet.getType match {
        case 1 => {
        	val tile = mc.theWorld.getBlockTileEntity(packet.readInt, packet.readInt, packet.readInt)
        	if(tile.isInstanceOf[ICustomPacketTile])
        	    tile.asInstanceOf[ICustomPacketTile].handleDescriptionPacket(packet)
        }
    }
}