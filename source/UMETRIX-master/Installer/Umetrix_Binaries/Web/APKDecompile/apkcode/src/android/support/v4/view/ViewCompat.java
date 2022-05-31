package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;

public final class ViewCompat
{
  static final ViewCompat.ViewCompatImpl a = new ViewCompat.BaseViewCompatImpl();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 23)
    {
      a = new ViewCompat.MarshmallowViewCompatImpl();
      return;
    }
    if (i >= 21)
    {
      a = new ViewCompat.LollipopViewCompatImpl();
      return;
    }
    if (i >= 19)
    {
      a = new ViewCompat.KitKatViewCompatImpl();
      return;
    }
    if (i >= 17)
    {
      a = new ViewCompat.JbMr1ViewCompatImpl();
      return;
    }
    if (i >= 16)
    {
      a = new ViewCompat.JBViewCompatImpl();
      return;
    }
    if (i >= 15)
    {
      a = new ViewCompat.ICSMr1ViewCompatImpl();
      return;
    }
    if (i >= 14)
    {
      a = new ViewCompat.ICSViewCompatImpl();
      return;
    }
    if (i >= 11)
    {
      a = new ViewCompat.HCViewCompatImpl();
      return;
    }
    if (i >= 9)
    {
      a = new ViewCompat.GBViewCompatImpl();
      return;
    }
    if (i >= 7)
    {
      a = new ViewCompat.EclairMr1ViewCompatImpl();
      return;
    }
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return a.a(paramInt1, paramInt2, paramInt3);
  }
  
  public static int a(View paramView)
  {
    return a.a(paramView);
  }
  
  public static WindowInsetsCompat a(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    return a.a(paramView, paramWindowInsetsCompat);
  }
  
  public static void a(View paramView, float paramFloat)
  {
    a.a(paramView, paramFloat);
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2)
  {
    a.a(paramView, paramInt1, paramInt2);
  }
  
  public static void a(View paramView, int paramInt, Paint paramPaint)
  {
    a.a(paramView, paramInt, paramPaint);
  }
  
  public static void a(View paramView, ColorStateList paramColorStateList)
  {
    a.a(paramView, paramColorStateList);
  }
  
  public static void a(View paramView, PorterDuff.Mode paramMode)
  {
    a.a(paramView, paramMode);
  }
  
  public static void a(View paramView, AccessibilityDelegateCompat paramAccessibilityDelegateCompat)
  {
    a.a(paramView, paramAccessibilityDelegateCompat);
  }
  
  public static void a(View paramView, OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener)
  {
    a.a(paramView, paramOnApplyWindowInsetsListener);
  }
  
  public static void a(View paramView, Runnable paramRunnable)
  {
    a.a(paramView, paramRunnable);
  }
  
  public static void a(View paramView, Runnable paramRunnable, long paramLong)
  {
    a.a(paramView, paramRunnable, paramLong);
  }
  
  public static void a(View paramView, boolean paramBoolean)
  {
    a.a(paramView, paramBoolean);
  }
  
  public static boolean a(View paramView, int paramInt)
  {
    return a.a(paramView, paramInt);
  }
  
  public static WindowInsetsCompat b(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    return a.b(paramView, paramWindowInsetsCompat);
  }
  
  public static void b(View paramView)
  {
    a.b(paramView);
  }
  
  public static void b(View paramView, float paramFloat)
  {
    a.b(paramView, paramFloat);
  }
  
  public static void b(View paramView, boolean paramBoolean)
  {
    a.b(paramView, paramBoolean);
  }
  
  public static boolean b(View paramView, int paramInt)
  {
    return a.b(paramView, paramInt);
  }
  
  public static int c(View paramView)
  {
    return a.c(paramView);
  }
  
  public static void c(View paramView, float paramFloat)
  {
    a.c(paramView, paramFloat);
  }
  
  public static void c(View paramView, int paramInt)
  {
    a.c(paramView, paramInt);
  }
  
  public static int d(View paramView)
  {
    return a.d(paramView);
  }
  
  public static void d(View paramView, int paramInt)
  {
    a.e(paramView, paramInt);
  }
  
  public static int e(View paramView)
  {
    return a.e(paramView);
  }
  
  public static void e(View paramView, int paramInt)
  {
    a.d(paramView, paramInt);
  }
  
  public static ViewParent f(View paramView)
  {
    return a.f(paramView);
  }
  
  public static int g(View paramView)
  {
    return a.g(paramView);
  }
  
  public static int h(View paramView)
  {
    return a.h(paramView);
  }
  
  public static float i(View paramView)
  {
    return a.j(paramView);
  }
  
  public static int j(View paramView)
  {
    return a.k(paramView);
  }
  
  public static ViewPropertyAnimatorCompat k(View paramView)
  {
    return a.l(paramView);
  }
  
  public static float l(View paramView)
  {
    return a.o(paramView);
  }
  
  public static int m(View paramView)
  {
    return a.m(paramView);
  }
  
  public static void n(View paramView)
  {
    a.n(paramView);
  }
  
  public static boolean o(View paramView)
  {
    return a.p(paramView);
  }
  
  public static void p(View paramView)
  {
    a.q(paramView);
  }
  
  public static boolean q(View paramView)
  {
    return a.i(paramView);
  }
  
  public static ColorStateList r(View paramView)
  {
    return a.r(paramView);
  }
  
  public static PorterDuff.Mode s(View paramView)
  {
    return a.s(paramView);
  }
  
  public static void t(View paramView)
  {
    a.t(paramView);
  }
  
  public static boolean u(View paramView)
  {
    return a.u(paramView);
  }
  
  public static boolean v(View paramView)
  {
    return a.v(paramView);
  }
  
  public static boolean w(View paramView)
  {
    return a.w(paramView);
  }
}
