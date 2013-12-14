package melius_commons.pokefenn

import cpw.mods.fml.common.network.NetworkMod
import codechicken.lib.packet.PacketCustom.CustomTinyPacketHandler
import cpw.mods.fml.common.Mod
import melius_commons.pokefenn.lib.Strings
import melius_commons.pokefenn.util.CreativeTabMelius
import net.minecraft.creativetab.CreativeTabs
import java.util.logging.Logger
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import melius_commons.pokefenn.configuration.ConfigurationHandler
import java.io.File
import cpw.mods.fml.common.event.FMLInitializationEvent

@Mod(modid = "melius", name = "Melius", version = "0.0.0", modLanguage="scala")
@NetworkMod(clientSideRequired = true, serverSideRequired = true, tinyPacketHandler=classOf[CustomTinyPacketHandler])
object Melius
{
    val tabsMelius = new CreativeTabMelius(CreativeTabs.getNextID, Strings.modid)
    val logger = Logger.getLogger(Strings.name)
    
    @EventHandler
    def preInit(event:FMLPreInitializationEvent) {
        ConfigurationHandler.init(new File(event.getModConfigurationDirectory, Strings.modid + "/" + Strings.name + ".cfg"))

        MeliusProxy.preInit()
    }

    @EventHandler
    def load(event:FMLInitializationEvent) {
    	MeliusProxy.init()
    }
}