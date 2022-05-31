package net.fred.feedex.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;
import net.fred.feedex.activity.HomeActivity;
import net.fred.feedex.utils.PrefUtils;

public class WidgetProvider
  extends AppWidgetProvider
{
  public WidgetProvider() {}
  
  public void onUpdate(Context paramContext, AppWidgetManager paramAppWidgetManager, int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      Intent localIntent = new Intent(paramContext, WidgetService.class);
      localIntent.putExtra("appWidgetId", k);
      localIntent.putExtra("customInfo", PrefUtils.a(k + ".fontsize", 0));
      localIntent.setData(Uri.parse(localIntent.toUri(1)));
      RemoteViews localRemoteViews = new RemoteViews(paramContext.getPackageName(), 2130968635);
      localRemoteViews.setOnClickPendingIntent(2131689618, PendingIntent.getActivity(paramContext, 0, new Intent(paramContext, HomeActivity.class), 0));
      localRemoteViews.setPendingIntentTemplate(2131689617, PendingIntent.getActivity(paramContext, 0, new Intent("android.intent.action.VIEW"), 0));
      localRemoteViews.setRemoteAdapter(2131689617, localIntent);
      localRemoteViews.setInt(2131689617, "setBackgroundColor", PrefUtils.a(k + ".background", 2080374784));
      paramAppWidgetManager.updateAppWidget(k, localRemoteViews);
      i += 1;
    }
    super.onUpdate(paramContext, paramAppWidgetManager, paramArrayOfInt);
  }
}
