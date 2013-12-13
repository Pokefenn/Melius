package melius_commons.pokefenn

import cpw.mods.fml.common.network.NetworkMod
import cpw.mods.fml.common.{FMLCommonHandler, Mod}
import cpw.mods.fml.common.event.{FMLPostInitializationEvent, FMLInitializationEvent, FMLPreInitializationEvent}
import cpw.mods.fml.common.Mod.{Instance, EventHandler}
import java.util.logging.Logger
import melius_commons.pokefenn.packet._
import cpw.mods.fml.relauncher.Side
import melius_commons.pokefenn.lib.Strings

/**
 * Created with IntelliJ IDEA.
 * User: Pokefenn
 * Date: 13/12/13
 * Time: 09:51

 */

@Mod(modid = "melius", name = "Melius", version = "0.0.0",  modLanguage = "scala")
@NetworkMod(channels = Array("melius"), clientSideRequired = true, serverSideRequired = false)
object Melius {




  @Instance("melius") var instance: Melius.type = null
  final val logger: Logger = Logger.getLogger("melius")



  @EventHandler def preInit(event: FMLPreInitializationEvent) {



  }

  @EventHandler def init(evt: FMLInitializationEvent) {



  }


  @EventHandler def postInit(evt: FMLPostInitializationEvent) {



  }












}
