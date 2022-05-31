package net.fred.feedex.widget;

import android.content.Intent;
import android.widget.RemoteViewsService;
import android.widget.RemoteViewsService.RemoteViewsFactory;

public class WidgetService
  extends RemoteViewsService
{
  public WidgetService() {}
  
  public RemoteViewsService.RemoteViewsFactory onGetViewFactory(Intent paramIntent)
  {
    return new WidgetFeedsFactory(getApplicationContext(), paramIntent);
  }
}
