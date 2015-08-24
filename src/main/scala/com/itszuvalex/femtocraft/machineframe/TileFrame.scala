package com.itszuvalex.femtocraft.machineframe

import com.itszuvalex.femtocraft.Femtocraft
import com.itszuvalex.itszulib.core.TileEntityBase
import net.minecraft.client.Minecraft
import net.minecraft.entity.player.EntityPlayer

/**
 * Created by Alex on 24.08.2015.
 */
class TileFrame extends TileEntityBase {
  override def getMod = Femtocraft

  override def hasDescription = true
}
