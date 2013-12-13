package melius_commons.pokefenn.packet

import cpw.mods.fml.common.network.{Player, IPacketHandler}
import net.minecraft.network.INetworkManager
import net.minecraft.network.packet.Packet250CustomPayload

/**
 * Created with IntelliJ IDEA.
 * User: Pokefenn
 * Date: 13/12/13
 * Time: 10:09

 */
object PacketHandler extends IPacketHandler {



  def onPacketData(manager: INetworkManager, packet: Packet250CustomPayload, player: Player){

  }


}
