package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

class ScrollerCompatGingerbread
{
  public static Object a(Context paramContext, Interpolator paramInterpolator)
  {
    if (paramInterpolator != null) {
      return new OverScroller(paramContext, paramInterpolator);
    }
    return new OverScroller(paramContext);
  }
  
  public static void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ((OverScroller)paramObject).startScroll(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    ((OverScroller)paramObject).startScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public static void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    ((OverScroller)paramObject).fling(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
  }
  
  public static void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    ((OverScroller)paramObject).fling(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
  }
  
  public static boolean a(Object paramObject)
  {
    return ((OverScroller)paramObject).isFinished();
  }
  
  public static boolean a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    return ((OverScroller)paramObject).springBack(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  public static int b(Object paramObject)
  {
    return ((OverScroller)paramObject).getCurrX();
  }
  
  public static int c(Object paramObject)
  {
    return ((OverScroller)paramObject).getCurrY();
  }
  
  public static boolean d(Object paramObject)
  {
    return ((OverScroller)paramObject).computeScrollOffset();
  }
  
  public static void e(Object paramObject)
  {
    ((OverScroller)paramObject).abortAnimation();
  }
  
  public static int f(Object paramObject)
  {
    return ((OverScroller)paramObject).getFinalX();
  }
  
  public static int g(Object paramObject)
  {
    return ((OverScroller)paramObject).getFinalY();
  }
}
