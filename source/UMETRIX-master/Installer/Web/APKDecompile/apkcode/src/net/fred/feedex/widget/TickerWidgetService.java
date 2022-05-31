package net.fred.feedex.widget;

import android.app.PendingIntent;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Handler;
import android.os.IBinder;
import android.widget.RemoteViews;
import net.fred.feedex.activity.HomeActivity;
import net.fred.feedex.provider.FeedData.EntryColumns;
import net.fred.feedex.utils.ThrottledContentObserver;

public class TickerWidgetService
  extends Service
{
  private ThrottledContentObserver a;
  
  public TickerWidgetService() {}
  
  private void a()
  {
    RemoteViews localRemoteViews = new RemoteViews(getPackageName(), 2130968630);
    localRemoteViews.setOnClickPendingIntent(2131689613, PendingIntent.getActivity(this, 0, new Intent(this, HomeActivity.class), 0));
    Cursor localCursor = getContentResolver().query(FeedData.EntryColumns.c, new String[] { "(SELECT COUNT(*) FROM entries WHERE isread IS NULL)" }, null, null, null);
    if (localCursor != null) {
      if (localCursor.moveToFirst())
      {
        int i = localCursor.getInt(0);
        if (i <= 0) {
          break label139;
        }
        localRemoteViews.setTextViewText(2131689612, String.valueOf(i));
        localRemoteViews.setViewVisibility(2131689612, 0);
        localRemoteViews.setViewVisibility(2131689611, 0);
      }
    }
    for (;;)
    {
      localCursor.close();
      AppWidgetManager.getInstance(this).updateAppWidget(new ComponentName(getPackageName(), TickerWidgetProvider.class.getName()), localRemoteViews);
      return;
      label139:
      localRemoteViews.setViewVisibility(2131689612, 4);
      localRemoteViews.setViewVisibility(2131689611, 4);
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.a = new TickerWidgetService.1(this, new Handler(), 3000L);
    getContentResolver().registerContentObserver(FeedData.EntryColumns.c, true, this.a);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    getContentResolver().unregisterContentObserver(this.a);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    a();
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
}
