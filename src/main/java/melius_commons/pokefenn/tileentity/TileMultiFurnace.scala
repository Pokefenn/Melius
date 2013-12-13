package melius_commons.pokefenn.tileentity

import net.minecraft.tileentity.TileEntity
import net.minecraft.inventory.IInventory
import net.minecraft.item.ItemStack
import net.minecraft.entity.player.EntityPlayer

/**
 * Created with IntelliJ IDEA.
 * User: Pokefenn
 * Date: 13/12/13
 * Time: 15:13

 */
object TileMultiFurnace extends TileEntity with IInventory {

  final val INVENTORY_SIZE: Int = 1
  final val INVENTORY_SLOT_INDEX: Int = 0

  private var inventory: Array[ItemStack] = null

  inventory = new Array[ItemStack](INVENTORY_SIZE)



  val TEMP_VAL = 1;

  def closeChest(){

    //No code here due to it not being a chest xD

  }

  def openChest(){

    //Again, not a chest :p

  }

  def setInventorySlotContents(i: Int, itemstack: ItemStack){

  }

  def getSizeInventory: Int = {

    return inventory.length

  }

  def getStackInSlot(i: Int): ItemStack = {

    return ItemStack;
  }

  def decrStackSize(i: Int, j: Int): ItemStack = {

    return ItemStack;

  }

  def getStackInSlotOnClosing(i: Int): ItemStack = {

    return ItemStack;

  }

  def getInvName: String = {

    return "tempValue";

  }

  def isInvNameLocalized: Boolean = {

    return true;

  }

  def getInventoryStackLimit: Int = {

    return TEMP_VAL;

  }

  def isUseableByPlayer(entityplayer: EntityPlayer): Boolean = {

    return true;

  }

  def isItemValidForSlot(i: Int, itemstack: ItemStack): Boolean = {

    return true;

  }
}
