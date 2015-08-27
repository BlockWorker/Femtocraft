package com.itszuvalex.femtocraft.core

import scala.collection._

/**
 * Created by Christopher on 8/26/2015.
 */
object FrameMultiblockRegistry {
  private val frameMap = mutable.HashMap[String, IFrameMultiblock]()

  def registerMultiblock(multi: IFrameMultiblock) = frameMap.put(multi.getName, multi)

  def getMultiblock(name: String) = frameMap.get(name)
}
