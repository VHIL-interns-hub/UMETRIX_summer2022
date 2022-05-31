package android.support.v4.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.PopupWindow;

public final class PopupWindowCompat
{
  static final PopupWindowCompat.PopupWindowImpl a = new PopupWindowCompat.BasePopupWindowImpl();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 23)
    {
      a = new PopupWindowCompat.Api23PopupWindowImpl();
      return;
    }
    if (i >= 21)
    {
      a = new PopupWindowCompat.Api21PopupWindowImpl();
      return;
    }
    if (i >= 19)
    {
      a = new PopupWindowCompat.KitKatPopupWindowImpl();
      return;
    }
    if (i >= 9)
    {
      a = new PopupWindowCompat.GingerbreadPopupWindowImpl();
      return;
    }
  }
  
  public static void a(PopupWindow paramPopupWindow, int paramInt)
  {
    a.a(paramPopupWindow, paramInt);
  }
  
  public static void a(PopupWindow paramPopupWindow, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    a.a(paramPopupWindow, paramView, paramInt1, paramInt2, paramInt3);
  }
  
  public static void a(PopupWindow paramPopupWindow, boolean paramBoolean)
  {
    a.a(paramPopupWindow, paramBoolean);
  }
}
