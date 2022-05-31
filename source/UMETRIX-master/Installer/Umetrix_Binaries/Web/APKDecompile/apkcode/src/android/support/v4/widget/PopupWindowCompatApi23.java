package android.support.v4.widget;

import android.widget.PopupWindow;

class PopupWindowCompatApi23
{
  static void a(PopupWindow paramPopupWindow, int paramInt)
  {
    paramPopupWindow.setWindowLayoutType(paramInt);
  }
  
  static void a(PopupWindow paramPopupWindow, boolean paramBoolean)
  {
    paramPopupWindow.setOverlapAnchor(paramBoolean);
  }
}
