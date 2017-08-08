package com.madhouse.ssp.entity

/**
  * Created by Sunxiang on 2017-07-28 09:50.
  *
  */
case class Output(path: String, prefix: String, suffix: String, rotateIntervalMs: Long) {
  override def toString() = s"path:$path, prefix:$prefix, suffix:$suffix, rotateIntervalMs: $rotateIntervalMs"
}