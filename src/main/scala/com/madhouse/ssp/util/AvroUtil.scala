package com.madhouse.ssp.util

import org.apache.avro.Schema
import org.apache.avro.io.DecoderFactory
import org.apache.avro.specific.{SpecificDatumReader, SpecificRecordBase}

/**
  * Created by Sunxiang on 2017-07-28 09:50.
  *
  */
object AvroUtil {

  def recordDecode[T <: SpecificRecordBase](bytes: Array[Byte], schema: Schema): T = {
    val reader = new SpecificDatumReader[T](schema)
    val decoder = DecoderFactory.get.binaryDecoder(bytes, null)
    try {
      reader.read(null.asInstanceOf[T], decoder)
    } catch {
      case _: Exception => null.asInstanceOf[T]
    }
  }

}