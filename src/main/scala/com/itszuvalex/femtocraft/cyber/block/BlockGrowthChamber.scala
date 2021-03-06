package com.itszuvalex.femtocraft.cyber.block

import com.itszuvalex.femtocraft.cyber.tile.TileGrowthChamber
import com.itszuvalex.itszulib.core.TileContainer
import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.World

/**
 * Created by Alex on 30.09.2015.
 */
class BlockGrowthChamber extends TileContainer(Material.iron) {
  override def createNewTileEntity(p_149915_1_ : World, p_149915_2_ : Int): TileEntity = new TileGrowthChamber

  override def renderAsNormalBlock = false

  override def getRenderBlockPass = 2

  override def isOpaqueCube = false

  override def breakBlock(world: World, x: Int, y: Int, z: Int, block: Block, par6: Int): Unit = {
    world.getTileEntity(x, y, z) match {
      case te: TileGrowthChamber =>
        te.onBlockBreak()
      case _ =>
    }
    super.breakBlock(world, x, y, z, block, par6)
  }
}
