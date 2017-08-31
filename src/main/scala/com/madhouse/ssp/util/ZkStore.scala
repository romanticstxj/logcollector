package com.madhouse.ssp.util

import com.madhouse.ssp.Configure
import org.I0Itec.zkclient.ZkClient

/**
  * Created by Sunxiang on 2017-07-28 09:50.
  *
  */
object ZkStore {
  private var client: ZkClient = _

  private def init(zkServers: String) = {
    client = new ZkClient(zkServers, 60000, 6000, new ZKStringSerializer())
  }

  def withZk[T](fn: ZkClient => T)(implicit configure: Configure): T = {
    if (client == null || client.getShutdownTrigger) init(configure.zkServers)
    fn(client)
  }
}
