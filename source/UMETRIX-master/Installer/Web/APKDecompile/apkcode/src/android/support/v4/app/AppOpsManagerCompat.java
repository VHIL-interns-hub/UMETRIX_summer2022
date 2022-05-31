package android.support.v4.app;

import android.content.Context;
import android.os.Build.VERSION;

public final class AppOpsManagerCompat
{
  private static final AppOpsManagerCompat.AppOpsManagerImpl a = new AppOpsManagerCompat.AppOpsManagerImpl(null);
  
  static
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      a = new AppOpsManagerCompat.AppOpsManager23(null);
      return;
    }
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    return a.a(paramContext, paramString1, paramString2);
  }
  
  public static String a(String paramString)
  {
    return a.a(paramString);
  }
}
