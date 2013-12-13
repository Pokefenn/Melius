package melius_commons.pokefenn

import cpw.mods.fml.common.network.NetworkMod
import cpw.mods.fml.common.{FMLCommonHandler, Mod}
import cpw.mods.fml.common.event.{FMLPostInitializationEvent, FMLInitializationEvent, FMLPreInitializationEvent}
import cpw.mods.fml.common.Mod.{Instance, EventHandler}
import java.util.logging.Logger
import melius_commons.pokefenn.packet._
import cpw.mods.fml.relauncher.Side

/**
 * Created with IntelliJ IDEA.
 * User: Pokefenn
 * Date: 13/12/13
 * Time: 09:51

 */

@Mod(modid = Melius.modid, name = Melius.name, version = Melius.version,  modLanguage = "scala")
@NetworkMod(channels = Array(Melius.modid), clientSideRequired = true, serverSideRequired = false)
object Melius {


  @Instance(Melius.modid) var instance: Melius.type = null
  def modid = "melius"
  def name = "Melius"
  def version = "0.0.0"

  final val logger: Logger = Logger.getLogger(Melius.modid)



  @EventHandler def preInit(event: FMLPreInitializationEvent) {



  }

  @EventHandler def init(evt: FMLInitializationEvent) {



  }


  @EventHandler def postInit(evt: FMLPostInitializationEvent) {



  }












}
