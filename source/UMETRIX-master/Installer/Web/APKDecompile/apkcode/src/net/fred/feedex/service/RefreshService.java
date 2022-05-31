package net.fred.feedex.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.IBinder;
import android.os.SystemClock;
import net.fred.feedex.utils.PrefUtils;

public class RefreshService
  extends Service
{
  private final SharedPreferences.OnSharedPreferenceChangeListener a = new RefreshService.1(this);
  private AlarmManager b;
  private PendingIntent c;
  
  public RefreshService() {}
  
  private void a(boolean paramBoolean)
  {
    if (this.c == null) {
      this.c = PendingIntent.getBroadcast(this, 0, new Intent(this, RefreshService.RefreshAlarmReceiver.class), 0);
    }
    try
    {
      for (;;)
      {
        i = Math.max(60000, Integer.parseInt(PrefUtils.a("refresh.interval", "3600000")));
        long l4 = SystemClock.elapsedRealtime();
        long l3 = l4 + 10000L;
        long l2 = l3;
        if (paramBoolean)
        {
          l2 = PrefUtils.a("lastscheduledrefresh", 0L);
          long l1 = l2;
          if (l4 < l2)
          {
            PrefUtils.b("lastscheduledrefresh", 0L);
            l1 = 0L;
          }
          l2 = l3;
          if (l1 > 0L) {
            l2 = Math.max(l3, l1 + i);
          }
        }
        this.b.setInexactRepeating(2, l2, i, this.c);
        return;
        this.b.cancel(this.c);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = 3600000;
      }
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    onRebind(paramIntent);
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.b = ((AlarmManager)getSystemService("alarm"));
    PrefUtils.a(this.a);
    a(true);
  }
  
  public void onDestroy()
  {
    if (this.c != null) {
      this.b.cancel(this.c);
    }
    PrefUtils.b(this.a);
    super.onDestroy();
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    return true;
  }
}
