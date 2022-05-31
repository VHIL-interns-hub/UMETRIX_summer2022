package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup;

public final class ViewGroupCompat
{
  static final ViewGroupCompat.ViewGroupCompatImpl a = new ViewGroupCompat.ViewGroupCompatStubImpl();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21)
    {
      a = new ViewGroupCompat.ViewGroupCompatLollipopImpl();
      return;
    }
    if (i >= 18)
    {
      a = new ViewGroupCompat.ViewGroupCompatJellybeanMR2Impl();
      return;
    }
    if (i >= 14)
    {
      a = new ViewGroupCompat.ViewGroupCompatIcsImpl();
      return;
    }
    if (i >= 11)
    {
      a = new ViewGroupCompat.ViewGroupCompatHCImpl();
      return;
    }
  }
  
  public static void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    a.a(paramViewGroup, paramBoolean);
  }
}
