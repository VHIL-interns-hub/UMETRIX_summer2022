package net.fred.feedex.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;

public class TickerWidgetProvider
  extends AppWidgetProvider
{
  public TickerWidgetProvider() {}
  
  public void onUpdate(Context paramContext, AppWidgetManager paramAppWidgetManager, int[] paramArrayOfInt)
  {
    paramContext.startService(new Intent(paramContext, TickerWidgetService.class));
    super.onUpdate(paramContext, paramAppWidgetManager, paramArrayOfInt);
  }
}
