package com.madhouse.ssp.util

import java.io.Closeable

import org.apache.avro.file.SeekableInput
import org.apache.hadoop.fs.FSDataInputStream

/**
  * Created by Sunxiang on 2017-07-31 15:34.
  *
  */
class FsInput(val len: Long, val stream: FSDataInputStream) extends Closeable with SeekableInput {
  override def close(): Unit = stream.close()

  override def read(b: Array[Byte], off: Int, len: Int): Int = stream.read(b, off, len)

  override def tell(): Long = stream.getPos

  override def length(): Long = len

  override def seek(p: Long): Unit = stream.seek(p)
}
