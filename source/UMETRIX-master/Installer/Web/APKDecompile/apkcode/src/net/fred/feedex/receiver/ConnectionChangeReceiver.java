package net.fred.feedex.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import net.fred.feedex.service.FetcherService;
import net.fred.feedex.utils.PrefUtils;

public class ConnectionChangeReceiver
  extends BroadcastReceiver
{
  private boolean a = false;
  
  public ConnectionChangeReceiver() {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((this.a) && (paramIntent.getBooleanExtra("noConnectivity", false))) {
      this.a = false;
    }
    int i;
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.a) || (paramIntent.getBooleanExtra("noConnectivity", false)));
        this.a = true;
      } while ((PrefUtils.a("IS_REFRESHING", false)) || (!PrefUtils.a("refresh.enabled", true)));
      i = 3600000;
      try
      {
        int j = Math.max(60000, Integer.parseInt(PrefUtils.a("refresh.interval", "3600000")));
        i = j;
      }
      catch (Exception paramIntent)
      {
        long l2;
        long l3;
        long l1;
        for (;;) {}
      }
      l2 = PrefUtils.a("lastscheduledrefresh", 0L);
      l3 = SystemClock.elapsedRealtime();
      l1 = l2;
      if (l3 < l2)
      {
        PrefUtils.b("lastscheduledrefresh", 0L);
        l1 = 0L;
      }
    } while ((l1 != 0L) && (l3 - l1 <= i));
    paramContext.startService(new Intent(paramContext, FetcherService.class).setAction("net.fred.feedex.REFRESH").putExtra("from_auto_refresh", true));
  }
}
