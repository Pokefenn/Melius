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
class TileMultiFurnace extends TileEntity with IInventory {

  val TEMP_VAL = 1;

  def closeChest(){

  }

  def openChest(){

  }

  def setInventorySlotContents(i: Int, itemstack: ItemStack){

  }

  def getSizeInventory: Int = {

    return TEMP_VAL;

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
