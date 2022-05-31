package com.bumptech.glide.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

class DefaultConnectivityMonitor
  implements ConnectivityMonitor
{
  private final Context a;
  private final ConnectivityMonitor.ConnectivityListener b;
  private boolean c;
  private boolean d;
  private final BroadcastReceiver e = new DefaultConnectivityMonitor.1(this);
  
  public DefaultConnectivityMonitor(Context paramContext, ConnectivityMonitor.ConnectivityListener paramConnectivityListener)
  {
    this.a = paramContext.getApplicationContext();
    this.b = paramConnectivityListener;
  }
  
  private void a()
  {
    if (this.d) {
      return;
    }
    this.c = a(this.a);
    this.a.registerReceiver(this.e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    this.d = true;
  }
  
  private boolean a(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (paramContext != null) && (paramContext.isConnected());
  }
  
  private void b()
  {
    if (!this.d) {
      return;
    }
    this.a.unregisterReceiver(this.e);
    this.d = false;
  }
  
  public void d()
  {
    a();
  }
  
  public void e()
  {
    b();
  }
  
  public void f() {}
}
