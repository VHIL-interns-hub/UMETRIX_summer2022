package android.support.v4.view;

import android.view.WindowInsets;

class WindowInsetsCompatApi21
  extends WindowInsetsCompat
{
  private final WindowInsets a;
  
  WindowInsetsCompatApi21(WindowInsets paramWindowInsets)
  {
    this.a = paramWindowInsets;
  }
  
  public int a()
  {
    return this.a.getSystemWindowInsetLeft();
  }
  
  public WindowInsetsCompat a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return new WindowInsetsCompatApi21(this.a.replaceSystemWindowInsets(paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public int b()
  {
    return this.a.getSystemWindowInsetTop();
  }
  
  public int c()
  {
    return this.a.getSystemWindowInsetRight();
  }
  
  public int d()
  {
    return this.a.getSystemWindowInsetBottom();
  }
  
  public boolean e()
  {
    return this.a.isConsumed();
  }
  
  WindowInsets f()
  {
    return this.a;
  }
}
