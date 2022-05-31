package android.support.v4.text;

import android.os.Build.VERSION;
import java.util.Locale;

public final class TextUtilsCompat
{
  public static final Locale a;
  private static final TextUtilsCompat.TextUtilsCompatImpl b;
  private static String c;
  private static String d;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 17) {}
    for (b = new TextUtilsCompat.TextUtilsCompatJellybeanMr1Impl(null);; b = new TextUtilsCompat.TextUtilsCompatImpl(null))
    {
      a = new Locale("", "");
      c = "Arab";
      d = "Hebr";
      return;
    }
  }
  
  public static int a(Locale paramLocale)
  {
    return b.a(paramLocale);
  }
}
