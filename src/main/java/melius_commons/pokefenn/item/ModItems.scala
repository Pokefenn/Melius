package melius_commons.pokefenn.item

import cpw.mods.fml.common.registry.GameRegistry
import melius_commons.pokefenn.lib.{ItemIds, Strings}
import net.minecraft.block.Block
import net.minecraft.item.Item

/**
 * Created with IntelliJ IDEA.
 * User: Pokefenn
 * Date: 13/12/13
 * Time: 11:45

 */
object ModItems {

  var metaData:Item = _

  def init(){

    metaData = new ItemMetaData(ItemIds.META_DATA);

    GameRegistry.registerItem(metaData, Strings.META_DATA_NAME)

  }


}
