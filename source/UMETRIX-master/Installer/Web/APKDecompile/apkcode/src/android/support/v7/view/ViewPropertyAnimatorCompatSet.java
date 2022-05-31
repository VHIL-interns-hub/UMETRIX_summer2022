package android.support.v7.view;

import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public class ViewPropertyAnimatorCompatSet
{
  private final ArrayList a = new ArrayList();
  private long b = -1L;
  private Interpolator c;
  private ViewPropertyAnimatorListener d;
  private boolean e;
  private final ViewPropertyAnimatorListenerAdapter f = new ViewPropertyAnimatorCompatSet.1(this);
  
  public ViewPropertyAnimatorCompatSet() {}
  
  private void c()
  {
    this.e = false;
  }
  
  public ViewPropertyAnimatorCompatSet a(long paramLong)
  {
    if (!this.e) {
      this.b = paramLong;
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompatSet a(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat)
  {
    if (!this.e) {
      this.a.add(paramViewPropertyAnimatorCompat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompatSet a(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat1, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat2)
  {
    this.a.add(paramViewPropertyAnimatorCompat1);
    paramViewPropertyAnimatorCompat2.b(paramViewPropertyAnimatorCompat1.a());
    this.a.add(paramViewPropertyAnimatorCompat2);
    return this;
  }
  
  public ViewPropertyAnimatorCompatSet a(ViewPropertyAnimatorListener paramViewPropertyAnimatorListener)
  {
    if (!this.e) {
      this.d = paramViewPropertyAnimatorListener;
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompatSet a(Interpolator paramInterpolator)
  {
    if (!this.e) {
      this.c = paramInterpolator;
    }
    return this;
  }
  
  public void a()
  {
    if (this.e) {
      return;
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = (ViewPropertyAnimatorCompat)localIterator.next();
      if (this.b >= 0L) {
        localViewPropertyAnimatorCompat.a(this.b);
      }
      if (this.c != null) {
        localViewPropertyAnimatorCompat.a(this.c);
      }
      if (this.d != null) {
        localViewPropertyAnimatorCompat.a(this.f);
      }
      localViewPropertyAnimatorCompat.c();
    }
    this.e = true;
  }
  
  public void b()
  {
    if (!this.e) {
      return;
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((ViewPropertyAnimatorCompat)localIterator.next()).b();
    }
    this.e = false;
  }
}
