package android.support.v4.widget;

import android.widget.OverScroller;

class ScrollerCompatIcs
{
  public static float a(Object paramObject)
  {
    return ((OverScroller)paramObject).getCurrVelocity();
  }
}
