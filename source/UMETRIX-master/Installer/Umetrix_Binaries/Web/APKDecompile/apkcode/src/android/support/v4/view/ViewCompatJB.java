package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

class ViewCompatJB
{
  public static void a(View paramView)
  {
    paramView.postInvalidateOnAnimation();
  }
  
  public static void a(View paramView, int paramInt)
  {
    paramView.setImportantForAccessibility(paramInt);
  }
  
  public static void a(View paramView, Runnable paramRunnable)
  {
    paramView.postOnAnimation(paramRunnable);
  }
  
  public static void a(View paramView, Runnable paramRunnable, long paramLong)
  {
    paramView.postOnAnimationDelayed(paramRunnable, paramLong);
  }
  
  public static int b(View paramView)
  {
    return paramView.getImportantForAccessibility();
  }
  
  public static ViewParent c(View paramView)
  {
    return paramView.getParentForAccessibility();
  }
  
  public static int d(View paramView)
  {
    return paramView.getMinimumHeight();
  }
  
  public static void e(View paramView)
  {
    paramView.requestFitSystemWindows();
  }
  
  public static boolean f(View paramView)
  {
    return paramView.getFitsSystemWindows();
  }
  
  public static boolean g(View paramView)
  {
    return paramView.hasOverlappingRendering();
  }
}
