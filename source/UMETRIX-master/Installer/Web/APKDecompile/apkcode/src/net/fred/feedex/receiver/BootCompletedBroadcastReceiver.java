package net.fred.feedex.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import net.fred.feedex.service.RefreshService;
import net.fred.feedex.utils.PrefUtils;

public class BootCompletedBroadcastReceiver
  extends BroadcastReceiver
{
  public BootCompletedBroadcastReceiver() {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    PrefUtils.b("lastscheduledrefresh", 0L);
    if (PrefUtils.a("refresh.enabled", true)) {
      paramContext.startService(new Intent(paramContext, RefreshService.class));
    }
  }
}
