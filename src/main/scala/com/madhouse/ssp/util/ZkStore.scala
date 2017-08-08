package com.madhouse.ssp.util

import com.madhouse.ssp.Configure
import org.I0Itec.zkclient.ZkClient

/**
  * Created by Sunxiang on 2017-07-28 09:50.
  *
  */
object ZkStore {
  private var client: ZkClient = _

  private def init() = {
    client = new ZkClient(Configure.zkServers, 60000, 6000, new ZKStringSerializer())
  }

  def withZk[T](fn: ZkClient => T): T = {
    if (client == null || client.getShutdownTrigger) init()
    fn(client)
  }
}
