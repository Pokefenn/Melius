package melius_commons.pokefenn

import cpw.mods.fml.common.network.NetworkMod
import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.event.{FMLPostInitializationEvent, FMLInitializationEvent, FMLPreInitializationEvent}
import cpw.mods.fml.common.Mod.EventHandler

/**
 * Created with IntelliJ IDEA.
 * User: Pokefenn
 * Date: 13/12/13
 * Time: 09:51

 */

@Mod(modid = Melius.modid, name = Melius.name, version = Melius.version,  modLanguage = "scala")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
object Melius {

  def modid = "Melius"
  def name = "melius"
  def version = "0.0.0"

  @EventHandler def preInit(event: FMLPreInitializationEvent) {



  }

  @EventHandler def init(evt: FMLInitializationEvent) {



  }


  @EventHandler def postInit(evt: FMLPostInitializationEvent) {



  }












}
