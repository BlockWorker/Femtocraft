package com.itszuvalex.femtocraft.machineframe

import com.itszuvalex.femtocraft.Femtocraft
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.World

/**
 * Created by Alex on 24.08.2015.
 */
class BlockNormalFrame extends BlockFrame {
  override val texLocation: String = Femtocraft.ID + ":" + "normalFrame"
  override val frameType: BlockFrame = this

  setCreativeTab(Femtocraft.tab)

  override def createNewTileEntity(p_149915_1_ : World, p_149915_2_ : Int): TileEntity = new TileNormalFrame
}
