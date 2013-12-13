package melius_commons.pokefenn.configuration

import java.io.File
import net.minecraftforge.common.Configuration
import cpw.mods.fml.common.FMLLog
import java.util.logging.Level
import melius_commons.pokefenn.lib.{Strings, BlockIds}

/**
 * Created with IntelliJ IDEA.
 * User: Pokefenn
 * Date: 13/12/13
 * Time: 11:50

 */
object ConfigurationHandler {

  def init(configFile: File) {
    configuration = new Configuration(configFile)
    try {
      configuration.load

      BlockIds.MULTI_FURNACE = configuration.getBlock(Strings.MULTI_FURNACE_NAME, BlockIds.MULTI_FURNACE_DEFAULT).getInt(BlockIds.MULTI_FURNACE_DEFAULT)

    }
    catch {
      case e: Exception => {
        FMLLog.log(Level.SEVERE, e, Strings.name + " has had a problem loading its configuration, go ask on the forums :p")
      }
    }
    finally {
      configuration.save
    }
  }

  def set(categoryName: String, propertyName: String, newValue: String) {
    configuration.load
    if (configuration.getCategoryNames.contains(categoryName)) {
      if (configuration.getCategory(categoryName).containsKey(propertyName)) {
        configuration.getCategory(categoryName).get(propertyName).set(newValue)
      }
    }
    configuration.save
  }

  var configuration: Configuration = null
  final val CATEGORY_GAMEPLAY: String = "gameplay"



}
