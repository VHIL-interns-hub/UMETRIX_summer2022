package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import android.view.WindowInsets;

class ViewCompatLollipop
{
  public static WindowInsetsCompat a(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    Object localObject = paramWindowInsetsCompat;
    if ((paramWindowInsetsCompat instanceof WindowInsetsCompatApi21))
    {
      WindowInsets localWindowInsets = ((WindowInsetsCompatApi21)paramWindowInsetsCompat).f();
      paramView = paramView.onApplyWindowInsets(localWindowInsets);
      localObject = paramWindowInsetsCompat;
      if (paramView != localWindowInsets) {
        localObject = new WindowInsetsCompatApi21(paramView);
      }
    }
    return localObject;
  }
  
  public static void a(View paramView)
  {
    paramView.requestApplyInsets();
  }
  
  public static void a(View paramView, float paramFloat)
  {
    paramView.setElevation(paramFloat);
  }
  
  static void a(View paramView, ColorStateList paramColorStateList)
  {
    paramView.setBackgroundTintList(paramColorStateList);
  }
  
  static void a(View paramView, PorterDuff.Mode paramMode)
  {
    paramView.setBackgroundTintMode(paramMode);
  }
  
  public static void a(View paramView, OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener)
  {
    if (paramOnApplyWindowInsetsListener == null)
    {
      paramView.setOnApplyWindowInsetsListener(null);
      return;
    }
    paramView.setOnApplyWindowInsetsListener(new ViewCompatLollipop.1(paramOnApplyWindowInsetsListener));
  }
  
  public static float b(View paramView)
  {
    return paramView.getElevation();
  }
  
  public static WindowInsetsCompat b(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    Object localObject = paramWindowInsetsCompat;
    if ((paramWindowInsetsCompat instanceof WindowInsetsCompatApi21))
    {
      WindowInsets localWindowInsets = ((WindowInsetsCompatApi21)paramWindowInsetsCompat).f();
      paramView = paramView.dispatchApplyWindowInsets(localWindowInsets);
      localObject = paramWindowInsetsCompat;
      if (paramView != localWindowInsets) {
        localObject = new WindowInsetsCompatApi21(paramView);
      }
    }
    return localObject;
  }
  
  static ColorStateList c(View paramView)
  {
    return paramView.getBackgroundTintList();
  }
  
  static PorterDuff.Mode d(View paramView)
  {
    return paramView.getBackgroundTintMode();
  }
  
  public static void e(View paramView)
  {
    paramView.stopNestedScroll();
  }
}
