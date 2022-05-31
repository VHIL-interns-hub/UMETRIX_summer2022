package android.support.v4.view;

import android.os.Build.VERSION;

public final class GravityCompat
{
  static final GravityCompat.GravityCompatImpl a = new GravityCompat.GravityCompatImplBase();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      a = new GravityCompat.GravityCompatImplJellybeanMr1();
      return;
    }
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    return a.a(paramInt1, paramInt2);
  }
}
