package com.bumptech.glide.manager;

import android.content.Context;

public class ConnectivityMonitorFactory
{
  public ConnectivityMonitorFactory() {}
  
  public ConnectivityMonitor a(Context paramContext, ConnectivityMonitor.ConnectivityListener paramConnectivityListener)
  {
    if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return new DefaultConnectivityMonitor(paramContext, paramConnectivityListener);
    }
    return new NullConnectivityMonitor();
  }
}
