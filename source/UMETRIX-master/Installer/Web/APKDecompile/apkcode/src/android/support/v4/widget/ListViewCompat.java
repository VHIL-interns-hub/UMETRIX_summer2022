package android.support.v4.widget;

import android.os.Build.VERSION;
import android.widget.ListView;

public final class ListViewCompat
{
  public static void a(ListView paramListView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      ListViewCompatKitKat.a(paramListView, paramInt);
      return;
    }
    ListViewCompatDonut.a(paramListView, paramInt);
  }
}
