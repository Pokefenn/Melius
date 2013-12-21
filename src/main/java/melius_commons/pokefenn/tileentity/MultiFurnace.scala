package melius_commons.pokefenn.tileentity

import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import codechicken.lib.inventory.InventoryUtils

class MultiFurnace(_tile:TileMultiblock[MultiFurnace]) extends Multiblock(_tile)
{
    val inv = Array.ofDim[ItemStack](2)
    var burnTime = 0

    override def save(tag:NBTTagCompound) {
        tag.setInteger("burnTime", burnTime)
        tag.setTag("inv", InventoryUtils.writeItemStacksToTag(inv))
    }

    override def load(tag:NBTTagCompound) {
        burnTime = tag.getInteger("burnTime")
        InventoryUtils.readItemStacksFromTag(inv, tag.getTagList("inv"))
    }
}
