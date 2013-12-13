package melius_commons.pokefenn.recipe;

import cpw.mods.fml.common.registry.GameRegistry;
import melius_commons.pokefenn.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

/**
 * Created with IntelliJ IDEA.
 * User: Pokefenn
 * Date: 13/12/13
 * Time: 16:52
 */
public class CraftingTableRecipesMelius {

    public static void init(){

        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.chestOre()), new Object[]{ ('c'), Block.chest, ('i'), Block.oreIron});


    }


}
