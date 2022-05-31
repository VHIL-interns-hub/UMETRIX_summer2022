package net.fred.feedex.widget;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService.RemoteViewsFactory;
import net.fred.feedex.provider.FeedData.EntryColumns;
import net.fred.feedex.utils.PrefUtils;
import net.fred.feedex.utils.ThrottledContentObserver;

class WidgetFeedsFactory
  implements RemoteViewsService.RemoteViewsFactory
{
  private final int a;
  private final int b;
  private Context c = null;
  private Cursor d;
  private ThrottledContentObserver e;
  
  public WidgetFeedsFactory(Context paramContext, Intent paramIntent)
  {
    this.c = paramContext;
    this.a = paramIntent.getIntExtra("appWidgetId", 0);
    this.b = paramIntent.getIntExtra("customInfo", 0);
  }
  
  private void a()
  {
    Object localObject1 = new StringBuilder();
    Object localObject2 = PrefUtils.a(this.a + ".feeds", "");
    if (((String)localObject2).length() > 0)
    {
      if (((StringBuilder)localObject1).length() > 0) {
        ((StringBuilder)localObject1).append(" AND ");
      }
      ((StringBuilder)localObject1).append("feedid").append(" IN (").append((String)localObject2).append(')');
    }
    localObject2 = this.c.getContentResolver();
    Uri localUri = FeedData.EntryColumns.c;
    localObject1 = ((StringBuilder)localObject1).toString();
    this.d = ((ContentResolver)localObject2).query(localUri, new String[] { "title", "_id", "icon" }, (String)localObject1, null, "date DESC");
  }
  
  public int getCount()
  {
    return this.d.getCount();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public RemoteViews getLoadingView()
  {
    return null;
  }
  
  public RemoteViews getViewAt(int paramInt)
  {
    RemoteViews localRemoteViews = new RemoteViews(this.c.getPackageName(), 2130968637);
    Object localObject;
    if (this.d.moveToPosition(paramInt))
    {
      localRemoteViews.setTextViewText(16908308, this.d.getString(0));
      localRemoteViews.setFloat(16908308, "setTextSize", this.b * 3 + 15);
      localObject = new Intent("android.intent.action.VIEW", FeedData.EntryColumns.b(this.d.getString(1)));
      ((Intent)localObject).putExtra("fromWidget", true);
      localRemoteViews.setOnClickFillInIntent(16908290, (Intent)localObject);
      localRemoteViews.setImageViewResource(16908294, 2130903040);
      if (this.d.isNull(2)) {}
    }
    try
    {
      localObject = this.d.getBlob(2);
      if ((localObject != null) && (localObject.length > 0))
      {
        localObject = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
        if (localObject != null) {
          localRemoteViews.setImageViewBitmap(16908294, (Bitmap)localObject);
        }
      }
      return localRemoteViews;
    }
    catch (Throwable localThrowable) {}
    return localRemoteViews;
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  public void onCreate()
  {
    a();
    this.e = new WidgetFeedsFactory.1(this, new Handler(), 3000L);
    this.c.getContentResolver().registerContentObserver(FeedData.EntryColumns.c, true, this.e);
  }
  
  public void onDataSetChanged()
  {
    this.d.close();
    a();
  }
  
  public void onDestroy()
  {
    this.d.close();
    this.c.getContentResolver().unregisterContentObserver(this.e);
  }
}
