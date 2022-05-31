package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public final class ViewPropertyAnimatorCompat
{
  static final ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl a = new ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl();
  private WeakReference b;
  private Runnable c = null;
  private Runnable d = null;
  private int e = -1;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21)
    {
      a = new ViewPropertyAnimatorCompat.LollipopViewPropertyAnimatorCompatImpl();
      return;
    }
    if (i >= 19)
    {
      a = new ViewPropertyAnimatorCompat.KitKatViewPropertyAnimatorCompatImpl();
      return;
    }
    if (i >= 18)
    {
      a = new ViewPropertyAnimatorCompat.JBMr2ViewPropertyAnimatorCompatImpl();
      return;
    }
    if (i >= 16)
    {
      a = new ViewPropertyAnimatorCompat.JBViewPropertyAnimatorCompatImpl();
      return;
    }
    if (i >= 14)
    {
      a = new ViewPropertyAnimatorCompat.ICSViewPropertyAnimatorCompatImpl();
      return;
    }
  }
  
  ViewPropertyAnimatorCompat(View paramView)
  {
    this.b = new WeakReference(paramView);
  }
  
  public long a()
  {
    View localView = (View)this.b.get();
    if (localView != null) {
      return a.a(this, localView);
    }
    return 0L;
  }
  
  public ViewPropertyAnimatorCompat a(float paramFloat)
  {
    View localView = (View)this.b.get();
    if (localView != null) {
      a.a(this, localView, paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat a(long paramLong)
  {
    View localView = (View)this.b.get();
    if (localView != null) {
      a.a(this, localView, paramLong);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat a(ViewPropertyAnimatorListener paramViewPropertyAnimatorListener)
  {
    View localView = (View)this.b.get();
    if (localView != null) {
      a.a(this, localView, paramViewPropertyAnimatorListener);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat a(ViewPropertyAnimatorUpdateListener paramViewPropertyAnimatorUpdateListener)
  {
    View localView = (View)this.b.get();
    if (localView != null) {
      a.a(this, localView, paramViewPropertyAnimatorUpdateListener);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat a(Interpolator paramInterpolator)
  {
    View localView = (View)this.b.get();
    if (localView != null) {
      a.a(this, localView, paramInterpolator);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat b(float paramFloat)
  {
    View localView = (View)this.b.get();
    if (localView != null) {
      a.b(this, localView, paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat b(long paramLong)
  {
    View localView = (View)this.b.get();
    if (localView != null) {
      a.b(this, localView, paramLong);
    }
    return this;
  }
  
  public void b()
  {
    View localView = (View)this.b.get();
    if (localView != null) {
      a.b(this, localView);
    }
  }
  
  public void c()
  {
    View localView = (View)this.b.get();
    if (localView != null) {
      a.c(this, localView);
    }
  }
}
