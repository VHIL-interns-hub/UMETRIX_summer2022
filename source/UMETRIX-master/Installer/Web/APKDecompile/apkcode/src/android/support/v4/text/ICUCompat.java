package android.support.v4.text;

import android.os.Build.VERSION;
import java.util.Locale;

public final class ICUCompat
{
  private static final ICUCompat.ICUCompatImpl a = new ICUCompat.ICUCompatImplBase();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21)
    {
      a = new ICUCompat.ICUCompatImplLollipop();
      return;
    }
    if (i >= 14)
    {
      a = new ICUCompat.ICUCompatImplIcs();
      return;
    }
  }
  
  public static String a(Locale paramLocale)
  {
    return a.a(paramLocale);
  }
}
