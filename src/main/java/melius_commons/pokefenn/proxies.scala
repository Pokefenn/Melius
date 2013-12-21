package melius_commons.pokefenn

import codechicken.lib.packet.PacketCustom
import cpw.mods.fml.client.registry.RenderingRegistry
import melius_commons.pokefenn.render.RenderHelper
import melius_commons.pokefenn.block.ModBlocks
import melius_commons.pokefenn.item.ModItems
import cpw.mods.fml.common.registry.GameRegistry
import melius_commons.pokefenn.tileentity.TileMultiFurnace
import melius_commons.pokefenn.tileentity.TileChestOre
import melius_commons.pokefenn.lib.Strings
import cpw.mods.fml.common.network.IGuiHandler
import cpw.mods.fml.relauncher.SideOnly
import cpw.mods.fml.relauncher.Side
import net.minecraft.world.World
import net.minecraft.entity.player.EntityPlayer
import melius_commons.pokefenn.inventory.ContainerChestOre
import melius_commons.pokefenn.lib.GuiIds
import melius_commons.pokefenn.client.gui.GuiChestOre
import cpw.mods.fml.common.network.NetworkRegistry
import melius_commons.pokefenn.tileentity.TileFurnaceIO

abstract class CommonProxy extends IGuiHandler
{
    def preInit() {
        ModBlocks.init()
        ModItems.init()
    }
    
    def init() {
        NetworkRegistry.instance.registerGuiHandler(Melius, this)
        
        GameRegistry.registerTileEntity(classOf[TileMultiFurnace], Strings.TE_MULTI_FURNACE_NAME)
        GameRegistry.registerTileEntity(classOf[TileFurnaceIO], Strings.TE_FURNACE_IO_NAME)
        GameRegistry.registerTileEntity(classOf[TileChestOre], Strings.TE_CHEST_ORE_NAME)
    }
    
    def getServerGuiElement(id:Int, player:EntityPlayer, world:World, x:Int, y:Int, z:Int) = {
        def tile[T]() = world.getBlockTileEntity(x, y, z).asInstanceOf[T]
        id match {
            case GuiIds.CHEST_ORE_GUI_ID => new ContainerChestOre(player.inventory, tile[TileChestOre])
            case _ => null
        }
    }
}

class ClientProxy extends CommonProxy
{
    @SideOnly(Side.CLIENT)
    override def preInit() {
		super.preInit()

        RenderHelper.load()
		PacketCustom.assignHandler(Melius, MeliusCPH)
	}
    
    @SideOnly(Side.CLIENT)
    override def init() {
        super.init()
    }
    
    @SideOnly(Side.CLIENT)
    def getClientGuiElement(id:Int, player:EntityPlayer, world:World, x:Int, y:Int, z:Int) = {
        def tile[T]() = world.getBlockTileEntity(x, y, z).asInstanceOf[T]
        id match {
            case GuiIds.CHEST_ORE_GUI_ID => new GuiChestOre(player.inventory, tile[TileChestOre])
            case _ => null
        }
    }
}

object MeliusProxy extends ClientProxy
{
    
}