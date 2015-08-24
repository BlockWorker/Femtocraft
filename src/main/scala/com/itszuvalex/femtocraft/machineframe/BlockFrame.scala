package com.itszuvalex.femtocraft.machineframe

import com.itszuvalex.femtocraft.Femtocraft
import com.itszuvalex.itszulib.core.TileContainer
import net.minecraft.block.material.Material
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.util.IIcon
import net.minecraft.world.IBlockAccess
import net.minecraftforge.common.util.ForgeDirection

/**
 * Created by Alex on 24.08.2015.
 */
abstract class BlockFrame extends TileContainer(Material.iron) {

  val texLocation : String
  val frameType : BlockFrame

  var textures = new Array[IIcon](47)

  override def isOpaqueCube = false

  override def getRenderBlockPass = 0

  private def boolToInt(boolean: Boolean) : Int = if (boolean) 1 else 0

  override def registerBlockIcons(iconRegister: IIconRegister): Unit = {
    (0 to 46).map( num => (texLocation + "/" + (if (num < 10) "0" else "") + num, num)).foreach { name =>
      textures{name._2} = iconRegister.registerIcon(name._1)
    }
  }

  override def getIcon(world: IBlockAccess, x: Int, y: Int, z: Int, side: Int): IIcon = {
    val blockArray = new Array[Boolean](9)
    val sidemap : Map[Int, Int] = Map(0 -> 0, 1 -> 1, 2 -> 2, 3 -> 7, 4 -> 3, 5 -> 5, 6 -> 8, 7 -> 14, 8 -> 4, 9 -> 10, 10 -> 6, 11 -> 13, 12 -> 9, 13 -> 12, 14 -> 11, 15 -> 15)
    /*
    Array Mapping:      Binary Sides:     Binary Corners:     Number 8 is the block covering that face.
    4 0 5                 1               1   2
    3   1               8   2
    7 2 6                 4               8   4
     */
    if (side == 0 || side == 1) {
      blockArray{0} = world.getBlock(x, y, z - 1).isInstanceOf[frameType.type]
      blockArray{1} = world.getBlock(x + 1, y, z).isInstanceOf[frameType.type]
      blockArray{2} = world.getBlock(x, y, z + 1).isInstanceOf[frameType.type]
      blockArray{3} = world.getBlock(x - 1, y, z).isInstanceOf[frameType.type]
      blockArray{4} = world.getBlock(x - 1, y, z - 1).isInstanceOf[frameType.type]
      blockArray{5} = world.getBlock(x + 1, y, z - 1).isInstanceOf[frameType.type]
      blockArray{6} = world.getBlock(x + 1, y, z + 1).isInstanceOf[frameType.type]
      blockArray{7} = world.getBlock(x - 1, y, z + 1).isInstanceOf[frameType.type]
      blockArray{8} = world.getBlock(x, if (side == 0) y - 1 else y + 1, z).isInstanceOf[frameType.type]
    } else if (side == 2) {
      blockArray{0} = world.getBlock(x, y + 1, z).isInstanceOf[frameType.type]
      blockArray{1} = world.getBlock(x - 1, y, z).isInstanceOf[frameType.type]
      blockArray{2} = world.getBlock(x, y - 1, z).isInstanceOf[frameType.type]
      blockArray{3} = world.getBlock(x + 1, y, z).isInstanceOf[frameType.type]
      blockArray{4} = world.getBlock(x + 1, y + 1, z).isInstanceOf[frameType.type]
      blockArray{5} = world.getBlock(x - 1, y + 1, z).isInstanceOf[frameType.type]
      blockArray{6} = world.getBlock(x - 1, y - 1, z).isInstanceOf[frameType.type]
      blockArray{7} = world.getBlock(x + 1, y - 1, z).isInstanceOf[frameType.type]
      blockArray{8} = world.getBlock(x, y, z - 1).isInstanceOf[frameType.type]
    } else if (side == 3) {
      blockArray{0} = world.getBlock(x, y + 1, z).isInstanceOf[frameType.type]
      blockArray{1} = world.getBlock(x + 1, y, z).isInstanceOf[frameType.type]
      blockArray{2} = world.getBlock(x, y - 1, z).isInstanceOf[frameType.type]
      blockArray{3} = world.getBlock(x - 1, y, z).isInstanceOf[frameType.type]
      blockArray{4} = world.getBlock(x - 1, y + 1, z).isInstanceOf[frameType.type]
      blockArray{5} = world.getBlock(x + 1, y + 1, z).isInstanceOf[frameType.type]
      blockArray{6} = world.getBlock(x + 1, y - 1, z).isInstanceOf[frameType.type]
      blockArray{7} = world.getBlock(x - 1, y - 1, z).isInstanceOf[frameType.type]
      blockArray{8} = world.getBlock(x, y, z + 1).isInstanceOf[frameType.type]
    } else if (side == 4) {
      blockArray{0} = world.getBlock(x, y + 1, z).isInstanceOf[frameType.type]
      blockArray{1} = world.getBlock(x, y, z + 1).isInstanceOf[frameType.type]
      blockArray{2} = world.getBlock(x, y - 1, z).isInstanceOf[frameType.type]
      blockArray{3} = world.getBlock(x, y, z - 1).isInstanceOf[frameType.type]
      blockArray{4} = world.getBlock(x, y + 1, z - 1).isInstanceOf[frameType.type]
      blockArray{5} = world.getBlock(x, y + 1, z + 1).isInstanceOf[frameType.type]
      blockArray{6} = world.getBlock(x, y - 1, z + 1).isInstanceOf[frameType.type]
      blockArray{7} = world.getBlock(x, y - 1, z - 1).isInstanceOf[frameType.type]
      blockArray{8} = world.getBlock(x - 1, y, z).isInstanceOf[frameType.type]
    } else if (side == 5) {
      blockArray{0} = world.getBlock(x, y + 1, z).isInstanceOf[frameType.type]
      blockArray{1} = world.getBlock(x, y, z - 1).isInstanceOf[frameType.type]
      blockArray{2} = world.getBlock(x, y - 1, z).isInstanceOf[frameType.type]
      blockArray{3} = world.getBlock(x, y, z + 1).isInstanceOf[frameType.type]
      blockArray{4} = world.getBlock(x, y + 1, z + 1).isInstanceOf[frameType.type]
      blockArray{5} = world.getBlock(x, y + 1, z - 1).isInstanceOf[frameType.type]
      blockArray{6} = world.getBlock(x, y - 1, z - 1).isInstanceOf[frameType.type]
      blockArray{7} = world.getBlock(x, y - 1, z + 1).isInstanceOf[frameType.type]
      blockArray{8} = world.getBlock(x + 1, y, z).isInstanceOf[frameType.type]
    }
    if (blockArray{8}) return textures{31}
    var sides : Int = 0
    var corners : Int = 0
    for ( i <- 0 to 3 ) sides += (boolToInt(blockArray{i}) << i)
    for ( i <- 4 to 7 ) corners += (boolToInt(!blockArray{i}) << (i - 4))
    val sideconfig = sidemap(sides)
    if (sideconfig < 7) textures{sideconfig}
    else {
      sideconfig match {
        case 7 => textures{7 + ((corners & 2) >> 1)}
        case 8 => textures{9 + ((corners & 4) >> 2)}
        case 9 => textures{11 + ((corners & 8) >> 3)}
        case 10 => textures{13 + (corners & 1)}
        case 11 => textures{15 + ((corners & 12) >> 2)}
        case 12 => textures{19 + ((corners & 8) >> 2) + (corners & 1)}
        case 13 => textures{23 + (corners & 3)}
        case 14 => textures{27 + ((corners & 6) >> 1)}
        case 15 => textures{31 + corners}
      }
    }
  }

}
