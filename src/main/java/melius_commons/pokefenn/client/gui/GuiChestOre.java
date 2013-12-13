package melius_commons.pokefenn.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import melius_commons.pokefenn.inventory.ContainerChestOre;
import melius_commons.pokefenn.lib.Strings;
import melius_commons.pokefenn.lib.Textures;
import melius_commons.pokefenn.tileentity.TileChestOre;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

/**
 * Created with IntelliJ IDEA.
 * User: Pokefenn
 * Date: 13/12/13
 * Time: 18:36
 */

@SideOnly(Side.CLIENT)
public class GuiChestOre extends GuiContainer {

    private TileChestOre tileChestOre;

    public GuiChestOre(InventoryPlayer inventoryPlayer, TileChestOre tileChestOre) {

        super(new ContainerChestOre(inventoryPlayer, tileChestOre));
        this.tileChestOre = tileChestOre;
        xSize = 176;
        ySize = 166;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y) {

        String containerName = tileChestOre.isInvNameLocalized() ? tileChestOre.getInvName() : StatCollector.translateToLocal(tileChestOre.getInvName());
        fontRenderer.drawString(containerName, xSize / 2 - fontRenderer.getStringWidth(containerName) / 2, 6, 4210752);
        fontRenderer.drawString(StatCollector.translateToLocal(Strings.CONTAINER_INVENTORY), 8, ySize - 93, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(Textures.GUI_CHEST_ORE);
        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
    }



}
