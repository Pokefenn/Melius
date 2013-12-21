package melius_commons.pokefenn.tileentity

import melius_commons.pokefenn.render.RenderMultiFurnace

class TileMultiFurnace extends TileMultiblock[MultiFurnace]
{
    def createMulti = new MultiFurnace(this)
    def getRenderInstance = RenderMultiFurnace
}
