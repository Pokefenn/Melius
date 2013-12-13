package melius_commons.pokefenn.tileentity

import net.minecraft.tileentity.TileEntity
import net.minecraft.inventory.IInventory
import net.minecraft.item.ItemStack
import net.minecraft.entity.player.EntityPlayer
import melius_commons.pokefenn.lib.Strings

/**
 * Created with IntelliJ IDEA.
 * User: Pokefenn
 * Date: 13/12/13
 * Time: 16:03

 */
class TileChestOre extends TileEntity with IInventory {

  final val INVENTORY_SIZE: Int = 1
  final val INVENTORY_SLOT_INDEX: Int = 0

  private var inventory: Array[ItemStack] = null

  inventory = new Array[ItemStack](INVENTORY_SIZE)




  //val TEMP_VAL = 1;

  def closeChest(){

    //No code here due to it not being a chest xD

  }

  def openChest(){

    //Again, not a chest :p

  }

  def setInventorySlotContents(slotIndex: Int, itemstack: ItemStack){

  }

  def getSizeInventory: Int = {

    return inventory.length

  }

  def getStackInSlot(slotIndex: Int): ItemStack = {

    return inventory(slotIndex)
  }

  def decrStackSize(slotIndex: Int, decrementAmount: Int): ItemStack = {

    var itemStack: ItemStack = getStackInSlot(slotIndex)
    if (itemStack != null) {

      if (itemStack.stackSize <= decrementAmount) {

        setInventorySlotContents(slotIndex, null)
      }

      else {

        itemStack = itemStack.splitStack(decrementAmount)
        if (itemStack.stackSize == 0) {

          setInventorySlotContents(slotIndex, null)
        }

      }

    }
    return itemStack

  }

  def getStackInSlotOnClosing(slotIndex: Int): ItemStack = {

    val itemStack: ItemStack = getStackInSlot(slotIndex)

    if (itemStack != null) {

      setInventorySlotContents(slotIndex, null)
    }
    return itemStack

  }

  def getInvName: String = {

    return Strings.INVENTORY_CHEST_ORE_NAME;

  }

  def isInvNameLocalized: Boolean = {

    return true;

  }

  def getInventoryStackLimit: Int = {

    return 64;

  }

  def isUseableByPlayer(entityplayer: EntityPlayer): Boolean = {

    return true;

  }

  def isItemValidForSlot(slotIndex: Int, itemstack: ItemStack): Boolean = {

    return true;

  }



}
