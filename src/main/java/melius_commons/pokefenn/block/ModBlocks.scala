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
    var chestOre:Block = _

    def init() {
        blockMelius = new BlockMelius(BlockIds.MELIUS)
        chestOre = new BlockChestOre(BlockIds.CHEST_ORE)

        GameRegistry.registerBlock(blockMelius, blockMelius.getUnlocalizedName)
        GameRegistry.registerBlock(chestOre, Strings.CHEST_ORE_NAME)
    }
}
