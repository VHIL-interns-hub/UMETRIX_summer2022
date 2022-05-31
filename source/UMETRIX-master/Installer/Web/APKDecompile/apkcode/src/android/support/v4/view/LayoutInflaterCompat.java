package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.LayoutInflater;

public final class LayoutInflaterCompat
{
  static final LayoutInflaterCompat.LayoutInflaterCompatImpl a = new LayoutInflaterCompat.LayoutInflaterCompatImplBase();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21)
    {
      a = new LayoutInflaterCompat.LayoutInflaterCompatImplV21();
      return;
    }
    if (i >= 11)
    {
      a = new LayoutInflaterCompat.LayoutInflaterCompatImplV11();
      return;
    }
  }
  
  public static LayoutInflaterFactory a(LayoutInflater paramLayoutInflater)
  {
    return a.a(paramLayoutInflater);
  }
  
  public static void a(LayoutInflater paramLayoutInflater, LayoutInflaterFactory paramLayoutInflaterFactory)
  {
    a.a(paramLayoutInflater, paramLayoutInflaterFactory);
  }
}
