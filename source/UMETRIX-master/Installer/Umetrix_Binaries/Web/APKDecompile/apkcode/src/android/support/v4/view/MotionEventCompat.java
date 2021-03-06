package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.MotionEvent;

public final class MotionEventCompat
{
  static final MotionEventCompat.MotionEventVersionImpl a = new MotionEventCompat.BaseMotionEventVersionImpl();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 12)
    {
      a = new MotionEventCompat.HoneycombMr1MotionEventVersionImpl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 9)
    {
      a = new MotionEventCompat.GingerbreadMotionEventVersionImpl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 5)
    {
      a = new MotionEventCompat.EclairMotionEventVersionImpl();
      return;
    }
  }
  
  public static int a(MotionEvent paramMotionEvent)
  {
    return paramMotionEvent.getAction() & 0xFF;
  }
  
  public static int a(MotionEvent paramMotionEvent, int paramInt)
  {
    return a.a(paramMotionEvent, paramInt);
  }
  
  public static int b(MotionEvent paramMotionEvent)
  {
    return (paramMotionEvent.getAction() & 0xFF00) >> 8;
  }
  
  public static int b(MotionEvent paramMotionEvent, int paramInt)
  {
    return a.b(paramMotionEvent, paramInt);
  }
  
  public static float c(MotionEvent paramMotionEvent, int paramInt)
  {
    return a.c(paramMotionEvent, paramInt);
  }
  
  public static int c(MotionEvent paramMotionEvent)
  {
    return a.a(paramMotionEvent);
  }
  
  public static float d(MotionEvent paramMotionEvent, int paramInt)
  {
    return a.d(paramMotionEvent, paramInt);
  }
  
  public static int d(MotionEvent paramMotionEvent)
  {
    return a.b(paramMotionEvent);
  }
  
  public static float e(MotionEvent paramMotionEvent, int paramInt)
  {
    return a.e(paramMotionEvent, paramInt);
  }
}
