package melius_commons.pokefenn.block

import cpw.mods.fml.common.registry.GameRegistry
import melius_commons.pokefenn.lib.{BlockIds, Strings}
import net.minecraft.block.Block

/**
 * Created with IntelliJ IDEA.
 * User: Pokefenn
 * Date: 13/12/13
 * Time: 11:25
 *
 */
object ModBlocks
{
    var blockMelius:Block = _

    def init() {
        blockMelius = new BlockMelius(BlockIds.MELIUS)

        GameRegistry.registerBlock(blockMelius, blockMelius.getUnlocalizedName)

    }
}
